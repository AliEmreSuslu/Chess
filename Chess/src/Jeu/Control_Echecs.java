package Jeu;

import com.Board.Plateau;
import piece.Piece;

public class Control_Echecs{
    Plateau board;
    public Control_Echecs(Plateau board){
        this.board=board;
    }

    private boolean control_Tour(int col,int row,Piece Roi,int RoiCol,int RoiRow,int colVal,int rowVal){
        for (int i=1;i<8;i++){
            int currentCol = RoiCol+(i*colVal);
            int currentRow = RoiRow+(i*rowVal);
            if (currentCol==col && currentRow==row){
                break;
            }
            Piece piece=board.getPiece(currentCol, currentRow);
            if (piece!=null&&piece!=board.Piece_choisi){
                if (!board.controlleur.memeEquipe(piece,Roi) && (piece.nom.equals("Tour") || piece.nom.equals("Dame"))){
                    return true;
                }
                break;
            }
        }
        return false;
    }


    private boolean control_Fou(int col,int row,Piece Roi,int RoiCol,int RoiRow,int colVal,int rowVal){
        for (int i=1;i<8;i++){
            int currentCol = RoiCol-(i*colVal);
            int currentRow = RoiRow-(i*rowVal);
            if (currentCol==col && currentRow==row){
                break;
            }
            Piece piece=board.getPiece(currentCol, currentRow);
            if (piece!=null&&piece!=board.Piece_choisi){
                if (!board.controlleur.memeEquipe(piece,Roi) && (piece.nom.equals("Fou") || piece.nom.equals("Dame"))){
                    return true;
                }
                break;
            }
        }
        return false;
    }
    // Vérifie si le Roi est en danger par un Cavalier
    private boolean control_Cavalier(int col,int row,Piece Roi,int RoiCol,int RoiRow){
        int[][] offsets = {{-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}};
        for(int[] offset : offsets) {
            if(control_Cavalier2(board.getPiece(RoiCol + offset[0], RoiRow + offset[1]), Roi, col, row)) {
                return true;
            }
        }
        return false;
    }

    // Vérifie si le Roi est en danger par un autre Roi
    private boolean control_Roi(Piece Roi,int RoiCol,int RoiRow){
        int[][] offsets = {{-1, -1}, {1, -1}, {0, -1}, {-1, 0}, {1, 0}, {-1, 1}, {1, 1}, {0, 1}};
        for(int[] offset : offsets) {
            if(control_Roi2(board.getPiece(RoiCol + offset[0], RoiRow + offset[1]), Roi)) {
                return true;
            }
        }
        return false;
    }
    private boolean control_Pion(int col,int row,Piece Roi,int kinCol,int RoiRow){
        int colorVal=Roi.est_Blanc ? -1:1;
        return control_Pion2(board.getPiece(kinCol+1,RoiRow+colorVal),Roi,col,row)||
                control_Pion2(board.getPiece(kinCol-1,RoiRow+colorVal),Roi,col,row);
    }
    private boolean control_Cavalier2(Piece p,Piece k,int col,int row){
        return p!=null && !board.controlleur.memeEquipe(p,k) && p.nom.equals("Cavalier") && !(p.col==col && p.row==row);
    }
    private boolean control_Roi2(Piece p,Piece k){
        return p!=null && !board.controlleur.memeEquipe(p,k)&&p.nom.equals("Roi");
    }
    private boolean control_Pion2(Piece p,Piece k,int col,int row){
        return p!=null && !board.controlleur.memeEquipe(p,k) && p.nom.equals("Pion") && !(p.col==col && p.row==row);
    }
    public boolean Roi_Check(Bouger move){
        Piece Roi=board.trouveRoi(move.piece.est_Blanc);
        assert Roi!=null;
        int RoiCol=Roi.col;
        int RoiRow=Roi.row;

        if (board.Piece_choisi!=null&&board.Piece_choisi.nom.equals("Roi")){
            RoiCol=move.nouv_Col;
            RoiRow= move.nouv_Row;
        }
        return control_Tour(move.nouv_Col,move.nouv_Row,Roi,RoiCol,RoiRow,0,1)||
                control_Tour(move.nouv_Col,move.nouv_Row,Roi,RoiCol,RoiRow,1,0)||
                control_Tour(move.nouv_Col,move.nouv_Row,Roi,RoiCol,RoiRow,0,-1)||
                control_Tour(move.nouv_Col,move.nouv_Row,Roi,RoiCol,RoiRow,-1,0)||
                control_Fou(move.nouv_Col,move.nouv_Row,Roi,RoiCol,RoiRow,-1,-1)||
                control_Fou(move.nouv_Col,move.nouv_Row,Roi,RoiCol,RoiRow,1,-1)||
                control_Fou(move.nouv_Col,move.nouv_Row,Roi,RoiCol,RoiRow,1,1)||
                control_Fou(move.nouv_Col,move.nouv_Row,Roi,RoiCol,RoiRow,-1,1)||
                control_Cavalier(move.nouv_Col, move.nouv_Row, Roi,RoiCol,RoiRow)||
                control_Pion(move.nouv_Col, move.nouv_Row, Roi,RoiCol,RoiRow)||
                control_Roi(Roi,RoiCol,RoiRow);
    }

}
