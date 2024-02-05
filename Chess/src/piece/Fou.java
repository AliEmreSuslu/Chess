package piece;

import com.Board.Plateau;

public class Fou extends Piece{
    public Fou(Plateau board, int col, int row, boolean est_White) {
        super(board);
        this.col=col;
        this.row=row;
        this.est_Blanc =est_White;
        this.xPos=col* board.taillede_carre;
        this.yPos=row* board.taillede_carre;


        if (est_White) {
            this.loadImage("src/img/Fou_White.png", board.taillede_carre, board.taillede_carre);
        } else {
            this.loadImage("src/img/Fou_Black.png", board.taillede_carre, board.taillede_carre);
        }
        this.nom ="Fou";
    }

    @Override
    public boolean peut_bouger(int col, int row) {
        return Math.abs(this.col-col)==Math.abs(this.row-row);
    }

    @Override
    public boolean collisin_de_movement(int col, int row) {
        if (this.col > col && this.row > row) {
            for (int c = 1; c < Math.abs(this.col - col); c++) {
                if (board.getPiece(this.col - c, this.row - c) != null) {
                    return true;
                }
            }
        }
        if (this.col < col && this.row > row) {
            for (int c = 1; c < Math.abs(this.col - col); c++) {
                if (board.getPiece(this.col + c, this.row - c) != null) {
                    return true;
                }
            }
        }
        if (this.col > col && this.row < row) {
            for (int c = 1; c < Math.abs(this.col - col); c++) {
                if (board.getPiece(this.col - c, this.row + c) != null) {
                    return true;
                }
            }
        }
        if (this.col < col && this.row < row) {
            for (int c = 1; c < Math.abs(this.col - col); c++) {
                if (board.getPiece(this.col + c, this.row + c) != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
