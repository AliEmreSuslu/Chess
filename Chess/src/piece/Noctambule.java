package piece;

import com.Board.Plateau;

public class Noctambule extends Piece {

    public Noctambule(Plateau board, int col, int row, boolean est_White) {
        super(board);
        this.col = col;
        this.row = row;
        this.est_Blanc = est_White;
        this.xPos = col * board.taillede_carre;
        this.yPos = row * board.taillede_carre;


        if (est_White) {
            this.loadImage("src/img/Cavalier_White.png", board.taillede_carre, board.taillede_carre);
        } else {
            this.loadImage("src/img/Cavalier_Black.png", board.taillede_carre, board.taillede_carre);
        }
        this.nom = "Noctambule";
    }

    public boolean peut_bouger(int col, int row) {
        if (Math.abs(col - this.col) * Math.abs(row - this.row) == 2) {

            int colDirection = (col - this.col) / 2;
            int rowDirection = (row - this.row) / 2;
            for (int i = 1; i < Math.abs(col - this.col); i++) {
                if (board.getPiece(this.col + i * colDirection, this.row + i * rowDirection) != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
