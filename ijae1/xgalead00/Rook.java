package ijae1.xgalead00;
import javax.swing.JOptionPane;

public class Rook extends Piece {
    public Rook(int row, int col, Player player){
        super(row, col, player, PieceName.ROOK);
    }

    @Override

    public boolean CanMoveTo(int nextrow, int nextcol, Piece[][] ChessBoard) {
        // Check for no diagonal movement
        if(!((Math.abs(row - nextrow)) == 0 && (Math.abs(col - nextcol)) !=0
            || (Math.abs(row - nextrow)) !=0 && (Math.abs(col - nextcol)) ==0)){
            JOptionPane.showMessageDialog(null, "Invalid move! Rook cannot move diagonally! ");
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
                JOptionPane.showMessageDialog(null, "Obstruction! Illegal move for Rook!");
                return false;
            }
            currentrow += rowstep;
            currentcol += colstep;
        }
        return true;
    }
}    

