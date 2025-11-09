package ijae1.xgalead00;

public class Queen extends Piece {
    public Queen(int row, int col, Player player){
        super(row, col, player, PieceName.QUEEN);
    }

    @Override
    
    public boolean CanMoveTo(int nextrow, int nextcol, Piece[][] ChessBoard) {
        // Check for diagonal, horizontal, or vertical movement
        if (!((Math.abs(row - nextrow) == Math.abs(col - nextcol)) || // ensures diagonal movement
        ((Math.abs(row - nextrow) == 0 && Math.abs(col - nextcol) != 0) || // ensures horizontal
        (Math.abs(row - nextrow) != 0 && Math.abs(col - nextcol) == 0)))) { // ensures vertical 
            System.out.print("Illegal Move for Queen! Queen can only move diagonally, horizontally, or vertically!");
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
                System.out.print("Obstruction! Illegal move for Queen!");
                return false;
            }
            currentrow += rowstep;
            currentcol += colstep;
        }
        return true;
    }
}
