package calculatorGit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

public class OperatorButton extends OutputButtons{
	OperatorButton(String number){
		super(number);
	
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedButton = returnString();
				writeInputToScreen();
				determineOperand(pressedButton);
			}
		});
	
	}
	
	public void determineOperand(String operand) {
		switch (operand) {
			case "*":
				multiply();
			case "/":
				divide();
			case "+":
				plus();
			case "-":
				minus();
		}
	}
	
		public void multiply() {
			System.out.println("multiply");
			}
		
		public void divide() {
			System.out.println("divide");
			
			}
		public void plus() {
			System.out.println("plus");
			if (previousWasPoint) {
				
			} else {
				currentResult += lastNumber;
			}
			}
		public void minus() {
			System.out.println("minus");
			currentResult -= lastNumber;
			}
		
		public void lineCalculation() {
			
		}
		public void pointCalculatoin() {
			
		}
}
