import java.util.Scanner;

public class ChessBoard {      
    //Declaring new array of size rows x columns
    static Piece[][] ChessBoard = new Piece[8][8]; 
    static Scanner scn = new Scanner(System.in);

    static void PrintChessboard() {  
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
    }
    static void BlankSlate() {
        ChessBoard[7][0] = new Piece(7, 0, Player.WHITE, PieceName.ROOK);
        ChessBoard[7][1] = new Piece(7, 1, Player.WHITE, PieceName.KNIGHT);
        ChessBoard[7][2] = new Piece(7, 2, Player.WHITE, PieceName.BISHOP);

    }
    public static void main(String[] args) {
        BlankSlate();
        PrintChessboard();
        MovePiece();
    }
    static void MovePiece() {

        //Retrieve Player info

        // White or black
        System.out.print("Enter Player: ");
        Player player = Player.valueOf(scn.next().toUpperCase());
         
        // Type of Piece
        System.out.print("Enter Piece: ");
        PieceName piecename = PieceName.valueOf(scn.next().toUpperCase());
    
        // Column Location
        System.out.print("Enter Column: ");
        char colchar = scn.next().toUpperCase().charAt(0);
        int col = colchar - 'A';

        // Row Location
        System.out.print("Enter Row: ");
        int row = 8 - scn.nextInt();

        // Making sure input is valid
        // Check if there is a piece
        Piece piece = ChessBoard[row][col];
        if (piece ==null) {
            System.out.println("No piece at that location!");
            return;
        }
        
        // check if piece belongs to a player
        if (piece.getplayer() !=player){ 
            System.out.println("That piece does not belong to  " + player + "!");
            return;
        }

        // Check if piece type is correct
        if (piece.getpiecename() !=piecename){
            System.out.println("That is not the correct piece type!");
            return;
        }
        // Destinations
        System.out.print("Enter destination Column: ");
        char newcolchar = scn.next().toUpperCase().charAt(0);
        int newcolnum = newcolchar - 'A';

        System.out.print("Enter destination row: ");
        int newrow = 8 - scn.nextInt();

        ChessBoard[newrow][newcolnum] = piece;
        ChessBoard[row][col] = null;

        piece.row = newrow;
        piece.col = newcolnum;
        PrintChessboard();
        }
    }




