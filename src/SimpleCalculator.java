/*
 * 
 * Author: Akmal Sab 17/04/2020 7:33 AM
 * 
 */

//to import all related package
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;


public class SimpleCalculator implements ActionListener {
	
	//create variable
	public String firstInput, secondInput; 
	public int total;
	
	//create JTextField as a public so that all function can recognize
	JTextField input1 = new JTextField(5);
	JTextField input2 = new JTextField(5);
	
	//class constructor set initial values for variables
	public SimpleCalculator() {
		firstInput = ""; 
		secondInput = "";
		total = 0;
	}
	
	//function to create and show the UI	
	public void createAndShowGui() {
		//create a frame first without title
		JFrame frame = new JFrame();
		//To set the operation when user close the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		//To set the size of the window. (width,height)
		frame.setSize(300,200);
		//To set layout manager
		frame.setLayout(new BorderLayout());		
		
		//Create a panel
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();
		//To set layout manager
		centerPanel.setLayout(new GridLayout(2,2));
		southPanel.setLayout(new FlowLayout());			
		
		//Create a label and give them label's name
		JLabel title = new JLabel("Simple Calculator");
		JLabel firstNumber = new JLabel("First number:");
		JLabel secondNumber = new JLabel("Second number:");
		
		//JLabel nulls = new JLabel("");
		
		//Create a button and give them button's name
		JButton add = new JButton("Add");
		JButton reset = new JButton("Reset");	
		
		//Register GUI component to the appropriate listener
		add.addActionListener(this);		
		//Register GUI component to the appropriate listener (Using Anonymous class)
		reset.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e){
			    	input1.setText("");
			    	input2.setText("");
			    }  
			    });  
		
		//To add created component into frame
		frame.add(title, BorderLayout.NORTH);
		frame.add(centerPanel,BorderLayout.CENTER);
		frame.add(southPanel,BorderLayout.SOUTH);
		//frame.add(nulls, BorderLayout.EAST);
		//frame.add(nulls, BorderLayout.WEST);
		
		//To add created component into panel
		centerPanel.add(firstNumber);
		centerPanel.add(input1);		
		centerPanel.add(secondNumber);
		centerPanel.add(input2);
		
		//To add created component into panel
		southPanel.add(add);
		southPanel.add(reset);
		
		//To set frame visibility
		frame.setVisible(true);		
	}
	
	//function that will be trigger by ActionListener for 'Add' button
	public void actionPerformed(ActionEvent e) {
		firstInput = input1.getText(); //assign input1 value to variable firstInput
		secondInput = input2.getText(); //assign input1 value to variable secondInput
		total = Integer.parseInt(firstInput) + Integer.parseInt(secondInput); //convert string to int then add them both and assign it to variable 'total'
		System.out.println(firstInput + " + " + secondInput + " = " + total); //output the answers in console
	}
	
	public static void main(String[] args) {		
		SimpleCalculator sc = new SimpleCalculator(); //create class object's name sc
		sc.createAndShowGui();//call class function
	}

}
