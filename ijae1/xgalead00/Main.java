package ijae1.xgalead00;

public class Main {
    public static void main(String[] args) {
        ChessBoard.BlankSlate();

        System.out.println("For this assignment, I printed a row of white Bishops instead of pawns; as the pawns are not yet implimented and would obstruct other pieces.");
        System.out.println("In the second assignment, I implemented three additional pieces: King, Queen, and Rook");
        System.out.println("Additionally, Checkmate has been implimented for when the king is captured.");
        System.out.println("To test the checkmate, the following sequence should work:\n d2e3\n d1d7\n d7e8");

        while (!ChessBoard.checkmate) { // Infinite Loop to keep game playing unless checkmate
            ChessBoard.PrintChessboard();
            ChessBoard.MovePiece();
        }
    }
}