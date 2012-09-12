package com.francesc.treasuremap.oo;

/**
 * 
 * @author Francesc Qui–ones Gispert
 * @date 12/09/2012
 * 
 *       This class implements a point in the tresaurus map. It defines if there
 *       is a tesaurus in this point, how many tesaurus are nearby (1 point of
 *       distance)
 * 
 */
public class Point {

	/**
	 * Is in this point a treasure? 1 or X yes. 0 or - no.
	 */
	int point;

	/**
	 * Provide the num of tresaures nearby
	 */
	int numTreasures;

	public Point(int point, int numTreasures) {
		this.point = point;
		this.numTreasures = numTreasures;
	}

	/**
	 * empty constructor
	 */
	public Point() {

	}

	/**
	 * Solver for a concrete point. Is this point a treasure point? To answer it
	 * evaluates the integer of the map. It's allowed to initialize the map with
	 * integers 1,0 or chars 'X','-'. If the position is equal to 1 or 'X'
	 * return true, else returns false.
	 * 
	 * @return boolean Is this point a treasure point?
	 */
	public boolean isTreasurePoint() {
		boolean solver = false;

		if ((point == 1) || (point == 'X')) {
			solver = true;
		}

		return solver;
	}

	/**
	 * Decides if in this point there is a tresaure. If Random > threshold there
	 * is a tesaure.
	 * 
	 * @param threshold
	 *            threshold
	 */
	public void populatePoint(double threshold) {
		double rand = Math.random();
		if (rand > threshold) {
			rand = 1;
		} else {
			rand = 0;
		}
		point = (int) rand;
	}

	/**
	 * To string, this point to string
	 */
	public String toString() {
		return point + "";
	}

	/**
	 * Getter for poing
	 * 
	 * @return
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * Setter for point
	 * 
	 * @param point
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * Getter for num treasures
	 * 
	 * @return int numTreasures
	 */
	public int getNumTreasures() {
		return numTreasures;
	}

	/**
	 * Setter for numTreasures
	 * 
	 * @param int numTreasures
	 */
	public void setNumTreasures(int numTreasures) {
		this.numTreasures = numTreasures;
	}

}
