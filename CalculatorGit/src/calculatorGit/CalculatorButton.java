package calculatorGit;

import javax.swing.JButton;

public class CalculatorButton extends JButton{
	protected static char[] enteredData = new char[24];
	protected static int positionInCalculation = 0;

	CalculatorButton(String number){
		super(number);
	}
	
	protected static void convertToStringThenCallUpdate() {
		String screenDisplay = String.copyValueOf(enteredData).substring(0, positionInCalculation);
		updateScreen(screenDisplay);
	}
	
	protected static void updateScreen(String screenDisplay) {
		CalculatorView.textOutput.setText(screenDisplay);
	}
}
