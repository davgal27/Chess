public class Main {
    public static void main(String[] args) {
        ChessBoard.BlankSlate();

        System.out.println("For this assignment, I printed a row of white Bishops instead of pawns so to be able to demonstrate that they can actually move.");
        System.out.println("To show obstruction prevention logic, an example like c2d3, then f1c4 should work.");
        System.out.println("For the logic of my approach to work, the files of the other pieces had to exist; so for now they are placeholders and do not work");

        while (!ChessBoard.checkmate) { // Infinite Loop to keep game playing unless checkmate
            ChessBoard.PrintChessboard();
            ChessBoard.MovePiece();
        }
    }
}