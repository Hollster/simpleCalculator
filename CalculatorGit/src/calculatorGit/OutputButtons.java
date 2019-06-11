package calculatorGit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

public class OutputButtons extends JButton{
	public String pressedButton;
	public double lastNumber;
	public double currentResult;
	public double currentPointCalculationResult;
	
	OutputButtons(String number){
		super(number);
	}
	
	public String returnString() {
		return this.getText();
	}
	
	public void writeInputToScreen() {
		CalculatorView.textOutput.setText(CalculatorView.textOutput.getText() + pressedButton);
	}
}
