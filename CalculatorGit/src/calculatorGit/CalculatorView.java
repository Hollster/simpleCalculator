package calculatorGit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
		textOutput.setHorizontalAlignment(SwingConstants.RIGHT);
		textOutput.setBackground(Color.CYAN);
		textOutput.setEditable(false);
		textOutput.setBounds(10, 11, 416, 55);
		contentPane.add(textOutput);
		textOutput.setColumns(10);
		
		OperatorButton buttonPlus = new OperatorButton("+");
		buttonPlus.setBounds(16, 77, 89, 23);
		contentPane.add(buttonPlus);
		
		OperatorButton buttonMinus = new OperatorButton("-");
		buttonMinus.setBounds(121, 77, 89, 23);
		contentPane.add(buttonMinus);
		
		OperatorButton buttonTimes = new OperatorButton("*");
		buttonTimes.setBounds(232, 77, 89, 23);
		contentPane.add(buttonTimes);
		
		OperatorButton buttonDivided = new OperatorButton("/");
		buttonDivided.setBounds(331, 77, 89, 23);
		contentPane.add(buttonDivided);
			
		JButton buttonDel = new JButton("Del");
		buttonDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonDel.setBounds(331, 121, 89, 23);
		contentPane.add(buttonDel);
		
		NumberButton buttonOK = new NumberButton("OK");
		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		buttonOK.setBounds(337, 155, 83, 57);
		contentPane.add(buttonOK);
		
		NumberButton button_1 = new NumberButton("1");
		button_1.setBounds(10, 121, 89, 23);
		contentPane.add(button_1);
		
		NumberButton button_2 = new NumberButton("2");
		button_2.setBounds(121, 121, 89, 23);
		contentPane.add(button_2);
		
		NumberButton button_3 = new NumberButton("3");
		button_3.setBounds(232, 121, 89, 23);
		contentPane.add(button_3);
		
		NumberButton button_4 = new NumberButton("4");
		button_4.setBounds(10, 155, 89, 23);
		contentPane.add(button_4);
		
		NumberButton button_5 = new NumberButton("5");
		button_5.setBounds(121, 155, 89, 23);
		contentPane.add(button_5);
		
		NumberButton button_6 = new NumberButton("6");
		button_6.setBounds(232, 155, 89, 23);
		contentPane.add(button_6);
		
		NumberButton button_7 = new NumberButton("7");
		button_7.setBounds(10, 189, 89, 23);
		contentPane.add(button_7);
		
		NumberButton button_8 = new NumberButton("8");
		button_8.setBounds(121, 189, 89, 23);
		contentPane.add(button_8);
		
		NumberButton button_9 = new NumberButton("9");
		button_9.setBounds(232, 189, 89, 23);
		contentPane.add(button_9);
		
		NumberButton button_0 = new NumberButton("0");
		button_0.setBounds(121, 229, 89, 23);
		contentPane.add(button_0);
	}
}
