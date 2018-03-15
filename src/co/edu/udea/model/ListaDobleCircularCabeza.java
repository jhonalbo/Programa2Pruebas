package co.edu.udea.model;

public class ListaDobleCircularCabeza {
	public Nodo cabeza;
	public int	cantidad;
	public Nodo ultimo;
	
	float sumaX;
	float sumaY;

	public ListaDobleCircularCabeza(Point p)
	{
		cabeza = new Nodo(p);
		ultimo = cabeza;
		cantidad = 1;
	}
	
	public ListaDobleCircularCabeza()
	{
		cabeza = null;
		ultimo = cabeza;
		cantidad = 0;
	}

	public void AgregarNodo(Point p)
	{
		Nodo nNodo = new Nodo(p);
		sumaX += p.getX();
		sumaY += p.getY();
		
		//nNodo.AsignarSiguiente(ultimo);
		if (cantidad == 0)
		{
			cabeza = nNodo;
			cabeza.setSiguiente(nNodo);
			ultimo = nNodo;
		}else{
			ultimo.setSiguiente(nNodo);
			ultimo=nNodo;
		}
		
		cantidad ++;
	}
	
	public ListaDobleCircularCabeza llenarLista(Point[] numeros){
		ListaDobleCircularCabeza lista = new ListaDobleCircularCabeza();
		for(Point n : numeros){
			lista.AgregarNodo(n);
		}
		
		return lista;
	}
	
	public float RetornarSuma(boolean x)
	{
		if(x) return sumaX; else return sumaY;
	}
	
	public int RetornarCantidad()
	{
		return cantidad;
	}
	
	public Nodo nodeAt(int d) throws java.lang.NullPointerException{		
		Nodo nodo = this.cabeza;
		for(int i=0; i < this.cantidad; i++){
			if(i==d){
				break;
			}else{
				nodo = nodo.siguiente;
			}
		}
		return nodo;		
	}
}
