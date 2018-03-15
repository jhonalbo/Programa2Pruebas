package co.edu.udea.business;


import co.edu.udea.model.ListaDobleCircularCabeza;
import co.edu.udea.model.Nodo;
import co.edu.udea.model.Point;
import co.edu.udea.model.StraightLine;

public class Calculator implements ICalculator{

	@Override
	public float calculateMean(ListaDobleCircularCabeza dataList, boolean x) {
		try{		
			if(dataList.cantidad>0){
				float promedio = dataList.RetornarSuma(x)/dataList.cantidad;
				return promedio;
			}else{
				return 0;
			}			
		}catch(Exception e){
			return 0;
		}
	}
	
	@Override
	public StraightLine calculateRegressionLine(ListaDobleCircularCabeza lista) {
		StraightLine line = new StraightLine();
		float xAvg = calculateMean(lista, true);
		float yAvg = calculateMean(lista, false);
		float slope = calculateSlope(lista, xAvg, yAvg);
		line.setSlope(slope);		
		line.setIntercept(calculateIntercept(slope, xAvg, yAvg));		
		return line;
	}
	
	@Override
	public float calculateCorrelationCoefficient(ListaDobleCircularCabeza lista){
		int n = lista.cantidad;
		float term1 = 0f;
		for(int i=0; i < n; i++){
			term1 += lista.nodeAt(i).getValor().getX() *
					lista.nodeAt(i).getValor().getY();
		}		
		term1 = n * term1;
		
		float term2 = 0f;
		float term2Fact1 = 0f;
		float term2Fact2 = 0f;
		for(int i=0; i < n; i++){
			term2Fact1 += lista.nodeAt(i).getValor().getX();
		}
		for(int i=0; i < n; i++){
			term2Fact2 += lista.nodeAt(i).getValor().getY();
		}
		term2 = term2Fact1 * term2Fact2;
		
		float t4f1t1 = 0f;
		for(int i = 0; i < n; i++){
			t4f1t1 += (float) (Math.pow(lista.nodeAt(i).getValor().getX(), 2));
		}
		t4f1t1 = n * t4f1t1;
		
		float t4f1t2 = 0f;
		for(int i = 0; i < n; i++){
			t4f1t2 += (float) lista.nodeAt(i).getValor().getX();
		}
		t4f1t2 = (float) (Math.pow(t4f1t2, 2));
		
		float t4f2t1 = 0f;
		for(int i = 0; i < n; i++){
			t4f2t1 += (float) (Math.pow(lista.nodeAt(i).getValor().getY(), 2));
		}
		t4f2t1 = n * t4f2t1;
		
		float t4f2t2 = 0f;
		for(int i = 0; i < n; i++){
			t4f2t2 += (float) lista.nodeAt(i).getValor().getY();
		}
		t4f2t2 = (float) (Math.pow(t4f2t2, 2));
		
		float r = (float) ((term1 - term2)/(Math.sqrt((t4f1t1 - t4f1t2) * (t4f2t1 - t4f2t2))));
		
		return r;
	}
	
	public float calculateSlope(ListaDobleCircularCabeza lista, float xAvg, float yAvg){
		int n = lista.cantidad;		
		float term1 = 0f;
		for(int i=0; i<n; i++){
			term1 += lista.nodeAt(i).getValor().getX() *
					lista.nodeAt(i).getValor().getY();
		}
		
		float term2 = n * xAvg * yAvg;
		
		float term3 = 0f;
		for(int i = 0; i < n; i++){
			term3 += (float) (Math.pow(lista.nodeAt(i).getValor().getX(), 2));
		}
		
		float term4 = (float) (n * Math.pow(xAvg, 2));
		float b1 = (term1 - term2) / (term3 - term4);
		
		return b1;
	}
	
	public float calculateIntercept(float slope, float xAvg, float yAvg){		
		return (yAvg - slope * xAvg);
	}
	
	public static void main(String[] args){
		Point p1 = new Point(130, 186);
		Point p2 = new Point(650, 699);
		Point p3 = new Point(99, 132);
		Point p4 = new Point(150, 272);
		Point p5 = new Point(128, 291);
		Point p6 = new Point(302, 331);
		Point p7 = new Point(95, 199);
		Point p8 = new Point(945, 1890);
		Point p9 = new Point(368, 788);
		Point p10 = new Point(961, 1601);
		Point[] numeros = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};
		ListaDobleCircularCabeza lista = new ListaDobleCircularCabeza();
		lista  = lista.llenarLista(numeros);
		Calculator c = new Calculator();
		StraightLine line = c.calculateRegressionLine(lista);
		float correlation = c.calculateCorrelationCoefficient(lista);
		System.out.println("Slope: " + line.getSlope() + ". Intercept: "+ line.getIntercept());
		System.out.println("Correlation: "+correlation);
		/*System.out.println("promedio: "+c.calculateMean(lista));
		System.out.println("desviacion estandar: "+c.calculateStandardDeviation(lista));*/
	}
	
}