package Jeu;

import com.Board.Plateau;
import piece.Piece;

public class Bouger {
    public boolean promotion;
    public Piece piece;
    public Piece capture;
    int ancinne_col;
    int ancinne_Row;
    public int nouv_Col;
    public int nouv_Row;


    public Bouger(Plateau board, Piece piece, int nouv_Col, int nouv_Row){
        this.capture=board.getPiece(nouv_Col,nouv_Row);
        this.promotion = estPromotion();
        this.ancinne_col=piece.col;
        this.ancinne_Row= piece.col;
        this.nouv_Col=nouv_Col;
        this.nouv_Row=nouv_Row;
        this.piece=piece;

    }
    // Méthode pour vérifier si un pion atteint la fin du plateau
    private boolean estPromotion() {
        if(this.piece.nom.equals("Pion")) {
            if(this.piece.est_Blanc && this.nouv_Row == 0) {
                return true;
            }
            if(!this.piece.est_Blanc && this.nouv_Row == 7) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bouger{" +
                "piece=" + piece +
                ", capture=" + capture +
                ", ancinne_col=" + ancinne_col +
                ", ancinne_Row=" + ancinne_Row +
                ", nouv_Col=" + nouv_Col +
                ", nouv_Row=" + nouv_Row +
                ", promotion=" + promotion +
                '}';
    }
}
