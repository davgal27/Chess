package ijae1.xgalead00;
import javax.swing.JOptionPane;

enum Player { //two players 
    BLACK,
    WHITE
}

enum PieceName {
    PAWN,
    ROOK,
    KNIGHT,
    BISHOP,
    QUEEN,
    KING
}

// Abstract class which allows extension of each specific piece type to extend it and implment its respective movement rules
public abstract class Piece {
    int col;
    int row; 
    Player player;
    PieceName piecename;

    public Piece(int row, int col, Player player, PieceName piecename)
    {
        this.col = col;
        this.row = row;
        this.player = player;
        this.piecename = piecename;
    }

    // GETTERS 
    public int getcol() {
        return col;
    }

    public int getrow() {
        return row;
    }

    public Player getplayer() {
        return player;
    }

    public PieceName getpiecename() {
        return piecename;
    }
    // Method for abbreviating the piece names 
    public String pieceabbreviation() {
        String color = (player == Player.WHITE)? "W" : "B";
        String pieceletter = switch(piecename) {
            case PAWN -> "P";
            case ROOK -> "R";
            case KNIGHT -> "N"; // Can't think of a better name which wont conflict with king, for now this is a temp solution 
            case BISHOP -> "B";
            case QUEEN -> "Q";
            case KING -> "K";
        };
        return color + pieceletter;
    }

    @Override public String toString()
    {
        return pieceabbreviation();
    }
    // Method which handles the movement of logic of the individual pieces, which extend the piece class.
    public abstract boolean CanMoveTo(int nextrow, int nextcol, Piece[][] Chessboard);


}
