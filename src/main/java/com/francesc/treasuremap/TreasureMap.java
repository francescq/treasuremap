package com.francesc.treasuremap;

public class TreasureMap extends Map {
	
	private double threshold;
	
	TreasureMap(int i, int j, double threshold){
		super(i,j);
		this.threshold=threshold;
		
		
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
	
	
	@Override
	public int solvePoint(int [][] map, int x, int y){
		return solvePoint(map, x, y, 1);
	}
	private int solvePoint(int [][] map, int x, int y, int depth) {
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
