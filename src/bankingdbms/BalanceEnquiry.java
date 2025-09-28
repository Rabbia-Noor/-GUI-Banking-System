package bankingdbms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
	
	
	JButton back;
	String  pinnumber;
	
	BalanceEnquiry(String  pinnumber)
	{
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel label = new JLabel(i1);
		label.setBounds(0,0,800,750);
		add(label);
		
		 back= new JButton("Back");
		 back.setBounds(300,380,140,30);
	     back.addActionListener(this);
		 label.add(back);
			
		 Conn conn=new Conn();
		 int balance=0;
			try
			{
				ResultSet rs = conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
				while(rs.next()) {
					
					if(rs.getString("type").equals("Deposit")){
						balance+= Integer.parseInt(rs.getString("amount"));
					}
					else {
						balance-= Integer.parseInt(rs.getString("amount"));
					}
				}
			}
				catch(Exception e)
				{
						System.out.println(e);		
				}
			JLabel text = new JLabel("Your Current Account Balance is Rs "+balance);
			text.setFont(new Font("System",Font.BOLD,16));
			text.setForeground(Color.WHITE);
			text.setBounds(140,150,400,30);
			label.add(text);
		
		
		setSize(800,750);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}

	public static void main(String[] args) {
		new BalanceEnquiry("");

	}

}
