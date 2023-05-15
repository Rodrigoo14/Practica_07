package actividad3;

import actividad1.ExceptionIsEmpty;
import actividad2.Node;

public class PriorityQueueLinkSort<E, P extends Comparable<P>> implements PriorityQueue<E, P> {
	class EntryNode {
		E data;
		P priority;
		
		EntryNode (E data, P priority) {
			this.data = data;
			this.priority = priority;
		}
		
		@Override
		public String toString() {
			String s = this.data.toString() + " | " + this.priority.toString();
			return s;
		}
	}
	
	private Node<EntryNode> first;
	private Node<EntryNode> last;
	
	public PriorityQueueLinkSort() {
		this.first = null;
		this.last = null;
	}
	
	@Override
	public void enqueue(E x, P pr) {
		Node<EntryNode> newNode = new Node<EntryNode>(new EntryNode(x, pr));
		if (this.isEmpty()) {
			this.first = newNode;
			this.last = newNode;
		} else if (pr.compareTo(this.first.getData().priority) > 0) {
			newNode.setNext(this.first);
			this.first = newNode;
		} else if (pr.compareTo(this.last.getData().priority) <= 0) {
			this.last.setNext(newNode);
			this.last = newNode;
		} else {
			Node<EntryNode> aux = this.first;
			while (aux.getNext() != null && aux.getNext().getData().priority.compareTo(pr) >= 0) {
				aux = aux.getNext();
			}
			newNode.setNext(aux.getNext());
			aux.setNext(newNode);
		}
	}

	@Override
	public E dequeue() throws ExceptionIsEmpty {
		if (this.isEmpty()) {
			throw new ExceptionIsEmpty("La COLA se encuentra vacia");
		}
		Node<EntryNode> aux = this.first;
		this.first = this.first.getNext();
		if (this.first == null) {
			this.last = null;
		}
		return aux.getData().data;
	}

	@Override
	public E front() throws ExceptionIsEmpty {
		if (this.isEmpty()) {
			throw new ExceptionIsEmpty("La COLA se encuentra vacia");
		}
		return this.first.getData().data;
	}

	@Override
	public E back() throws ExceptionIsEmpty {
		if (this.isEmpty()) {
			throw new ExceptionIsEmpty("La COLA se encuentra vacia");
		}
		return this.last.getData().data;
	}

	@Override
	public boolean isEmpty() {
		return this.first == null;
	}
	
	@Override
	public String toString() {
		String s = "PRIORITY QUEUELINK SORT\n";
		Node<EntryNode> aux = this.first;
		while (aux != null) {
			s += "[ " + aux + " | -]--->";
			aux = aux.getNext();
		}
		return s;
	}
	
}
