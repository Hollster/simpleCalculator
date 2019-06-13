package calculatorGit;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CalculatorView extends JFrame {

	private JPanel contentPane;
	public static JTextField textOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorView frame = new CalculatorView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculatorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textOutput = new JTextField();
		textOutput.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textOutput.setHorizontalAlignment(SwingConstants.RIGHT);
		textOutput.setBackground(Color.CYAN);
		textOutput.setEditable(false);
		textOutput.setBounds(10, 11, 416, 55);
		contentPane.add(textOutput);
		textOutput.setColumns(10);
		
		OutputButton buttonPlus = new OutputButton("+");
		buttonPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.writeOperatorToArrayList('+');
				CalculatorController.addToScreen('+');
			}
		});
		buttonPlus.setBounds(16, 77, 89, 23);
		contentPane.add(buttonPlus);
		
		OutputButton buttonMinus = new OutputButton("-");
		buttonMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.writeOperatorToArrayList('-');
				CalculatorController.addToScreen('-');
			}
		});
		buttonMinus.setBounds(121, 77, 89, 23);
		contentPane.add(buttonMinus);
		
		OutputButton buttonTimes = new OutputButton("*");
		buttonTimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.writeOperatorToArrayList('*');
				CalculatorController.addToScreen('*');
			}
		});
		buttonTimes.setBounds(232, 77, 89, 23);
		contentPane.add(buttonTimes);
		
		OutputButton buttonDivided = new OutputButton("/");
		buttonDivided.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.writeOperatorToArrayList('/');
				CalculatorController.addToScreen('/');
			}
		});
		buttonDivided.setBounds(331, 77, 89, 23);
		contentPane.add(buttonDivided);
			
		DeleteButton buttonDel = new DeleteButton("Del");
		buttonDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.deleteLastEntry();
			}
		});
		buttonDel.setBounds(331, 121, 89, 23);
		contentPane.add(buttonDel);
		
		OkButton buttonOK = new OkButton("OK");
		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonOK.setBounds(337, 155, 83, 57);
		contentPane.add(buttonOK);
		
		OutputButton button_1 = new OutputButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.addDigitToCurrentNumberList(1);
				CalculatorController.addToScreen('1');
			}
		});
		button_1.setBounds(10, 121, 89, 23);
		contentPane.add(button_1);
		
		OutputButton button_2 = new OutputButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.addDigitToCurrentNumberList(2);
				CalculatorController.addToScreen('2');
			}
		});
		button_2.setBounds(121, 121, 89, 23);
		contentPane.add(button_2);
		
		OutputButton button_3 = new OutputButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.addDigitToCurrentNumberList(3);
				CalculatorController.addToScreen('3');
			}
		});
		button_3.setBounds(232, 121, 89, 23);
		contentPane.add(button_3);
		
		OutputButton button_4 = new OutputButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.addDigitToCurrentNumberList(4);
				CalculatorController.addToScreen('4');
			}
		});
		button_4.setBounds(10, 155, 89, 23);
		contentPane.add(button_4);
		
		OutputButton button_5 = new OutputButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.addDigitToCurrentNumberList(5);
				CalculatorController.addToScreen('5');
			}
		});
		button_5.setBounds(121, 155, 89, 23);
		contentPane.add(button_5);
		
		OutputButton button_6 = new OutputButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.addDigitToCurrentNumberList(6);
				CalculatorController.addToScreen('6');
			}
		});
		button_6.setBounds(232, 155, 89, 23);
		contentPane.add(button_6);
		
		OutputButton button_7 = new OutputButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.addDigitToCurrentNumberList(7);
				CalculatorController.addToScreen('7');
			}
		});
		button_7.setBounds(10, 189, 89, 23);
		contentPane.add(button_7);
		
		OutputButton button_8 = new OutputButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.addDigitToCurrentNumberList(8);
				CalculatorController.addToScreen('8');
			}
		});
		button_8.setBounds(121, 189, 89, 23);
		contentPane.add(button_8);
		
		OutputButton button_9 = new OutputButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.addDigitToCurrentNumberList(9);
				CalculatorController.addToScreen('9');
			}
		});
		button_9.setBounds(232, 189, 89, 23);
		contentPane.add(button_9);
		
		OutputButton button_0 = new OutputButton("0");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorController.addDigitToCurrentNumberList(0);
				CalculatorController.addToScreen('0');
			}
		});
		button_0.setBounds(121, 229, 89, 23);
		contentPane.add(button_0);
	}
}
