package calculatorGit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class OkButton extends CalculatorButton{
	private static char nextChar;
	private static char[] resultData;
	private static int currentNumber;
	private static int nextNumber;
	
	OkButton(String okLabel)
	{
		super(okLabel);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(firstEntryIsANumber()) {
					resultData = Arrays.copyOf(enteredData, positionInCalculation);
					System.out.println(enteredData);
					positionInCalculation = 0;
					doCalculation();
				}
			}
		});
	}
	
	protected static void doCalculation() {
			numberCheckNext();
			CalculatorButton.updateScreen(String.valueOf(currentNumber));
	}
	
	protected static boolean firstEntryIsANumber() {
		if(isNumber(enteredData[0])) {	
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid Entry, please start your entry with a number");
			return false;
		}
	}
	
	protected static void numberCheckNext() {
		currentNumber = Character.getNumericValue(resultData[positionInCalculation]);
		getWholeNumber(positionInCalculation);
	}
	
	private static void getWholeNumber(int startPosition) {
		if(startPosition + 1 < resultData.length) {
			if(isNumber(resultData[startPosition + 1])) {
				getWholeNumber(startPosition + 1);
			}
			else {
				currentNumber = Integer.parseInt(String.valueOf(Arrays.copyOfRange(resultData, positionInCalculation, startPosition + 1)));
				positionInCalculation = startPosition;
				System.out.println("this is the whole number: " + currentNumber);
				operatorCheckNext();
			}
		} else {
				currentNumber = Integer.parseInt(String.valueOf(Arrays.copyOfRange(resultData, positionInCalculation, startPosition + 1)));
				positionInCalculation = startPosition;
				System.out.println("this is the whole number: " + currentNumber);
		}
	}
	
	private static void operatorCheckNext() {
		if(positionInCalculation + 1 < resultData.length) {
			nextChar = resultData[positionInCalculation + 1];
			if(!isNumber(nextChar)) {
				JOptionPane.showMessageDialog(null, "Invalid entry, you can't enter two operators in immediate succession");
			} else {
				if (resultData[positionInCalculation] == '*' || resultData[positionInCalculation] == '/') {
					pointCalculation();
				}
			}
		}	
		// ansonsten wird die letzte eingabe einfach ignoriert
	}
	
	private static boolean isNumber(char entry) {
		if(entry >= '0' && entry <= '9') {	
			return true;
		}
		else {
			return false;
		}
	}
	
	private static void pointCalculation() {
		if(resultData[positionInCalculation] == '*') {
			currentNumber *= resultData[positionInCalculation + 1];
		} else {
			currentNumber /= resultData[positionInCalculation + 1];
		}
	}
	
	private static void lineCalculation() {
		//if(result)
	}
}
