package calculatorGit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButton extends OutputButtons{
	NumberButton(String number){
		super(number);
	
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedButton = returnString();
				writeInputToScreen();
				printNumber(pressedButton);
			}
		});
	
	}
	
	public void printNumber(String number) {
		System.out.println(number);
	}
	
	public void saveNumber(String number) {
		lastNumber = Double.parseDouble(number);
	}
}
