package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import arithmetic.Calculation;

public class CalculatorActionListener implements ActionListener {

	/*
	 * Private variables
	 */
	private String action, first, second, op;
	private static Calculation calculation = new Calculation();
	private JTextField resultField;
	private JButton button;

	/**
	 * Constructor for the class
	 * 
	 * @param resultField_ the JTextField to print result
	 * @param button_      Jbutton that was pressed
	 */
	public CalculatorActionListener(JTextField resultField_, JButton button_) {
		super();
		this.resultField = resultField_;
		if (button_ != null) {
			this.action = button_.getText();
			this.button = button_;
		} else {
			this.action = "";
			this.button = null;
		}
		setZero();
	}

	/**
	 * Method to empty the values of the local variables
	 */
	public void setZero() {
		first = "";
		second = "";
		op = "";
	}

	/**
	 * Method to get the values of all the private members of the Calculation class
	 * and affect them to the local variables
	 */
	public void getMembers() {
		first = calculation.getN1();
		second = calculation.getN2();
		op = calculation.getOp();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMembers();

		// Case when button delete is pressed
		if (action.equals("DEL")) {
			calculation.delete(first, second, op);
			getMembers();
			resultField.setText(first + op + second); // print text
		}
		// Case when button equals is pressed
		else if (action.equals("=")) {
			equalsAction(first, second, op, action);
		}
		// Case when button clear is pressed
		else if (action.equals("C")) {
			resultField.setText("");
			calculation.setPrivateMembersToEmptyString();
		}
		// Case when button dot is pressed
		else if (action.equals(".")) {
			second = calculation.checkIfDouble(second); // change current value to double if it's an integer
			calculation.setN2(second);
			resultField.setText(first + op + second); // print text
		}
		// Case when button +/- is pressed
		else if (action.equals("+/-")) {
			second = calculation.toNegative(second); // toggle current value to negative or positive
			calculation.setN2(second); // set private member of Calculation class with the current value
			resultField.setText(first + op + second); // print text

		}
		// Case when operator button is pressed
		else if (action.equals("+") || action.equals("-") || action.equals("/") || action.equals("x")
				|| action.equals("%")) {
			operatorAction(first, second, op, action);
		} else {
			second = second + action;
			calculation.setN2(second);
			resultField.setText(first + op + second); // print text
		}
		setZero(); // empty the local variables when the action is done

		if (e != null) {
			button.getParent().requestFocus(); // return the focus to the frame
		}
	}

	/**
	 * Method called when an operator is pressed. Determines the action according to
	 * conditions
	 * 
	 * @param first  string that contains the previous number entered
	 * @param second string that contains the current number entered
	 * @param op     string that contains the operator
	 * @param action string that contains the label of the button pressed
	 */
	public void operatorAction(String first, String second, String op, String action) {
		// if the field is empty or a error message is printed, we block the operation
		if (resultField.getText().isEmpty() || Character.isAlphabetic(resultField.getText().charAt(0))) {
			resultField.setText("Cannot start with operator");
		} else if (op.isEmpty()) {
			first = second;
			second = "";
			op = action;
			calculation.setPrivateMembersWithValue(first, second, op);
			resultField.setText(first + op + second);// print text
		} else if (second.isEmpty()) {
			op = action;
			calculation.setOp(op);
			resultField.setText(first + op + second); // print text
		} else {
			first = calculation.doCalculation(first, second, op);
			// if an error resulted from the calculation, we print the message
			if (Character.isAlphabetic(first.charAt(0))) {
				resultField.setText(first);
			} else {
				second = "";
				op = action;
				calculation.setPrivateMembersWithValue(first, second, op);
				resultField.setText(first + op + second); // print text
			}
		}
	}

	/**
	 * Method called when equals button pressed
	 * 
	 * @param first  string that contains the previous number entered
	 * @param second string that contains the current number entered
	 * @param op     string that contains the operator
	 * @param action string that contains the label of the button pressed
	 */
	public void equalsAction(String first, String second, String op, String action) {
		// if string is complete, we compute final result
		if (!first.isEmpty() && !second.isEmpty() && !op.isEmpty()) {
			second = calculation.doCalculation(first, second, op);
			calculation.setPrivateMembersToEmptyString(); // empty private members of Calculation class

			// if an error resulted from the calculation, we print the message
			if (Character.isAlphabetic(second.charAt(0))) {
				resultField.setText(second);
			} else {
				calculation.setN2(second); // we set the current value to the private member
				resultField.setText(second); // we print the result
			}

		} else {
			if (!first.isEmpty()) {
				second = first; // affect previous value to current value
			}
			// empty local variables and private members
			op = "";
			first = "";
			calculation.setPrivateMembersToEmptyString();
			// set current value to the private member
			calculation.setN2(second);
			resultField.setText(second); // print text
		}
	}

}
