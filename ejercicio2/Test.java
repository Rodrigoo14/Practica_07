package ejercicio2;

import actividad1.ExceptionIsEmpty;

public class Test {

	public static void main(String[] args) throws ExceptionIsEmpty {
		QueueArray<Integer> queueArray = new QueueArray<Integer>(5);
		queueArray.enqueue(45);
		queueArray.enqueue(100);
		queueArray.enqueue(00);
		queueArray.enqueue(80);
		queueArray.enqueue(-112);
		System.out.println(queueArray);
		queueArray.dequeue();
		System.out.println(queueArray);
		queueArray.enqueue(-110);
		queueArray.dequeue();
		queueArray.dequeue();
		System.out.println(queueArray);
		System.out.println("A la cabeza de la COLA se encuentra el elemento: " + queueArray.front());
		System.out.println("Al final de la COLA se encuentra el elemento: " + queueArray.back());
	}

}
