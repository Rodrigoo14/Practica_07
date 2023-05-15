package actividad3;

import actividad1.ExceptionIsEmpty;

public class Test {

	public static void main (String[] args) throws ExceptionIsEmpty {
		PriorityQueueLinkSort<String, Integer> priQue = new PriorityQueueLinkSort<String, Integer>();
		System.out.println("La COLA de prioridad esta vacia? " + priQue.isEmpty());
		priQue.enqueue("Hola", 10);
		priQue.enqueue("Buenas", 1);
		priQue.enqueue("asd", 7);
		priQue.enqueue("45", 11);
		System.out.println(priQue);
		priQue.enqueue("Buenos Dias", 10);
		priQue.enqueue("adios", 9);
		priQue.enqueue("qwe", 0);
		System.out.println(priQue);
		System.out.println("Qutamos el elemento: " + priQue.dequeue());
		System.out.println("Qutamos el elemento: " + priQue.dequeue());
		System.out.println(priQue);
		
		System.out.println("FRONT: " + priQue.front());
		System.out.println("BACK: " + priQue.back());
		
	}
}
