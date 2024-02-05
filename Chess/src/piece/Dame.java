package piece;

import com.Board.Plateau;

public class Dame extends Piece{
    public Dame(Plateau board, int col, int row, boolean est_White) {
        super(board);
        this.col=col;
        this.row=row;
        this.est_Blanc =est_White;
        this.xPos=col* board.taillede_carre;
        this.yPos=row* board.taillede_carre;


        if (est_White) {
            this.loadImage("src/img/Dame_White.png", board.taillede_carre, board.taillede_carre);
        } else {
            this.loadImage("src/img/Dame_Black.png", board.taillede_carre, board.taillede_carre);
        }
        this.nom ="Dame";
    }
    public boolean peut_bouger(int col, int row) {
        return this.col==col||this.row==row||Math.abs(this.col-col)==Math.abs(this.row-row);
    }
    public boolean collisin_de_movement(int col, int row) {
        if (this.col==col||this.row==row){
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
        }else{
            if (this.col>col&&this.row>row){
                for (int c=1;c<Math.abs(this.col-col);c++){
                    if (board.getPiece(this.col-1,this.row-1)!=null){
                        return true;
                    }

                }
            }
            if (this.col<col&&this.row>row){
                for (int c=1;c<Math.abs(this.col-col);c++){
                    if (board.getPiece(this.col+1,this.row-1)!=null){
                        return true;
                    }

                }
            }
            if (this.col>col&&this.row<row){
                for (int c=1;c<Math.abs(this.col-col);c++){
                    if (board.getPiece(this.col-1,this.row+1)!=null){
                        return true;
                    }

                }
            }
            if (this.col<col&&this.row<row){
                for (int c=1;c<Math.abs(this.col-col);c++){
                    if (board.getPiece(this.col+1,this.row+1)!=null){
                        return true;
                    }

                }
            }
        }
        return false;
    }
}
