package clients.summary;

import java.awt.Container;
import java.awt.Font;

import javax.swing.*;
import clients.Record; 

import javax.swing.RootPaneContainer;

public class SummaryView {
	
	private static final int H = 600;       
	private static final int W = 400;
	
	private final JLabel titlelbl			= new JLabel();
	
	private final JLabel namelbl 			= new JLabel();
	private final JLabel numberlbl			= new JLabel();
	private final JLabel doblbl				= new JLabel();
	private final JLabel resplbl 			= new JLabel();
	private final JLabel sp02lbl 			= new JLabel();
	private final JLabel oxygenlbl			= new JLabel();
	private final JLabel bpressurelbl 		= new JLabel();
	private final JLabel pulselbl			= new JLabel();
	private final JLabel conslbl			= new JLabel();
	private final JLabel templbl			= new JLabel();
	private final JLabel finalScorelbl  	= new JLabel();
	private final JLabel risklbl			= new JLabel();
	private final JLabel wardResponselbl	= new JLabel();
	private final JLabel redFlaglbl			= new JLabel();
	private final JLabel initialslbl		= new JLabel();	
	private final JButton postbtn			= new JButton();
	
	private SummaryController cont;
	public Record subject;

	public SummaryView(RootPaneContainer rpc, int x, int y, Record r) {
		subject = r;
		Container cp = rpc.getContentPane();
		Container rootWindow = (Container) rpc;
		cp.setLayout(null);
		rootWindow.setSize(W, H);
		rootWindow.setLocation(x,y);
		cp.setBackground(new java.awt.Color(255,255,255));
		
		titlelbl.setBounds(35, 10+30*0, 200, 20);
		titlelbl.setText("Summary");
		cp.add(titlelbl);
		
		namelbl.setBounds(35, 35+30*1, 200, 20);
		namelbl.setText("Name: " + r.getFName() + " " + r.getLName());
		cp.add(namelbl);
		
		numberlbl.setBounds(200, 35+30*1, 200, 20);
		numberlbl.setText("NHS Number: " + r.getNumber());
		cp.add(numberlbl);
		
		doblbl.setBounds(35, 25+30*2, 200, 20);
		doblbl.setText("Date of Birth: " + r.getdob());
		cp.add(doblbl);
		
		resplbl.setBounds(35, 35+30*3, 200, 20);
		resplbl.setText("Respiration: " + r.getResp());
		cp.add(resplbl);
		
		String scale;
		if (r.getsp02scale()) {
			scale = "Scale 2";
		} else {
			scale = "Scale 1";
		}
		
		sp02lbl.setBounds(35, 35+30*4, 200, 20);
		sp02lbl.setText("Sp02: " + r.getsp02() + " (" + scale + ")") ;
		cp.add(sp02lbl);
		
		oxygenlbl.setBounds(35, 35+30*5, 200, 20);
		oxygenlbl.setText("Air or Oxygen: " + r.getOxygen());
		cp.add(oxygenlbl);
		
		bpressurelbl.setBounds(35, 35+30*6, 200, 20);
		bpressurelbl.setText("Systolic blood pressure: " + r.getBPressure());
		cp.add(bpressurelbl);
		
		pulselbl.setBounds(35, 35+30*7, 200, 20);
		pulselbl.setText("Pulse rate: " + r.getPulse());
		cp.add(pulselbl);
		
		conslbl.setBounds(35, 35+30*8, 200, 20);
		conslbl.setText("Consciousness: " + r.getCons());
		cp.add(conslbl);
		
		templbl.setBounds(35, 35+30*9, 200, 20);
		templbl.setText("Temperature: " + r.getTemp());
		cp.add(templbl);
		
		int fScore = r.getFinalScore();
		finalScorelbl.setBounds(35, 35+30*11, 200, 20);
		finalScorelbl.setText("NEWS Score: " + fScore);
		cp.add(finalScorelbl);
		
		risklbl.setBounds(35, 35+30*12, 400, 20);		
		risklbl.setText("> Risk: " + r.getRisk() );
		cp.add(risklbl);
		
		wardResponselbl.setBounds(35, 35+30*13, 400, 20);
		wardResponselbl.setText("> Response: " + r.getResponse() );
		cp.add(wardResponselbl);
		
		if (r.getRedFlag()) {
			redFlaglbl.setBounds(35, 35+ 30*14, 250, 20);
			redFlaglbl.setText("<A value entered has a score of 3>");
			cp.add(redFlaglbl);
		}
		
		initialslbl.setBounds(35,35 +30*15, 250, 20);
		initialslbl.setText("Your initials: " + r.getInitials());
		cp.add(initialslbl);
		
		postbtn.setBounds(275, 35+ 30*15, 90, 20);
		postbtn.setText("Submit");
	
		
		postbtn.addActionListener(
				e -> cont.doPost(subject));		
		cp.add(postbtn);
		
	}
	
	public void setController(SummaryController c) {
		cont = c;
	}
	
	public void showBox(Boolean b, String value1, String value2) {
		if (b == true) {
			JOptionPane.showMessageDialog(null, "Record created for " + value1 + " " + value2 + ". You may close the summary window.");
		} else {
			JOptionPane.showMessageDialog(null, "Response Code: " + value1 + " Response Message " + value2);
		}
	} 	
	
}
