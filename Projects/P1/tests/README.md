# Project 1: Autonomous PacMan

## By: Michael Orlando, Anthony Liu, Elizabeth Bernhardt, Samikshya Sapkota

## Gameplay
<p float="left">
  <img src="https://i.imgur.com/i64u0yZ.png" width="322" />
  <img src="https://i.imgur.com/KCrZiJH.png" width="300" /> 
  <img src="https://i.imgur.com/xzwF7bB.png" width="300" />
</p>

## How to run this from the command line

Make sure to run these commands from inside the P1 directory

```bash
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```
>>>>A list of the functions you wrote with
>>>>a description of the implementation for each function
>>>>a description of the test you wrote
>>>>The descriptions don't have to be long - a sentence or two would suffice.

## PacMan Class Functions   <img src="https://i.imgur.com/pYDel6A.png" width="20" />

* get_valid_moves() -> This method checks the 4 directions/locations around PacMan and if they are inbounds and not of Type.WALL it is a valid move and added to the returned list. 
  - This test places two PacMan on the frame. It then calls the get_valid_moves function and compares its elements to the expected values based on the respective PacMan's locations. 
* move() -> This method uses the get_valid_moves method to find the possible locations that PacMan can move, and will move to a location to where a cookie exists, if possible. Otherwise, the pacman will choose a random valid location.
  - The test places a PacMan object a location (1,1) and calls move(), which should return true. The test then places the PacMan at location (0,0) and calls move(), which should return false since he is sitting on a wall and cannot move.
* is_ghost_in_range() -> 
  - *enter test info here*
* consume() ->
  - *enter test info here*

## Ghost Class Functions  <img src="https://i.imgur.com/MvyBJiR.jpg" width="100"/>

* get_valid_moves() -> This method checks the 4 directions/locations around a Ghost and if they are inbounds and not of Type.WALL it is a valid move and added to the returned list. 
  - This test places two Ghost on the frame. It then calls the get_valid_moves function and compares its elements to the expected values based on the respective Ghost's locations.
* move() -> This method uses the get_valid_moves method to find the possible locations that the ghost can move, and then chooses a location randomly to move.
  - The test places a ghost object a location (1,1) and calls move(), which should return true. The test then places the ghost at location (0,0) and calls move(), which should return false since he is sitting on a wall and cannot move.
* is_pacman_in_range() ->
  - *enter test info here*
* attack() ->
  - *enter test info here*

## Map Class Functions <img src="https://i.imgur.com/IN1YUkR.png" width="45"/>

* move(String name, Location loc, Type type) ->
  - *enter test info here*
* getLoc(Location loc) -> This function returns the object type at a given location.
  - The test creates a new frame and tests each type individually based on a given location.
* attack(String name) -> This method checks the 4 directions/locations around the named Ghost and checks if any location contains the Type.PACMAN. If a location contains the Type.PACMAN, gameOver is set to true, and true is returned. Otherwise, false is returned.
  - This test creates a frame with a PacMan, a Ghost within range of the PacMan, and a Ghost not in range. The ghost out of range attacks, and returns false. The ghost in range attacks and returns true. 
* eatCookie(String Name) ->
  - *enter test info here*


>>>>Feel free to be creative and add any other elements. For example, you could
>>>>add a video of your code playing PacMan instead of an image
>>>>add small code blocks that supplement your descriptions
>>>>add a table of contents for your readme
>>>>These aren't required, but could be interesting to explore.
