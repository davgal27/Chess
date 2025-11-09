package ijae1.xgalead00;

public class Bishop extends Piece {
    public Bishop(int row, int col, Player player){
        super(row, col, player, PieceName.BISHOP);
    }

    @Override

    public boolean CanMoveTo(int nextrow, int nextcol, Piece[][] ChessBoard) {
        // Check for diagonal movement
        if(Math.abs(row - nextrow) != Math.abs(col - nextcol)){
            System.out.print("Invalid move!, Bishop can only move Diagonally");
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
                System.out.print("Obstruction! Illegal move for Bishop!");
                return false;
            }
            currentrow += rowstep;
            currentcol += colstep;
        }
        return true;
    }
}
