**Author:** Skylar Abruzese (labruzes@u.rochester.edu)
==============
## Overview ##
This lab was aimed at understanding and implimenting generics and functional method in Java by writing the same array functions in different ways.

## ArrayFuncs.java ##
This is where all the source code for the project is. It contains all 9 methods that are asked to be implimented in the 6 tasks. 

*Notes*
* The lab mentions specific names for each method, however in order to test all my methods at the same time I need them to have seperate names. Hence the method names follow the format: t(task number)(methodname) ex. ```t1PrintArray()``` 
* Task 6 could be simply defined in terms of part 5, however I was unsure if this missed the point of part 6 so I left it commented it out and reimplimented the logic for a Character array

## Testing.java ##
This is where all the methods are tested. Each task has a method call for testing. The test methods, named task1(), task2() etc, each test the methods asked by their respective task number.

The main methods tests all methods in `ArrayFuncs.java` and prints out the values tested, and a test status along with the expected status.
