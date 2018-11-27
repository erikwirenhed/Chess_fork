package pieces;

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

		diagonalwalk(9);
		diagonalwalk(7);
		StraightWalk(1);
		StraightWalk(8);
	}

	@Override
	public void hideMove() {
		// TODO Auto-generated method stub

	}

}
