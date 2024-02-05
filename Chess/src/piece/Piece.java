package piece;

import com.Board.Plateau;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Piece {
    public int col,row;
    public int xPos,yPos;

    public boolean est_Blanc;
    public String nom;
    public boolean isfirstmove=true;
    Image sprite;
    Plateau board;
    public Piece(Plateau board){
        this.board=board;
    }
    public void paint(Graphics2D g2d){
        g2d.drawImage(sprite,xPos,yPos,null);
    }
    public boolean peut_bouger(int col, int row){
        return true;
    }
    public boolean collisin_de_movement(int col, int row){
        return false;
    }
    public void loadImage(String imagePath, int width, int height) {
        try {
            Image originalImage = ImageIO.read(new FileInputStream(imagePath));
            this.sprite = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
