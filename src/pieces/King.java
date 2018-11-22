package pieces;


import board.Square;
import javafx.scene.paint.Color;

public class King extends Piece implements moveable {
	
	
	
	public King(Color c) {
		super(c);
	}

	@Override
	public void move() {

	}

	@Override
	public void showMove() {
		// TODO Auto-generated method stub
		Square s = (Square) this.getParent();
		
		// diagonalt ner till v�nster.
	
		for (int index = Square.all_squares.indexOf(s) + 7; index < Square.all_squares.size(); index += 65) {
			if (index % 8 == 7) {
				break;
			}
			if(Square.all_squares.get(index).hasPiece()&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())){
				break;
			}
			else if(Square.all_squares.get(index).hasPiece()&& (this.getColor() != Square.all_squares.get(index).getPieceColor())){
				Square.all_squares.get(index).getBackground().setFill(Color.GREEN);
				break;
			}
			else{
			
			Square.all_squares.get(index).getBackground().setFill(Color.RED);
			}

		}

		// diagonalt ner till h�ger.
		for (int index = Square.all_squares.indexOf(s) + 9; index < Square.all_squares.size(); index += 65) {
			if (index % 8 == 0) {
				break;
			}
			if(Square.all_squares.get(index).hasPiece()&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())){
				break;
			}
			else if(Square.all_squares.get(index).hasPiece()&& (this.getColor() != Square.all_squares.get(index).getPieceColor())){
				Square.all_squares.get(index).getBackground().setFill(Color.GREEN);
				break;
			}
			else{
			
			Square.all_squares.get(index).getBackground().setFill(Color.RED);
			}

		}
		// diagonalt upp till h�ger.
		for (int index = Square.all_squares.indexOf(s) - 7; index >= 0; index -= 65) {
			if (index % 8 == 0) {
				break;
			}
			if(Square.all_squares.get(index).hasPiece()&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())){
				break;
			}
			else if(Square.all_squares.get(index).hasPiece()&& (this.getColor() != Square.all_squares.get(index).getPieceColor())){
				Square.all_squares.get(index).getBackground().setFill(Color.GREEN);
				break;
			}
			else{
			
			Square.all_squares.get(index).getBackground().setFill(Color.RED);
			}

		}
		// diagonalt till v�nster.
		for (int index = Square.all_squares.indexOf(s) - 9; index >= 0; index -= 65) {
			if (index % 8 == 7) {
				break;
			}
			if(Square.all_squares.get(index).hasPiece()&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())){
				break;
			}
			else if(Square.all_squares.get(index).hasPiece()&& (this.getColor() != Square.all_squares.get(index).getPieceColor())){
				Square.all_squares.get(index).getBackground().setFill(Color.GREEN);
				break;
			}
			else{
			
			Square.all_squares.get(index).getBackground().setFill(Color.RED);
			}

		}

		// rakt ner.
		for (int index = Square.all_squares.indexOf(s) + 8; index < Square.all_squares.size(); index += 65) {
			if(Square.all_squares.get(index).hasPiece()&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())){
				break;
			}
			else if(Square.all_squares.get(index).hasPiece()&& (this.getColor() != Square.all_squares.get(index).getPieceColor())){
				Square.all_squares.get(index).getBackground().setFill(Color.GREEN);
				break;
			}
			else{
			
			Square.all_squares.get(index).getBackground().setFill(Color.RED);
			}

		}
		// rakt upp�t.
		for (int index = Square.all_squares.indexOf(s) - 8; index >= 0; index -= 65) {
			if(Square.all_squares.get(index).hasPiece()&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())){
				break;
			}
			else if(Square.all_squares.get(index).hasPiece()&& (this.getColor() != Square.all_squares.get(index).getPieceColor())){
				Square.all_squares.get(index).getBackground().setFill(Color.GREEN);
				break;
			}
			else{
			
			Square.all_squares.get(index).getBackground().setFill(Color.RED);
			}
		}

		// rakt v�nster.
		for (int index = Square.all_squares.indexOf(s) - 1; index >= 0; index -= 65) {
			if (index % 8 == 7) {
				break;
			}
			if(Square.all_squares.get(index).hasPiece()&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())){
				break;
			}
			else if(Square.all_squares.get(index).hasPiece()&& (this.getColor() != Square.all_squares.get(index).getPieceColor())){
				Square.all_squares.get(index).getBackground().setFill(Color.GREEN);
				break;
			}
			else{
			
			Square.all_squares.get(index).getBackground().setFill(Color.RED);
			}
			

		} 	
		// rakt h�ger.
		for (int index = Square.all_squares.indexOf(s) + 1; index < Square.all_squares.size(); index += 65) {
			if (index % 8 == 0) {
				break;
			}
			if(Square.all_squares.get(index).hasPiece()&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())){
				break;
			}
			else if(Square.all_squares.get(index).hasPiece()&& (this.getColor() != Square.all_squares.get(index).getPieceColor())){
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
