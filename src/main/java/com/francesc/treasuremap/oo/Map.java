package com.francesc.treasuremap.oo;

import java.util.List;
import java.util.Vector;

/**
 * 
 * @author Francesc Qui�ones Gispert
 * @date 12/09/2012
 * 
 *       Abstract class implementing the treasure map. It forces to subclasses
 *       to choose the map generation population and map the solve mode
 */
public abstract class Map {

	/**
	 * Treasure map itself. List of vectors
	 */
	private List<Vector> map = null;

	private double threshold;

	/**
	 * Creates the map with a treshold in order to autogenerate
	 * 
	 * @param treshold
	 *            autogenerated treshold
	 */
	protected Map(int threshold) {
		map = new Vector();
	}

	/**
	 * Creates the map and the result map to specified width and height ith the
	 * specified threshold.
	 * 
	 * @param x
	 *            width
	 * @param y
	 *            height
	 * @param threshold
	 *            threshold
	 */
	protected Map(int x, int y, double threshold) {
		this.threshold = threshold;

		map = new Vector<Vector>();

		Vector<Point> row = null;
		Point point = null;

		for (int i = 0; i < x; i++) {
			row = new Vector<Point>();
			this.map.add(row);

			for (int j = 0; j < y; j++) {
				point = new Point();
				point.populatePoint(getThreshold());
				row.add(point);
			}
		}
	}

	/**
	 * Creates the map from outside param. Initialize the result map to map size
	 * as well. It doesn't provide the threshold because it is not necessary
	 * 
	 * @param map
	 *            treasure map
	 */
	protected Map(int[][] map) {
		int y = 0;

		if (map == null) {
			throw new NullPointerException(Map.class
					+ " Map(int [][] map): map argument must not be null");
		}

		// if map size is [0,0]
		if (map.length > 0) {
			y = map[0].length;
		}

		this.map = new Vector<Vector>();

		Vector<Point> row = null;
		Point point = null;

		for (int i = 0; i < map.length; i++) {
			row = new Vector<Point>();
			this.map.add(row);

			for (int j = 0; j < y; j++) {
				point = new Point(map[i][j], -1);
				row.add(point);
			}
		}
	}

	/**
	 * TreasureMap getter
	 * 
	 * @return int [][] matrix
	 */
	public List<Vector> getMap() {
		return map;
	}

	/**
	 * TreasureMap setter
	 * 
	 * @param map
	 *            int [][] matrix
	 */
	public void setMap(List<Vector> map) {
		this.map = map;
	}

	/**
	 * Goes throgh the entire treasure mattrix to populate it
	 */
	public void populate() {
		for (Vector<Point> v : getMap()) {
			for (Point p : v) {
				p.populatePoint(getThreshold());
			}
		}
	}

	/**
	 * It forces to subclass to decide the solve approach
	 * 
	 * @param i
	 *            position x to solve
	 * @param j
	 *            position y to solve
	 */
	protected abstract void solvePoint(int i, int j);

	/**
	 * Solve goes through the treasure map matrix. For each point evaluated
	 * calls solvePoint.
	 */
	public void solve() {
		long time = System.currentTimeMillis();

		for (int i = 0; i < getMap().size(); i++) {
			for (int j = 0; j < getMap().get(i).size(); j++) {
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
		s.append(toStringMap("map"));
		s.append("\nResult:\n");
		s.append(toStringMap("result"));
		return s.toString();
	}

	private String toStringMap(String mode) {
		StringBuilder row = null;
		StringBuilder line = new StringBuilder("--");
		StringBuilder treasureMap = new StringBuilder("");

		int y = 0;

		for (Vector<Point> v : getMap()) {
			row = new StringBuilder("|");

			for (Point p : v) {
				if ("map".equals(mode)) {
					row.append(p.getPoint());
				} else {
					row.append(p.getNumTreasures());
				}

				if (y == 0) {
					line.append("-");
				}
			}
			if (y == 0) {
				line.append("\n");
				treasureMap.append(line);
				y++;
			}
			row.append("|\n");
			treasureMap.append(row);
		}

		treasureMap.append(line);

		return treasureMap.toString();
	}

	/**
	 * getter for threshold
	 * 
	 * @return double
	 */
	public double getThreshold() {
		return threshold;
	}

	/**
	 * setter for threshold
	 * 
	 * @param threshold
	 *            double
	 */
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

}
