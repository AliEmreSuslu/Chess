package piece;

import com.Board.Plateau;

public class Princess extends Piece{

    public Princess(Plateau board, int col, int row, boolean est_White) {
        super(board);
        this.col=col;
        this.row=row;
        this.est_Blanc =est_White;
        this.xPos=col* board.taillede_carre;
        this.yPos=row* board.taillede_carre;


        if (est_White) {
            this.loadImage("src/img/Cavalier_White.png", board.taillede_carre, board.taillede_carre);
        } else {
            this.loadImage("src/img/Cavalier_Black.png", board.taillede_carre, board.taillede_carre);
        }
        this.nom ="Princess";
    }


    @Override
    public boolean peut_bouger(int col, int row){

        if(Math.abs(col-this.col)*Math.abs(row-this.row)==2)
            return true;

        if(Math.abs(this.col-col)==Math.abs(this.row-row))
            return true;
        return false;
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
