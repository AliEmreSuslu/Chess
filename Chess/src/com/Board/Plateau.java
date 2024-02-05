package com.Board;

import Jeu.Bouger;
import Jeu.Control_Echecs;
import Jeu.Controlleur;
import piece.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Plateau extends JPanel {
    public boolean changement_piece=false; // Indique si une pièce a été déplacée
    public Controlleur controlleur; // Contrôleur de jeu
    public int colcnt=0; // Compteur de colonnes
    Color col1; // Première couleur pour les cases de l'échiquier
    Color col2; // Deuxième couleur pour les cases de l'échiquier
    public Control_Echecs check_Echecs; // Contrôleur pour vérifier les échecs
    Joueur input=new Joueur(this); // Entrée du joueur
    public Piece Piece_choisi; // Pièce sélectionnée
    int cols=8; // Nombre de colonnes
    int rows=8; // Nombre de rangées
    public int taillede_carre=85; // Taille d'une case
    public boolean est_WhiteTurn = true; // Indique si c'est au tour des blancs
    public boolean gameOver = false; // Indique si le jeu est terminé

    public ArrayList<Piece> pieceList=new ArrayList<>();
    public Plateau(){
        this.setPreferredSize(new Dimension(cols*taillede_carre,rows *taillede_carre));
        this.addMouseListener(input);
        this.addMouseMotionListener(input);
        this.check_Echecs = new Control_Echecs(this);
        this.controlleur = new Controlleur(this);
        ajout_Piece();
    }

    public Piece getPiece(int col,int row){
        for (Piece piece : pieceList){
            if (piece.col==col && piece.row==row){
                return piece;
            }
        }
        return null;
    }
    public Piece trouveRoi(boolean est_White){
        for (Piece piece : pieceList){
            if(est_White== piece.est_Blanc &&piece.nom.equals("Roi")){
                return piece;
            }
        }
        return null;
    }

    public void ajout_Piece(){
        if (changement_piece==false){
            pieceList.add(new Cavalier(this,1,0,false));
            pieceList.add(new Cavalier(this,6,0,false));
            pieceList.add(new Fou(this,2,0,false));
            pieceList.add(new Fou(this,5,0,false));
            pieceList.add(new Tour(this,0,0,false));
            pieceList.add(new Tour(this,7,0,false));
            pieceList.add(new Dame(this,3,0,false));
        }
        else {
            pieceList.add(new Noctambule(this,1,0,false));
            pieceList.add(new Noctambule(this,6,0,false));
            pieceList.add(new Princess(this,2,0,false));
            pieceList.add(new Princess(this,5,0,false));
            pieceList.add(new Imperatrice(this,0,0,false));
            pieceList.add(new Imperatrice(this,7,0,false));
            pieceList.add(new Sauterelle(this,3,0,false));

        }
        pieceList.add(new Roi(this,4,0,false));
        pieceList.add(new Pion(this,0,1,false));
        pieceList.add(new Pion(this,1,1,false));
        pieceList.add(new Pion(this,2,1,false));
        pieceList.add(new Pion(this,3,1,false));
        pieceList.add(new Pion(this,4,1,false));
        pieceList.add(new Pion(this,5,1,false));
        pieceList.add(new Pion(this,6,1,false));
        pieceList.add(new Pion(this,7,1,false));

        if (changement_piece==false){
            pieceList.add(new Cavalier(this,1,7,true));
            pieceList.add(new Cavalier(this,6,7,true));
            pieceList.add(new Fou(this,2,7,true));
            pieceList.add(new Fou(this,5,7,true));
            pieceList.add(new Tour(this,0,7,true));
            pieceList.add(new Tour(this,7,7,true));
            pieceList.add(new Dame(this,3,7,true));
        }
        else {
            pieceList.add(new Noctambule(this,1,7,true));
            pieceList.add(new Noctambule(this,6,7,true));
            pieceList.add(new Princess(this,2,7,true));
            pieceList.add(new Princess(this,5,7,true));
            pieceList.add(new Imperatrice(this,0,7,true));
            pieceList.add(new Imperatrice(this,7,7,true));
            pieceList.add(new Sauterelle(this,3,7,true));
        }

        pieceList.add(new Roi(this,4,7,true));
        pieceList.add(new Pion(this,0,6,true));
        pieceList.add(new Pion(this,1,6,true));
        pieceList.add(new Pion(this,2,6,true));
        pieceList.add(new Pion(this,3,6,true));
        pieceList.add(new Pion(this,4,6,true));
        pieceList.add(new Pion(this,5,6,true));
        pieceList.add(new Pion(this,6,6,true));
        pieceList.add(new Pion(this,7,6,true));


    }
    public void setCol(){
        if (colcnt==0) {
            this.col1 = new Color(118, 150, 86);
            this.col2 = new Color(238, 238, 210);
            colcnt=1;
        }
        else {
            this.col1 = new Color(203, 118, 41);
            this.col2 = new Color(107, 69, 38);
            colcnt = 0;
        }
    }



    //Les mesthods pour les buttons:
    public void resetBoard() {
        pieceList.clear();
        est_WhiteTurn = true;
        gameOver = false;
        Piece_choisi = null;
        ajout_Piece();
        repaint();
    }
    public void setChangement_piece(){
        if (changement_piece==false){
            changement_piece=true;
        }
        else
            changement_piece=false;
    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ((r + c) % 2 == 0) {
                    g2d.setColor(col1);
                } else {
                    g2d.setColor(col2);
                }
                g2d.fillRect(c * taillede_carre, r * taillede_carre, taillede_carre, taillede_carre);
            }
        }
        if (Piece_choisi != null) {
            for (int j = 0; j < rows; j++) {
                for (int t = 0; t < cols; t++) {
                    Bouger move = new Bouger(this, Piece_choisi, t, j);
                    if (controlleur.Movement_valide(move)) {
                        g2d.setColor(new Color(109, 28, 28));
                        g2d.fillRect(t * taillede_carre, j * taillede_carre, taillede_carre, taillede_carre);
                    }
                }
            }
        }
        for (Piece piece : pieceList) {
            piece.paint(g2d);
        }
    }
}
