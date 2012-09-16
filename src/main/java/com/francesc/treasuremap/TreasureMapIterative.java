package com.francesc.treasuremap;

public class TreasureMapIterative extends TreasureGrid {

	/**
	 * Threshold to help to autogenerate map.
	 */
	private double threshold;

	/**
	 * Add the threshold. For autogeneraded treasure maps.
	 * 
	 * @param i
	 *            map width to generate
	 * @param j
	 *            map height to generate
	 * @param threshold
	 *            to
	 */
	public TreasureMapIterative(int i, int j, double threshold) {
		super(i, j);
		this.threshold = threshold;
	}

	/**
	 * Treasure map from outer param
	 * 
	 * @param map
	 *            int [][] treasure map
	 */
	public TreasureMapIterative(int[][] map) {
		super(map);
	}

	/**
	 * If random > threshold this is going to be a treasure point.
	 * 
	 * @return int 1 if is a treasure point, 0 if no
	 */
	@Override
	protected int populatePoint() {
		double rand = Math.random();
		if (rand > threshold) {
			rand = 1;
		} else {
			rand = 0;
		}
		return (int) rand;
	}

	/**
	 * redirects to solvePointIterative
	 */
	@Override
	public void solvePoint(int x, int y) {
		solvePointIterative(x, y);
	}

	/**
	 * Solves the problem using iterative approach. This approach is quicker
	 * than recursive
	 * 
	 * @param x
	 *            width to evaluate
	 * @param y
	 *            height to evaluate
	 * @return int how many treasures are nearby?
	 */
	private void solvePointIterative(int x, int y) {
		for (int i = x - 1; i < x + 2; i++) {

			for (int j = y - 1; j < y + 2; j++) {

				if (isTreasurePoint(i, j)) {
					addTreasureToPoint(x, y);
				}
			}
		}
	}

	/**
	 * Threshold getter
	 * 
	 * @return double threshold
	 */
	public double getThreshold() {
		return threshold;
	}

	/**
	 * Threshold setter
	 * 
	 * @param threshold
	 */
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

}
