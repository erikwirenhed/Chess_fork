package board;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pieces.Piece;

public class Square extends Group {

	public static final double SIZE = 80;
	private Rectangle bg;
	private Color originalColor;
	private Piece piece;
	int turn = 1;
	private static Square active;
	public static ArrayList<Square> all_squares = new ArrayList<Square>();
	public static ArrayList<Piece>takenPiece = new ArrayList<Piece>();
	
	
	public static void resetBoardColor() {
		for (Square square : all_squares) {
			square.getBackground().setFill(square.originalColor);
			
		}
	}

	public Square(Color c) {

		all_squares.add(this);

		originalColor = c;
		bg = new Rectangle(SIZE, SIZE, c);
		this.getChildren().add(bg);

		this.setOnMouseClicked(event -> {
			
			
			

			

			
			 if (hasPiece()&& (Piece.getActive()== null)){
		
				
				resetBoardColor(); 

				this.piece.showMove();
			

					/*
					 * if
					 * (!this.getBackground().getFill().equals(originalColor)) {
					 * this.getBackground().setFill(originalColor); }
					 */

					if(Piece.getActive() == this.piece){
						Piece.removeActive();
					//	active.getBackground().setFill(active.originalColor);
						Square.removeActive();
						resetBoardColor();
					}
					else {
						
						this.getBackground().setFill(Color.RED);
						piece.makeActive();

						this.makeActive();

					}
			}
			 else if(Piece.getActive() == this.piece){
					Piece.removeActive();
				//	active.getBackground().setFill(active.originalColor);
					Square.removeActive();
					resetBoardColor();
				}	 
			 else if(hasPiece() && Piece.getActive() != null && bg.getFill()==Color.RED){
				 	removePiece(this.piece);
				 	addPiece(Piece.getActive());
					Piece.removeActive();
					Square.getActive().piece = null;
					active.getBackground().setFill(active.originalColor);
					Square.removeActive();
					this.piece.move();
					resetBoardColor();
			 }
			else {
				if(bg.getFill()==Color.RED){
				if (Piece.getActive() != null) {
					addPiece(Piece.getActive());
					Piece.removeActive();
					Square.getActive().piece = null;
					active.getBackground().setFill(active.originalColor);
					Square.removeActive();
					this.piece.move();
					resetBoardColor();
					
				}
				}
				
			
				else{ // Tom ruta => Avmarkera allt
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

	public void removePiece(Piece p){
		this.piece = p;
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

	public void getColor(){
		
	}

}
