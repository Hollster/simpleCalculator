package calculatorGit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class OutputButton extends CalculatorButton{
	public char pressedButton;
	public double lastNumber;
	public double currentResult;
	public double currentPointCalculationResult;
	
	OutputButton(String number){
		super(number);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (positionInCalculation < 24) {
					pressedButton = returnChar();
					writeInputIntoArray();
					convertToStringThenCallUpdate();
					
				} else {
					JOptionPane.showMessageDialog(null, "Limit erreicht");
				}
			}
		});
	}
	
	private char returnChar() {
		return this.getText().charAt(0);
	}
	
	private void writeInputIntoArray() {
		enteredData[positionInCalculation] = pressedButton;
		positionInCalculation++;
	}
}
