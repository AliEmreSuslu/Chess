package piece;

import com.Board.Plateau;

public class Imperatrice extends Piece{

    public Imperatrice(Plateau board, int col, int row, boolean est_White) {
        super(board);
        this.col=col;
        this.row=row;
        this.est_Blanc =est_White;
        this.xPos=col* board.taillede_carre;
        this.yPos=row* board.taillede_carre;


        if (est_White) {
            this.loadImage("src/img/Tour_White.png", board.taillede_carre, board.taillede_carre);
        } else {
            this.loadImage("src/img/Tour_Black.png", board.taillede_carre, board.taillede_carre);
        }
        this.nom ="Imperatrice";
    }


    @Override
    public boolean peut_bouger(int col, int row){

        if(Math.abs(col-this.col)*Math.abs(row-this.row)==2)
            return true;

        if(this.col==col||this.row==row)
            return true;
        return false;
    }


    @Override
    public boolean collisin_de_movement(int col, int row) {

        if (this.col>col){
            for (int c=this.col-1;c>col;c--){
                if (board.getPiece(c,this.row)!=null){
                    return true;
                }

            }
        }
        if (this.col<col){
            for (int c=this.col+1;c<col;c++){
                if (board.getPiece(c,this.row)!=null){
                    return true;
                }

            }
        }
        if (this.row>row){
            for (int c=this.row-1;c>row;c--){
                if (board.getPiece(this.col,c)!=null){
                    return true;
                }

            }
        }
        if (this.row<row){
            for (int c=this.row+1;c<row;c++){
                if (board.getPiece(this.col,c)!=null){
                    return true;
                }

            }
        }
        return false;
    }
}
