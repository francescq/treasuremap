treasuremap
===========

Hello, 

My name is Francesc Qui–ones.

The basic structure of this problem is an Abstract class with TreasureGrid methods.
The subclasses are forced to implement the solve approach. Each solve approach depends on the strategy

I tried 5 approaches:
ObjectOriented iterative: Iterate each grid point. Look for treasures at neighbours points iterating them.
ObjectOriented recursive: Iterate each grid point. Look for treasures at neighbours points recursively.
PrimitiveType iterate: Iterate each grid point. Look for treasures at neighbours points iterating them.
PrimitiveType recursive: Iterate each grid point. Look for treasures at neighbours points recursively.
PrimitiveType countTreasures: Iterate each grid point and look for treasures. Then, add +1 to neighbours treasuresCout.

ObjectOriented and PrimitiveType has their own jUnit Test. 

One test on each has a grid 1000x1000 in order to test the code performance.

The ObjectOriented approach is near to 20 times slower than PrimitiveTypes. 
The iterating approach is quicker than others.

treasuremap