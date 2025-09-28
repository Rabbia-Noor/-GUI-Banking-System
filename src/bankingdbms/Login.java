package bankingdbms;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	
	JButton login, clear, signup;
	JTextField cardTextField;
	JPasswordField pinTextField;
	Login()
	{
		setTitle("PRIME BANK");
		setLayout(null);
		ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/image.jpg"));
		Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel label = new JLabel(i1);
		label.setBounds(50,10,150,150);
		add(label);
		
		JLabel text = new JLabel("Welcome to Prime Bank");
		text.setFont(new Font("Osward",Font.BOLD,38));
		text.setBounds(210,60,500,40);
		add(text);
		
		JLabel cardno = new JLabel("Card No:");
		cardno.setFont(new Font("Raleway",Font.BOLD,30));
		cardno.setBounds(200,170,150,40);
		add(cardno);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(400,170 ,230 ,30 );
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		JLabel pin = new JLabel("PIN:");
		pin .setFont(new Font("Raleway",Font.BOLD,28));
		pin .setBounds(200,240,150,40);
		add(pin );
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(400,240 ,230 ,30 );
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);
		
		login = new JButton("SIGN IN");
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login .setBounds(300,300,100,30);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear .setBounds(430,300,100,30);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup .setBackground(Color.BLACK);
		signup .setForeground(Color.WHITE);
		signup .setBounds(300,350,230,30);
		signup.addActionListener(this);
		add(signup );
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,480);
		setVisible(true);
		setLocation(350,100);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		}
		else if(ae.getSource()== login) {
			Conn conn= new Conn();
			String cardnumber =cardTextField.getText();
			String pinnumber =pinTextField.getText();
			String query="select * from login where cardnumber= '" +cardnumber+ "'and pin= '"+pinnumber+"'";
			try {
				ResultSet rs= conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
			}
		else if(ae.getSource()==signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	}


	public static void main(String[] args)
	{
		new Login();
	}


}
