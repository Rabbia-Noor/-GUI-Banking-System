package bankingdbms;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
	
	JButton r1,r2,r3,r4,r5,r6,back;
	String pinnumber;
	
	FastCash(String pinnumber){
		
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/atm2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel label = new JLabel(i1);
		label.setBounds(0,0,800,750);
		add(label);
		
		JLabel text = new JLabel("Select Withdrawl Amount");
		text.setFont(new Font("System",Font.BOLD,16));
		text.setForeground(Color.WHITE);
		text.setBounds(180,150,700,35);
		label.add(text);
		
		r1= new JButton("Rs 100");
		r1.setBounds(150,275,130,30);
		r1.addActionListener(this);
	    label.add(r1);
	    
	    r2= new JButton("Rs 500");
	    r2.setBounds(300,275,140,30);
		r2.addActionListener(this);
	    label.add(r2);
	    
	    r3= new JButton("Rs 1000");
	    r3.setBounds(150,310,130,30);
		r3.addActionListener(this);
	    label.add(r3);
	    
	    r4= new JButton("Rs 2000");
	    r4.setBounds(300,310,140,30);
	    r4.addActionListener(this);
	    label.add(r4);
	    
	    r5= new JButton("Rs 5000");
	    r5.setBounds(150,345,130,30);
	    r5.addActionListener(this);
	    label.add(r5);
	    
	    r6= new JButton("Rs 10,000");
	    r6.setBounds(300,345,140,30);
	    r6.addActionListener(this);
	    label.add(r6);
	    
	    back= new JButton("Back");
	    back.setBounds(300,380,140,30);
	    back.addActionListener(this);
	    label.add(back);
		
		
		setSize(800,750);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
	}	
	
	public void actionPerformed(ActionEvent ae) {
	    String amount = null;
	    if (ae.getSource() == back) {
	        setVisible(false);
	        new Transactions(pinnumber).setVisible(true);
	    } else {
	        amount = ((JButton) ae.getSource()).getText().substring(3);
	    }

	    if (amount == null) {
	        return; 
	    }

	    Conn c = new Conn();
	    try {
	        ResultSet rs = c.s.executeQuery("select * from bank where pin='" + pinnumber + "'");
	        int balance = 0;
	        while (rs.next()) {
	            if (rs.getString("type").equals("Deposit")) {
	                balance += Integer.parseInt(rs.getString("amount"));
	            } else {
	                balance -= Integer.parseInt(rs.getString("amount"));
	            }
	        }

	        if (balance < Integer.parseInt(amount)) {
	            JOptionPane.showMessageDialog(null, "Insufficient Balance");
	            return;
	        }

	        Date date = new Date();
	        String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Withdrawl', '" + amount + "')";
	        c.s.executeUpdate(query);
	        JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
	        setVisible(false);
	        new Transactions(pinnumber).setVisible(true);
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}


	public static void main(String[] args) {
		new FastCash("");
	}

}
