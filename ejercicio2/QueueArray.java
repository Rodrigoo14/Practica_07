package ejercicio2;

import actividad1.ExceptionIsEmpty;
import actividad2.Queue;

public class QueueArray<E> implements Queue<E> {
	private int size;
	private E[] array;
	private int head;
	private int back;
	
	public QueueArray(int size) {
		this.size = size;
		this.array = (E[]) new Object[size];
		this.head = 0;
		this.back = 0;
	}
	
	public boolean isFull() {
		return this.array[this.back] != null;
	}
	
	@Override
	public void enqueue(E x) {
		if (this.isEmpty()) {
			this.array[this.back] = x;
			this.head = this.back;
			this.back = (this.back + 1) % this.size;
		} else if (!this.isFull() && this.array[this.back] == null) {
			this.array[this.back] = x;
			this.back = (this.back + 1) % this.size;
			
		}
	}

	@Override
	public E dequeue() throws ExceptionIsEmpty {
		if (this.isEmpty()) {
			throw new ExceptionIsEmpty("La QUEUEARRAY esta vacia");
		}
		E aux = this.array[this.head];
		this.array[this.head] = null;
		this.head = (this.head + 1) % this.size;
		return aux;
	}

	@Override
	public E front() throws ExceptionIsEmpty {
		return this.array[this.head];
	}

	@Override
	public E back() throws ExceptionIsEmpty {
		return this.array[this.back];
	}

	@Override
	public boolean isEmpty() {
		return this.array[this.head] == null && this.array[this.back] == null;
	}

	@Override
	public String toString() {
		String s = "QUEUEARRAY\n";
		for (int i = 0; i <= this.size - 1; i++) {
			if (this.array[i] == this.array[this.head])
				s += "-> [" + this.array[i] +"] \t(" + i + ")\t(head)\n";
			else
				s += "-> [" + this.array[i] +"] \t(" + i + ")\n";
		}
		return s;
	}
	
}
