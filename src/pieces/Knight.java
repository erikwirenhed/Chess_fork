package pieces;

import board.ChessBoard;
import board.Square;
import javafx.scene.paint.Color;

public class Knight extends Piece implements moveable {

	public Knight(Color c) {
		super(c);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showMove() {

		Square s = (Square) this.getParent();

		int index = Square.all_squares.indexOf(s);

		// UP
		if (!(index % 8 == 7)) {
			if (!(index - 16 + 1 < 0)) {

				movmentPath(index - 16 + 1);
			}
		}

		if (!(index % 8 == 0)) {
			if (!(index - 16 - 1 < 0)){
				movmentPath(index-16-1);
			}
		}

		// DOWN
		if (!(index % 8 == 7)) {
			if (!(index + 16 + 1 > 63))
				movmentPath(index+16+1);
		}

		if (!(index % 8 == 0)) {
			if (!(index + 16 - 1 > 63))
				movmentPath(index+16-1);

		}

		// LEFT
		if (!(index % 8 == 0 || index % 8 == 1)) {
			if (!(index - 2 - 8 < 0))
				movmentPath(index-2-8);

			if (!(index - 2 + 8 > 63))
				movmentPath(index-2+8);
		}

		// RIGHT
		if (!(index % 8 == 6 || index % 8 == 7)) {
			if (!(index + 2 - 8 < 0))
				movmentPath(index+2-8);
		
			if (!(index + 2 + 8 > 63))
				movmentPath(index+2+8);
		}
	}

	@Override
	public void hideMove() {
		// TODO Auto-generated method stub

	}

}
