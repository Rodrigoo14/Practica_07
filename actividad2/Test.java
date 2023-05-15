package actividad2;

import actividad1.ExceptionIsEmpty;

public class Test {

	public static void main(String[] args) throws ExceptionIsEmpty {
		QueueLink<Integer> queueInt = new QueueLink<Integer>();
		System.out.println("La QUEUELINK esta vacia? " + queueInt.isEmpty());
		queueInt.enqueue(45);
		queueInt.enqueue(600);
		queueInt.enqueue(-1000);
		queueInt.enqueue(-5);
		System.out.println(queueInt);
		System.out.println("Retiramos -> " + queueInt.dequeue());
		queueInt.enqueue(17);
		System.out.println(queueInt);
		System.out.println("En la cabeza tenemos a -> " + queueInt.front());
		System.out.println("En la parte trasera tenemos a -> " + queueInt.back());
		System.out.println("La QUEUELINK esta vacia? " + queueInt.isEmpty());
	}
}
