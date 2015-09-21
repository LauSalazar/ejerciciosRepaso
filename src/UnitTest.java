import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

	@Test 
	public void SumaDiagonalesTest() {

		int[][] matrix = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		int resultado = Funciones.sumaDiagonales(matrix, 3);
		Assert.assertEquals(3, resultado);
		int[][] matrix2 = { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } };
		resultado = Funciones.sumaDiagonales(matrix2, 3);
		Assert.assertEquals(5, resultado); 
	}

	@Test
	/**
	 * M�todo para probar la funci�n del triangulo de pascal
	 */
	public void matrizPascalTest() {
		int[][] matriz1 = { { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 2, 1, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 1, 3, 3, 1, 0, 0, 0, 0, 0, 0 }, 
				{ 1, 4, 6, 4, 1, 0, 0, 0, 0, 0 },
				{ 1, 5, 10, 10, 5, 1, 0, 0, 0, 0 }, 
				{ 1, 6, 15, 20, 15, 6, 1, 0, 0, 0 },
				{ 1, 7, 21, 35, 35, 21, 7, 1, 0, 0 }, 
				{ 1, 8, 28, 56, 70, 56, 28, 8, 1, 0 },
				{ 1, 9, 36, 84, 126, 126, 84, 36, 9, 1 } };
		int[][] matrizResultado = Funciones.matrizPascal(10);
		Assert.assertArrayEquals(matriz1, matrizResultado);

		int[][] matriz2 = {{1}};
		matrizResultado = Funciones.matrizPascal(1);
		Assert.assertArrayEquals(matriz2, matrizResultado);
		
		int[][] matriz3 = {{1,0},{1,1}};
		matrizResultado = Funciones.matrizPascal(2);
		Assert.assertArrayEquals(matriz3, matrizResultado);
		
		int[][] matriz4 = {};
		matrizResultado = Funciones.matrizPascal(0);
		Assert.assertArrayEquals(matriz4, matrizResultado);
	}	

    @Test
    public void SumaDiagonalesTest2() {
        int[][] matrix = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } }; 
        int resultado = Funciones.sumaDiagonales2(matrix);
        Assert.assertEquals(3, resultado); 
        int[][] matrix2 = { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } };
        resultado = Funciones.sumaDiagonales2(matrix2);
        Assert.assertEquals(5, resultado);
    }	

	@Test
	public void repetidoListaLigadaTest() {
		Nodo cabeza1 = new Nodo(1);
		cabeza1.setSiguiente(new Nodo(1));
		Nodo cabeza2 = new Nodo(1);
		cabeza2.setSiguiente(new Nodo(1));

		Nodo cabezaRes = Funciones.repetidos2(cabeza1, cabeza2);
		Assert.assertNotNull(cabezaRes);
		Assert.assertNotNull(cabezaRes.getSiguiente());

		Assert.assertEquals(1, (int) (cabezaRes.getSiguiente().getDato())); 
		Assert.assertNull(cabezaRes.getSiguiente().getSiguiente()); 
	}

	/*
	 * Principios del TDD (Test driven development) Desarrollo orientado a pruebas 
	 * Se dice que en el TDD lo primero que se debe hacer es escribir una prueba que falle 
	 * TODO:1. Descomentar esta prueba 
	 * TODO:2. Agregar las referencias a Stack 
	 * TODO: 3. Correr la prueba 'sortStack' deber�a fallar? Por qu�? 
	 * TODO: 4. Agregar lo que falte ( StacksAndQueue class y el m�todo sort) 
	 * TODO: 5. El segundo paso es escribir lo minimo de c�digo para que la prueba pase. 
	 * Este pedazo de codigo le sirve 
	 * public static Stack<Integer> sort(Stack<Integer> stack){ 
	 * Stack<Integer> s = new Stack<Integer>(); 
	 * s.push(1); 
	 * s.push(2); 
	 * s.push(3); 
	 * s.push(4); 
	 * return s; }
	 * TODO: 6. El 3 paso en el TDD es el refactor, osea modificar el c�digo
	 * fuente de ese m�todo de ordenamiento sin alterar el resultado para que
	 * funcione con cualquier caso. 
	 * TODO: 7 Lea sobre TDD.
	 */

	@Test
	public void sortStack(){
	 Stack<Integer> stack = new Stack<Integer>();
	 stack.push(4);
	 stack.push(3);
	 stack.push(2);
	 stack.push(1);
	 stack = StacksAndQueue.sort(stack);
	 Assert.assertEquals(4, stack.size());
	 Assert.assertEquals(1, (int)stack.pop());
	 Assert.assertEquals(2, (int)stack.pop());
	 Assert.assertEquals(3, (int)stack.pop());
	 Assert.assertEquals(4, (int)stack.pop());
	 }
}
