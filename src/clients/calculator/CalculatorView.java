package clients.calculator;

import java.awt.*;
import javax.swing.*;

/**
 * <H1> View for the Calculator </H1>
 * 
 * Responsible for all elements displayed on screen to the user surrounding the calculator segment
 * @author Brad
 *
 */
public class CalculatorView {
	
	private static final int H = 600;       
	private static final int W = 400;
	
	private boolean typeError;

	private static final String SUBMIT = "Submit";
	private static final String CLEAR = "Clear";
	
	private final JLabel titlelbl			= new JLabel();
	
	private final JFrame errormsg			= new JFrame();
	
	private final JLabel forenamelbl		= new JLabel();
	private final JTextField forenametxt	= new JTextField();
	
	private final JLabel surnamelbl			= new JLabel();
	private final JTextField surnametxt		= new JTextField();
	
	private final JLabel numberlbl			= new JLabel();
	private final JTextField numbertxt		= new JTextField();
	
	private final JLabel doblbl				= new JLabel();
	private final JTextField dobtxt			= new JTextField();
	
	private final JLabel resplbl 			= new JLabel();	
	private final JTextField resptxt 		= new JTextField();
	
	private final JLabel sp02lbl	 		= new JLabel();	
	private final JTextField sp02txt	 	= new JTextField();
	
	private final JLabel sp02scalelbl		= new JLabel();
	private final JCheckBox sp02scalech		= new JCheckBox();
	
	private final JLabel oxygenlbl	 		= new JLabel();	
	String[] oxyOptions = {"Air", "Oxygen"};
	private final JComboBox oxygencb		= new JComboBox(oxyOptions); 
	
	private final JLabel bpressurelbl		= new JLabel();	
	private final JTextField bpressuretxt	= new JTextField();
	
	private final JLabel pulselbl			= new JLabel();	
	private final JTextField pulsetxt		= new JTextField();
	
	private final JLabel conslbl			= new JLabel();
	String[] consOptions = {"Alert", "Confused", "Voice", "Pain", "Unresponsive"};
	private final JComboBox conscb		= new JComboBox(consOptions); 
	
	private final JLabel templbl			= new JLabel();
	private final JTextField temptxt		= new JTextField();
	
	private final JLabel initiallbl 		= new JLabel();
	private final JTextField initialtxt		= new JTextField();
	
	private final JButton submitbtn			= new JButton( SUBMIT ); 
	private final JButton clearbtn			= new JButton( CLEAR );

	private CalculatorController cont;
	
	/**
	 * Construct the calculator view
	 * 
	 * @param rpc Window to construct 
	 * @param x x-coordinate of the window
	 * @param y y-coordinate of the window
	 */
	public CalculatorView(RootPaneContainer rpc, int x, int y) {
		
		Container cp = rpc.getContentPane();
		Container rootWindow = (Container) rpc;
		cp.setLayout(null);
		rootWindow.setSize(W, H);
		rootWindow.setLocation(x,y);
		cp.setBackground(new java.awt.Color(255,255,255));

		
		titlelbl.setBounds(120, 10+30*0, 150, 20);
		titlelbl.setText("NEWS Score Calculator");
		cp.add(titlelbl);
		
		clearbtn.setBounds(280, 10+30*1, 70, 20);
		clearbtn.addActionListener(e -> doClear());
		cp.add(clearbtn);
		
		forenamelbl.setBounds(85,35+30*1, 150, 20);
		forenamelbl.setText("Forename: ");
		cp.add(forenamelbl);
		
		forenametxt.setBounds(150, 35+30*1, 100, 20);
		forenametxt.setText("");
		cp.add(forenametxt);
		
		surnamelbl.setBounds(90, 25+30*2, 150, 20);
		surnamelbl.setText("Surname: ");
		cp.add(surnamelbl);
		
		surnametxt.setBounds(150, 25+30*2, 100, 20);
		surnametxt.setText("");
		cp.add(surnametxt);
		
		numberlbl.setBounds(70, 15+30*3, 100, 20);
		numberlbl.setText("NHS Number: ");
		cp.add(numberlbl);
		
		numbertxt.setBounds(150, 15+30*3, 100, 20);
		numbertxt.setText("");
		cp.add(numbertxt);
		
		doblbl.setBounds(70, 5+30*4, 100, 20);
		doblbl.setText("Date of Birth: ");
		cp.add(doblbl);
		
		dobtxt.setBounds(150, 5+30*4, 100, 20);
		dobtxt.setText("");
		cp.add(dobtxt);
		
		resplbl.setBounds(45, 50+30*5, 150, 20);
		resplbl.setText("Respiratory Rate: ");
		cp.add(resplbl);
		
		resptxt.setBounds(150, 50+30*5, 80, 20);
		resptxt.setText("");
		cp.add(resptxt);
		
		sp02lbl.setBounds(115, 50+30*6, 150, 20);
		sp02lbl.setText("Sp02: ");
		cp.add(sp02lbl);
		
		sp02txt.setBounds(150, 50+30*6, 80, 20);
		sp02txt.setText("");
		cp.add(sp02txt);
		
		sp02scalelbl.setBounds(35, 50+30*7, 150, 20);
		sp02scalelbl.setText("Using Sp02 Scale 2: ");
		cp.add(sp02scalelbl);
		
		sp02scalech.setBounds(150, 50+30*7, 50, 20 );
		sp02scalech.setText("Yes");
		cp.add(sp02scalech);
		
		oxygenlbl.setBounds(100, 50+30*8, 150, 20);
		oxygenlbl.setText("Oxygen:");
		cp.add(oxygenlbl);
		
		oxygencb.setBounds(150, 50+30*8, 80, 20);
		oxygencb.setSelectedIndex(0);
		cp.add(oxygencb);
		
		bpressurelbl.setBounds(8, 50+30*9, 150, 20);
		bpressurelbl.setText("Systolic Blood Pressure: ");
		cp.add(bpressurelbl);
		
		bpressuretxt.setBounds(150, 50+30*9, 80, 20);
		bpressuretxt.setText("");
		cp.add(bpressuretxt);
		
		pulselbl.setBounds(110, 50+30*10, 150, 20);
		pulselbl.setText("Pulse: ");
		cp.add(pulselbl);
		
		pulsetxt.setBounds(150, 50+30*10, 80, 20);
		pulsetxt.setText("");
		cp.add(pulsetxt);
		
		conslbl.setBounds(54, 50+30*11, 150, 20);
		conslbl.setText("Consciousness: ");
		cp.add(conslbl);
		
		conscb.setBounds(150, 50+30*11, 80, 20);
		conscb.setSelectedIndex(0);
		cp.add(conscb);
		
		templbl.setBounds(68, 50+30*12, 150, 20);
		templbl.setText("Temperature: ");
		cp.add(templbl);
		
		temptxt.setBounds(150, 50+30*12, 80, 20);
		temptxt.setText("");
		cp.add(temptxt);
		
		initiallbl.setBounds(92, 68 +30*13, 200, 20);
		initiallbl.setText("Your initials (not patients):");
		cp.add(initiallbl);
		
		initialtxt.setBounds(242, 70+30*13, 40, 20);
		initialtxt.setText("");
		cp.add(initialtxt);
		
		submitbtn.setBounds(200, 70+30*14, 80, 20);
		submitbtn.addActionListener(			
				e -> cont.doSubmit(
						getForename(), 
						getSurname(),
						getNumber(),
						getdob(),
						getResp(), 
						getsp02(),
						getsp02scale(),
						getOxygen(), 
						getBPressure(), 
						getPulse(), 
						getCons(), 
						getTemp(),
						getInitials())); 		
		cp.add(submitbtn);
	}
	
	/**
	 * Show pop-up error message pertaining to incorrect values in fields
	 * @param report contains the fields in question
	 */
	public void doError(String report) {
		JOptionPane.showMessageDialog(errormsg, report, "Alert", JOptionPane.WARNING_MESSAGE);
	}
	
	
	public void setController(CalculatorController c) {
		cont = c;
	}
	
	/**
	 * gets the forename from the JTextField element
	 * @return forename
	 */
	public String getForename() {
		return forenametxt.getText();
	}
	
	/**
	 * gets the surname from the JTextField element
	 * @return surname
	 */
	public String getSurname() {
		return surnametxt.getText();
	}
	
	/**
	 * gets the NHS number from the JTextField element
	 * @return
	 */
	public String getNumber() {
		return numbertxt.getText();
	}
		
	/**
	 * get the date of birth from the JTextField element
	 * @return date of birth
	 */
	public String getdob() {
		return dobtxt.getText();
	}
	
	/**
	 * get the respiration rate value from the JTextField element
	 * @return respiration
	 */
	public String getResp() {
		return resptxt.getText();					
	}
	
	/**
	 * get the sp02 value from the JTextField element
	 * @return sp02
	 */
	public String getsp02() {
		return sp02txt.getText();
	}
	
	/**
	 * get the sp02 scale value from the JComboBox element
	 * @return sp02 scale 
	 */
	public boolean getsp02scale() {
		return sp02scalech.isSelected();
	}
	
	/**
	 * get the oxygen value from the JComboBox element
	 * @return oxygen or air
	 */
	public String getOxygen() {
		return oxygencb.getSelectedItem().toString();
	}
	
	/**
	 * get the blood pressure value from the JTextField element
	 * @return blood pressure
	 */
	public String getBPressure() {
		return bpressuretxt.getText();
	}
	
	/**
	 * get the pulse value from the JTextField element
	 * @return pulse rate
	 */
	public String getPulse() {
		return pulsetxt.getText();
	}
	
	/**
	 * get the consciousness value from the JComboBox element
	 * @return consciousness
	 */
	public String getCons() {
		return conscb.getSelectedItem().toString();
	}
	
	/**
	 * get the temperature value from the JTextField element
	 * @return temperature
	 */
	public String getTemp() {
		return temptxt.getText();
	}
	
	/**
	 * get the initials value from the JTextField element
	 * @return initials of user
	 */
	public String getInitials() {
		return initialtxt.getText();
	}
		
	/**
	 * Clear the values in the fields bar the initials
	 */
	public void doClear() {
		forenametxt.setText("");
		surnametxt.setText("");
		numbertxt.setText("");
		dobtxt.setText("");
		resptxt.setText("");
		sp02txt.setText("");
		sp02scalech.setSelected(false);
		oxygencb.setSelectedIndex(0);
		bpressuretxt.setText("");
		pulsetxt.setText("");
		conscb.setSelectedIndex(0);
		temptxt.setText("");		
	}

}
