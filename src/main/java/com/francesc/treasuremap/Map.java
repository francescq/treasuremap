package com.francesc.treasuremap;

public abstract class Map {

	private int [][] map = null;
	private int [][] result = null;
	
	Map(int x, int y){
		map = new int [x][y];
		result = new int [x][y];
		
		
	}
	
	protected int [][] getMap(){
		return map;
	}
	
	protected int [][] getResult(){
		return result;
	}
	
	protected abstract int populate();
	
	protected void populateMap(){
		for (int i = 0; i < map.length; i++) {

			for (int j = 0; j < map[i].length; j++) {

				map[i][j] = populate();
				
			}
		}
	}
	
	protected abstract int solvePoint(int [][] map, int x, int y);
	
	public void solve(){
		long time = System.currentTimeMillis();

		for (int i = 0; i < map.length; i++) {

			for (int j = 0; j < map[i].length; j++) {

				result[i][j] = solvePoint(getMap(), i, j);
			}

		}
		
		System.out.println("Solved in: "+(System.currentTimeMillis()-time)+" milis");
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder("\nMap:");
		s.append(toStringMap(getMap()));
		s.append("\nResult:\n");
		s.append( toStringMap(getResult()));
		return s.toString();
	}

	private String toStringMap(int [][] map) {
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
