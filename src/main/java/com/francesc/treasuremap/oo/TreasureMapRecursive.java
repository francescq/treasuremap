package com.francesc.treasuremap.oo;


public class TreasureMapRecursive extends Map {

	public TreasureMapRecursive(int x, int y, double treshold){
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
	 * Uses reurseve approach to solve the mattrix. Is slower than iterative
	 * 
	 * @param map
	 *            int [][] treasure map
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
		Point p = null;
		if (depth == 0) {
			try {
				 p = (Point) getMap().get(x).get(y);
				if (p.isTreasurePoint()) {
					count = 1;
				}
			} catch (Exception e) {

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

	@Override
	protected void solvePoint(int i, int j) {
		int numTreasures = solvePointRecursive(i,j,1);
		((Point) getMap().get(i).get(j)).setNumTreasures(numTreasures);
	}
}
