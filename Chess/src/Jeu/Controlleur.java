package Jeu;

import com.Board.Plateau;
import piece.Piece;

public class Controlleur {
    Plateau board;

    public Controlleur(Plateau board) {
        this.board = board;
    }

    public boolean Movement_valide(Bouger movement) {
        return !memeEquipe(movement.piece, movement.capture)
                && movement.piece.peut_bouger(movement.nouv_Col, movement.nouv_Row)
                && !movement.piece.collisin_de_movement(movement.nouv_Col, movement.nouv_Row)
                && !board.check_Echecs.Roi_Check(movement);
    }
    public void capture(Bouger movement){
        board.pieceList.remove(movement.capture);
    }
    public boolean memeEquipe(Piece p1, Piece p2){
        if(p1==null||p2==null){
            return false;
        }
        return p1.est_Blanc ==p2.est_Blanc;
    }
    public void faireBouger(Bouger movement){
        capture(movement);
        movement.piece.col = movement.nouv_Col;
        movement.piece.row = movement.nouv_Row;
        movement.piece.xPos = movement.nouv_Col * board.taillede_carre;
        movement.piece.yPos = movement.nouv_Row * board.taillede_carre;
        movement.piece.isfirstmove = false;
        board.est_WhiteTurn = !board.est_WhiteTurn;

    }
}

