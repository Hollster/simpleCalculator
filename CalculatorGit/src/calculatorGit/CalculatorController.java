package calculatorGit;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorController {
	// sollte eigentlich in CalculatorModel
	static ArrayList<Integer> numberList = new ArrayList<Integer>(); 
	static ArrayList<Integer> digitList = new ArrayList<Integer>();
	static ArrayList<Character> operatorList = new ArrayList<Character>();
	
// writing
	public static void appendDigit(int currentDigit) {
		digitList.add(currentDigit);
	}
	
	private static void appendNumber(int currentNumber) {
		numberList.add(currentNumber);
	}
	
	private static int getNumberFromDigits(ArrayList<Integer> digitList) {
		int currentNumber = 0;
		int listLength = digitList.size();
		for (int i = listLength - 1, power = 0; i >= 0; i--, power++) {
			currentNumber = currentNumber + digitList.get(i) * (int)Math.pow(10, power);
		}
		return currentNumber;
	}
	
	public static void appendOperator (char operator) {
		if(!digitList.isEmpty()) {
			appendNumber(getNumberFromDigits(digitList));
			operatorList.add(operator);
			digitList.clear();
		} else {
			if (!numberList.isEmpty()) {
				operatorList.set(operatorList.size() - 1, operator);
				//deleteFromScreen();
				updateScreen();
			} else {
				appendNumber(0);
				operatorList.add(operator);
			}
		}
	}

// deleting
	public static void deleteLastEntry() {
		if (!digitList.isEmpty() || !operatorList.isEmpty() || !numberList.isEmpty()) {
			if(!digitList.isEmpty()) {
				deleteLastNumber(digitList);
			}
			else {
				deleteLastOperator(operatorList);
			}
			updateScreen();
			addZeroToBlankScreen();
		}
	}
	
	private static void addZeroToBlankScreen() {
		if(digitList.isEmpty() && numberList.isEmpty()) {
			CalculatorView.textOutput.setText("0");
		}
	}
	
	private static void deleteLastNumber(ArrayList<Integer> digitList) {
		int lengthList = digitList.size();
		digitList.remove(lengthList-1);
	}
	
	private static void deleteLastOperator(ArrayList<Character> operatorList) {
		operatorList.remove(operatorList.size()-1);
		convertNumberToDigits(numberList.get(numberList.size() - 1));
		numberList.remove(numberList.size() - 1);
	}
	
	private static void convertNumberToDigits(int number) {
		int i = 0;
		int rest = 0;
		while ((number / Math.pow(10, i)) >= 1) {
			rest = (number % (int)Math.pow(10, i + 1));
			digitList.add(0, rest / (int)Math.pow(10, i));
			number -= rest;
			i++;
		}
		
	}
	
	public static void updateScreen() {
		String currentDisplay = "";
		for (int i = 0; i < numberList.size(); i++) {
			currentDisplay = currentDisplay + numberList.get(i);
			currentDisplay = currentDisplay + operatorList.get(i);
		}
		for (int j = 0; j < digitList.size(); j++) {
			currentDisplay = currentDisplay + digitList.get(j);
		}
		CalculatorView.textOutput.setText(currentDisplay);
	}
	
	
// Final Edit of Data
	private static void finalEdit() {
		if(digitList.isEmpty()) {
			operatorList.remove(operatorList.size() - 1);
		}
		else {
			appendNumber(getNumberFromDigits(digitList));
		}
	}
	
	// Calculation
	public static void calculation() {
		finalEdit();
		doAllPointCalculations();
		postResult(CalculatorController.doAllLineCalculations());
		resetLists();
	}
	
	private static void doAllPointCalculations() {
		for (int i = 0; i < operatorList.size(); i++) {
			if(isPointCalculation(operatorList.get(i))) {
				numberList.set(i, pointCalculation(numberList.get(i), numberList.get(i+1), operatorList.get(i)));
				numberList.remove(i + 1);
				operatorList.remove(i);
				i--;
			}
		}
	}
		
	private static boolean isPointCalculation(char currentOperator) {
		return currentOperator == '*' || currentOperator == '/';
	}
	
	private static int pointCalculation(int firstNumber, int secondNumber, char operator) {
		return operator == '*' ? firstNumber * secondNumber : firstNumber / secondNumber;
	}
	
	private static int doAllLineCalculations() {
		int result = numberList.get(0);
		for (int i = 0; i < operatorList.size(); i++) {
			result = lineCalculation(result, numberList.get(i + 1), operatorList.get(i));
		}
		return result;
	}

	private static int lineCalculation(int firstNumber, int secondNumber, char operator) {
		return operator == '+' ? firstNumber + secondNumber : firstNumber - secondNumber;
	}
	
	private static void postResult(int result) {
		CalculatorView.textOutput.setText(String.valueOf(result));
	}
	
	private static void resetLists() {
		numberList.clear();
		digitList.clear();
		operatorList.clear();
	}
}