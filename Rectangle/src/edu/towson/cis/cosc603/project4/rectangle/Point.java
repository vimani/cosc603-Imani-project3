package edu.towson.cis.cosc603.project4.rectangle;

/**
 * The Point Class.
 */
public class Point {
	
	/** x and y coordinates. */
	public Double xval;
	public Double yval;
	
	/**
	 * Instantiates a new point.
	 *
	 * @param x the x
	 * @param y the y
	 */
	Point(Double x, Double y) {
		xval = x;
		yval = y;
	}
	
	public Double getX(){
		return xval;
	}
	
	public Double getY(){
		return yval;
	}
}
