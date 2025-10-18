enum Player {
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


public class Piece {
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

    public String pieceabbreviation() {
        String color = (player == Player.WHITE)? "W" : "B";
        String pieceletter = switch(piecename) {
            case PAWN -> "P";
            case ROOK -> "R";
            case KNIGHT -> "N";
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

}
