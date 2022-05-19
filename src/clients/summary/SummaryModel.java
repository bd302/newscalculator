package clients.summary;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;


public class SummaryModel {
	
	private static SummaryController cont;
	
	public static int rc;	
	public static String rm;
	

	public SummaryModel() {
		// TODO Auto-generated constructor stub
	}
	
	public static Boolean post(clients.Record r) { 
		int sp02scale = 0;
		String number=r.getNumber();
		String firstname =r.getFName();
		String lastname =r.getLName();
		String dob=r.getdob();
		int respiration=r.getResp();
		int sp02 = r.getsp02();		
		boolean sp02s= r.getsp02scale();
		String oxygen = r.getOxygen();
		int bloodpressure = r.getBPressure();
		int pulse = r.getPulse();
		String cons = r.getCons();
    	float temp = r.getTemp();
    	int finalScore = r.getFinalScore();
    	boolean redFlag = r.getRedFlag();
    	String risk = r.getRisk();
    	String response = r.getResponse();
    	String initials = r.getInitials();
    	LocalDateTime time = LocalDateTime.now();
    	LocalDateTime nexttime = null;
    	HttpURLConnection conn = null;
    	
    	if (redFlag == true) {
    		nexttime = (time.plusHours(1));    	
    	} else if (finalScore == 0) {
    		nexttime = (time.plusHours(12));
    	} else if (finalScore > 0 && finalScore <= 4) {
    		nexttime = (time.plusHours(4));
    	} else if (finalScore > 4 && finalScore <= 7) {
    		nexttime = (time.plusHours(1));
    	}
    	
		try {
				if (sp02s == true) {
					sp02scale = 0;				
				} else if (sp02s == false) {
					sp02scale = 1;
				}
				
				URL url = new URL("https://bd302.brighton.domains/news_api/index.php?");
				Map<String,String> arguments = new HashMap<>();
				arguments.put("nhsNo", number);
				arguments.put("firstname", firstname);
				arguments.put("lastname", lastname);
				arguments.put("dob", dob);
				arguments.put("respiration", String.valueOf(respiration));
				arguments.put("sp02", String.valueOf(sp02));
				arguments.put("sp02scale", String.valueOf(sp02scale));
				arguments.put("oxygen", oxygen);
				arguments.put("bloodpressure", String.valueOf(bloodpressure));
				arguments.put("pulse", String.valueOf(pulse));
				arguments.put("cons", cons);
				arguments.put("temp", String.valueOf(temp));
				arguments.put("finalscore", String.valueOf(finalScore));
				arguments.put("redflag", String.valueOf(redFlag));
				arguments.put("risk", risk);
				arguments.put("response", response);
				arguments.put("initials", initials);
				arguments.put("time", String.valueOf(time));
				arguments.put("nexttime", String.valueOf(nexttime));

				StringJoiner sj = new StringJoiner("&");

				for(Map.Entry<String,String> entry : arguments.entrySet())
					sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
							+ URLEncoder.encode(entry.getValue(), "UTF-8"));
				byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
				int length = out.length;

				String mode = "no-cors";
				String headers = "Access-Control-Allow-Origin";
				String type = "application/x-www-form-urlencoded; charset=UTF-8";

				conn=(HttpURLConnection)url.openConnection();	
				conn.setRequestMethod("POST");
				conn.setFixedLengthStreamingMode(length);
				conn.setRequestProperty("Mode", mode);
				conn.setRequestProperty("Headers", headers);
				conn.setRequestProperty("Content-Type", type);
				conn.setDoOutput(true);
				conn.connect();
				

				try (OutputStream os = conn.getOutputStream()) {
					os.write(out);
				}
				
				rc = conn.getResponseCode();				
				rm = conn.getResponseMessage();
				
				return true;

			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}finally {
				conn.disconnect();
			}				
	}
	

	public void setController(SummaryController c) {
		cont = c;
	}
}