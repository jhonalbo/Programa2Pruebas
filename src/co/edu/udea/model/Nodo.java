package co.edu.udea.model;

public class Nodo {
	
	public Point valor;
	public Nodo anterior;
	public Nodo siguiente;
	
	public Nodo(Point p)
	{
		valor 		= p;
		anterior 	= null;
		siguiente 	= null;
	}
	
	public void setSiguiente(Nodo n)
	{
		siguiente = n;
	}
	
	public void setAnterior(Nodo n) 
	{
		anterior = n;
	}
	
	public Point getValor()
	{
		return (valor);
	}
}
