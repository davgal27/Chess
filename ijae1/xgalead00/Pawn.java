public class Pawn extends Piece {
    public Pawn(int row, int col, Player player){
        super(row, col, player, PieceName.PAWN);
    }

    @Override
    
    public boolean CanMoveTo(int nextrow, int nextcol, Piece[][] ChessBoard) {
        System.out.print("For now, the Pawn is out of order, please try a bishop!");
        return false;
    }
}
