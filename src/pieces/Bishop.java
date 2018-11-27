package pieces;

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

		diagonalwalk(7);
		diagonalwalk(9);
	}

	@Override
	public void hideMove() {
		// TODO Auto-generated method stub

	}
	

}
