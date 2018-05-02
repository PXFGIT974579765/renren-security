package io.renren.common.utils;

/**
 * 线性回归基础数据类
 * @author ryanyang
 * @date 2018-4-26
 */
public class DataPoint {

	/** the x value */
	public double x;

	/** the y value */
	public double y;

	/**
	 * Constructor.
	 * 
	 * @param x
	 *            the x value
	 * @param y
	 *            the y value
	 */
	public DataPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
