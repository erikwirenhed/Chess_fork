package pieces;

import board.ChessBoard;
import board.Square;
import javafx.scene.paint.Color;

public class Rook extends Piece {

	public Rook(Color c) {
		super(c);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showMove() {

		Square s = (Square) this.getParent();

		for (int index = Square.all_squares.indexOf(s) + 8; index < Square.all_squares.size(); index += 8) {
			if(Square.all_squares.get(index).hasPiece()&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())){
				break;
			}
			else if(Square.all_squares.get(index).hasPiece()&& (this.getColor() != Square.all_squares.get(index).getPieceColor())){
				if (Square.all_squares.get(index).hasKing()) {
					ChessBoard.check();
				}
				Square.all_squares.get(index).getBackground().setFill(Color.GREEN);
				break;
			}
			else{
			
			Square.all_squares.get(index).getBackground().setFill(Color.RED);
			}
		}
		for (int index = Square.all_squares.indexOf(s) - 8; index >= 0; index -= 8) {
			if(Square.all_squares.get(index).hasPiece()&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())){
				break;
			}
			else if(Square.all_squares.get(index).hasPiece()&& (this.getColor() != Square.all_squares.get(index).getPieceColor())){
				if (Square.all_squares.get(index).hasKing()) {
					ChessBoard.check();
				}
				Square.all_squares.get(index).getBackground().setFill(Color.GREEN);
				break;
			}
			else{
			
			Square.all_squares.get(index).getBackground().setFill(Color.RED);
			}		
			}

		for (int index = Square.all_squares.indexOf(s) - 1; index >= 0; index -= 1) {
			if (index % 8 == 7) {
				break;
			}
			if(Square.all_squares.get(index).hasPiece()&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())){
				break;
			}
			else if(Square.all_squares.get(index).hasPiece()&& (this.getColor() != Square.all_squares.get(index).getPieceColor())){
				if (Square.all_squares.get(index).hasKing()) {
					ChessBoard.check();
				}
				Square.all_squares.get(index).getBackground().setFill(Color.GREEN);
				break;
			}
			else{
			
			Square.all_squares.get(index).getBackground().setFill(Color.RED);
			}
		}
		for (int index = Square.all_squares.indexOf(s) + 1; index < Square.all_squares.size(); index += 1) {
			if (index % 8 == 0) {
				break;
			}
			if(Square.all_squares.get(index).hasPiece()&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())){
				break;
			}
			else if(Square.all_squares.get(index).hasPiece()&& (this.getColor() != Square.all_squares.get(index).getPieceColor())){
				if (Square.all_squares.get(index).hasKing()) {
					ChessBoard.check();
				}
				Square.all_squares.get(index).getBackground().setFill(Color.GREEN);
				break;
			}
			else{
			
			Square.all_squares.get(index).getBackground().setFill(Color.RED);
			}
		}

	}

	@Override
	public void hideMove() {
		// TODO Auto-generated method stub

	}

}
