/**
 * 
 */
package com.mmt.producerConsumer.waitNotify;

/**
 * @author MMT3966
 *
 */
public class Resource {

	private int number;
	private boolean odd;
	private boolean even;

	public Resource(int number, boolean odd, boolean even) {
		super();
		this.number = number;
		this.odd = odd;
		this.even = even;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the odd
	 */
	public boolean isOdd() {
		return odd;
	}

	/**
	 * @param odd
	 *            the odd to set
	 */
	public void setOdd(boolean odd) {
		this.odd = odd;
	}

	/**
	 * @return the even
	 */
	public boolean isEven() {
		return even;
	}

	/**
	 * @param even
	 *            the even to set
	 */
	public void setEven(boolean even) {
		this.even = even;
	}

}
