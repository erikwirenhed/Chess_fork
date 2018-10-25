package board;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import pieces.Piece;

public class Square extends Group {

	public static final double SIZE = 80;
	private Rectangle bg;
	private Color originalColor;
	private Piece piece;
	private static Square active;
	private Color lastColor;
	private Color lastSquareColor;
	
	public Square(Color c) {
		
		
		originalColor = c;
		bg = new Rectangle(SIZE, SIZE, c);
		this.getChildren().add(bg);

		this.setOnMouseClicked(event -> {

			
			// EXEMPEL:
			if (hasPiece()) {
				if (!this.getBackground().getFill().equals(originalColor)) {
					this.getBackground().setFill(originalColor);
				} 
				else if(Piece.getActive()==null){
					this.getBackground().setFill(Color.RED);
					piece.makeActive();
					//lastSquareColor=this.originalColor;
					//lastColor=piece.getColor();
					this.makeActive();
					
				}
				
				else{
					Piece.removeActive();
					active.getBackground().setFill(active.originalColor);
					Square.removeActive();
				}
			}
			else {
				if (Piece.getActive() != null) {
					addPiece(Piece.getActive());
					Piece.removeActive();
					Square.getActive().piece=null;
					active.getBackground().setFill(active.originalColor);
					Square.removeActive();
					
				
				}
			}

		});

	}

	public void addPiece(Piece p) {
		this.piece = p;
		this.getChildren().add(p);
	}

	public boolean hasPiece() {
		return this.piece != null;
	}

	public Rectangle getBackground() {
		return this.bg;
	}
	
	public void makeActive(){
		active=this;
	}

	public static Square getActive(){
		return active;
	}
	
	public static void removeActive(){
		Square.active=null;
		
	}
}
