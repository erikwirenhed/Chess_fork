package pieces;

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
		
		Square s = (Square) this.getParent();
		
		for (int index = Square.all_squares.indexOf(s)+7; index < Square.all_squares.size(); index += 7) {
			
					if (index % 8 == 7) {
				break;
			}
					if(Square.all_squares.get(index).hasPiece()){
						break;
					}
					else{
					Square.all_squares.get(index).getBackground().setFill(Color.RED);

					}
		

		}
		for (int index = Square.all_squares.indexOf(s)+9; index < Square.all_squares.size(); index += 9) {
			if (index % 8 == 0) {
				break;
			}
			if(Square.all_squares.get(index).hasPiece()){
				break;
			}
			else{
			Square.all_squares.get(index).getBackground().setFill(Color.RED);

			}


		}
		for (int index = Square.all_squares.indexOf(s)-7; index >= 0; index -= 7) {
			if (index % 8 == 0) {
				break;
			}
			if(Square.all_squares.get(index).hasPiece()){
				break;
			}
			else{
			Square.all_squares.get(index).getBackground().setFill(Color.RED);

			}
			


		}
		for (int index = Square.all_squares.indexOf(s)-9; index >= 0; index -= 9) {
			if (index % 8 == 7) {
				break;
			}
			if(Square.all_squares.get(index).hasPiece()){
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
