package com.francesc.treasuremap.oo;

public class TreasureMapIterative extends Map {

	public TreasureMapIterative(int x, int y, double treshold) {
		super(x, y, treshold);
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
	 * @param map
	 *            int [][] treasure map
	 * @param x
	 *            width to evaluate
	 * @param y
	 *            height to evaluate
	 * @return int how many treasures are nearby?
	 */
	private void solvePointIterative(int x, int y) {
		int count = 0;
		Point p = null;

		for (int i = x - 1; i < x + 2; i++) {

			for (int j = y - 1; j < y + 2; j++) {
				try {
					p = (Point) getMap().get(i).get(j);

					if (p.isTreasurePoint()) {
						count++;
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}

		p.setNumTreasures(count);
	}

}
