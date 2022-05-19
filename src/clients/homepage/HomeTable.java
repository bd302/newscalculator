package clients.homepage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * <h1>Class used for generating the table window </h1>
 * @author Brad
 *
 */
public class HomeTable extends JPanel {
	
	private static String type;
	private static String value;
	private static int STATUS_COL = 14; //the column number for risk
	
	/**
	 * Constructor for HomeTable			
	 * @param type type of field the table searched for
	 * @param value the value of the field 
	 */
    public HomeTable(String type, String value) {
    	setType(type, value);
    	initialiseUI(type, value);
    	
    }
    
    /**
     * Constructs a JPanel for the table to housed in
     */
    public static void showFrame() {
        JPanel panel = new HomeTable(type, value);
        if (value.length() == 0) {
    		showBox(type);
    	} else {
    		panel.setOpaque(true);

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.setTitle("Table of results where " + type + " = " + value);
            frame.setContentPane(panel);
            frame.pack();
            frame.setVisible(true);
    	}
        
    }
    
    /**
     * Function that goes through the table and recolours the cells based on the risk value
     * @param table The table to recolour
     * @return
     */
    private static JTable colourTable(final JTable table) {
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
            	
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                //find the value
                String risk = (String)table.getModel().getValueAt(row, STATUS_COL);
                
                if ("Low".equals(risk)) {
                	setBackground(table.getBackground());
                    setForeground(table.getForeground());
                } else if ("Low-medium".equals(risk)) {
                	setBackground(Color.YELLOW);
                	setForeground(Color.BLACK);
                } else if("Medium".equals(risk)) {
                	setBackground(Color.ORANGE);
                	setForeground(Color.BLACK);
                } else if ("High".equals(risk)) {
                	setBackground(Color.RED);
                	setForeground(Color.WHITE);
                } else {
                	setBackground(Color.BLACK);
                    setForeground(Color.BLACK);
                }       
                return this;
            }   
        });
        return table;
    }
    
    /**
     * Function called on initialisation, constructs the table
     * @param type type of field that will be searched
     * @param value value of the field
     */
    public void initialiseUI(String type, String value) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1750, 500));
        String[][] data = getRecords(type, value);
        String[] columns = new String[] {
				"nhsNo", 
				"firstname", 
				"lastname", 
				"dob", 
				"respiration", 
				"sp02", 
				"sp02scale", 
				"oxygen",
				"bloodpressure",
				"pulse",
				"consciousness",
				"temperature",
				"finalScore",
				"redFlag",
				"risk",
				"response",
				"initials",
				"time",
				"nexttime"
		};
        JTable table = new JTable(data, columns);
        //					  nhsNo  fn   ln  dob  res  sp02 scale oxy  bp  pul  con tem  fs   rf   ri   re   in   ti    nt
        setColumnWidths(table, 150, 200, 200, 100, 200, 200, 100, 100, 100, 100, 300, 200, 90, 100, 200, 500, 50, 500, 500);
        
        // Turn off JTable's auto resize so that JScrollPane will show a horizontal
        // scroll bar.
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        JTable renderedTable = colourTable(table);

        JScrollPane pane = new JScrollPane(renderedTable);
        add(pane, BorderLayout.CENTER);
        
    }
    
    /**
     * Set the columns widths of the table
     * @param table JTable to have column lengths set
     * @param widths 18 integers that pertain to the size of the columns
     */
    public static void setColumnWidths(JTable table, int... widths) {
    	TableColumnModel columnModel = table.getColumnModel();
    	for (int i = 0; i < widths.length; i++) {
            if (i < columnModel.getColumnCount()) {
                columnModel.getColumn(i).setMaxWidth(widths[i]);
            }
            else break;
            }
    	
    }
    
    public void setType(String type, String value) {
    	this.type = type;
    	this.value = value;
    }
    
    /**
     * Function responsible for the retrieval of the information from the database
     * 
     * @param searchType field to be searched
     * @param searchValue value of the field
     * @return A 2-Dimensional containing the records from the database
     */
	public static String[][] getRecords(String searchType, String searchValue) {
		HttpURLConnection conn = null;
		String[][] results = null;
		try {
			
			URL url = new URL("https://bd302.brighton.domains/news_api/index.php?search="+URLEncoder.encode(searchType)
																				+"&value="+URLEncoder.encode(searchValue));
			String mode = "no-cors";
			String headers = "Access-Control-Allow-Origin";
			String type = "application/x-www-urlencoded; charset=UTF-8";
			
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Mode", mode);
			conn.setRequestProperty("Headers", headers);
			conn.setRequestProperty("Content-Type", type);
			conn.setDoOutput(true);
			conn.connect();
			
			BufferedReader in = new BufferedReader(new InputStreamReader (((HttpURLConnection)url.openConnection()).getInputStream(), Charset.forName("UTF-8")));
			String inputLine = in.readLine();
			JSONArray array = new JSONArray(inputLine);
			in.close();
				
			results = formatAll(array);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.disconnect();
			return results;
		}
		
	}
	
	/**
	 * Transform a JSONArray into a 2-Dimensional array using an ArrayList
	 * @param array JSONArray to be transformed
	 * @return 2-Dimensional array with the contents from the database
	 */
	public static String[][] formatAll(JSONArray array) {
		
		ArrayList<String[]> list = new ArrayList<String[]>();
		for (int i = 0; i < array.length(); i++) {
			
			JSONObject object = array.getJSONObject(i);			
			String sp02scale;
			String nhsNo = object.getString("nhsNo");
			String firstname = object.getString("firstname");		
			String lastname = object.getString("lastname");			
			String dateOfBirth = object.getString("dob");
			String respiration = object.getString("respiration");
			String sp02 = object.getString("sp02");
			String sp02s = object.getString("sp02scale");			
			if (sp02s.equals("0")) {
				sp02scale = "2";
			} else {
				sp02scale = sp02s;
			}
			String oxygen = object.getString("oxygen");
			String bloodpressure = object.getString("bloodpressure");
			String pulse = object.getString("pulse");
			String cons = object.getString("cons");
			String temp = object.getString("temp");
			String finalScore = object.getString("finalscore");
			String redflag = object.getString("redflag");
			String risk = object.getString("risk");
			String response = object.getString("response");
			String initials = object.getString("initials");
			String time = object.getString("time");
			String nexttime = object.getString("nexttime");
			
			String data[] = {nhsNo, firstname, lastname, dateOfBirth, respiration, sp02, sp02scale, oxygen, bloodpressure, pulse, cons, temp, finalScore, redflag, risk, response, initials, time, nexttime};
						
			list.add(data);
		}
		
		String[][] object = new String[list.size()][];
		
		for (int i = 0; i < list.size(); i++) {
			object[i] = list.get(i);
		}
		return object;
	}
	
	/**
	 * Error message if the submit button is hit without a value.
	 * @param v
	 */
	public static void showBox(String v) {		
			JOptionPane.showMessageDialog(null, "Please enter a value for " + v);
	} 
	
}