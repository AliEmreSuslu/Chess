package piece;

import com.Board.Plateau;

public class Cavalier extends Piece{

    public Cavalier(Plateau plateau, int col, int row, boolean est_White) {
        super(plateau);
        this.col=col;
        this.row=row;
        this.est_Blanc =est_White;
        this.xPos=col* plateau.taillede_carre;
        this.yPos=row* plateau.taillede_carre;


        if (est_White) {
            this.loadImage("src/img/Cavalier_White.png", plateau.taillede_carre, plateau.taillede_carre);
        } else {
            this.loadImage("src/img/Cavalier_Black.png", plateau.taillede_carre, plateau.taillede_carre);
        }
        this.nom ="Cavalier";
    }
    public boolean peut_bouger(int col, int row){
        return Math.abs(col-this.col)*Math.abs(row-this.row)==2;
    }
}
