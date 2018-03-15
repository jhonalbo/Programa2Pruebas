package co.edu.udea.business;

import co.edu.udea.model.ListaDobleCircularCabeza;
import co.edu.udea.model.StraightLine;

public interface ICalculator {

	
	public float calculateMean(ListaDobleCircularCabeza dataList, boolean x);
	
	public StraightLine calculateRegressionLine(ListaDobleCircularCabeza lista);
	
	public float calculateCorrelationCoefficient(ListaDobleCircularCabeza lista);
	
}
