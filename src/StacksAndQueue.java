import java.util.Stack;

public class StacksAndQueue {
	
	/**
	 * Ordena una pila
	 * @param stack pila a ordenar
	 * @return pila ordenada
	 */
	public static Stack<Integer> sort (Stack<Integer> stack){
		if (stack == null) return null;
		if (stack.empty()) return stack;
		
		Stack<Integer> aux = new Stack<Integer>();
		while(!isSorted(stack)){
			int mayor = stack.pop();
			while(!stack.empty()){			
				if(mayor>stack.peek()){
					aux.push(stack.pop());
				}
				else{
					aux.push(mayor);
					mayor=stack.pop();
				}
			}
			stack.push(mayor);
			int tamanho = aux.size();
			for(int i = 0; i<tamanho;i++){
				stack.push(aux.pop());
			}
		}		
		return stack;
	}
	
	/**
	 * Indica si la pila esta ordenada
	 * @param pila
	 * @return booleano
	 */
	public static boolean isSorted(Stack<Integer> pila){
		
		Stack<Integer> aux = new Stack<Integer>();
		aux.push(pila.pop());
		boolean estaOrdenado=true;
		
		while(!pila.empty()){				
			if(aux.peek()>pila.peek()){
				estaOrdenado= false;
				break;
			} 
			aux.push(pila.pop());
		}
		while(!aux.empty()){
			pila.push(aux.pop());
		}
		return estaOrdenado;
	}
}
