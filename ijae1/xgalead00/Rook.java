package ijae1.xgalead00;

public class Rook extends Piece {
    public Rook(int row, int col, Player player){
        super(row, col, player, PieceName.ROOK);
    }

    @Override

    public boolean CanMoveTo(int nextrow, int nextcol, Piece[][] ChessBoard) {
        System.out.print("For now, the Rook is out of order, please try a bishop!");
        return false;
    }    
}
