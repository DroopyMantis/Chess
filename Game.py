

class Game:
    def __init__(self):
        self.end = False
        self.whiteTurn = True
        self.board = [
           # A   B   C   D   E   F   G   H
            "R","B","K","Q","X","K","B","R", # 8
            "P","P","P","P","P","P","P","P", # 7
            ".",".",".",".",".",".",".",".", # 6
            ".",".",".",".",".",".",".",".", # 5
            ".",".",".",".",".",".",".",".", # 4
            ".",".",".",".",".",".",".",".", # 3
            "p","p","p","p","p","p","p","p", # 2
            "r","b","k","q","x","k","b","r"] # 1


    def __str__(self):
        """
        Prints the board as a string
        """
        for i in range(8):
            row = []
            for j in range(8):
                row.append(self.board[i * 8 + j])

            print(row)

        return ""

    def move(self):
        """
        User must enter piece and tile using board notation
        """
        piece = input("Enter the square of the piece you want to move: ")
        if len(piece) != 2:
            print("Please enter a valid square")
            Game.move(self)
        if not ((96 < ord(piece[0]) < 105 or 64 < ord(piece[0]) < 73) and 48 < ord(piece[1]) < 57):
            print("Please enter a valid square")
            Game.move(self)
        tile = input("Enter the square of where the piece is to move: ")
        if len(tile) != 2:
            print("Please enter a valid square")
            Game.move(self)
        if not ((96 < ord(tile[0]) < 105 or 64 < ord(tile[0]) < 73) and 48 < ord(tile[1]) < 57):
            print("Please enter a valid square")
            Game.move(self)
        # check turn, check checks, check legality of piece, check captures
        p1 = self.getIndex(piece)
        p2 = self.getIndex(tile)

        self.board[p2] = self.board[p1]
        self.board[p1] = "."

        Game.__str__(self)


    def getIndex(self, square):
        """
        Given a square in notation format, will return that square's index on the board
        """
        c1 = ord(square[0])
        r1 = ord(square[1])

        if c1 == 65 or c1 == 97:
            c2 = 1
        elif c1 == 66 or c1 == 98:
            c2 = 2
        elif c1 == 67 or c1 == 99:
            c2 = 3
        elif c1 == 68 or c1 == 100:
            c2 = 4
        elif c1 == 69 or c1 == 101:
            c2 = 5
        elif c1 == 70 or c1 == 102:
            c2 = 6
        elif c1 == 71 or c1 == 103:
            c2 = 7
        else:
            c2 = 8

        if r1 == 49:
            r2 = 8
        elif r1 == 50:
            r2 = 7
        elif r1 == 51:
            r2 = 6
        elif r1 == 52:
            r2 = 5
        elif r1 == 53:
            r2 = 4
        elif r1 == 54:
            r2 = 3
        elif r1 == 55:
            r2 = 2
        else:
            r2 = 1

        index = (r2 - 1) * 8 + (c2 - 1)
        return index


    def checkWin(self):
        pass
        # if win end = true
        # return winner

    def gameLoop(self):
        pass

    def check(self):
        pass
