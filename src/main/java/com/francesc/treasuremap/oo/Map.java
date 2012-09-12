package com.francesc.treasuremap.oo;

import java.util.List;
import java.util.Vector;

/**
 * 
 * @author francescq
 * 
 *         Abstract class implementing the treasure map. It forces to subclasses
 *         to choose the map generation population and map solve mode
 */
public abstract class Map {

	/**
	 * Treasure map itself. List of vectors
	 */
	private List<Vector> map = null;

	private double threshold;

	/**
	 * Creates the map and the result map to specified width and height
	 * 
	 * @param x
	 *            width
	 * @param y
	 *            height
	 */
	protected Map(int threshold) {
		map = new Vector();
	}
	
	protected Map(int x, int y, double threshold){
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
	 * as well.
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
			y = map[0].length - 1;
		}
		
		this.map = new Vector<Vector>();

		Vector<Point> row = null;
		Point point = null;

		for (int i = 0; i < map.length; i++) {
			row = new Vector<Point>();
			this.map.add(row);

			for (int j = 0; j < map[i].length; j++) {
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
	public void setMap(List map) {
		this.map = map;
	}

	/**
	 * Goes throgh the entire treasure mattrix to populate it
	 */
	public void populate() {
		for (Vector<Point> v : map) {
			for (Point p : v) {
				p.populatePoint(getThreshold());
			}
		}
	}

	protected abstract void solvePoint(int i, int j);

	/**
	 * Solve goes through the treasure map matrix. For each point evaluated
	 * calls solvePoint.
	 */
	public void solve() {
		long time = System.currentTimeMillis();

		for (int i = 0; i < map.size(); i++) {
			for (int j = 0; j < map.get(i).size(); j++) {
				solvePoint(i,j);
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

		for (Vector<Point> v : map) {
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
			}
			row.append("|\n");
			treasureMap.append(row);

			y++;
		}

		treasureMap.append(line);

		return treasureMap.toString();
	}

	public double getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

}
