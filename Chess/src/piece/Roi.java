package piece;

import com.Board.Plateau;

public class Roi extends Piece{
    public Roi(Plateau board, int col, int row, boolean est_White) {
        super(board);
        this.col=col;
        this.row=row;
        this.est_Blanc =est_White;
        this.xPos=col* board.taillede_carre;
        this.yPos=row* board.taillede_carre;


        if (est_White) {
            this.loadImage("src/img/Roi_White.png", board.taillede_carre, board.taillede_carre);
        } else {
            this.loadImage("src/img/Roi_Black.png", board.taillede_carre, board.taillede_carre);
        }
        this.nom ="Roi";
    }

    @Override
    public boolean peut_bouger(int col, int row) {
        return Math.abs((col-this.col)*(row-this.row))==1||Math.abs(col-this.col)+Math.abs(row-this.row)==1;
    }
}
