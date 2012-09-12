

public class TreasureMap {

	int[][] map = null;
	int[][] result = null;

	int x, y = 0;

	double threshold = 0.9;

	double time = 0;

	public TreasureMap(int x, int y) {
		this.x = x;
		this.y = y;
		map = new int[x][y];
		result = new int[x][y];
	}

	public TreasureMap(int[][] map) {
		this.map = map;
	}

	public TreasureMap() {
		this(10, 10);
	}

	public void populateMap() {
		time = System.currentTimeMillis();
		double rand = 0;
		for (int i = 0; i < map.length; i++) {
			for (int y = 0; y < map.length; y++) {
				rand = Math.random();
				if (rand > threshold) {
					rand = 1;
				} else {
					rand = 0;
				}
				map[i][y] = (int) rand;
			}
		}
		time = System.currentTimeMillis() - time;
		System.out.println(time);
	}

	public String toString() {
		StringBuilder row = null;
		StringBuilder line = new StringBuilder("--");
		StringBuilder treasureMap = new StringBuilder("");
		int x = 0;

		for (int y = 0; y < map[map.length - 1].length; y++) {
			row = new StringBuilder("|");

			for (x = 0; x < map.length; x++) {
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

	public String toStringResult() {
		StringBuilder row = null;
		StringBuilder line = new StringBuilder("--");
		StringBuilder treasureMap = new StringBuilder("");

		for (int y = 0; y < result[result.length - 1].length; y++) {
			row = new StringBuilder("|");

			for (int x = 0; x < result.length; x++) {
				row.append(result[x][y]);

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

	private void solvePoint(int x, int y) {

		int count = 0;

		for (int i = x - 1; i < x + 2; i++) {

			for (int j = y - 1; j < y + 2; j++) {
				if(i < 0 | i >= map.length) break;
				if(j < 0 | j >= map[i].length) break;
				
				//try {
					if (map[i][j] == 1) {
						count++;
					}
				//} catch (ArrayIndexOutOfBoundsException e) {

				//}
			}
		}

		result[x][y] = count;
	}

	public void solve() {
		long time = System.currentTimeMillis();

		for (int i = 0; i < map.length; i++) {

			for (int j = 0; j < map[i].length; j++) {

				solvePoint(i, j);
			}

		}
		
		System.out.println("Solved in: "+(System.currentTimeMillis()-time)+" milis");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TreasureMap treasureMap = new TreasureMap(1000,1000);
		treasureMap.populateMap();
		//System.out.println("Treasuere Map:\n" + treasureMap.toString());
		treasureMap.solve();
		//System.out.println("Treasuere Map Sloved:\n"+ treasureMap.toStringResult());
	}

}
