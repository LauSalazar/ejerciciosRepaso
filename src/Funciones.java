import java.util.*;

/**
 * Ejercicios de repaso de lógica de programación
 * 
 * @author lSalazar
 *
 */
public class Funciones {
	/**
	 * Cuenta cuantas veces esta cada letra en una palabra
	 * 
	 * @param A
	 *            Palabra
	 * @return Arreglo de 26 posiciones con las cuenta de cada letra
	 */
	public int[] getCountAnagram(char[] A) {
		int[] abcA = new int[26];
		for (int i = 0; i < A.length; i++) {
			abcA[A[i] - 'a'] += 1;
		}
		return abcA;
	}

	/**
	 * Devuelve el valor absoluto de un número entero
	 * 
	 * @param a
	 *            Numero
	 * @return Valor absoluto de a
	 */
	public static int absoluto(int a) {
		if (a >= 0)
			return a;
		else
			return -a;
	}

	/**
	 * Realiza la división entre dos enteros
	 * 
	 * @param a
	 *            Dividendo
	 * @param b
	 *            Divisor
	 * @return ResultadoDividendo con el resultado de la operación
	 */
	public ResultadoDivision division(int a, int b) {
		if (b == 0)
			return null;
		ResultadoDivision RD = new ResultadoDivision();
		if (a == 0)
			return RD;
		int c = 0, aux = 0;
		int absA = absoluto(a);
		int absB = absoluto(b);
		if (absA == absB)
			c = 1;
		else if (absA < absB) {
			aux = absA - absB;
		} else {
			c = 1;
			aux = absA - absB;
			while (aux >= absB) {
				c += 1;
				aux = aux - absB;
			}
		}
		if ((a > 0 && b < 0) || (a < 0 && b > 0))
			c = -c;
		RD.setResultado(c);
		RD.setResiduo(aux);
		return RD;
	}

	/**
	 * Búsqueda binaria de un valor en un arreglo
	 * 
	 * @param arreglo
	 *            Datos en los que se buscará el valor
	 * @param valor
	 *            Dato a encontrar
	 * @return Posición del valor en el arreglo o -1 si no lo encuentra
	 */
	public int busquedaB(int[] arreglo, int valor) {
		int p = 0;
		int u = arreglo.length - 1;
		int medio = 0;
		while (p <= u) {
			medio = (p + u) / 2;
			if (arreglo[medio] == valor)
				return medio;
			else if (valor < arreglo[medio])
				u = medio - 1;
			else
				p = medio + 1;
		}
		return -1;
	}

	/**
	 * Búsqueda binaria recursiva de un valor en un arreglo
	 * 
	 * @param arreglo
	 *            Datos en los que se buscará el valor
	 * @param valor
	 *            Dato a encontrar
	 * @param p
	 *            primera posición
	 * @param u
	 *            última posición
	 * @return Posición del valor en el arreglo o -1 si no lo encuentra
	 */
	public int busquedaBR(int[] arreglo, int valor, int p, int u) {
		int medio = (p + u) / 2, pos = 0;
		if (arreglo[medio] == valor)
			pos = medio;
		else if (valor < arreglo[medio] && p <= u)
			pos = busquedaBR(arreglo, valor, p, medio - 1);
		else if (valor > arreglo[medio] && p <= u)
			pos = busquedaBR(arreglo, valor, medio + 1, u);
		else
			pos = -1;
		return pos;
	}

	/**
	 * Algoritmo babilónico para el cálculo de la raiz cuadrada
	 * 
	 * @param x
	 *            Radicando
	 * @return Raiz cuadrada de x
	 */
	public double raizCuadrada(double x) {
		double a = x;
		double b = 0;
		while (a != b) {
			b = a;
			a = ((x / a) + a) / 2;
		}
		return a;
	}

	/**
	 * Compara dos listas ligadas y devuelve los valores que son compartidos
	 * entre estas dos
	 * 
	 * @param cabeza1
	 *            Nodo que apunta a la cabeza de la primera lista
	 * @param cabeza2
	 *            Nodo que apunta a la cabeza de la segunda lista
	 * @return Lista con los valores repetidos
	 */
	public ListaLigada repetidos(Nodo cabeza1, Nodo cabeza2) {
		if (cabeza1 == null || cabeza2 == null)
			return null;

		if (cabeza1.getSiguiente() == null || cabeza2.getSiguiente() == null)
			return null;

		ListaLigada listaNueva = new ListaLigada();
		Nodo nodo1 = cabeza1.getSiguiente(), nodo2 = cabeza2.getSiguiente();

		while (nodo1 != null) {
			while (nodo2 != null) {
				if (nodo1.getDato() == nodo2.getDato()) {
					listaNueva.agregarNodo(nodo1);
					nodo2 = null;
				} else
					nodo2 = nodo2.getSiguiente();
			}
			nodo1 = nodo1.getSiguiente();
			nodo2 = cabeza2.getSiguiente();
		}
		return listaNueva;
	}

	/**
	 * Cálculo de raiz cuadrada con precisión
	 * 
	 * @param x
	 *            Radicando
	 * @param precision
	 *            Indica que el resultado puede estar +/- la precisión
	 * @return Raiz cuadrada de x +/- la precision
	 * @throws Exception
	 */
	public double raizR(double x, double precision) throws Exception {
		if (x < 0)
			throw new Exception("No se puede obtener la raiz cuadrada de un negativo, mediante reales.");
		if (precision > 1 || precision < 0)
			throw new Exception("Se debe ingresar valor entre 0 y 1");
		double p = 0;
		double medio = 0;
		double u = x;
		while (p <= u) {
			medio = (p + u) / 2;
			if (medio * medio > x)
				u = medio - precision;
			else
				p = medio + precision;
		}
		return medio;
	}

	/**
	 * Devuelve si existen dos numeros en el arreglo que sumados den x
	 * 
	 * @param arreglo
	 * @param x
	 * @return Booleano
	 */
	public boolean hayParAgain(int[] arreglo, int x) {
		if (arreglo == null)
			return false;
		if (arreglo.length < 1)
			return false;

		for (int i = 0; i < arreglo.length; i++) {
			int buscar = x - arreglo[i];
			if (busquedaB(arreglo, buscar) != -1)
				return true;
		}
		return false;
	}

	/**
	 * Encuentra los valores repetidos de dos listas ligadas y los guarda en una
	 * tercera Este método usa un HashSet como ayuda
	 * 
	 * @param cabeza1
	 *            Nodo que apunta al primer elemento de una de las listas
	 * @param cabeza2
	 *            Nodo que apunta al primer elemento de la otra lista
	 * @return Nodo que apunta al primer elemento de la lista con los elementos
	 *         repetidos en ambas listas
	 */
	public static Nodo repetidos2(Nodo cabeza1, Nodo cabeza2) {
		if (cabeza1 == null || cabeza2 == null)
			return null;

		if (cabeza1.getSiguiente() == null || cabeza2.getSiguiente() == null)
			return null;

		ListaLigada listaNueva = new ListaLigada();
		Nodo nodo1 = cabeza1.getSiguiente(), nodo2 = cabeza2.getSiguiente();
		HashSet<Integer> aux = new HashSet<Integer>();
		while (nodo1 != null) {
			aux.add(nodo1.getDato());
			nodo1 = nodo1.getSiguiente();
		}
		while (nodo2 != null) {
			if (aux.contains(nodo2.getDato())) {
				listaNueva.agregarNodo(nodo2);
			}
			nodo2 = nodo2.getSiguiente();
		}
		Nodo nodoApuntador = new Nodo();
		nodoApuntador.setSiguiente(listaNueva.getPrimero());
		return nodoApuntador;
	}

	/**
	 * Devuelve una matriz nxn con los elementos de un triangulo de pascal
	 * 
	 * @param n
	 *            Define el tamaño de la matriz cuadrada
	 * @return Matriz con elementos de un triangulo de pascal
	 */
	public static int[][] matrizPascal(int n) {
		int[][] matriz = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					matriz[i][j] = 1;
				else if (j == 0)
					matriz[i][j] = 1;
				else if (i > 0 && j <= i) {
					matriz[i][j] = matriz[i - 1][j - 1] + matriz[i - 1][j];
				}
			}
		}
		return matriz;
	}

	/**
	 * Suma los datos de las diagonales principal y secundaria de una matriz
	 * cuadrada
	 * 
	 * @param matriz
	 * @param n
	 *            Tamaño de la matriz (nxn)
	 * @return Suma de los datos
	 */
	public static int sumaDiagonales(int[][] matriz, int n) { // Lo puse
																// estatico
																// porque no
																// quería
																// declarar un
																// objeto de
																// tipo
																// Funciones...
		int suma = 0;
		int medio = n / 2;
		for (int i = 0; i < n; i++) {
			if (n % 2 == 0) {
				suma = suma + matriz[i][i] + matriz[i][n - 1 - i];
			} else if (i == medio) {
				suma = suma + matriz[i][i];
			} else {
				suma = suma + matriz[i][i] + matriz[i][n - 1 - i];
			}
		}

		return suma;
	}

	public static int sumaDiagonales2(int[][] matrix) {
		int suma = 0;
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			suma += matrix[i][i] + matrix[i][n - i - 1];
		}
		suma -= n % 2 != 0 ? matrix[n / 2][n / 2] : 0;
		return suma;
	}

	/**
	 * Dice el numero de bits en uno de un numero entero
	 * 
	 * @param numero
	 * @return suma de bits en uno
	 */
	public static int bitsEnUno(int numero) {
		if (numero < 0)
			numero = absoluto(numero);
		int bits = 0;
		int resto = 0;
		while (numero != 0) {
			resto = numero % 2;
			numero = numero / 2;
			if (resto == 1)
				bits += 1;
		}
		return bits;
	}
	
	/**
	 * Devuelve arreglo con los datos de la matriz leidos en espiral
	 * @param matriz
	 * @return 
	 */
	public static int[] espiral(int[][] matriz) {
		int filas = matriz.length;
		int col = matriz[0].length;
		int tamanho = col*filas;
		int[] espiral = new int[tamanho];
		int limCol = 0, limFila = 0;
		int k = 0, l = 0;
		int medioCol = col / 2, medioFila = filas / 2;
		int i, j;
		int iEspiral = 0;

		while (k <= medioFila && l <= medioCol) {
			i = k;
			j = l;
			for (; j < col; j++) {
				espiral[iEspiral] = matriz[i][j];
				iEspiral += 1;
			}
			if(iEspiral == tamanho) break;
			j -= 1;
			i += 1;
			for (; i < filas; i++) {
				espiral[iEspiral] = matriz[i][j];
				iEspiral += 1;
			}
			if(iEspiral == tamanho) break;
			i -= 1;
			j -= 1;
			for (; j >= limCol; j--) {
				espiral[iEspiral] = matriz[i][j];
				iEspiral += 1;
			}
			if(iEspiral == tamanho) break;
			j += 1;
			i -= 1;
			for (; i >= limFila; i--) {
				if (i != j) {
					espiral[iEspiral] = matriz[i][j];
					iEspiral += 1;
				} else
					break;
			}
			if(iEspiral == tamanho) break;
			limCol += 1;
			limFila += 1;
			k += 1;
			l += 1;
			filas -= 1;
			col -= 1;
		}
		return espiral;
	}
}
