package clients.calculator;


public class CalculatorResults {
	
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

	public CalculatorResults(String fn, String ln, String n, String dob, int r, int sp, boolean sps, String o, int bp, int p, String c, float t, String i) {
		
		forename = fn;
		lastname = ln;
		number = n;
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
	}

	public String getForename() {
		return forename;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getNumber() {
		return number;
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
	

}
