package pieces;

import board.Square;
import javafx.scene.paint.Color;

public class Pawn extends Piece implements moveable {

	private boolean hasMoved = false;
	int color = this.getColor();
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
			if (this.getColor() == 1) {

				for (int index = Square.all_squares.indexOf(s) - 8; index >= 0; index -= 65) {
					for (int index1 = Square.all_squares.indexOf(s) - 16; index1 >= 0; index1 -= 65) {

						Square.all_squares.get(index).getBackground().setFill(Color.RED);
						Square.all_squares.get(index1).getBackground().setFill(Color.RED);

					}
				}
			} else if (this.getColor() == 0) {
				for (int index = Square.all_squares.indexOf(s) + 8; index < Square.all_squares.size(); index += 65) {
					for (int index1 = Square.all_squares.indexOf(s) + 16; index1 < Square.all_squares.size(); index1 += 65) {
						if(Square.all_squares.get(index1).hasPiece()){
							break;
						}
						else if(Square.all_squares.get(index).hasPiece()){
							break;
						}
						else{
						Square.all_squares.get(index).getBackground().setFill(Color.RED);
						Square.all_squares.get(index1).getBackground().setFill(Color.RED);
						}
						
						

					}
				}
			}
		}

		else {
			if (this.getColor() == 1) {

				for (int index = Square.all_squares.indexOf(s) - 8; index >= 0; index -= 65) {

					Square.all_squares.get(index).getBackground().setFill(Color.RED);

				}
			}

			else if (this.getColor() == 0) {
				for (int index = Square.all_squares.indexOf(s) + 8; index < Square.all_squares.size(); index += 65) {
					if(Square.all_squares.get(index).hasPiece()){
						break;
					}
					else{
					Square.all_squares.get(index).getBackground().setFill(Color.RED);

					}
				}
			}
		}

	}

	@Override
	public void hideMove() {
		// TODO Auto-generated method stub

	}

/*	@Override
	public int getColorOfPiece() {
		// TODO Auto-generated method stub
		return color;
	}
*/
}
