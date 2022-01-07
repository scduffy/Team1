# cmsc389T-winter22

# Project 1: Autonomous PacMan

## By: Michael Orlando, Anthony Liu, Elizabeth Bernhardt, Samikshya Sapkota

>>>>An image of your code playing PacMan
>>>>A section on how to run the code from the command line
>>>>include a code block



>>>>A list of the functions you wrote with
>>>>a description of the implementation for each function
>>>>a description of the test you wrote
>>>>The descriptions don't have to be long - a sentence or two would suffice.

## PacMan Class Functions

* get_valid_moves() -> 
  - *enter test info here*
* move() -> This method uses the get_valid_moves method to find the possible locations that PacMan can move, and will move to a location to where a cookie exists, if possible. Otherwise, the pacman will choose a random valid location.
  - The test places a PacMan object a location (1,1) and calls move(), which should return true. The test then places the PacMan at location (0,0) and calls move(), which should return false since he is sitting on a wall and cannot move.
* is_ghost_in_range() -> 
  - *enter test info here*
* consume() ->
  - *enter test info here*

## Ghost Class Functions

* get_valid_moves()
  - *enter test info here*
* move() -> This method uses the get_valid_moves method to find the possible locations that the ghost can move, and then chooses a location randomly to move.
  - The test places a ghost object a location (1,1) and calls move(), which should return true. The test then places the ghost at location (0,0) and calls move(), which should return false since he is sitting on a wall and cannot move.
* is_pacman_in_range()
  - *enter test info here*
* attack()
  - *enter test info here*

## Map Class Functions

* move(String name, Location loc, Type type)
  - *enter test info here*
* getLoc(Location loc) -> This function returns the object type at a given location.
  - The test creates a new frame and tests each type individually based on a given location.
* attack(String name)
  - *enter test info here*
* eatCookie(String Name)
  - *enter test info here*


>>>>Feel free to be creative and add any other elements. For example, you could

>>>>add a video of your code playing PacMan instead of an image
>>>>add small code blocks that supplement your descriptions
>>>>add a table of contents for your readme
>>>>These aren't required, but could be interesting to explore.
