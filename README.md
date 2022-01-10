# Team1
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

## PacMan Class Functions   <img src="https://i.imgur.com/pYDel6A.png" width="20" />

* get_valid_moves() -> This method checks the 4 directions/locations around PacMan and if they are inbounds and not of Type.WALL it is a valid move and added to the returned list. 
  - This test places two PacMan on the frame. It then calls the get_valid_moves function and compares its elements to the expected values based on the respective PacMan's locations. 
* move() -> This method uses the get_valid_moves method to find the possible locations that PacMan can move, and will move to a location to where a cookie exists, if possible. Otherwise, the pacman will choose a random valid location.
  - The test places a PacMan object a location (1,1) and calls move(), which should return true. The test then places the PacMan at location (0,0) and calls move(), which should return false since he is sitting on a wall and cannot move.
* is_ghost_in_range() -> This method checks its surroundings to see if any Ghosts are in attack range. The attack radius of a ghost is 1 which means that a ghost at location  can attack PacMan as long as PacMan is located at . If any Ghosts are in the attack range, this method returns true otherwise it returns false.
  - The test ensures that when ghost is in range of pacman the function return true and the other test checks that it will correctly return false when it is out of range.
* consume() -> This method checks to see if there is a cookie at PacMan's current location by calling the getLoc(Location loc) in the Map class on PacMan's current location and checking if a cookie component exists at the location. If there is a cookie, the eatCookie(String name) from the Map class is called which returns the JComponent for the consumed cookie to this function which then returns this JComponent to the caller. Otherwise, this function returns null to caller, indicating there was no cookie to consume.
  - The test places PacMan at location (1,1) and verifies a cookie was successfully consumed when present and no cookie is consumed when the cookie for the location has already been consumed. Since there should be a cookie at location (1,1), the first assertion checks that the returned value is not null as the JComponent of the consumed cookie should have been returned. The second assertion verifies that null is returned when attempting to consume a cookie at the same location as the cookie should have already been consumed by the first assertion for the location (1,1).

## Ghost Class Functions  <img src="https://i.imgur.com/MvyBJiR.jpg" width="100"/>

* get_valid_moves() -> This method checks the 4 directions/locations around a Ghost and if they are inbounds and not of Type.WALL it is a valid move and added to the returned list. 
  - This test places two Ghost on the frame. It then calls the get_valid_moves function and compares its elements to the expected values based on the respective Ghost's locations.
* move() -> This method uses the get_valid_moves method to find the possible locations that the ghost can move, and then chooses a location randomly to move.
  - The test places a ghost object a location (1,1) and calls move(), which should return true. The test then places the ghost at location (0,0) and calls move(), which should return false since he is sitting on a wall and cannot move.
* is_pacman_in_range() -> This method obtains the available moves for the ghost by calling the get_valid_moves() method and then checks each location, including the ghost's current location, to determine if PacMan is in range. If PacMan is found to be in one of the locations checked, the method returns true. Otherwise, if PacMan is not found in any of the checked locations, this method returns false.
  - The test adds PacMan and two ghosts to the map so that ghost1 is one move away from PacMan (in range to attack) and ghost2 is more than one move away from PacMan (not in range to attack). The first assertion verifies that ghost2 is not in range while the second asserts that ghost1 is in range to attack PacMan. 
* attack() -> This function checks to see if PacMan is in the attack range by using the is_pacman_in_range method and attacks PacMan if it is in range. This function returns true if the attack was successful and false otherwise.
  - This test checks if the ghost is in range, then the attack must be successful. And also ensures that the attack fails when packman is out of the reachable bounds of the ghost.

## Map Class Functions <img src="https://i.imgur.com/IN1YUkR.png" width="45"/>

* move(String name, Location loc, Type type) -> The method takes a name, location, and type and put the object specified by the name at the location. If the function is able to successfull move the object it returns true, otherwise it returns false.
  - This test checks if a player (Packman or ghost) can move from one location to another. They cannot move if there is a wall or other obstruction. Tests make sure that move is successful in the correct conditions and also the data members are updated accordingly.
* getLoc(Location loc) -> This function returns the object type at a given location.
  - The test creates a new frame and tests each type individually based on a given location.
* attack(String name) -> This method checks the 4 directions/locations around the named Ghost and checks if any location contains the Type.PACMAN. If a location contains the Type.PACMAN, gameOver is set to true, and true is returned. Otherwise, false is returned.
  - This test creates a frame with a PacMan, a Ghost within range of the PacMan, and a Ghost not in range. The ghost out of range attacks, and returns false. The ghost in range attacks and returns true. 
* eatCookie(String Name) -> This method determines if a cookie with the expected cookie id (formatted as "tok_x#_y#", where the '#' represent the corresponding x and y coordinates of the location) is at the given location. If such a cookie exists, it is removed from the location and field, the accumulator for the number of cookies consumed is incremented, and the corresponding cookie component in field is removed and returned. If there is no cookie to consume at this location, this method returns null.
  - This test adds PacMan to the location (1,1) and asserts a cookie is consumed and the accumulator updated as appropriate. The first assertions verify that the cookie at location (1,1) is successfully consumed by checking it is not null (there should be a returned component for the cookie) and the cookie accumulator incremented from 0 to 1. The second assertion verifies that no cookie is consumed by checking for a null (there should not be a consumed component) as the cookie in this location should have been consumed in the first assertion. The accumulator is also checked to verify it is still equal to 1 as there was no cookie consumed by the second assertion.

