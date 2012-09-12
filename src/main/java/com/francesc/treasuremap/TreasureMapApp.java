package com.francesc.treasuremap;

public class TreasureMapApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map treasureMap = new TreasureMap(1000, 1000, 0.9);
		treasureMap.populate();
		treasureMap.solve();
		//System.out.println(treasureMap);

		treasureMap = new TreasureMapRecursive(1000, 1000, 0.9);
		treasureMap.populate();
		treasureMap.solve();
		//System.out.println(treasureMap);


	}

}
