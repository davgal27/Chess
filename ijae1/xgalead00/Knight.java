package ijae1.xgalead00;

public class Knight extends Piece {
    public Knight(int row, int col, Player player){
        super(row, col, player, PieceName.KNIGHT);
    }

    @Override
    
    public boolean CanMoveTo(int nextrow, int nextcol, Piece[][] ChessBoard) {
        int row_diff = Math.abs(row - nextrow);
        int col_diff = Math.abs(col - nextcol);

        // Check that the movment is an L shape, so 2+1 or 1+2 
        if (!((row_diff == 2 && col_diff == 1) || (row_diff == 1 && col_diff == 2))){
            System.out.print("Illegal Move for knight!, Knight moves only in an L shape!");
            return false;
        }
        return true;

        // Knight can jump, so there is not need to check for obstructions
    }    
}
