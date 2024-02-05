package piece;

import com.Board.Plateau;

public class Sauterelle extends Piece {
    public Sauterelle(Plateau board, int col, int row, boolean est_White) {
        super(board);
        this.col = col;
        this.row = row;
        this.est_Blanc = est_White;
        this.xPos = col * board.taillede_carre;
        this.yPos = row * board.taillede_carre;

        this.nom = "Sauterelle";
        if (est_White) {
            this.loadImage("src/img/Dame_White.png", board.taillede_carre, board.taillede_carre);
        } else {
            this.loadImage("src/img/Dame_Black.png", board.taillede_carre, board.taillede_carre);
        }
        this.nom = "Sauterelle";
    }

    public boolean peut_bouger(int col, int row) {
        if (this.col == col || this.row == row || Math.abs(this.col - col) == Math.abs(this.row - row)) {
            int colDirection = col > this.col ? 1 : (col < this.col ? -1 : 0);
            int rowDirection = row > this.row ? 1 : (row < this.row ? -1 : 0);
            boolean Jump = false;
            for (int c = 1; c < Math.abs(this.col - col) || c < Math.abs(this.row - row); c++) {
                Piece piece = board.getPiece(this.col + c * colDirection, this.row + c * rowDirection);
                if (piece != null) {
                    if (Jump || this.col + c * colDirection == col && this.row + c * rowDirection == row) {
                        
                        return false;
                    }
                    Jump = true;
                }
            }
            return Jump; 
        }
        return false;
    }
}
