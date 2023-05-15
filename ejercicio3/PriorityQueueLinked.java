package ejercicio3;

import actividad1.ExceptionIsEmpty;
import actividad2.QueueLink;
import actividad3.PriorityQueue;

public class PriorityQueueLinked<E, P extends Comparable <P>> implements PriorityQueue<E, P> {	
	private QueueLink<E>[] array;
	private int prioridades;

	
	public PriorityQueueLinked(int prioridades) {
		this.prioridades = prioridades;
		this.array = (QueueLink<E>[]) new QueueLink[prioridades];
		for (int i = 0; i < this.prioridades; i++) {
			this.array[i] = new QueueLink<E>();
		}
	}
	
	@Override
	public void enqueue(E x, P pr) {
		int prio = (int)pr;
		if (prio > -1 && prio <= this.prioridades) {
			this.array[prio-1].enqueue(x);
		}
	}

	@Override
	public E dequeue() throws ExceptionIsEmpty {
		for (int i = 0; i <= this.prioridades - 1; i++) {
            if (!this.array[i].isEmpty()) {
                return this.array[i].dequeue();
            }
        }
        return null;
	}

	@Override
	public E front() throws ExceptionIsEmpty {
		for (int i = 0; i < this.prioridades; i++) {
			if (!this.array[i].isEmpty()) {
				return this.array[i].front();
			}
		}
		throw new ExceptionIsEmpty("La PRIORITYQUEUELINK esta vacia");
	}

	@Override
	public E back() throws ExceptionIsEmpty {
		for (int i = this.prioridades-1; i > -1; i--) {
			if (!this.array[i].isEmpty()) {
				return this.array[i].back();
			}
		}
		throw new ExceptionIsEmpty("La PRIORITYQUEUELINK esta vacia");
	}

	@Override
	public boolean isEmpty() {
		for (int i = 0; i < this.prioridades; i++) {
            if (!this.array[i].isEmpty()) {
                return false;
            }
        }
        return true;
	}

	@Override
	public String toString() {
		String s = "PRIORITYQUEUELINK\n";
		for (int i = 0; i <= this.prioridades - 1; i++) {
			s += "-> " + this.array[i] +" \t(" + i + ")\n";
		}
		return s;
	}
	
}
