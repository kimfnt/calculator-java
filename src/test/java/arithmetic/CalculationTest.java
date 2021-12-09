package arithmetic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import arithmetic.Calculation;

class CalculationTest {

	private Calculation calc = new Calculation();
	private String n1, n2, n3, n4, op;

	@Test
	void checkIfDoubleTest() {
		n1 = "5.0";
		n2 = "6";
		n3 = "-43";
		n4 = "-10.2";
		assertEquals("5.0", calc.checkIfDouble(n1));
		assertEquals("6.", calc.checkIfDouble(n2));
		assertNotEquals("-43", calc.checkIfDouble(n3));
		assertNotEquals("-10.2.", calc.checkIfDouble(n4));
	}

	@Test
	void deleteTest() {
		n1 = "5";
		n2 = "180";
		op = "+";
		calc.setPrivateMembersWithValue(n1, n2, op);
		calc.delete(n1, n2, op);
		String s = calc.getN1() + calc.getOp() + calc.getN2();
		assertEquals("5+18", s);

		n1 = "5";
		n2 = "";
		op = "+";
		calc.setPrivateMembersWithValue(n1, n2, op);
		calc.delete(n1, n2, op);
		s = calc.getN1() + calc.getOp() + calc.getN2();
		assertEquals("5", s);
	}

	@Test
	void doCalculationTest() {
		// Test sum
		n1 = "5";
		n2 = "180";
		op = "+";
		assertEquals("185", calc.doCalculation(n1,n2,op));

		// Test minus
		n1 = "5";
		n2 = "4.5";
		op = "-";
		assertEquals("0.5", calc.doCalculation(n1,n2,op));

		// Test multiply
		n1 = "5";
		n2 = "2.4";
		op = "x";
		assertEquals("12", calc.doCalculation(n1,n2,op));

		// Test divide
		n1 = "40";
		n2 = "8";
		op = "/";
		assertEquals("5", calc.doCalculation(n1,n2,op));
		n2 = "0";
		assertEquals("Cannot divide by zero", calc.doCalculation(n1,n2,op));

		// Test modulo
		n1 = "15";
		n2 = "3";
		op = "%";
		assertEquals("0", calc.doCalculation(n1,n2,op));
	}

	@Test
	void toNegativeTest() {
		n1 = "5.0";
		n2 = "6";
		n3 = "-43";
		n4 = "-10.2";
		assertEquals("-5.0", calc.toNegative(n1));
		assertEquals("-6", calc.toNegative(n2));
		assertEquals("43", calc.toNegative(n3));
		assertEquals("10.2", calc.toNegative(n4));
	}

}
