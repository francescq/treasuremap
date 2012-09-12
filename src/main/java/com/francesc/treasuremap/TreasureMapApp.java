package com.francesc.treasuremap;

public class TreasureMapApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Stress with iterative approach
		Map treasureMap = new TreasureMap(1000, 1000, 0.9);
		treasureMap.populate();
		treasureMap.solve();
		//System.out.println(treasureMap);

		//Stress with recursive approach
		treasureMap = new TreasureMapRecursive(1000, 1000 , 0.9);
		treasureMap.populate();
		treasureMap.solve();
		//System.out.println(treasureMap);
		
		//Test with char maps
		int [][] mapTest = {{'X','-','-'},{'-','-','-'},{'-','-','X'}};
		treasureMap = new TreasureMap(mapTest);
		treasureMap.solve();
		System.out.println(treasureMap);


	}

}
