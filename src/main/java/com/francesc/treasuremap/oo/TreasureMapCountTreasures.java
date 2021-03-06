package com.francesc.treasuremap.oo;

public class TreasureMapCountTreasures extends TreasureGrid {

	/**
	 * Contructor for autogenerated maps
	 * 
	 * @param x
	 *            width
	 * @param y
	 *            height
	 * @param threshold
	 *            threshold
	 */
	public TreasureMapCountTreasures(int x, int y, double threshold) {
		super(x, y, threshold);
	}

	/**
	 * Treasure map from outer param
	 * 
	 * @param map
	 *            int [][] treasure map
	 */
	public TreasureMapCountTreasures(int[][] map) {
		super(map);
	}

	/**
	 * Add a treasure to neighbours treasure count
	 * 
	 * @param x
	 *            width point
	 * @param y
	 *            height point
	 */
	private void addTreasureToNeighbours(int x, int y) {
		for (int i = x - 1; i < x + 2; i++) {
			for (int j = y - 1; j < y + 2; j++) {
				if (isInGrid(i, j)) {
					addTreasureToPoint(i, j);
				}
			}
		}
	}

	/**
	 * IF the point is a treasure, then add +1 to neighbours treasures count
	 */
	@Override
	protected void solvePoint(int i, int j) {
		if (isTreasurePoint(i, j)) {
			addTreasureToNeighbours(i, j);
		}

	}

}
