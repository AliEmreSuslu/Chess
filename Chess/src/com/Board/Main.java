package com.Board;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {


        JFrame frame=new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(900,720));
        frame.setLocationRelativeTo(null);

        Plateau board=new Plateau();
        board.setCol();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> {

            board.resetBoard();
            frame.revalidate();
            frame.repaint();
        });
        JButton colorButton = new JButton("Changer Couleur");
        colorButton.addActionListener(e -> {

            board.setCol();
            board.resetBoard();
            frame.revalidate();
            frame.repaint();
        });
        JButton piecesDif = new JButton("Changer Les Pieces");
        piecesDif.addActionListener(e -> {
            board.setChangement_piece();
            board.resetBoard();
            frame.revalidate();
            frame.repaint();
        });
        buttonPanel.add(restartButton);
        buttonPanel.add(colorButton);
        buttonPanel.add(piecesDif);
        frame.add(buttonPanel, BorderLayout.EAST);
        frame.add(board, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}