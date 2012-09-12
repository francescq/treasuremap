package com.francesc.treasuremap;

import org.junit.Assert;
import org.junit.Test;

public class TreasureMapTest {

	@Test public void testTreasureMapInit(){
		TreasureMap t = new TreasureMap(10,10,0.9);
		t.populate();
		int [][] map = t.getMap();
		
		int counter = 0;
		
		for(int i = 0; i < map.length; i++ ){
			for (int j = 0; j < map[i].length; j++){
				if(map[i][j] == 1){
					counter++;
				}
			}
		}
		
		Assert.assertTrue(counter > 0);
		
	}
	
	@Test public void testTreasureMapSolve(){
		TreasureMap t = new TreasureMap(10,10,0.9);
		t.populate();
		t.solve();
		
		int [][] map = t.getMap();
		
		for(int i = 0; i < map.length; i++){
			for(int j = 0; i < map[i].length; j++){
				
			}
		}
		
	}
}
