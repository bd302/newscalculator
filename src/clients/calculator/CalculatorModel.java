package clients.calculator;

import clients.Record;
import clients.summary.SummaryController;
import clients.summary.SummaryModel;
import clients.summary.SummaryView;

import java.awt.Dimension;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import clients.PositionOnScreen;

/**
 * <H1>Model for the calculator</H1>
 * 
 * Implements the logic behind the NEWS Calculator
 * @author Brad
 *
 */
public class CalculatorModel {
	
	private CalculatorController cont; 
	
	public CalculatorModel() {
		
	}

	/**
	 * Handles the submitted data from the view
	 * 
	 * @param fn First name
	 * @param ln Last name
	 * @param n NHS Number
	 * @param dob Date of birth
	 * @param r Respiration
	 * @param sp Sp02
	 * @param sps Sp02 Scale
	 * @param o Oxygen or Air
	 * @param bp Blood Pressure
	 * @param p Pulse
	 * @param c Consciousness
	 * @param t Temperature
	 * @param i Initials of user
	 */
	public void doSubmit(String fn, String ln, String n, String dob, String r, String sp, boolean sps, String o, String bp, String p, String c, String t, String i) {
		
		//create new validated data class from inputs from calculator
		ValidatedData calculatorResults = validateResults(fn, ln, n, dob, r, sp, sps, o, bp, p, c, t, i);
		
		if (calculatorResults.getFlag()) {
			cont.doError(calculatorResults.getMsg());	
		} else {
			//complete results by creating record class			
			Record results = calculateNEWS(calculatorResults.getResults());
			
			//start summary with the record
			startSummaryGUI_MVC(results);
		}		
	}
	
	/**
	 * Validates the results given by the view
	 * 
	 * @param fn First name
	 * @param ln Last name
	 * @param n NHS Number
	 * @param dob Date of birth
	 * @param r Respiration
	 * @param sp Sp02
	 * @param sps Sp02 Scale
	 * @param o Oxygen or Air
	 * @param bp Blood pressure
	 * @param p Pulse
	 * @param c Consciousness
	 * @param t Temperature
	 * @param i Initials
	 * @return Validated data object containing the Record Object
	 */
	private ValidatedData validateResults(String fn, String ln, String n, String dob, String r, String sp, boolean sps, String o, String bp, String p, String c, String t, String i) {
		String errormsg = ("The values entered are incorrect for: ");
		boolean errorFlag = false;
		
		String forename = fn;
		String lastname = ln;
		String number = "";
		String dateofbirth = dob;
		
		int respiration = 0;
		int sp02 = 0;
		int bpressure = 0;
		int pulse = 0;
		float temperature = 0.0f;
		
		String initials = i;
		
		if(!(fn.length() > 0)) {
			errormsg = errormsg + "Forename, ";
			errorFlag = true;
		}
		
		if (!(ln.length() > 0)) {
			errormsg = errormsg + "Surname, ";
			errorFlag = true;
		}
		
			
		try {
			int numberTemp = Integer.parseInt(n);
			number = n;
		} catch (Exception e) {
			if (n.length() >= 1) {
				number = "Unknown";
			} else {
				errormsg = errormsg + "NHS Number, ";
				errorFlag = true;
			}
		}
	
		if (dob.length() < 1) {
			dateofbirth = "n/a";
		}
		
		try {
			respiration = Integer.parseInt(r);
		} catch (Exception e) {
			errormsg = errormsg + "Respiration Rate, ";
			errorFlag = true;
		}
		try {
			sp02 = Integer.parseInt(sp);
		} catch (Exception e) {
			errormsg = errormsg + "Sp02, ";
			errorFlag = true;
		}
		
		
		try {
			bpressure = Integer.parseInt(bp);
		} catch (Exception e) {
			errormsg = errormsg + "Blood Pressure, ";
			errorFlag = true;
		}
		try {
			pulse = Integer.parseInt(p);
		} catch (Exception e) {
			errormsg = errormsg + "Pulse, ";
			errorFlag = true;
		} 
		try {
			temperature = Float.parseFloat(t);
			if (temperature == 0.0) {errorFlag = true;}
		} catch (Exception e) {
			errormsg = errormsg + "Temperature, ";
			errorFlag = true;
		}
		
		if (!(i.length() > 0)){
			errormsg = errormsg + "Initials";
			errorFlag = true;
		}

		
		CalculatorResults results = new CalculatorResults(forename, lastname, number, dateofbirth, respiration, sp02, sps, o, bpressure, pulse, c, temperature, initials);
		ValidatedData d = new ValidatedData(results, errorFlag, errormsg);
		return d;		
	}
	
	/**
	 * Takes in an object of CalculatorResults and calculates the NEWS score for the patient
	 * @param results CalculatorResults containing the input information from the calculator
	 * @return A record containing the evaluated results
	 */
	private Record calculateNEWS(CalculatorResults results) {	
		int score = 0;
		boolean redFlag = false;
		
		String fn = results.getForename();
		String ln = results.getLastname();
		String n = results.getNumber();
		String dob = results.getdob();
		String i = results.getInitials();
		
		int r = results.getResp();
		int sp02 = results.getsp02();
		boolean sp02s = results.getsp02scale();
		String o = results.getOxygen();
		int bp = results.getBPressure();
		int p = results.getPulse();
		String c = results.getCons();
		float t = results.getTemp();
		
		//respiration
		if (r <= 8) {		
			score = score + 3;
			redFlag = true;
		} else if (r >=9 && r < 12) {
			score = score + 1;
		} else if (r >= 12 && r < 21) {
			score = score + 0;
		} else if (r >= 21 && r < 25) {
			score = score + 2;
		} else if (r >=25) {
			score = score + 3;
			redFlag = true;
		}
		
		
		//Sp02
		if (sp02s == true) {
			//scale 2
			if (sp02 <= 83) {
				score = score + 3;
				redFlag = true;
			} else if (sp02 == 84 || sp02 == 85) {
				score = score + 2;
			} else if (sp02 == 86 || sp02 == 87) {
				score = score + 1;
			} else if ((sp02 >= 88 && sp02 < 93) || (sp02 >= 93 && o == "Air")) {
				score = score + 0;
			} else if ((sp02 == 93 || sp02 == 94) && o == "Oxygen") {
				score = score + 1;
			} else if ((sp02 == 95 || sp02 == 96) && o == "Oxygen") {
				score = score + 2;
			} else if ((sp02 >= 97 && o == "Oxygen")) {
				score = score + 1;
			}
			
		} else {
			//scale 1
			if (sp02 <= 91) {
				score = score + 3;
				redFlag = true;
			} else if (sp02 == 92 || sp02 == 93) {
				score = score + 2;
			} else if (sp02 == 94 || sp02 == 95) {
				score = score + 1;
			} else if (sp02 >= 96) {
				score = score + 0;
			}
			
		}
		
		//Oxygen
		if (o == "Oxygen") {
			score = score + 2;
		} else {
			score = score + 0;
		}
				
		//Systolic Blood Pressure
		if (bp <= 90) {
			score = score + 3;
			redFlag = true;
		} else if (bp >= 91 && bp < 101) {
			score = score + 2;
		} else if (bp >= 101 && bp < 111) {
			score = score + 1;
		} else if (bp >= 111 && bp < 220) {
			score = score + 0;
		} else if (bp >= 220) {
			score = score + 3;
			redFlag = true;
		}
				
		//Pulse
		if (p <= 40) {
			score = score + 3;
			redFlag = true;
		} else if (p >= 41 && p < 51) {
			score = score + 1;
		} else if (p >= 51 && p < 91) {
			score = score + 0;
		} else if (p >= 91 && p < 111) {
			score = score + 1;
		} else if (p >= 111 && p < 131) {
			score = score + 2;
		} else if (p >= 131) {
			score = score + 3;
			redFlag = true;
		}
				
		//Consciousness
		if (c == "Alert") {
			score = score + 0;
		} else {
			score = score + 3;
			redFlag = true;
		}
				
		//Temperature
		if(t <= 35.0) {
			score = score + 3;
			redFlag = true;
		} else if (t > 35.0 && t <= 36.0) {
			score = score + 1;
		} else if (t > 36.0 && t <= 38.0) {
			score = score + 0;
		} else if (t > 38.0 && t <= 39.0) {
			score = score + 1;
		} else if (t > 39.0) {
			score = score + 2;
		}
		
		LocalDateTime time = LocalDateTime.now();
				
		
		Record record = new Record(n, fn, ln, dob,  r, sp02, sp02s, o, bp, p, c, t, score, redFlag, i, time);
		return record;
	}
	
	/**
	 * Start the summary GUI 
	 * @param r Pass a Record to generate the content for the Record
	 */
	public void startSummaryGUI_MVC(Record r) 
	{
		JFrame window = new JFrame();
		window.setTitle("Summary");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension pos = PositionOnScreen.getPos();
		
		
		SummaryModel model = new SummaryModel();
		SummaryView view = new SummaryView(window, pos.width, pos.height, r);
		SummaryController cont = new SummaryController(model, view);
	
		window.setVisible(true);
	}
	
	public void setController(CalculatorController c) {
		cont = c;
	}
	
}
