package co.edu.udea.model;

public class StraightLine {
	
	private float intercept;
	
	private float slope;

	public StraightLine(float intercept, float slope) {
		this.intercept = intercept;
		this.slope = slope;
	}

	public StraightLine() {
	}

	public float getIntercept() {
		return intercept;
	}

	public void setIntercept(float intercept) {
		this.intercept = intercept;
	}

	public float getSlope() {
		return slope;
	}

	public void setSlope(float slope) {
		this.slope = slope;
	}
	
	public float calculatePoint(float x){
		return (getIntercept() + getSlope()*x);
	}

}
