
public class Knight extends Piece {
    public Knight(int row, int col, Player player){
        super(row, col, player, PieceName.KNIGHT);
    }

    @Override
    
    public boolean CanMoveTo(int nextrow, int nextcol, Piece[][] ChessBoard) {
        System.out.print("For now, the knight is out of order, please try a bishop!");
        return false;
    }    
}
