package ejercicio4;

public class StackArray<E> implements Stack<E> {
	private E[] array;
	private int tope;
	
	public StackArray(int n) {
		this.array = (E[]) new Object[n];
		this.tope = -1;
	}
	
	@Override
	public void push(E x) {
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] == null) {
				this.array[i] = x;
				this.tope = i;
				break;
			}
		}		
	}

	@Override
	public E pop() throws ExceptionIsEmpty {
		if (this.tope == -1) {
			throw new ExceptionIsEmpty("La pila se encuentra vacia");
		}
		E aux = this.array[this.tope];
		this.array[this.tope] = null;
		this.tope--;
		return aux;
	}

	@Override
	public E top() throws ExceptionIsEmpty {
		if (this.tope == -1) {
			throw new ExceptionIsEmpty("La pila se encuentra vacia");
		}
		return this.array[this.tope];
	}

	@Override
	public boolean isEmpty() {
		return this.tope == -1;
	}
	
	public boolean isFull() {
		return this.array[this.array.length - 1] != null;
	}

	@Override
	public String toString() {
		String s = "PILA\n";
		for (int i = this.array.length - 1; i >= 0; i--) {
			s += "-> [" + this.array[i] +"] \t(" + i + ")\n";
		}
		return s;
	}
}
