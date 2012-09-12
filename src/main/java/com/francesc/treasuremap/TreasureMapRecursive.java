package com.francesc.treasuremap;

public class TreasureMapRecursive extends Map {
	
	private double threshold;
	
	TreasureMapRecursive(int i, int j, double threshold){
		super(i,j);
		this.threshold=threshold;
		
		populateMap();
	}

	@Override
	public int populate() {
		double rand = Math.random();
		if (rand > threshold) {
			rand = 1;
		} else {
			rand = 0;
		}
		return (int) rand;
	}
	
	protected int solvePoint(int [][] map, int x, int y) {
		int count = 0;

		for (int i = x - 1; i < x + 2; i++) {

			for (int j = y - 1; j < y + 2; j++) {
				if(i < 0 || i >= map.length) break;
				if(j < 0 || j >= map[i].length) break;
				
				try {
					if (map[i][j] == 1) {
						count++;
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}

		return count;
	}
	

	


}
