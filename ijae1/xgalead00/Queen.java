package ijae1.xgalead00;

public class Queen extends Piece {
    public Queen(int row, int col, Player player){
        super(row, col, player, PieceName.QUEEN);
    }

    @Override
    
    public boolean CanMoveTo(int nextrow, int nextcol, Piece[][] ChessBoard) {
        System.out.print("For now, the Queen is out of order, please try a bishop!");
        return false;
        
    }
}
