package clients;

import java.time.LocalDateTime;

public class Record {
	
	private String forename;
	private String lastname;
	private String number;
	private String dateofbirth;	
	private int respiration;
	private int sp02;
	private boolean sp02s;
	private String oxygen;
	private int bpressure;
	private int pulse;
	private String consciousness;
	private float temperature;	
	private String initials;
	
	private LocalDateTime time; 
	private int finalScore;
	private boolean redFlag;
	private String risk;
	private String response;
	
	public Record(String n, String fn, String ln, String dob, int r, int sp, boolean sps, String o, int bp, int p, String c, float t, int fs, boolean rf, String i, LocalDateTime ti) {
		
		number = n;
		forename = fn;
		lastname = ln;
		dateofbirth = dob;
		
		respiration = r;
		sp02 = sp;
		sp02s = sps;
		oxygen = o;
		bpressure = bp;
		pulse = p;
		consciousness = c;
		temperature = t;
		
		initials = i;
		time = ti;
		
		finalScore = fs;
		redFlag = rf;
		
		risk = calculateRisk(finalScore, redFlag);
		
		response = calculateResponse(risk);
		
	}
	
	public Record() {
		
	}
	
	private String calculateRisk (int finalScore, boolean redFlag) {
		if (finalScore >= 7 ) {
			risk = "High";
		} else if (finalScore >= 5) {
			risk = "Medium";
		} else if (finalScore >= 0 && redFlag == true) {
			risk = "Low-medium";
		} else if (finalScore >= 0) {
			risk = "Low";
		}
		return risk;
	}
	
	private String calculateResponse (String risk) {
		if (risk == "High") {
			response = "Urgent or emergency response";
		} else if (risk == "Medium") {
			response = "Key threshold for urgent response";
		} else if (risk == "Low-medium") {
			response = "Urgent ward-based response";
		} else if (risk == "Low") {
			response = "Ward-based response";
		}
		return response;
	}
	
	public String getNumber() {
		return number;
	}

	public String getFName() {
		return forename;
	}
	
	public String getLName() {
		return lastname;
	}
	
	public String getdob() {
		return dateofbirth;
	}
	
	public int getResp() {
		return respiration;
	}
	
	public int getsp02() {
		return sp02;
	}
	
	public boolean getsp02scale() {
		return sp02s;
	}
	
	public String getOxygen() {
		return oxygen;
	}
	
	public int getBPressure() {
		return bpressure;
	}
	
	public int getPulse() {
		return pulse;
	}
	
	public String getCons() {
		return consciousness;
	}
	
	public float getTemp() {
		return temperature;
	}
	
	public String getInitials() {
		return initials;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	
	public int getFinalScore() {
		return finalScore;
	}
	
	public boolean getRedFlag() {
		return redFlag;
	}
	
	public String getRisk() {
		return risk;
	}
	
	public String getResponse() {
		return response;
	}
}
