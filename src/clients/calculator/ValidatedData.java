package clients.calculator;

public class ValidatedData {
	
	private CalculatorResults results;
	private boolean errorFlag;
	private String errormsg;

	public ValidatedData(CalculatorResults r, boolean ef, String em) {
		results = r;
		errorFlag = ef;
		errormsg = em;
		
	}
	
	public CalculatorResults getResults() {
		return results;
	}
	
	public boolean getFlag() {
		return errorFlag;
	}
	
	public String getMsg() {
		return errormsg;
	}


}
