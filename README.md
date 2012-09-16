treasuremap
===========

Hello, 

My name is Francesc Quiñones.
@version 2
Fixed the problem with countTreasures method. Because a bug, it was not efficient. Now it is efficient.
-The iterate method for each point evaluates ALL the neighbours.
-The count treasures method add a treasure point to neighbours ONLY if the evaluated point is a treasure.

The difference between iterate, recursive and treasure count is: What I do if the point to evaluate is a treasure?

As allways, the most restrictive conditions goes first. This option increases the code performance.

As the threshold is more restrictive, the count treasure method will go faster.

Added treasure count to OO increasing a lot the performance.

@version 1
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

treasuremap