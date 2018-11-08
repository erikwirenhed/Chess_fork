package pieces;

import board.Square;
import javafx.scene.paint.Color;

public class King extends Piece implements moveable {
	public King(Color c) {
		super(c);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

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
			Square.all_squares.get(index).getBackground().setFill(Color.RED);

		}

		// diagonalt ner till h�ger.
		for (int index = Square.all_squares.indexOf(s) + 9; index < Square.all_squares.size(); index += 65) {
			if (index % 8 == 0) {
				break;
			}
			Square.all_squares.get(index).getBackground().setFill(Color.RED);

		}
		// diagonalt upp till h�ger.
		for (int index = Square.all_squares.indexOf(s) - 7; index >= 0; index -= 65) {
			if (index % 8 == 0) {
				break;
			}
			Square.all_squares.get(index).getBackground().setFill(Color.RED);

		}
		// diagonalt till v�nster.
		for (int index = Square.all_squares.indexOf(s) - 9; index >= 0; index -= 65) {
			if (index % 8 == 7) {
				break;
			}
			Square.all_squares.get(index).getBackground().setFill(Color.RED);

		}

		// rakt ner.
		for (int index = Square.all_squares.indexOf(s) + 8; index < Square.all_squares.size(); index += 65) {
			Square.all_squares.get(index).getBackground().setFill(Color.RED);

		}
		// rakt upp�t.
		for (int index = Square.all_squares.indexOf(s) - 8; index >= 0; index -= 65) {
			Square.all_squares.get(index).getBackground().setFill(Color.RED);
		}

		// rakt v�nster.
		for (int index = Square.all_squares.indexOf(s) - 1; index >= 0; index -= 65) {
			if (index % 8 == 7) {
				break;
			}
			Square.all_squares.get(index).getBackground().setFill(Color.RED);

		} 	
		// rakt h�ger.
		for (int index = Square.all_squares.indexOf(s) + 1; index < Square.all_squares.size(); index += 65) {
			if (index % 8 == 0) {
				break;
			}
			Square.all_squares.get(index).getBackground().setFill(Color.RED);

		}   	
	}

	@Override
	public void hideMove() {
		// TODO Auto-generated method stub

	}

}
