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
	 * Método para probar la función del triangulo de pascal
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
	 * TODO: 3. Correr la prueba 'sortStack' debería fallar? Por qué? 
	 * TODO: 4. Agregar lo que falte ( StacksAndQueue class y el método sort) 
	 * TODO: 5. El segundo paso es escribir lo minimo de código para que la prueba pase. 
	 * Este pedazo de codigo le sirve 
	 * public static Stack<Integer> sort(Stack<Integer> stack){ 
	 * Stack<Integer> s = new Stack<Integer>(); 
	 * s.push(1); 
	 * s.push(2); 
	 * s.push(3); 
	 * s.push(4); 
	 * return s; }
	 * TODO: 6. El 3 paso en el TDD es el refactor, osea modificar el código
	 * fuente de ese método de ordenamiento sin alterar el resultado para que
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
	
	@Test
	public void bitsEnUno(){
		Assert.assertEquals(4, Funciones.bitsEnUno(-15));
		Assert.assertEquals(0, Funciones.bitsEnUno(0));
		Assert.assertEquals(3, Funciones.bitsEnUno(7));
	}
	
	@Test
	public void matrizEnEspiral(){
		int[] array0 = {};
		int[][] matriz0 = {{}};
		Assert.assertArrayEquals(array0, Funciones.espiral(matriz0));
		
		int[] array1 = {1};
		int[][] matriz1 = {{1}};
		Assert.assertArrayEquals(array1, Funciones.espiral(matriz1));
		
		int[] array = {1,2,3,6,9,8,7,4,5};
		int[][] matriz = {{1,2,3},{4,5,6},{7,8,9}};
		Assert.assertArrayEquals(array, Funciones.espiral(matriz));
		
		int[] array2 = {1,2,5,8,7,4};
		int[][] matriz2 = {{1,2},{4,5},{7,8}};
		Assert.assertArrayEquals(array2, Funciones.espiral(matriz2));
		
		int[] array3 = {1,2,3,4,8,16,11,10,9,5,6,7};
		int[][] matriz3 = {{1,2,3,4},{5,6,7,8},{9,10,11,16}};
		Assert.assertArrayEquals(array3, Funciones.espiral(matriz3));
		
		int [][] matriz4 = {{13,12,11,10,25},
		                    {14,3,2,9,24},		
		                    {15,4,1,8,23},
		                    {16,5,6,7,22},
		                    {17,18,19,20,21}};
		
		int[] array4 = {13,12,11,10,25,24,23,22,21,20,19,18,17,16,15,14,3,2,9,8,7,6,5,4,1};
		Assert.assertArrayEquals(array4, Funciones.espiral(matriz4));
	}  
}
