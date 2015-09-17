
public class ListaLigada {
	Nodo primero, ultimo;

	public ListaLigada() {
		primero = null;
		ultimo = null;
	}

	public boolean esVacia() {
		if (primero == null)
			return true;
		else
			return false;
	}

	public void agregarNodo(Nodo nodoNuevo) {
		if (esVacia()) {
			primero = nodoNuevo;
			ultimo = nodoNuevo;
		} else {
			ultimo.siguiente = nodoNuevo;
			ultimo = nodoNuevo;
		}
	}

	public Nodo getPrimero() {
		return primero;
	}

	public void setPrimero(Nodo primero) {
		this.primero = primero;
	}

	public Nodo getUltimo() {
		return ultimo;
	}

	public void setUltimo(Nodo ultimo) {
		this.ultimo = ultimo;
	}
}
