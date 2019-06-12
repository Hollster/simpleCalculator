package calculatorGit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class OkButton extends CalculatorButton{
	private static char[] resultData;
	private static int positionInResultData;
		
	OkButton(String okLabel)
	{
		super(okLabel);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultData = Arrays.copyOf(enteredData, positionInCalculation);
				positionInResultData = 0;
				if (isNumber()) {
				double currentResult = getWholeNumber();
				while(!isEndOfData()) {
					positionInResultData++;
					char currentOperator = getCurrentOperator();
					positionInResultData++;
					if(isNumber()) {
						double nextResult = getWholeNumber();
						currentResult = calculation(currentResult, currentOperator, nextResult);	
					} else {
						JOptionPane.showMessageDialog(null, "Invalid entry, you can't enter two operators in immediate succession");
						break;
					}
				}
				updateScreen(String.valueOf(currentResult));
			} else {
				JOptionPane.showMessageDialog(null, "Please start your entry with a number");
			}
				
			}
		});
	}

	private static double getWholeNumber() {
		int startPosition = positionInResultData;
		while (!isEndOfData() && resultData[positionInResultData + 1] >= '0' && resultData[positionInResultData + 1] <= '9') {
			positionInResultData++;
		}
		return Double.parseDouble(String.valueOf(Arrays.copyOfRange(resultData, startPosition, positionInResultData + 1)));
	}
	
	private static boolean isEndOfData () {
		if(positionInResultData + 1 >= resultData.length) {
			return true;
		} else {
			return false;
		}
	}
	
	private static boolean isNumber() {
		if (resultData[positionInResultData] >= '0' && resultData[positionInResultData] <= '9') {
			return true;
		} else {
			return false;
		}
	}
	
	private static char getCurrentOperator() {
		return resultData[positionInResultData];
	}
		
	private static double calculation (double currentResult, char operator, double nextResult) {
		switch (operator) {
		case '+':
			if (isEndOfData() || nextIsLineOperator()) {
				return currentResult + nextResult;
			} else {
				return currentResult + calculateNextResult(nextResult);
			}
		case '-':
			if (isEndOfData() || nextIsLineOperator()) {
				return currentResult - nextResult;
			} else {
				return currentResult - calculateNextResult(nextResult);
			}
		case '*':
			return currentResult * nextResult;
		case '/':
			return currentResult / nextResult;
		default:
			System.exit(1);
			return currentResult;
		}
	}
	
	private static double calculateNextResult(double currentResult) {
		double nextResult = currentResult;
		while (!isEndOfData() && !nextIsLineOperator()) {
			positionInResultData++;
			char currentOperator = getCurrentOperator();
			positionInResultData++;
			if(isNumber()) {
				nextResult = getWholeNumber();
				nextResult = calculation(currentResult, currentOperator, nextResult);	
			} else {
				JOptionPane.showMessageDialog(null, "Invalid entry, you can't enter two operators in immediate succession");
				break;
			}
		}
		return nextResult;
	}
	
	private static boolean nextIsLineOperator() {
		positionInResultData++;
		if (getCurrentOperator() == '-' || getCurrentOperator() == '+' ){
			positionInResultData--;
			return true;	
		} else {
			positionInResultData--;
			return false;
		}
	}
}
