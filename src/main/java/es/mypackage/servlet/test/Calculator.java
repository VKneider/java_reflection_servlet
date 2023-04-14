package es.mypackage.servlet.test;

public class Calculator {
	
	public double add(Double op1, Double op2) {
   	 return op1+op2;
   }

    public double substract(Double op1, Double op2) {
   	 return op1-op2;
   }

    public double multiply(Double op1, Double op2) {
    	 return op1*op2;
    }

    public double divide(Double op1, Double op2) {
    	  if (op2 == 0) {
              throw new IllegalArgumentException("Cannot divide by zero");
          }
          return op1 / op2;
   }
}