package board;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class ChessBoard extends Group {

	int cordenateX;
	int cordenateY;
	
	public ChessBoard() {

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {

				Color bg = Color.SANDYBROWN;
				if ((row + col) % 2 == 0) {
					bg = Color.BLANCHEDALMOND;
				}

				Square s = new Square(bg);
				s.setTranslateX(col * Square.SIZE);
				s.setTranslateY(row * Square.SIZE);
				this.getChildren().add(s);

				if (row == 0) {
					if (col == 0 || col==7) {
						s.addPiece(new Rook(Color.BLACK));
						
						//s.addPiece(new King(Color.BLACK));  // Obs ta bort efter testning!
					}
					
					else if (col == 1 || col==6) {
						s.addPiece(new Knight(Color.BLACK));
					}
					
					else if (col == 2 || col==5) {
						s.addPiece(new Bishop(Color.BLACK));
					}
					
					else if (col == 3) {
						s.addPiece(new Queen(Color.BLACK));
					}
					
					else if (col == 4) {
						s.addPiece(new King(Color.BLACK));
					}
				
				}

				if (row == 7) {
					if (col == 0 || col == 7) {
						s.addPiece(new Rook(Color.WHITE));

					}
					
					else if (col == 1 || col==6) {
						s.addPiece(new Knight(Color.WHITE));
					}
					
					else if (col == 2 || col==5) {
						s.addPiece(new Bishop(Color.WHITE));
					}
					
					else if (col == 3) {
						s.addPiece(new Queen(Color.WHITE));
					}
					
					else if (col == 4) {
						s.addPiece(new King(Color.WHITE));
					}
					
					
				}
				if (row == 1) {
					s.addPiece(new Pawn(Color.BLACK));
				}
				if (row == 6) {
					s.addPiece(new Pawn(Color.WHITE));
				}
				
			/*	if(row == 4 && col == 4){
					s.addPiece(new King(Color.WHITE));   // Obs ta bort efter testning!
				}	*/
			} 

		}	
	}}
