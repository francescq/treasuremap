package com.francesc.treasuremap.oo;

public class Point {

	int point;
	int numTreasures;
	
	public Point(int point, int numTreasures){
		this.point = point;
		this.numTreasures = numTreasures;
	}
	
	public Point(){
		
	}

	/**
	 * Solver for a concrete point. Is this point a treasure point? To answer it
	 * evaluates the integer of the map. It's allowed to initialize the map with
	 * integers 1,0 or chars 'X','-'. If the position is equal to 1 or 'X'
	 * return true, else returns false.
	 * 
	 * 
	 * @param valuePoint
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
	
	public void populatePoint(double threshold) {
		double rand = Math.random();
		if (rand > threshold) {
			rand = 1;
		} else {
			rand = 0;
		}
		point = (int) rand;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getNumTreasures() {
		return numTreasures;
	}

	public void setNumTreasures(int numTreasures) {
		this.numTreasures = numTreasures;
	}

}
