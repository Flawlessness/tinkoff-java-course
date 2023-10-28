package edu.hw2.task1;

public sealed interface Expr {
    double evaluate();

    record Constant(double value) implements Expr {
        public Constant(Expr value) {
            this(value.evaluate());
        }

        @Override
        public double evaluate() {
            return value;
        }
    }

    record Negate(double value) implements Expr {
        public Negate(Expr value) {
            this(value.evaluate());
        }

        @Override
        public double evaluate() {
            return -value;
        }
    }

    record Addition(double firstValue, double secondValue) implements Expr {
        public Addition(Expr firstValue, Expr secondValue) {
            this(firstValue.evaluate(), secondValue.evaluate());
        }

        public Addition(Expr firstValue, double secondValue) {
            this(firstValue.evaluate(), secondValue);
        }

        public Addition(double firstValue, Expr secondValue) {
            this(firstValue, secondValue.evaluate());
        }

        @Override
        public double evaluate() {
            return firstValue + secondValue;
        }
    }


    record Exponent(double value, double power) implements Expr {
        public Exponent(Expr value, Expr power) {
            this(value.evaluate(), power.evaluate());
        }

        public Exponent(Expr value, double power) {
            this(value.evaluate(), power);
        }

        public Exponent(double value, Expr power) {
            this(value, power.evaluate());
        }

        @Override
        public double evaluate() {
            return Math.pow(value, power);
        }
    }

    record Multiplication(double firstValue, double secondValue) implements Expr {
        public Multiplication(Expr firstValue, Expr secondValue) {
            this(firstValue.evaluate(), secondValue.evaluate());
        }

        public Multiplication(Expr firstValue, double secondValue) {
            this(firstValue.evaluate(), secondValue);
        }

        public Multiplication(double firstValue, Expr secondValue) {
            this(firstValue, secondValue.evaluate());
        }

        @Override
        public double evaluate() {
            return firstValue * secondValue;
        }
    }
}
