package com.francesc.treasuremap.oo;

public class TreasureMapRecursive extends TreasureGrid {

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
	public TreasureMapRecursive(int x, int y, double treshold) {
		super(x, y, treshold);
	}

	/**
	 * Treasure map from outer param
	 * 
	 * @param map
	 *            int [][] treasure map
	 */
	public TreasureMapRecursive(int[][] map) {
		super(map);
	}

	/**
	 * Solves the problem using the iterative approach. This approach is slower
	 * than iterative
	 * 
	 * @param x
	 *            width position to evaluate
	 * @param y
	 *            height position to evaluate
	 */
	private int solvePointRecursive(int x, int y, int depth) {
		int count = 0;
		Point p = null;

		if (depth == 0) {
			// At the end of depth it evaluates the point
			if (isInGrid(x, y) && isTreasurePoint(x, y)) {

				count = 1;

			}

		} else {
			depth--;

			// Follow with recursivity, downgrading the recursivity depth

			// Go throught nearby points to evaluate them
			for (int i = x - 1; i < x + 2; i++) {

				for (int j = y - 1; j < y + 2; j++) {

					count += solvePointRecursive(i, j, depth);

				}
			}
		}

		return count;
	}

	/**
	 * Evaluates and save the num of treasures nearby in recursive approach
	 * 
	 * @param i
	 *            int width point to evaluate
	 * @param j
	 *            int height to evaluate
	 */
	@Override
	protected void solvePoint(int i, int j) {
		int numTreasures = solvePointRecursive(i, j, 1);
		addTreasuresToPoint(i, j, numTreasures);
	}
}
