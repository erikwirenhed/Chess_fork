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
		if(ChessBoard.isCheck()){
			ChessBoard.check();
		}
	}

	public Square(Color c) {

		all_squares.add(this);

		originalColor = c;
		bg = new Rectangle(SIZE, SIZE, c);
		this.getChildren().add(bg);

		this.setOnMouseClicked(event -> {

			if (hasPiece() && (Piece.getActive() == null) && ChessBoard.getTurn() == this.piece.getColor()) {

				resetBoardColor();

				this.piece.showMove();

				/*
				 * if (!this.getBackground().getFill().equals(originalColor)) {
				 * this.getBackground().setFill(originalColor); }
				 */

				/*
				 * if(Piece.getActive() == this.piece){ Piece.removeActive(); //
				 * active.getBackground().setFill(active.originalColor);
				 * Square.removeActive(); resetBoardColor(); }
				 */

				this.getBackground().setFill(Color.RED);
				piece.makeActive();

				this.makeActive();

			} else if (Piece.getActive() == this.piece) {
				Piece.removeActive();
				// active.getBackground().setFill(active.originalColor);
				Square.removeActive();
				resetBoardColor();
			} else if (hasPiece() && Piece.getActive() != null && bg.getFill() == Color.GREEN) {

				
				if (ChessBoard.isCheck()) {
					if(this.piece != ChessBoard.checkPiece){
						
						resetBoardColor();
						return;
					}
					
				}
				
				ChessBoard.unCheck();
				removePiece(this.piece);
				addPiece(Piece.getActive());
				Piece.removeActive();
				Square.getActive().piece = null;
				active.getBackground().setFill(active.originalColor);
				Square.removeActive();
				this.piece.move();
				ChessBoard.nextTurn();
				this.piece.showMove();
				if (ChessBoard.isCheck()) {
					resetBoardColor();
					ChessBoard.setCheckPiece(this.piece);
					ChessBoard.check();
				} else {
					resetBoardColor();
				}

			} else {
				if (bg.getFill() == Color.RED) {

					if (ChessBoard.isCheck()) {
						if(Piece.getActive() instanceof King){
							 placeholder = new King(ChessBoard.getTurn());
						}
						else{
							 placeholder = new Pawn(ChessBoard.getTurn());
						}
					
						
						addPiece(placeholder);
						ChessBoard.unCheck();
						ChessBoard.checkPiece.showMove(); // Sätter CHECK = true
															// om det blir
															// schack
						removePiece(placeholder);

						if (ChessBoard.isCheck()) {
							resetBoardColor();
							return;
						}

					}

					if (Piece.getActive() != null) {
						addPiece(Piece.getActive());
						if(Piece.getActive() instanceof King){
							if(ChessBoard.getTurn()==Color.BLACK){
								ChessBoard.blackKing=this;
							}
							else if (ChessBoard.getTurn()==Color.WHITE){
								ChessBoard.whiteKing=this;
							}
								

						}
						Piece.removeActive();
						Square.getActive().piece = null;
						active.getBackground().setFill(active.originalColor);
						Square.removeActive();
						this.piece.move();
						ChessBoard.nextTurn();

						this.piece.showMove();
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

			}
		});

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

	public void getColor() {

	}

	public Color getPieceColor() {
		return this.piece.getColor();
	}

	public boolean hasKing() {
		return (this.piece instanceof King);
	}

}
