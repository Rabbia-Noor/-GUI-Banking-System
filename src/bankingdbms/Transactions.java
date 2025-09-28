package bankingdbms;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit, withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
	String pinnumber;
	
	Transactions(String pinnumber){
		
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel label = new JLabel(i1);
		label.setBounds(0,0,800,750);
		add(label);
		
		JLabel text = new JLabel("Please select your Transaction");
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.WHITE);
		text.setBounds(180,150,700,35);
		label.add(text);
		
		deposit= new JButton("Deposit");
		deposit.setBounds(150,275,130,30);
		deposit.addActionListener(this);
	    label.add(deposit);
	    
	    withdrawl= new JButton("Cash Withdrawl");
	    withdrawl.setBounds(300,275,140,30);
		withdrawl.addActionListener(this);
	    label.add(withdrawl);
	    
	    fastcash= new JButton("Fast Cash");
	    fastcash.setBounds(150,310,130,30);
		fastcash.addActionListener(this);
	    label.add(fastcash);
	    
	    ministatement= new JButton("Mini Statement");
	    ministatement.setBounds(300,310,140,30);
	    ministatement.addActionListener(this);
	    label.add(ministatement);
	    
	    pinchange= new JButton("Pin Change");
	    pinchange.setBounds(150,345,130,30);
	    pinchange.addActionListener(this);
	    label.add(pinchange);
	    
	    balanceenquiry= new JButton("Balance Enquiry");
	    balanceenquiry.setBounds(300,345,140,30);
	    balanceenquiry.addActionListener(this);
	    label.add(balanceenquiry);
	    
	    exit= new JButton("Exit");
	    exit.setBounds(300,380,140,30);
	    exit.addActionListener(this);
	    label.add(exit);
		
		
		setSize(800,750);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		
		if(ae.getSource()== exit)
		{
			System.exit(0);
		}
		else if(ae.getSource()== deposit)
		{
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}
		else if(ae.getSource()== withdrawl)
		{
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		}
		else if(ae.getSource()== fastcash)
		{
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}
		else if(ae.getSource()== pinchange)
		{
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		}
		else if(ae.getSource()== balanceenquiry)
		{
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}
		else if(ae.getSource()== ministatement)
		{
			new MiniStatement(pinnumber).setVisible(true);
		}
}

	public static void main(String[] args) {
		new Transactions("");
	}

}
