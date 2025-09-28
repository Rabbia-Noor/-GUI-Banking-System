package bankingdbms;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
	
	String pinnumber;
	JPasswordField pinTextField,repinTextField;
	JButton change,back;
	
	PinChange(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel label = new JLabel(i1);
		label.setBounds(0,0,800,750);
		add(label);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.WHITE);
		text.setBounds(180,150,700,35);
		label.add(text);
		
		JLabel pintext = new JLabel("New PIN:");
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setForeground(Color.WHITE);
		pintext.setBounds(150,210,180,25);
		label.add(pintext);
		

		pinTextField = new JPasswordField();
		pinTextField.setBounds(300,210 ,150 ,25 );
		pinTextField.setFont(new Font("Raleway",Font.BOLD,25));
		label.add(pinTextField);
		
		JLabel repintext = new JLabel("Re-Enter New PIN:");
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setForeground(Color.WHITE);
		repintext.setBounds(150,250,180,25);
		label.add(repintext);

		repinTextField = new JPasswordField();
		repinTextField.setBounds(300,250 ,150 ,25 );
		repinTextField.setFont(new Font("Raleway",Font.BOLD,25));
		label.add(repinTextField);
		
		change= new JButton("Change");
		change.setBounds(300,345,140,30);
		change.addActionListener(this);
	    label.add(change);
	    
	    back= new JButton("Back");
	    back.setBounds(300,380,140,30);
		back.addActionListener(this);
	    label.add(back);
		
		
		
		setSize(800,750);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		

		if(ae.getSource()== change) {
				try {
				    String npin= pinTextField.getText();
				    String repin= repinTextField.getText();
				    
				    if(!npin.equals(repin)) {
				    	JOptionPane.showMessageDialog(null,"Entered PIN does not match");
				    	return;
				    }
				    if(npin.equals("")) {
				    	JOptionPane.showMessageDialog(null,"Please Enter New PIN");
				    	return;
				    }
				    if(repin.equals("")) {
				    	JOptionPane.showMessageDialog(null,"Please Re-Enter New PIN");
				    	return;
				    }
				    Conn conn=new Conn();
				    String query1="update bank set pin = '"+repin+"' where pin= '"+pinnumber+"'";
				    String query2="update login set pin = '"+repin+"' where pin= '"+pinnumber+"'";
				    String query3="update signupthree set pin = '"+repin+"' where pin= '"+pinnumber+"'";
				    
				   conn.s.executeUpdate(query1);	
				   conn.s.executeUpdate(query2);	
				   conn.s.executeUpdate(query3);	
                      
				    JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
				    setVisible(false);
					new Transactions(repin).setVisible(true);
				}
				catch(Exception e){
					System.out.println(e);		
				}
		}
		else 
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}

	
	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}

}
