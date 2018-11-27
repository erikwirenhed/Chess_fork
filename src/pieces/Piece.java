package pieces;

import board.ChessBoard;
import board.Square;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public abstract class Piece extends Group implements moveable {

	private static Piece active;
	private Color color;

	public Piece(Color c) {
		this.color = c;

		String COLOR = "WHITE";
		if (c == Color.BLACK) {
			COLOR = "BLACK";
		}

		Image img = new Image("/images/" + COLOR + "_" + this.getClass().getSimpleName().toUpperCase() + ".png");
		ImageView iv = new ImageView(img);
		iv.setFitWidth(Square.SIZE);
		iv.setFitHeight(Square.SIZE);
		this.getChildren().add(iv);

	}

	public void makeActive() {
		active = this;
	}

	public static Piece getActive() {
		return active;
	}

	public static void removeActive() {
		active = null;
	}

	public Color getColor() {
		return color;
	}

	public void diagonalwalk(int x) {

		int c = 0;

		Square s = (Square) this.getParent();

		for (int index = Square.all_squares.indexOf(s) + x; index < Square.all_squares.size(); index += x) {

			if (x == 7) {
				c = x;
			}

			if (index % 8 == c) {
				break;
			}
			movmentPath(index);
			if (false == movmentPath(index) || this instanceof King) {
		break;
			}

		}

		for (int index = Square.all_squares.indexOf(s) - x; index >= 0; index -= x) {

			if (x == 9) {
				c = 7;
			}

			if (index % 8 == c) {
				break;
			}
			movmentPath(index);
			if (false == movmentPath(index) || this instanceof King) {
		break;
			}

		}
	}

	public void StraightWalk(int x) {
		Square s = (Square) this.getParent();

		for (int index = Square.all_squares.indexOf(s) + x; index < Square.all_squares.size(); index += x) {
			if (x == 1) {
				if (index % 8 == 0) {
					break;
				}
			}
			movmentPath(index);
			if (false == movmentPath(index) || this instanceof King) {
				break;
			}
		}

		for (int index = Square.all_squares.indexOf(s) - x; index >= 0; index -= x) {
			if (x == 1) {
				if (index % 8 == 7) {
					break;
				}
			}
			movmentPath(index);
			if (false == movmentPath(index) || this instanceof King) {
				break;
			}
		}
	}

	private boolean movmentPath(int index) {
		if (Square.all_squares.get(index).hasPiece()
				&& !(this.getColor() != Square.all_squares.get(index).getPieceColor())) {
			return false; // RETURN I METOD
		} else if (Square.all_squares.get(index).hasPiece()
				&& (this.getColor() != Square.all_squares.get(index).getPieceColor())) {
			if (Square.all_squares.get(index).hasKing()) {
				ChessBoard.check();
			}
			Square.all_squares.get(index).getBackground().setFill(Color.GREEN);
			return false;
		} else {

			Square.all_squares.get(index).getBackground().setFill(Color.RED);
		}
		return true;

	}
}
