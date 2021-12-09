package arithmetic;

public class Calculation {

	/*
	 * Private variables to stock: the current value in n2, the previous value in n1
	 * and the operator in op
	 */
	private String n1;
	private String n2;
	private String op;

	/**
	 * Constructor of the class that initialises the variables to an empty string
	 */
	public Calculation() {
		setPrivateMembersToEmptyString();
	}

	/*
	 * Getters
	 */
	public String getN1() {
		return this.n1;
	}

	public String getN2() {
		return this.n2;
	}

	public String getOp() {
		return this.op;
	}

	/*
	 * Setters
	 */
	public void setN1(String s) {
		this.n1 = s;
	}

	public void setN2(String s) {
		this.n2 = s;
	}

	public void setOp(String s) {
		this.op = s;
	}

	/**
	 * Method to set private members value to empty string
	 */
	public void setPrivateMembersToEmptyString() {
		this.n1 = "";
		this.n2 = "";
		this.op = "";
	}

	/**
	 * Method to set private members value with values
	 */
	public void setPrivateMembersWithValue(String one, String two, String op) {
		this.n1 = one;
		this.n2 = two;
		this.op = op;
	}

	/*
	 * Methods
	 */

	/**
	 * Method to check if number is already a double or not
	 * 
	 * @param n2, String that contains the value to check
	 * @return the new string with or without the dot at the end
	 */
	public String checkIfDouble(String n2) {
		if (n2.contains(".")) {
			return n2; // we return the string like it is
		} else {
			return n2 + "."; // we return the string with a dot
		}
	}

	/**
	 * Method that deletes the last character printed on the JTextfield
	 * 
	 * @param first,  the previous value entered
	 * @param second, the current value
	 * @param op,     the operator
	 */
	public void delete(String first, String second, String op) {
		// if the current value has a length superior to 0
		if (second.length() > 0) {
			// we remove the last character
			second = second.substring(0, second.length() - 1);
			// we modify the value of the private member that stocks the current value
			setN2(second);
		}
		// otherwise, if the operator has a length superior to 0
		else if (op.length() > 0) {
			// we remove the operator
			op = op.substring(0, op.length() - 1);
			// we update the values of the members
			setPrivateMembersWithValue("", first, op);
		}
	}

	/**
	 * Method to do the operation according to the operator
	 * 
	 * @param op: String that contains the operator
	 * @param s1: String containing the first number
	 * @param s2: String containing the second number
	 * @return String containing the result of the operation
	 */
	public String doCalculation(String s1, String s2, String op) {
		String s;
		Double n;
		// parse the string value to double
		Double n1 = Double.parseDouble(s1);
		Double n2 = Double.parseDouble(s2);
		switch (op) {
		case "+":
			n = n1 + n2;
			if (n == Math.floor(n)) {
				s = String.valueOf((int) Math.round(n));
			} else {
				s = String.valueOf(n);
			}
			return s;

		case "-":
			n = n1 - n2;
			if (n == Math.floor(n)) {
				s = String.valueOf((int) Math.round(n));
			} else {
				s = String.valueOf(n);
			}
			return s;

		case "x":
			n = n1 * n2;
			if (n == Math.floor(n)) {
				s = String.valueOf((int) Math.round(n));
			} else {
				s = String.valueOf(n);
			}
			return s;

		case "/":
			if (n2 != 0) {
				n = n1 / n2;
				if (n == Math.floor(n)) {
					s = String.valueOf((int) Math.round(n));
				} else {
					s = String.valueOf(n);
				}
				return s;
			} else {
				s = "Cannot divide by zero";
				return s;
			}
		case "%":
			n = n1 % n2;
			if (n == Math.floor(n)) {
				s = String.valueOf((int) Math.round(n));
			} else {
				s = String.valueOf(n);
			}
			return s;
		}
		return s = "Error";
	}

	/**
	 * Method that checks if the number in the string is negative or not
	 * 
	 * @param n2 String that contains the current value to check
	 * @return string with minus if the current value was positive, otherwise string
	 *         without minus if the string was negative
	 */
	public String toNegative(String n2) {
		if (n2.contains("-")) {
			return n2.substring(1); // we return a substring that removes the first character (the minus)
		} else {
			return "-" + n2; // we return the string with a minus at the beginning
		}
	}

}
