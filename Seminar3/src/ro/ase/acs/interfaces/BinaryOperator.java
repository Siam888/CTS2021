package ro.ase.acs.interfaces;

@FunctionalInterface
public interface BinaryOperator {
	double operate(double operand1, double operand2);
}
