package actividad2;

import actividad1.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> {
	private Node<E> first;
	private Node<E> last;
	
	public QueueLink() {
		this.first = null;
		this.last = null;
	}
		
	@Override
	public void enqueue(E x) {
		Node<E> aux = new Node<E>(x);
		if (this.isEmpty()) {
			this.first = aux;
		} else {
			this.last.setNext(aux);
		}
		this.last = aux;
		
	}

	@Override
	public E dequeue() throws ExceptionIsEmpty {
		if (this.isEmpty()) {
			throw new ExceptionIsEmpty("La cola se encuentra vacia");
		}
		Node<E> aux = this.first;
		this.first = this.first.getNext();
		return aux.getData();
	}

	@Override
	public E front() throws ExceptionIsEmpty {
		if (this.isEmpty()) {
			throw new ExceptionIsEmpty("La cola se encuentra vacia");
		}
		return this.first.getData();
	}

	@Override
	public E back() throws ExceptionIsEmpty {
		if (this.isEmpty()) {
			throw new ExceptionIsEmpty("La cola se encuentra vacia");
		}
		return this.last.getData();
	}

	@Override
	public boolean isEmpty() {
		return this.first == null && this.last == null;
	}

	@Override
	public String toString() {
		String s = "QUEUELINK\n";
		Node<E> aux = this.first;
		while (aux != null) {
			s += "[ " + aux + "  | -]--->";
			aux = aux.getNext();
		}
		return s;
	}
	
}
