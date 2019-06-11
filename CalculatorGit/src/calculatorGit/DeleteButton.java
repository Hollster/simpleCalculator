package calculatorGit;

public class DeleteButton extends CalculatorButton{
	DeleteButton(String deleteLabel)
	{
		super(deleteLabel);
	}
	
	protected static void removeLastCharacterFromArray() {
		if (positionInCalculation > 0) {
			positionInCalculation--;
			enteredData[positionInCalculation] = '\u0000';
		}
	}
}
