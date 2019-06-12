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
				double currentResult = getWholeNumber();
				while(!isEndOfData()) {
					positionInResultData++;
					char currentOperator = getCurrentOperator();
					positionInResultData++;
					double nextResult = getWholeNumber();
					currentResult = calculation(currentResult, currentOperator, nextResult);	
				}
				updateScreen(String.valueOf(currentResult));
			}
		});
	}

	private static double getWholeNumber() {
		// we need this as a default to compare to
		int startPosition = positionInResultData;
		// erst gucken, ob wir schon am ende sind
		// wenn nein, gucken, ob der nächste character ne zahl ist
		// falls ja, einen weiter gehen, das passiert so lange, bis wir an der letzten charakter sind, die eine zahl ist
		while (!isEndOfData() && resultData[positionInResultData + 1] >= '0' && resultData[positionInResultData + 1] <= '9') {
			positionInResultData++;
		}
		// wenn wir das ende erreicht haben, gehen wir mit dem counter einen hoch, dh jetzt sind wir eigentlich schon am ende oder beim operator
		//positionInResultData++;
		return Double.parseDouble(String.valueOf(Arrays.copyOfRange(resultData, startPosition, positionInResultData + 1)));
	}
	
	private static boolean isEndOfData () {
		if(positionInResultData + 1 >= resultData.length) {
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
	
	private static double calculateNextResult(double nextResult) {
		double currentResult = nextResult;
		while (!isEndOfData() && !nextIsLineOperator()) {
			positionInResultData++;
			char currentOperator = getCurrentOperator();
			positionInResultData++;
			currentResult = getWholeNumber();			
			currentResult = calculation(nextResult, currentOperator, currentResult);
		}
		return currentResult;
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
