package ijae1.xgalead00;
import javax.swing.JOptionPane;

public class Pawn extends Piece {
    public Pawn(int row, int col, Player player){
        super(row, col, player, PieceName.PAWN);
    }

    @Override
    //Rules of the Pawn: 
    //1) Cannot move backwards or sideways / Can only move forward 
    //2) Can only move forward one square, unless it is the first move, it can move 2 in that case
    //3) Can Capture only if an enemy piece is diagonal to them 
    public boolean CanMoveTo(int nextrow, int nextcol, Piece[][] ChessBoard) {

        // Defining what is a forward direction for both black and white pieces 
        int direction = (player == Player.WHITE) ? -1 : 1; // White moves up, black moves down 


        // RULE 3: CAN ONLY CAPTURE PIECE DIAGONAL TO IT ----------------------------
        if (((Math.abs(row - nextrow) == Math.abs(col - nextcol)) && // Checks for diagonal movement
            (nextrow - row == direction) && //Checks that only one square is moved 
            (ChessBoard[nextrow][nextcol] != null)) && // Checks that the space isnt empty
            (Math.abs(row - nextrow) == 1)) { // Checks for 1 square of movement
            return true;

        }
        
        //RULE 1: ONLY FORWARD MOVES ----------------------------------------------

        // no sideways movement
        if (nextrow - row == 0){
            JOptionPane.showMessageDialog(null, "Illegal move for pawn!, Pawn can not move sideways!");
            return false;        
        }
        
        // no backward movement
        if ((nextrow - row) / direction <= 0){
            JOptionPane.showMessageDialog(null, "Illegal move for pawn!, Pawn can not move backwards!");
            return false;
        }


        // RULE 2: ONLY FORWARD ONE SQUARE UNLESS FIRST MOVE -------------------------------

        // Defining start row 
        int startrow = (player == Player.WHITE)? 6 : 1;

        // If it is the start row, and moves 2, it is allowed 
        if (row == startrow) {
            // On starting row: one square move 
            if (nextcol - col  == 0 && nextrow - row == direction &&
                (ChessBoard[nextrow][nextcol] == null)) {
                return true; 
            }

            // On starting row: two square move
            if (nextcol - col == 0 && nextrow - row == 2 * direction){
                // Calculate steps
                int rowstep = Integer.compare(nextrow, row);
                int colstep = Integer.compare(nextcol, col);

                int currentrow = rowstep + row;
                int currentcol = colstep + col;

                // Check for obstructions
                while (currentrow != nextrow || currentcol != nextcol){
                    if (ChessBoard[currentrow][currentcol] != null) {
                        JOptionPane.showMessageDialog(null, "Obstruction! Illegal move for Pawn!");
                        return false;
                    }
                    currentrow += rowstep;
                    currentcol += colstep;
                }
                return true;
            }

        } else {
            // Not on starting row: allow only 1 square forward
            if (nextcol - col == 0 && nextrow - row == direction){
                if (ChessBoard[nextrow][nextcol] == null){
                return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Illegal capture! Pawn can only capture pieces diagonally!");
                    return false;
                }    
            } else {
                JOptionPane.showMessageDialog(null, "Illegal forward move for pawn! Can only move 1 square forward if not on starting row.");
                return false;
            }
        }

        // if none of the rules are followed, return false
        JOptionPane.showMessageDialog(null, "Illegal move for pawn!");
        return false; 

    }
}
