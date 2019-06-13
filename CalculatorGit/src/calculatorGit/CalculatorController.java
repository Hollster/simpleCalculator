package calculatorGit;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorController {
	// sollte eigentlich in CalculatorModel
	static ArrayList<Double> numberList = new ArrayList<Double>(); 
	static ArrayList<Double> currentNumberList = new ArrayList<Double>();
	static ArrayList<Character> operatorList = new ArrayList<Character>();
	
// writing 
	public static void addDigitToCurrentNumberList(double currentDigit) {
		currentNumberList.add(currentDigit);
		System.out.println("currentNumberList: " + Arrays.toString(currentNumberList.toArray()));
	}
	
	public static void writeNumberToArrayList(double currentNumber) {
		numberList.add(currentNumber);
	}
	
	public static double getNumberFromDigits(ArrayList<Double> currentNumberList) {
		double currentNumber = 0;
		int listLength = currentNumberList.size();
		for (int i = listLength - 1, power = 0; i >= 0; i--, power++) {
			currentNumber = currentNumber + currentNumberList.get(i) * Math.pow(10, power);
		}
		return currentNumber;
	}
	
	public static void writeOperatorToArrayList (char operator) {
		writeNumberToArrayList(getNumberFromDigits(currentNumberList));
		operatorList.add(operator);
		currentNumberList.clear();
		System.out.println("currentNumberList: " + Arrays.toString(currentNumberList.toArray()));
		System.out.println("numberList: " + Arrays.toString(numberList.toArray()));
	}

// delete operations
	public static void deleteLastEntry() {
		if (!currentNumberList.isEmpty() || !currentNumberList.isEmpty() || !numberList.isEmpty()) {
			if(!currentNumberList.isEmpty()) {
				deleteLastNumber(currentNumberList);
			}
			else {
				deleteLastOperator(operatorList);
			}
			deleteFromScreen();
			System.out.println("currentNumberList: " + Arrays.toString(currentNumberList.toArray()));
			System.out.println("numberList: " + Arrays.toString(numberList.toArray()));
		}
	}
	
	public static void deleteLastNumber(ArrayList<Double> currentNumberList) {
		int lengthList = currentNumberList.size();
		currentNumberList.remove(lengthList-1);
	}
	
	public static void deleteLastOperator(ArrayList<Character> operatorList) {
		operatorList.remove(operatorList.size()-1);
		convertNumberToArrayList(numberList.get(numberList.size() - 1));
		numberList.remove(numberList.size() - 1);
	}
	
	public static void convertNumberToArrayList(double number) {
		int i = 0;
		double rest = 0;
		while ((number / Math.pow(10, i)) > 1) {
			rest = (number % Math.pow(10, i + 1));
			currentNumberList.add(0, rest / Math.pow(10, i));
			number -= rest;
			i++;
		}
		
	}
// Screen Updates	
	public static void addToScreen(char operator) {
		CalculatorView.textOutput.setText(CalculatorView.textOutput.getText() + operator);
	}
	
	public static void addToScreen(int number) {
		CalculatorView.textOutput.setText(CalculatorView.textOutput.getText() + number);
	}
	
	public static void deleteFromScreen() {
		String currentDisplay = CalculatorView.textOutput.getText();
		CalculatorView.textOutput.setText(currentDisplay.substring(0, currentDisplay.length() - 1));
	}
	
	// Final Edit of Data
		public static void finalEdit() {
			if(currentNumberList.isEmpty()) {
				operatorList.remove(operatorList.size() - 1);
			}
			else {
				writeNumberToArrayList(getNumberFromDigits(currentNumberList));
			}
			System.out.println("currentNumberList: " + Arrays.toString(currentNumberList.toArray()));
			System.out.println("numberList: " + Arrays.toString(numberList.toArray()));
		}

	// Calculation
		public static void doAllPointCalculations() {
			for (int i = 0; i < operatorList.size(); i++) {
				if(isPointCalculation(operatorList.get(i))) {
					numberList.set(i, pointCalculation(numberList.get(i), numberList.get(i+1), operatorList.get(i)));
					numberList.remove(i + 1);
					operatorList.remove(i);
					i--;
				}
				System.out.println("currentNumberList: " + Arrays.toString(currentNumberList.toArray()));
				System.out.println("numberList: " + Arrays.toString(numberList.toArray()));
			}
		}
		
		public static boolean isPointCalculation(char currentOperator) {
			if (currentOperator == '*' || currentOperator == '/') {
				return true;
			} else {
				return false;
			}
		}
		
		public static double pointCalculation(double firstNumber, double secondNumber, char operator) {
			if (operator == '*') {
				return firstNumber * secondNumber;
			} else {
				return firstNumber / secondNumber;
			}
		}
		
		public static double doAllLineCalculations() {
			double result = numberList.get(0);
			for (int i = 0; i < operatorList.size(); i++) {
				result = lineCalculation(result, numberList.get(i + 1), operatorList.get(i));
			}
			return result;
		}

		public static double lineCalculation(double firstNumber, double secondNumber, char operator) {
			if (operator == '+') {
				return firstNumber + secondNumber;
			} else {
				return firstNumber - secondNumber;
			}
		}
		
		public static void postResult(double result) {
			CalculatorView.textOutput.setText(String.valueOf(result));
		}
		
		public static void resetLists() {
			numberList.clear();
			currentNumberList.clear();
			operatorList.clear();
		}
}

