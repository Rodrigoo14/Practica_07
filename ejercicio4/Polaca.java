package ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Polaca {
	String infija;
	
	public Polaca() {
	}
	
	public void readFile(String ruta) throws ExceptionIsEmpty {
		File archivo = new File(ruta);
		String linea;
		Scanner sc = null;
		try {
			sc = new Scanner(archivo);
			sc.useDelimiter("\\$");
			while (sc.hasNextLine()) {
				linea = sc.next();
				this.infija = linea;
				System.out.println("Prefija: " + linea);
				System.out.println("Postfija: " + this.inToPos(linea));
				System.out.println("Resultado: " + this.resultExpresion(this.inToPos(linea)));
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	public String inToPos(String infija) throws ExceptionIsEmpty {
		StackArray<Character> pilaOperadores = new StackArray<Character>(10);	// creamos nuestra pila de Operadores
		char caracterEvaluado;
		String postfija = "";
		if (infija.length() != 0) {
			for (int i = 0; i < infija.length(); i++) {
				caracterEvaluado = infija.charAt(i);
				if (!esOperador(caracterEvaluado)) {	// para cualquier caracter diferente de un operador
					postfija += String.valueOf(caracterEvaluado);	// concatenamos los caracteres diferentes
				}
				else {				// encontramos un operador
					switch(caracterEvaluado) {	// evaluamos el caracter
					case '(':			// caso parentesis de apertura
						pilaOperadores.push(caracterEvaluado);	// metemos el caracater a nuestra pila
						break;
					case ')':		// caso parentesis de cierre
						while (!pilaOperadores.isEmpty() && pilaOperadores.top() != '(') {	// mientras nuestra pila no este vacia y hasta que el tope no sea parentesis de apertura
							postfija += String.valueOf(pilaOperadores.pop());		// se agrega a la postfija los datos que vamos sacando de la pila
						}
						pilaOperadores.pop();
						break;
					default:		// para cualquier otro operador
						while (!pilaOperadores.isEmpty() && prioridad(caracterEvaluado) <= prioridad(pilaOperadores.top())) {
							// mientras la pila no este vacia y mientras la prioridad del tope de la pila es mayor a la de nuestro caracterEvaluado
							postfija += String.valueOf(pilaOperadores.pop());	// se ira agregando a postfija los operadores de la pila
						}
						pilaOperadores.push(caracterEvaluado);	// para eliminar el parentesis de apertura restante
					}
				}
			}
			while (!pilaOperadores.isEmpty()) {		// mientras no este vacia la pila
				postfija += String.valueOf(pilaOperadores.pop());	// se iran sacando los operadores
			}
		}
		return postfija;
	}
	
	public int resultExpresion(String postfija) throws ExceptionIsEmpty {
		StackArray<Integer> stack = new StackArray<Integer>(postfija.length());	// creacion de una nueva pila para almacenar los resultados de las operaciones
		for (int i = 0; i < postfija.length(); i++) {
			char caracter = postfija.charAt(i);
			if (Character.isDigit(caracter)) {	// si nuestro carcater es un digito lo agrega a la pila
				stack.push(caracter - '0');	// casteamos nuestro caracter 
			} else {
				int operando1 = stack.pop();
				int operando2 = stack.pop();
				switch (caracter) {
					case 'S':
						stack.push((int) Math.pow(operando2, operando1));
						break;
					case '*':
						stack.push(operando2 * operando1);
						break;
					case '/':
						stack.push(operando2 / operando1);
						break;
					case '+':
						stack.push(operando2 + operando1);
						break;
					case '-':
						stack.push(operando2 - operando1);
						break;
				}
			}
		}
		return stack.pop();
	}
	
	public static int prioridad(char caracter) {	// metodo que nos ayuda a obtener la prioridad dependiendo del caracter
		int prio = 0;
		switch (caracter) {
			case 'S':
				prio = 3;
				break;
			case '*':
			case '/':
				prio = 2;
				break;
			case '+':
			case '-':
				prio = 1;
				break;
			default:
				prio = 0;		
		}
		return prio;
	}
	
	public static boolean esOperador(char caracter) {	// metodo para verificar si tenemos un operador
		boolean resultado;
		switch (caracter) {
			case '(':
			case ')':
			case 'S':
			case '*':
			case '/':
			case '+':
			case '-':
				resultado = true;		// para todos estos casos se le asigna true a nuestra variable resultado
				break;
			default:
				resultado = false;		// para cualquier otro caracter se le asigna false a nuestra varible resultado
		}
		return resultado;	// retorno de resultado
	}

	
}

