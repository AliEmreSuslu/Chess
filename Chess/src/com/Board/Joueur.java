package com.Board;
import Jeu.Bouger;
import piece.Piece;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Cette classe représente un joueur dans le jeu d'échecs
public class Joueur extends MouseAdapter {
    Plateau board;
    public boolean jeufinis=false;

    // Constructeur pour la classe Joueur
    public Joueur(Plateau board){
        this.board=board;
    }

    // Gère l'événement de pression de souris
    @Override
    public void mousePressed(MouseEvent e) {
        if (board.gameOver){
            jeufinis=true;
        };
        int col = e.getX() /board.taillede_carre;
        int row=e.getY()/ board.taillede_carre;

        // Sélectionne la pièce si le joueur est autorisé à le faire
        Piece pieceXY=board.getPiece(col,row);
        if (pieceXY!=null && pieceXY.est_Blanc == board.est_WhiteTurn){
            board.Piece_choisi=pieceXY;
        }
    }

    // Gère l'événement de relâchement de la souris
    @Override
    public void mouseReleased(MouseEvent e) {
        if (board.gameOver) return;
        int col=e.getX()/board.taillede_carre;
        int row=e.getY()/board.taillede_carre;

        // Déplace la pièce si le mouvement est valide
        if (board.Piece_choisi!=null){
            Bouger move = new Bouger(board, board.Piece_choisi, col, row);
            if (board.controlleur.Movement_valide(move)) {
                board.controlleur.faireBouger(move);
                // Vérifie si le roi est en échec
                if (board.check_Echecs.Roi_Check(move)) {
                    board.gameOver = true;
                }
            } else {
                // Réinitialise la position de la pièce si le mouvement n'est pas valide
                board.Piece_choisi.xPos = board.Piece_choisi.col * board.taillede_carre;
                board.Piece_choisi.yPos = board.Piece_choisi.row * board.taillede_carre;
            }
        }
        // Réinitialise la pièce choisie et repeint le plateau
        board.Piece_choisi=null;
        board.repaint();

    }

    // Gère l'événement de glisser-déposer de la souris
    @Override
    public void mouseDragged(MouseEvent e) {
        // Déplace la pièce sélectionnée avec le mouvement de la souris
        if (board.Piece_choisi!=null){
            board.Piece_choisi.xPos=e.getX()-board.taillede_carre/2;
            board.Piece_choisi.yPos=e.getY()-board.taillede_carre/2;
            board.repaint();
        }
    }
}

