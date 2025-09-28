package bankingdbms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignupTwo  extends JFrame implements ActionListener {
	
	  
	  JTextField cnicTextField;
	  JButton next;
	  JRadioButton syes,sno,eyes,eno;
	  JComboBox religion,income,occupation,education;
	  String formno;
	
	  SignupTwo(String formno){
		  
		this.formno=formno;
		setLayout(null);
		
		setTitle("New Account Application Form - Page No 2");
		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
		additionalDetails.setBounds(290,60,400,30);
		add(additionalDetails);
		
		JLabel reg= new JLabel("Religion:");
		reg.setFont(new Font("Raleway",Font.BOLD,22));
		reg.setBounds(100,140,100,30);
		add(reg);
		
		String valReligion[] = {"Muslim","Hindu","Sikh","Christian","Other"};
		religion= new JComboBox(valReligion);
		religion.setBounds(300,140,400,30);
		religion.setBackground(Color.WHITE);
		add(religion);
		
		JLabel  income1= new JLabel("Income:");
		income1.setFont(new Font("Raleway",Font.BOLD,22));
		income1.setBounds(100,200,100,30);
		add(income1);
	
		String incomeCategory[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
		income= new JComboBox(incomeCategory);
		income.setBounds(300,200,400,30);
		income.setBackground(Color.WHITE);
		add(income);
		
		JLabel edu = new JLabel("Educational");
		edu.setFont(new Font("Raleway",Font.BOLD,22));
		edu.setBounds(100,260,200,30);
		add(edu);
		
		JLabel qualification = new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway",Font.BOLD,22));
		qualification.setBounds(100,285,200,30);
		add(qualification);
		
		String educationValues[] = {"Non-Graduate","Graduate","Post-Graduation","Doctrate","Others"};
		education= new JComboBox(educationValues);
		education.setBounds(300,285,400,30);
		education.setBackground(Color.WHITE);
		add(education);
		
		JLabel occup = new JLabel("Occupation:");
		occup.setFont(new Font("Raleway",Font.BOLD,22));
		occup.setBounds(100,350,200,30);
		add(occup);
		
		String occupationValues[] = {"Salaried","Self-Employed","Business","Student","Retire","Others"};
		occupation= new JComboBox(occupationValues);
		occupation.setBounds(300,350,400,30);
		occupation.setBackground(Color.WHITE);
		add(occupation);
		
		JLabel cnic = new JLabel("CNIC Number:");
		cnic.setFont(new Font("Raleway",Font.BOLD,22));
		cnic.setBounds(100,410,200,30);
		add(cnic);
		
		cnicTextField = new JTextField();
		cnicTextField.setBounds(300,410 ,400 ,30 );
		cnicTextField.setFont(new Font("Raleway",Font.BOLD,14));
		add(cnicTextField);
		
		JLabel scitizen = new JLabel("Senior Citizen:");
		scitizen.setFont(new Font("Raleway",Font.BOLD,22));
		scitizen.setBounds(100,470,200,30);
		add(scitizen);
		 
		syes= new JRadioButton("Yes");
		syes.setBounds(300,470,100,30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(450,470,100,30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup seniorgroup= new ButtonGroup();
		seniorgroup.add(syes);
		seniorgroup.add(sno);
		
		JLabel eaccount = new JLabel("Existing Account:");
		eaccount.setFont(new Font("Raleway",Font.BOLD,22));
		eaccount.setBounds(100,530,200,30);
		add(eaccount);
		
		eyes= new JRadioButton("Yes");
		eyes.setBounds(300,530,100,30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(450,530,100,30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup existinggroup= new ButtonGroup();
		existinggroup.add(eyes);
		existinggroup.add(eno);
		
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway",Font.BOLD,14));
		next.setBounds(620,600,80,30);
		next.addActionListener(this);
		add(next);
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(800,700);
		setVisible(true);
		setLocation(350,0);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		
		String sreligion= (String) religion.getSelectedItem();
		String sincome= (String) income.getSelectedItem();
		String seducation= (String) education.getSelectedItem();
		String soccupation= (String) occupation.getSelectedItem();
		String seniorcitizen=null;
		 
		if(syes.isSelected())
		{
			seniorcitizen="Yes";
		}
		else if(sno.isSelected())
		{
			seniorcitizen="No";
		}
	
		String existingaccount=null;
		if(eyes.isSelected())
		{
			existingaccount="Yes";
		}
		else if(eno.isSelected())
		{
			existingaccount="No";
		}
		
		String scnic= cnicTextField.getText();
		
		
		try {
		if(scnic.equals("")) {
			JOptionPane.showMessageDialog(null,"CNIC is Required");
		}
		else {
			Conn c=new Conn();
			String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+scnic+"','"+seniorcitizen+"','"+existingaccount+"')";
			c.s.executeUpdate(query);	
			 setVisible(false);
			 new SignupThree(formno).setVisible(true);
			}
		
	}catch(Exception e) 
	{
		System.out.println(e);		}
}
	
	public static void main(String[] args)
	{
		new SignupTwo("");
	}

}
