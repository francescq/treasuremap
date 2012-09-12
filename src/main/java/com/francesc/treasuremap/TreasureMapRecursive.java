package com.francesc.treasuremap;

public class TreasureMapRecursive extends Map {

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
	public TreasureMapRecursive(int i, int j, double threshold) {
		super(i, j);
		this.threshold = threshold;
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
	 * Uses reurseve approach to solve the mattrix. Is slower than iterative
	 * 
	 * @param x
	 *            int width to evaluate
	 * @param y
	 *            int height to evaluate
	 * @param depth
	 *            how many distance points to evaluate
	 * @return int number of nearby treasures at this point.
	 */
	private int solvePointRecursive(int x, int y, int depth) {
		int count = 0;

		if (depth == 0) {
			if (isTreasurePoint(x, y)) {
				count = 1;
			}
		} else {
			depth--;
			for (int i = x - 1; i < x + 2; i++) {

				for (int j = y - 1; j < y + 2; j++) {

					count += solvePointRecursive(i, j, depth);

				}
			}
		}

		return count;
	}

	/**
	 * redirects to solvePointRecursive
	 */
	@Override
	protected int solvePoint(int x, int y) {
		return solvePointRecursive(x, y, 1);
	}

}
