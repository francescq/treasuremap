package com.francesc.treasuremap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.francesc.treasuremap.oo.Map;
import com.francesc.treasuremap.oo.Point;
import com.francesc.treasuremap.oo.TreasureMapIterative;
import com.francesc.treasuremap.oo.TreasureMapRecursive;

/**
 * 
 * @author Francesc Qui�ones Gispert
 * @date 12/09/2012
 * 
 *       I developed the OO approach to demonstrate my OO knowledge. I don't
 *       know my mistake but this approach is much slower, 10 times, than the
 *       basic type approach
 * 
 */
public class TreasureMapOOTest {

	private int[][] mapTest = { { 'X', '-', '-' }, { '-', '-', '-' },
			{ '-', '-', 'X' } };
	private int[][] mapResult = { { 1, 1, 0 }, { 1, 2, 1 }, { 0, 1, 1 } };

	/**
	 * Test if TreasureMap solves mapTest as mapResult expected
	 */
	@Test
	public void testTreasureMapSolve() {
		TreasureMapIterative t = new TreasureMapIterative(mapTest);
		// t.setMap(mapTest);
		t.solve();

		for (int i = 0; i < mapResult.length; i++) {
			for (int j = 0; j < mapResult[i].length; j++) {
				Point p = (Point) t.getMap().get(i).get(j);
				assertTrue(mapResult[i][j] == p.getNumTreasures());
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

		for (int i = 0; i < mapResult.length; i++) {
			for (int j = 0; j < mapResult[i].length; j++) {
				Point p = (Point) t.getMap().get(i).get(j);
				assertTrue(mapResult[i][j] == p.getNumTreasures());
			}
		}
	}

	/**
	 * Test if there is any runtime exception
	 */
	@Test
	public void testTreasureMapIterativeSolveAutoGenerated() {
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
		TreasureMapRecursive t = new TreasureMapRecursive(10, 10, 0.9);
		t.populate();
		t.solve();

		t = new TreasureMapRecursive(0, 0, 0.9);
		t.populate();
		t.solve();
	}

	/**
	 * Test to know the performance
	 */
	@Test
	public void testTreasureMapPerformance() {
		Map treasureMap = null;
		// Stress with iterative approach
		treasureMap = new TreasureMapIterative(1000, 1000, 0.9);
		treasureMap.populate();
		treasureMap.solve();
		// System.out.println(treasureMap);

		// Stress with recursive approach
		treasureMap = new TreasureMapRecursive(1000, 1000, 0.9);
		treasureMap.populate();
		treasureMap.solve();
	}

	/**
	 * Test to check if point is in map grid
	 */
	@Test
	public void testTreasureMapIInGrid() {

		Map t = new TreasureMapIterative(mapTest);
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
