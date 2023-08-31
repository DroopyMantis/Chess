import java.util.Scanner;

public class Chess {
    private static String [][] arr = new String [8][8];
    private static String white = "-";
    private static String black = "_";

    public static void chessBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                int x = i + j;
                if(x % 2 == 0){
                    arr[i][j] = white;
                }
                else{
                    arr[i][j] = black;
                }
            }
        }
    }

    public static void printBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void fillBoard() {
        for (int i = 0; i < 8; i++) {
            arr[6][i] = "p"; //pawns
            arr[1][i] = "P";
        }
        arr[0][0] = "R"; arr[0][7] = "R"; arr[7][0] = "r"; arr[7][7] = "r"; //rooks
        arr[0][1] = "B"; arr[0][6] = "B"; arr[7][1] = "b"; arr[7][6] = "b"; //bishops
        arr[0][2] = "N"; arr[0][5] = "N"; arr[7][2] = "n"; arr[7][5] = "n"; //knights
        arr[0][3] = "K"; arr[0][4] = "Q"; arr[7][3] = "q"; arr[7][4] = "k"; //kings/queens
    }

    public static void move(int row, int col, int toRow, int toCol){
        col = col - 1; toCol = toCol - 1;
        row = row - 1; toRow = toRow - 1;
        row = 7 - row; toRow = 7- toRow;
        String piece = arr[row][col];
        arr[toRow][toCol] = piece;
        int x = row + col;
        if(x % 2 == 0){
            arr[row][col] = white;
        }
        else{
            arr[row][col] = black;
        }
        printBoard();
    }



    public static String play(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("White to move, enter row of piece");
        int row = myObj.nextInt();
        System.out.println("Row : " + row);
        System.out.println("Enter column of piece");
        int col = myObj.nextInt();
        System.out.println("Column : " + col);
        System.out.println("Enter row to move to");
        int toRow = myObj.nextInt();;
        System.out.println("Move to row : " + toRow);
        System.out.println("Enter column to move to");
        int toCol = myObj.nextInt();
        move(row, col, toRow, toCol);
        if(checkWin("white") == true){
            return "White win";
        } else{
            System.out.println("Black to move, enter row of piece");
            int row2 = myObj.nextInt();
            System.out.println("Row : " + row);
            System.out.println("Enter column of piece");
            int col2 = myObj.nextInt();
            System.out.println("Column : " + col);
            System.out.println("Enter row to move to");
            int toRow2 = myObj.nextInt();;
            System.out.println("Move to row : " + toRow);
            System.out.println("Enter column to move to");
            int toCol2 = myObj.nextInt();
            move(row2, col2, toRow2, toCol2);
        } if(checkWin("black") == true){
            return "Black win";
        }else{
            play();
        }
        return "Game Over";
    }

    public static boolean checkWin(String color){
        if(color == "white"){
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(arr[i][j] == "k"){
                        return false;
                    }
                }
            }
        } else if (color == "black") {
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(arr[i][j] == "k"){
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        chessBoard();
        fillBoard();
        printBoard();
        play();
    }
}
