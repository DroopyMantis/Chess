Chess project 

--TODO--
* Game Class - Contains methods to play chess
  * Visualize the board as a list - use a len(64) list to represent board
  * Methods
    * Move - Check if legal, then if in check, if both pass move
    * Check - See if the move results Check or if it doesn't block check
    * Legal - See if move is legal
    * New Game - Start new game with 2 player params, human or agent
    * Win - Return if checkmate
* GUI
  * Show board in a gui
  * Mouse listener to move pieces
  * implement game rules so that no illegal moves may be made
* Play Class
  * Main to play the game, choose players
* Agent
  * --TODO--