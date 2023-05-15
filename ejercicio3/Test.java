package ejercicio3;

import actividad1.ExceptionIsEmpty;

public class Test {

	public static void main (String[] args) throws ExceptionIsEmpty {
		PriorityQueueLinked<Integer, Integer> prioQueueLink = new PriorityQueueLinked<Integer, Integer>(5);
		prioQueueLink.enqueue(34, 2);
		prioQueueLink.enqueue(0, 2);
		prioQueueLink.enqueue(2, 1);
		System.out.println(prioQueueLink);
		prioQueueLink.dequeue();
		System.out.println(prioQueueLink);
		
		System.out.println("Al final se encuentra el elemento: " + prioQueueLink.back());
	}
}
