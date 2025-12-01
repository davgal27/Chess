package ijae1.xgalead00;

import java.util.Scanner;

public class ChessBoard {      
    //Declaring new array of size rows x columns
    static Piece[][] ChessBoard = new Piece[8][8]; 
    static Scanner scn = new Scanner(System.in);
    static boolean checkmate = false;

    static void PrintChessboard() {  
        System.out.println(); // new line between previous turn
        int rows = 8;                         
        int columns = 8;
        //Declaring new array of size rows x columns

        //Loop to fill the array
        for(int i = 0; i < rows; i++) {
            System.out.print(rows-i + " ");//y-label (1:8)
            for (int j = 0; j < columns; j++) {
                if (ChessBoard[i][j] != null) {
                    System.out.print(ChessBoard[i][j] + " "); // print the piece
                } else if ((i + j) % 2 == 0) {
                    System.out.print("■  "); // black square
                } else {
                    System.out.print("   "); // white square
                }
            }
            System.out.println();//print new line between rows 
            
        }
        System.out.print("  ");// initial margin for letters

        //Printing the x-label
        for (int j = 0; j < columns; j++){           
            char letter = (char) ('A' + j);
            System.out.print(letter + "  ");
            }
        System.out.println(); // two new lines to give cleaner look
        System.out.println();

    }


    static void BlankSlate() {
        // White Pieces
        ChessBoard[7][0] = new Rook(7, 0, Player.WHITE);
        ChessBoard[7][1] = new Knight(7, 1, Player.WHITE);
        ChessBoard[7][2] = new Bishop(7, 2, Player.WHITE);
        ChessBoard[7][3] = new Queen(7, 3, Player.WHITE);
        ChessBoard[7][4] = new King(7, 4, Player.WHITE);
        ChessBoard[7][5] = new Bishop(7, 5, Player.WHITE);
        ChessBoard[7][6] = new Knight(7, 6, Player.WHITE);
        ChessBoard[7][7] = new Rook(7, 7, Player.WHITE);

        // simple loop to print the pawns
        for (int i = 0; i < 8; i++) {
            ChessBoard[6][i] = new Pawn(6, i, Player.WHITE); 
        }

        // Black Pieces
        ChessBoard[0][0] = new Rook(0, 0, Player.BLACK);
        ChessBoard[0][1] = new Knight(0, 1, Player.BLACK);
        ChessBoard[0][2] = new Bishop(0, 2, Player.BLACK);
        ChessBoard[0][3] = new Queen(0, 3, Player.BLACK);
        ChessBoard[0][4] = new King(0, 4, Player.BLACK);
        ChessBoard[0][5] = new Bishop(0, 5, Player.BLACK);
        ChessBoard[0][6] = new Knight(0, 6, Player.BLACK);
        ChessBoard[0][7] = new Rook(0, 7, Player.BLACK);

        for (int i = 0; i < 8; i++) {
            ChessBoard[1][i] = new Pawn(1, i, Player.BLACK);
        }
    }
   

    static void MovePiece(String move_input, Player player) {

        //Retrieve Player info

        // White or black
        // System.out.print("Enter Player, or type Q to Quit: ");
        // String input = scn.nextLine().toUpperCase();
        // if (input.equals("Q")){
        //     checkmate = true;
        //     return;
        // }
        // Player player;
        // try{
        //     player = Player.valueOf(input);
        // } catch (IllegalArgumentException e) {
        //     JOptionPane.showMessageDialog(null, "Invalid input. must be White or Black!");
        //     return;
        // }


        // Move Input
        // System.out.print("Enter Move (format:c1d3): ");
        // String move = scn.nextLine();

        if (move_input.length() != 4 || move_input.contains(" ")){
            JOptionPane.showMessageDialog(null, "Invalid input format! Make sure there are no spaces or extra characters.");            
            return;
        }

        //Current Position 
        String currpos = move_input.substring(0,2); // first two letters (Current pos)
        int curcol = Character.toUpperCase(currpos.charAt(0)) - 'A'; // eg: B - A = indx 1 so it will put it at [1] / B
        int currow = 8 - Character.getNumericValue(currpos.charAt(1));

        // Making sure input is valid
        // Check if there is a piece
        Piece piece = ChessBoard[currow][curcol];
        if (piece == null) {
            JOptionPane.showMessageDialog(null, "No piece at that location!");
            return;
        }
        
        // check if piece belongs to a player
        if (piece.getplayer() !=player){ 
            JOptionPane.showMessageDialog(null, "That piece does not belong to  " + player + "!");
            return;
        }

        // Next Position
        String nextpos = move_input.substring(2,4); // last two letters (destination)
        int nextcol = Character.toUpperCase(nextpos.charAt(0)) - 'A';
        int nextrow = 8 - Character.getNumericValue(nextpos.charAt(1));

        // Check if piece at the next position is the same is player's own piece
        Piece nextpiece = ChessBoard[nextrow][nextcol];
        // First check if the move is legal
        if (!piece.CanMoveTo(nextrow, nextcol, ChessBoard)) {
            return;
        }
        if (nextpiece != null) {
            if (nextpiece.getplayer() == player){
                JOptionPane.showMessageDialog(null, "Why would you attack your own piece?");
                return;
            } else if (nextpiece.getpiecename() == PieceName.KING){
                JOptionPane.showMessageDialog(null, "Checkmate! " + piece.getplayer() + " has won the game!");
                checkmate = true; 
                return;
            } else {
                JOptionPane.showMessageDialog(null, piece.getplayer() + " " + piece.getpiecename() + " captures " 
                + nextpiece.getplayer() + " " + nextpiece.getpiecename() 
                + " at " + nextpos + "!");
            }
        }

        //Check rules of the piece 
        if (!piece.CanMoveTo(nextrow, nextcol, ChessBoard)){
            return;
        }
 
        ChessBoard[nextrow][nextcol] = piece;
        ChessBoard[currow][curcol] = null;

        piece.row = nextrow;
        piece.col = nextcol;
    }                    
}





