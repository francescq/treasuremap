package com.francesc.treasuremap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TreasureMapTest {

	private int[][] mapTest = { { 'X', '-', '-', '-', '-' },
			{ '-', '-', 'X', '-', '-' }, { '-', '-', '-', '-', '-' },
			{ '-', '-', '-', '-', '-' } };
	private int[][] mapResult = { { 1, 2, 1, 1, 0 }, { 1, 2, 1, 1, 0 },
			{ 0, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0 } };

	/**
	 * Test if TreasureMap solves mapTest as mapResult expected
	 */
	@Test
	public void testTreasureMapIterativeSolve() {
		TreasureGrid t = new TreasureMapIterative(mapTest);
		// t.setMap(mapTest);
		t.solve();

		int[][] result = t.getResult();

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				assertTrue(mapResult[i][j] == result[i][j]);
			}
		}
	}

	/**
	 * Test if TreasureMap solves mapTest as mapResult expected
	 */
	@Test
	public void testTreasureMapRecursiveSolve() {
		TreasureGrid t = new TreasureMapRecursive(mapTest);
		// t.setMap(mapTest);
		t.solve();

		int[][] result = t.getResult();

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				assertTrue(mapResult[i][j] == result[i][j]);
			}
		}
	}

	/**
	 * Test if TreasureMap solves mapTest as mapResult expected
	 */
	@Test
	public void testTreasureMapCountTreasuresSolve() {
		TreasureGrid t = new TreasureMapCountTreasure(mapTest);
		// t.setMap(mapTest);
		t.solve();

		int[][] result = t.getResult();

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				assertTrue(mapResult[i][j] == result[i][j]);
			}
		}
	}

	/**
	 * Test if TreasureMapRecursive solves mapTest as mapResult expected
	 */
	@Test
	public void testTreasureMapRecursive() {
		TreasureMapRecursive t = new TreasureMapRecursive(mapTest);
		t.solve();

		int[][] map = t.getResult();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				assertTrue(mapResult[i][j] == map[i][j]);
			}
		}
	}

	/**
	 * Test if there is any runtime exception
	 */
	@Test
	public void testTreasureMapSolveAutoGenerated() {
		TreasureMapIterative t = new TreasureMapIterative(10, 10, 0.9);
		t.populate();
		t.solve();

		t = new TreasureMapIterative(0, 0, 0.9);
		t.populate();
		t.solve();
	}

	/**
	 * Test to be sure that a null map cannot be used
	 */
	@Test
	public void testTreasureMapFailIfMapNull() {
		boolean ex = false;
		TreasureMapIterative t = null;
		try {
			t = new TreasureMapIterative(null);
		} catch (NullPointerException e) {
			ex = true;
		}
		assertTrue(ex);
	}

	/**
	 * Test to ensure that no exceptions are thrown
	 */
	@Test
	public void testTreasureMapRecursiveAutoGenerated() {
		TreasureGrid t = new TreasureMapRecursive(10, 10, 0.9);
		t.populate();
		t.solve();

		t = new TreasureMapRecursive(10, 10, 0.9);
		t.populate();
		t.solve();

		t = new TreasureMapCountTreasure(10, 10, 0.9);
		t.populate();
		t.solve();

	}

	/**
	 * Test to know the performance
	 */
	@Test
	public void testTreasureMapPerformance() {
		TreasureGrid treasureMap = null;
		// Stress with iterative approach
		treasureMap = new TreasureMapIterative(1000, 1000, 0.9);
		treasureMap.populate();
		treasureMap.solve();
		// System.out.println(treasureMap);

		// Stress with recursive approach
		treasureMap = new TreasureMapRecursive(1000, 1000, 0.9);
		treasureMap.populate();
		treasureMap.solve();

		// Stress with recursive approach
		treasureMap = new TreasureMapCountTreasure(1000, 1000, 0.9);
		treasureMap.populate();
		treasureMap.solve();

	}

	/**
	 * Test to check if point is in map grid
	 */
	@Test
	public void testTreasureMapIInGrid() {

		TreasureGrid t = new TreasureMapIterative(mapTest);
		for (int i = 0; i < mapTest.length; i++) {
			for (int j = 0; j < mapTest[i].length; j++) {
				assertTrue(t.isInGrid(i, j));
			}
		}

		assertFalse(t.isInGrid(-1, 1));
		assertFalse(t.isInGrid(-1, -1));
		assertFalse(t.isInGrid(1, -1));
		assertFalse(t.isInGrid(mapTest.length, mapTest[0].length));
		assertFalse(t.isInGrid(mapTest.length, mapTest[0].length - 1));
		assertFalse(t.isInGrid(mapTest.length - 1, mapTest[0].length));

	}
}
