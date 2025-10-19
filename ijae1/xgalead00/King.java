package ijae1.xgalead00;

public class King extends Piece{
    public King(int row, int col, Player player){
        super(row, col, player, PieceName.KING);
    }

    @Override
    
    public boolean CanMoveTo(int nextrow, int nextcol, Piece[][] ChessBoard) {
        System.out.print("For now, the King is out of order, please try a bishop!");
        return false;
    }
}
