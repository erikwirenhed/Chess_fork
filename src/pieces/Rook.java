package pieces;

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

		StraightWalk(8);
		StraightWalk(1);
		

	}

	@Override
	public void hideMove() {
		// TODO Auto-generated method stub

	}

	
}
