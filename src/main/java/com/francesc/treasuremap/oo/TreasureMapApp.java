package com.francesc.treasuremap.oo;

public class TreasureMapApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Test with char maps
		int[][] mapTest = { { 'X', '-', '-' }, { '-', '-', '-' },
				{ '-', '-', 'X' } };
		TreasureGrid treasureMap = new TreasureMapIterative(mapTest);
		treasureMap.solve();
		System.out.println(treasureMap);

		// Test with char maps
		treasureMap = new TreasureMapRecursive(mapTest);
		treasureMap.solve();
		System.out.println(treasureMap);

		// Test with char maps
		treasureMap = new TreasureMapCountTreasures(mapTest);
		treasureMap.solve();
		System.out.println(treasureMap);

	}

}
