package ijae1.xgalead00;

public class King extends Piece{
    public King(int row, int col, Player player){
        super(row, col, player, PieceName.KING);
    }

    @Override
    
    public boolean CanMoveTo(int nextrow, int nextcol, Piece[][] ChessBoard) {
        // Check for diagonal, horizontal, or vertical movement and 1 square movement
        if (!((Math.abs(row - nextrow) == Math.abs(col - nextcol)) || // ensures diagonal movement
        ((Math.abs(row - nextrow) == 0 && Math.abs(col - nextcol) != 0) || // ensures horizontal
        (Math.abs(row - nextrow) != 0 && Math.abs(col - nextcol) == 0))) || // ensures vertical 
        (Math.abs(row - nextrow) > 1 || Math.abs(col - nextcol) > 1))  { // ensures one square
            System.out.print("Illegal Move for King! King can only move diagonally, horizontally, or vertically for one square!");
            return false;
        }
        // Calculate steps
        int rowstep = Integer.compare(nextrow, row);
        int colstep = Integer.compare(nextcol, col);

        int currentrow = rowstep + row;
        int currentcol = colstep + col;

        // Check for obstructions
        while (currentrow != nextrow || currentcol != nextcol){
            if (ChessBoard[currentrow][currentcol] != null) {
                System.out.print("Obstruction! Illegal move for King!");
                return false;
            }
            currentrow += rowstep;
            currentcol += colstep;
        }
        return true;
    }
}
