package ejercicio1;

import actividad1.ExceptionIsEmpty;

public class Test {

	public static void main (String[] args) throws ExceptionIsEmpty {
		StackLink<Integer> stackLinkInt = new StackLink<Integer>(4);
		stackLinkInt.push(34);
		stackLinkInt.push(-100);
		stackLinkInt.push(100);
		stackLinkInt.push(54);
		stackLinkInt.push(0);
		System.out.println(stackLinkInt);
		System.out.println("En la cabeza se encuentra el numero: " + stackLinkInt.top());
		System.out.println("Sacamos el elemento: " + stackLinkInt.pop());
		System.out.println(stackLinkInt);
		System.out.println("La COLA se encuentra vacia? " + stackLinkInt.isEmpty());
	}
}
