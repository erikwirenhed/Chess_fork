package board;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pieces.King;
import pieces.Pawn;
import pieces.Piece;

public class Square extends Group {

	public static final double SIZE = 80;
	private static Piece placeholder;
	private Rectangle bg;
	private Color originalColor;
	private Piece piece;
	int turn = 1;
	private static Square active;
	public static ArrayList<Square> all_squares = new ArrayList<Square>();
	public static ArrayList<Piece> takenPiece = new ArrayList<Piece>();

	public static void resetBoardColor() {
		for (Square square : all_squares) {
			square.getBackground().setFill(square.originalColor);
		}
		if (ChessBoard.isCheck()) {
			ChessBoard.check();
		}
	}

	public void uppdateKingsPosition() {
		if (Piece.getActive() instanceof King) {
			if (ChessBoard.getTurn() == Color.BLACK) {
				ChessBoard.blackKing = this;
			} else if (ChessBoard.getTurn() == Color.WHITE) {
				ChessBoard.whiteKing = this;
			}
		}
	}

	public static void diactivateBoard() {
		Piece.getActive().move();

		Square.getActive().piece = null;
		active.getBackground().setFill(active.originalColor);
		Square.removeActive();

		ChessBoard.nextTurn();
		Piece.getActive().showMove();
		Piece.removeActive();
	}

	public Square(Color c) {

		all_squares.add(this);

		originalColor = c;
		bg = new Rectangle(SIZE, SIZE, c);
		this.getChildren().add(bg);

		this.setOnMouseClicked(event -> {

			if (hasPiece() && hasTurn()) {

				if (hasActive()) {
					Piece.removeActive();
					Square.removeActive();
					resetBoardColor();
					return; // UNMARK
				}
				
				resetBoardColor();

				this.piece.showMove(); // SHOW MOVE
				this.getBackground().setFill(Color.ROYALBLUE);
				piece.makeActive();
				this.makeActive();

			}

			else if (hasEnemy()) {

				if (ChessBoard.isCheck()) {
					if (!isCheckingPiece()) {
						resetBoardColor();
						return; // INVALID MOVE
					}

				}

				ChessBoard.unCheck();
				removePiece(this.piece);
				addPiece(Piece.getActive());

				uppdateKingsPosition();
				diactivateBoard();

				if (ChessBoard.isCheck()) {
					resetBoardColor();
					ChessBoard.setCheckPiece(this.piece);
					ChessBoard.check();
				} else {
					resetBoardColor();
				}

			}

			else if (hasMove()) {

				if (ChessBoard.isCheck()) {

					if (Piece.getActive() instanceof King) {
						placeholder = new King(ChessBoard.getTurn());
					} else {
						placeholder = new Pawn(ChessBoard.getTurn());
					}

					addPiece(placeholder);
					ChessBoard.unCheck();
					ChessBoard.checkPiece.showMove();
					removePiece(placeholder); // Sätter CHECK = true
					// om det blir
					// schack

					if (ChessBoard.isCheck()) {

						resetBoardColor();
						return;
					}

				}

				if (Piece.getActive() != null) {
					addPiece(Piece.getActive());

					uppdateKingsPosition();
					diactivateBoard();

					if (ChessBoard.isCheck()) {
						resetBoardColor();
						ChessBoard.setCheckPiece(this.piece);
						ChessBoard.check();
					} else {
						resetBoardColor();
					}

				}
			}

			else { // Tom ruta => Avmarkera allt
				Piece.removeActive();
				Square.removeActive();
				resetBoardColor();
			}

		});

	}

	private boolean hasActive() {
		return Piece.getActive() == this.piece;
	}

	private boolean isCheckingPiece() {
		return this.piece == ChessBoard.checkPiece;
	}

	private boolean hasMove() {
		return bg.getFill() == Color.DARKRED;
	}

	private boolean hasEnemy() {
		return bg.getFill() == Color.DARKGREEN;
	}

	private boolean hasTurn() {
		return ChessBoard.getTurn() == this.piece.getColor();
	}

	public void addPiece(Piece p) {
		this.piece = p;
		this.getChildren().add(p);
	}

	public void removePiece(Piece p) {
		this.piece = null;
		this.getChildren().remove(p);
	}

	public boolean hasPiece() {
		return this.piece != null;
	}

	public Rectangle getBackground() {
		return this.bg;
	}

	public void makeActive() {
		active = this;
	}

	public static Square getActive() {
		return active;
	}

	public static void removeActive() {
		Square.active = null;

	}

	public Color getPieceColor() {
		return this.piece.getColor();
	}

	public boolean hasKing() {
		return (this.piece instanceof King);
	}

}
