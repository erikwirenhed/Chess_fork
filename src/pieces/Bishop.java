package pieces;

import board.ChessBoard;
import board.Square;
import javafx.scene.paint.Color;

public class Bishop extends Piece {

	public Bishop(Color c) {
		super(c);
	}

	@Override
	public void move() {
		// TOM
	}

	@Override
	public void showMove() {

			walk(7);
			walk(9);
	}

	@Override
	public void hideMove() {
		// TODO Auto-generated method stub

	}
	
	private void walk(int x){
		
		int c = 0;
		
		Square s = (Square) this.getParent();

		for (int index = Square.all_squares.indexOf(s) + x; index < Square.all_squares.size(); index += x) {

			if(x==7){
				c=x;
			}
			
			
			if (index % 8 == c) {
				break;
			}
			if (Square.all_squares.get(index).hasPiece()
					&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())) {
				break;
			} else if (Square.all_squares.get(index).hasPiece()
					&& (this.getColor() != Square.all_squares.get(index).getPieceColor())) {
				if (Square.all_squares.get(index).hasKing()) {
					ChessBoard.check();
				}
				Square.all_squares.get(index).getBackground().setFill(Color.GREEN);
				break;
			} else {

				Square.all_squares.get(index).getBackground().setFill(Color.RED);
			}

		}
		
		for (int index = Square.all_squares.indexOf(s) - x; index >= 0; index -= x) {
			
			if(x==9){
				c=7;
			}
			
			if (index % 8 == c) {
				break;
			}
			if (Square.all_squares.get(index).hasPiece()
					&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())) {
				break;
			} else if (Square.all_squares.get(index).hasPiece()
					&& (this.getColor() != Square.all_squares.get(index).getPieceColor())) {
				if (Square.all_squares.get(index).hasKing()) {
					ChessBoard.check();
				}
				Square.all_squares.get(index).getBackground().setFill(Color.GREEN);
				break;
			} else {

				Square.all_squares.get(index).getBackground().setFill(Color.RED);
			}

		}
	}
	

}
