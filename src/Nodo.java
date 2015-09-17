
public class Nodo {
	Nodo siguiente;
	Integer dato;

	public Nodo() {
		siguiente = null;
		dato = null;
	}

	public Nodo(Integer elemento) {
		siguiente = null;
		dato = elemento;
	}

	public Integer getDato() {
		return dato;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public void setDato(Integer dato) {
		this.dato = dato;
	}
}
