package pieces;

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
		if (!(index - 16 + 1 < 0))
			Square.all_squares.get(index - 16 + 1).getBackground().setFill(Color.RED);
		if (!(index - 16 - 1 < 0))
			Square.all_squares.get(index - 16 - 1).getBackground().setFill(Color.RED);

		// DOWN
		if (!(index + 16 + 1 > 63))
			Square.all_squares.get(index + 16 + 1).getBackground().setFill(Color.RED);
		if (!(index + 16 - 1 > 63))
			Square.all_squares.get(index + 16 - 1).getBackground().setFill(Color.RED);

		// LEFT
		if (!(index - 2 - 8 < 0))
			Square.all_squares.get(index - 2 - 8).getBackground().setFill(Color.RED);
		if (!(index - 2 + 8 > 63))
			Square.all_squares.get(index - 2 + 8).getBackground().setFill(Color.RED);

		// RIGHT
		if (!(index + 2 - 8 < 0))
			Square.all_squares.get(index + 2 - 8).getBackground().setFill(Color.RED);
		if (!(index + 2 + 8 > 63))
			Square.all_squares.get(index + 2 + 8).getBackground().setFill(Color.RED);

	}

	@Override
	public void hideMove() {
		// TODO Auto-generated method stub

	}

}
