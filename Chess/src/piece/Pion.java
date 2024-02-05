package piece;

import com.Board.Plateau;

public class Pion extends Piece {
    public Pion(Plateau board, int col, int row, boolean est_White) {
        super(board);
        this.col=col;
        this.row=row;
        this.est_Blanc =est_White;
        this.xPos=col* board.taillede_carre;
        this.yPos=row* board.taillede_carre;

        this.nom ="Pion";
        if (est_White) {
            this.loadImage("src/img/Pion_White.png", board.taillede_carre, board.taillede_carre);
        } else {
            this.loadImage("src/img/Pion_Black.png", board.taillede_carre, board.taillede_carre);
        }
    }

    @Override
    public boolean peut_bouger(int col, int row) {
        int colorIndex= est_Blanc ? 1:-1;
        if(this.col ==col && row==this.row-colorIndex && board.getPiece(col,row)==null){
            return true;
        }
        if (isfirstmove && this.col==col && row==this.row-colorIndex*2 && board.getPiece(col,row)==null && board.getPiece(col,row*colorIndex)==null){
            return true;
        }
        if (col==this.col-1 && row==this.row-colorIndex && board.getPiece(col,row)!=null){
            return true;
        }
        if (col==this.col+1 && row==this.row-colorIndex && board.getPiece(col,row)!=null){
            return true;
        }
        return false;
    }
}
