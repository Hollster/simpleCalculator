package calculatorGit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class OkButton extends CalculatorButton{
	private static char[] resultData;
	private static int positionInResultData = 0;
	
	
	OkButton(String okLabel)
	{
		super(okLabel);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultData = Arrays.copyOf(enteredData, positionInCalculation);
				double currentResult = getWholeNumber();
				while(!isEndOfData()) {
					char currentOperator = getCurrentOperator();
					double nextResult = getWholeNumber();
					currentResult = calculation(currentResult, nextResult, currentOperator);	
				}
				updateScreen(String.valueOf(currentResult));
			}
		});
	}
	
	
	
	private static double getWholeNumber() {
		int startPosition = positionInResultData;
		while (!isEndOfData() && resultData[positionInResultData + 1] >= '0' && resultData[positionInResultData + 1] <= '9') {
			positionInResultData++;
		}
		positionInResultData++;
		return Double.parseDouble(String.valueOf(Arrays.copyOfRange(resultData, startPosition, positionInResultData)));
	}
	
	private static boolean isEndOfData () {
		if(positionInResultData + 1 >= resultData.length) {
			return true;
		} else {
			return false;
		}
	}
	
	private static char getCurrentOperator() {
		positionInResultData++;
		return resultData[positionInResultData -1];
	}
		
	
	private static double calculation (double currentResult, double nextResult, char operator) {
		switch (operator) {
		case '+':
			if (nextIsLineOperator()) {
				return currentResult + nextResult;
			} else {
				return currentResult + calculateNextResult(nextResult);
			}
		case '-':
			if (nextIsLineOperator()) {
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
	
	private static double calculateNextResult(double currentNumber) {
		return 77.7;
	}
	
	private static boolean nextIsLineOperator() {
		if (!isEndOfData()) {
			if (getCurrentOperator() == '-' || getCurrentOperator() == '+' ){
				positionInResultData--;
				return true;	
			} else {
				positionInResultData--;
				return false;
			}
		} else {
			return true;
		}
	}
}
