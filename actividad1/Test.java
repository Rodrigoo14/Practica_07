package actividad1;

public class Test {

	public static void main (String[] args) throws ExceptionIsEmpty {
		try {
			StackArray<Integer> pilaInt = new StackArray<Integer>(4);
			pilaInt.push(45);
			pilaInt.push(1000);
			pilaInt.push(500);
			pilaInt.push(-5);
			pilaInt.push(-10000);
			System.out.println(pilaInt);
			System.out.println("La pila esta llena? " + pilaInt.isFull());
			
			pilaInt.pop();
			pilaInt.pop();
			pilaInt.pop();
			//pilaInt.pop();
			System.out.println(pilaInt);
			//System.out.println("El elemento de la cabeza de la pila es: " + pilaInt.top());
			//pilaInt.pop();
			System.out.println("La pila esta vacia?\n" + pilaInt.isEmpty());
			System.out.println("La pila esta llena?\n" + pilaInt.isFull());
			
		}
		catch (ExceptionIsEmpty e) {
			System.out.println(e);
		}
	}
}
