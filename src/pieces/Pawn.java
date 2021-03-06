package pieces;

import board.ChessBoard;
import board.Square;
import javafx.scene.paint.Color;

public class Pawn extends Piece implements moveable {

	private boolean hasMoved = false;

	public Pawn(Color c) {
		super(c);
	}

	@Override
	public void move() {
		hasMoved = true;
		// TODO Auto-generated method stub

	}

	@Override
	public void showMove() {

		Square s = (Square) this.getParent();
		if (hasMoved == false) {
			if (this.getColor() == Color.WHITE) {

				for (int index = Square.all_squares.indexOf(s) - 8; index >= 0; index -= 65) {
					for (int index1 = Square.all_squares.indexOf(s) - 16; index1 >= 0; index1 -= 65) {

						if (Square.all_squares.get(index - 1).hasPiece() && index%8 != 0 && this.getColor() != Square.all_squares.get(index - 1).getPieceColor()) {
							if (Square.all_squares.get(index-1).hasKing()) {
								ChessBoard.check();
							}
							Square.all_squares.get(index - 1).getBackground().setFill(Color.DARKGREEN);
						}
						if (Square.all_squares.get(index + 1).hasPiece() && index%8 != 7 && this.getColor() != Square.all_squares.get(index + 1).getPieceColor()) {
							if (Square.all_squares.get(index+1).hasKing()) {
								ChessBoard.check();
							}
							Square.all_squares.get(index + 1).getBackground().setFill(Color.DARKGREEN);
						}
						if (!(Square.all_squares.get(index1).hasPiece())
								&& !(Square.all_squares.get(index).hasPiece())) {
							Square.all_squares.get(index1).getBackground().setFill(Color.DARKRED);
							Square.all_squares.get(index).getBackground().setFill(Color.DARKRED);
						}
						 else if((Square.all_squares.get(index1).hasPiece())){
							  Square.all_squares.get(index).getBackground().setFill
							  (Color.DARKRED); }

					}
				}
			} else if (this.getColor() == Color.BLACK) {
				for (int index = Square.all_squares.indexOf(s) + 8; index < Square.all_squares.size(); index += 65) {
					for (int index1 = Square.all_squares.indexOf(s) + 16; index1 < Square.all_squares.size(); index1 += 65) {
						
						
						
						if (Square.all_squares.get(index - 1).hasPiece() && index%8 != 0 && this.getColor() != Square.all_squares.get(index - 1).getPieceColor()) {
							if (Square.all_squares.get(index-1).hasKing()) {
								ChessBoard.check();
							}
							Square.all_squares.get(index - 1).getBackground().setFill(Color.DARKGREEN);
						}
						if (Square.all_squares.get(index + 1).hasPiece() && index%8 != 7 && this.getColor() != Square.all_squares.get(index + 1).getPieceColor()) {
							if (Square.all_squares.get(index+1).hasKing()) {
								ChessBoard.check();
							}
							Square.all_squares.get(index + 1).getBackground().setFill(Color.DARKGREEN);
						}
						if (!(Square.all_squares.get(index1).hasPiece())
								&& !(Square.all_squares.get(index).hasPiece())) {
							Square.all_squares.get(index1).getBackground().setFill(Color.DARKRED);
							Square.all_squares.get(index).getBackground().setFill(Color.DARKRED);
						}
						
						  else if((Square.all_squares.get(index1).hasPiece())){
						  Square.all_squares.get(index).getBackground().setFill
						  (Color.DARKRED); }
						 

					}
				}
			}
		}

		else {
			if (this.getColor() == Color.WHITE) {

				for (int index = Square.all_squares.indexOf(s) - 8; index >= 0; index -= 65) {

					if (Square.all_squares.get(index - 1).hasPiece() && index%8 != 0 
							&& this.getColor() != Square.all_squares.get(index - 1).getPieceColor()) {
						if (Square.all_squares.get(index-1).hasKing()) {
							ChessBoard.check();
						}
						Square.all_squares.get(index - 1).getBackground().setFill(Color.DARKGREEN);
					}
					if (Square.all_squares.get(index + 1).hasPiece() && index%8 != 7 
							&& this.getColor() != Square.all_squares.get(index + 1).getPieceColor()) {
						if (Square.all_squares.get(index+1).hasKing()) {
							ChessBoard.check();
						}
						Square.all_squares.get(index + 1).getBackground().setFill(Color.DARKGREEN);
					}
					if (!(Square.all_squares.get(index).hasPiece())) {
						Square.all_squares.get(index).getBackground().setFill(Color.DARKRED);
					}
				}
			}

			else if (this.getColor() == Color.BLACK) {
				for (int index = Square.all_squares.indexOf(s) + 8; index < Square.all_squares.size(); index += 65) {

					if (Square.all_squares.get(index - 1).hasPiece() && index%8 != 0
							&& this.getColor() != Square.all_squares.get(index - 1).getPieceColor()) {
						if (Square.all_squares.get(index-1).hasKing()) {
							ChessBoard.check();
						}
						Square.all_squares.get(index - 1).getBackground().setFill(Color.DARKGREEN);
					}
					if (Square.all_squares.get(index + 1).hasPiece() && index%8 != 7 
							&& this.getColor() != Square.all_squares.get(index + 1).getPieceColor()) {
						if (Square.all_squares.get(index+1).hasKing()) {
							ChessBoard.check();
						}
						Square.all_squares.get(index + 1).getBackground().setFill(Color.DARKGREEN);
					}

					if (!(Square.all_squares.get(index).hasPiece())) {
						Square.all_squares.get(index).getBackground().setFill(Color.DARKRED);
					}
				}
			}
		}

	}

	@Override
	public void hideMove() {
		// TODO Auto-generated method stub

	}

	
}
