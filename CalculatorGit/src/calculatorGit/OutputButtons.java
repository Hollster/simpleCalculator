package calculatorGit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

public class OutputButtons extends JButton{
	public char pressedButton;
	public double lastNumber;
	public double currentResult;
	public double currentPointCalculationResult;
	private static char[] enteredData = new char[24];
	public static int positionInCalculation = 0;
	
	OutputButtons(String number){
		super(number);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (positionInCalculation < 24) {
					pressedButton = returnChar();
					writeInputIntoArray();
					updateScreen();
					
				} else {
					System.out.println("Limit erreicht");
				}
			}
		});
	}
	
	public char returnChar() {
		return this.getText().charAt(0);
	}
	
	public static void updateScreen() {
		String screenDisplay = String.copyValueOf(enteredData).substring(0, positionInCalculation);
		CalculatorView.textOutput.setText(screenDisplay);
	}
	
	public void writeInputIntoArray() {
		enteredData[positionInCalculation] = pressedButton;
		positionInCalculation++;
	}
	
	public static void removeLastCharacterFromArray() {
		positionInCalculation--;
		enteredData[positionInCalculation] = '\u0000';
	}
}
