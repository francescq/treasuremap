package com.francesc.treasuremap;

/**
 * 
 * @author francescq
 * 
 *         Abstract class implementing the treasure map. It forces to subclasses
 *         to choose the map generation population and map solve mode
 */
public abstract class TreasureGrid {

	/**
	 * Treasure map itself. It's an int matrix
	 */
	private int[][] map = null;

	/**
	 * Result map. Where the treasure cells count is stored
	 */
	private int[][] result = null;

	/**
	 * Creates the map and the result map to specified width and height
	 * 
	 * @param x
	 *            width
	 * @param y
	 *            height
	 */
	protected TreasureGrid(int x, int y) {
		map = new int[x][y];
		result = new int[x][y];
	}

	/**
	 * Creates the map from outside param. Initialize the result map to map size
	 * as well.
	 * 
	 * @param map
	 *            treasure map
	 */
	protected TreasureGrid(int[][] map) {

		if (map == null) {
			throw new NullPointerException(
					TreasureGrid.class
							+ " TreasureGrid(int [][] map): map argument must not be null");
		}

		this.map = map;

		result = new int[map.length][map[0].length];

	}

	protected TreasureGrid() {

	}

	/**
	 * Returns if the evaluated point is in map grid or not
	 * 
	 * @param i
	 *            width position
	 * @param j
	 *            height position
	 * @return boolean is the point inside the map grid?
	 */
	protected boolean isInGrid(int i, int j) {
		boolean isInGrid = true;

		if (i < 0 || j < 0 || i >= getMap().length || j >= getMap()[i].length) {
			isInGrid = false;
		}

		return isInGrid;
	}

	/**
	 * TreasureMap getter
	 * 
	 * @return int [][] matrix
	 */
	public int[][] getMap() {
		return map;
	}

	/**
	 * TreasureMap solver getter
	 * 
	 * @return int [][] matrix
	 */
	public int[][] getResult() {
		return result;
	}

	/**
	 * TreasureMap setter
	 * 
	 * @param map
	 *            int [][] matrix
	 */
	public void setMap(int[][] map) {
		this.map = map;
	}

	/**
	 * ResultMAp setter
	 * 
	 * @param map
	 *            int [][] matrix
	 */
	public void setResult(int[][] result) {
		this.result = result;
	}

	/**
	 * Forces to subclass to try the autoPopulate methodology to a single point
	 * 
	 * @return int according to 1 or 'X' if there is a treasure, 0,'-' if there
	 *         is not.
	 */
	protected abstract int populatePoint();

	/**
	 * Goes throgh the entire treasure mattrix to populate it
	 */
	public void populate() {
		for (int i = 0; i < map.length; i++) {

			for (int j = 0; j < map[i].length; j++) {

				map[i][j] = populatePoint();

			}
		}
	}

	/**
	 * Solver for a concrete point. Is this point a treasure point? To answer it
	 * evaluates the integer of the map. It's allowed to initialize the map with
	 * integers 1,0 or chars 'X','-'. If the position is equal to 1 or 'X'
	 * return true, else returns false.
	 * 
	 * @param x
	 *            witdh to evaluate
	 * @param y
	 *            height to evaluate
	 * @return boolean Is this point a treasure point?
	 */
	protected boolean isTreasurePoint(int x, int y) {
		boolean solver = false;

		if (isInGrid(x, y))
			if ((getMap()[x][y] == 1) || (getMap()[x][y] == 'X')) {
				solver = true;
			}

		return solver;
	}

	/**
	 * Increments +1 to result matrix
	 * 
	 * @param x
	 *            width point
	 * @param y
	 *            height point
	 */
	protected void addTreasureToPoint(int x, int y) {
		result[x][y] = result[x][y] + 1;
	}

	/**
	 * solvePoin forces the subclass to implement the approach to solve te
	 * point.
	 * 
	 * @param x
	 *            width to evaluate
	 * @param y
	 *            height to evaluate
	 * @return int how many treasures are nearby?
	 */
	protected abstract void solvePoint(int x, int y);

	/**
	 * Solve goes through the treasure map matrix. For each point evaluated
	 * calls solvePoint.
	 */
	public void solve() {
		long time = System.currentTimeMillis();

		for (int i = 0; i < getMap().length; i++) {

			for (int j = 0; j < getMap()[i].length; j++) {

				solvePoint(i, j);

			}

		}

		System.out.println("Solved in: " + (System.currentTimeMillis() - time)
				+ " milis");
	}

	/**
	 * Prints the treasure map and the solver map.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder("\nMap:");
		s.append(toStringMap(getMap()));
		s.append("\nResult:\n");
		s.append(toStringMap(getResult()));
		return s.toString();
	}

	private String toStringMap(int[][] map) {
		StringBuilder row = null;
		StringBuilder line = new StringBuilder("--");
		StringBuilder treasureMap = new StringBuilder("");

		for (int y = 0; y < map[map.length - 1].length; y++) {
			row = new StringBuilder("|");

			for (int x = 0; x < map.length; x++) {
				row.append(map[x][y]);

				if (y == 0) {
					line.append("-");
				}
			}
			if (y == 0) {
				line.append("\n");
				treasureMap.append(line);
			}
			row.append("|\n");
			treasureMap.append(row);
		}

		treasureMap.append(line);

		return treasureMap.toString();
	}

}
