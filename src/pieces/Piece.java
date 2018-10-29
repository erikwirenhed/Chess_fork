package pieces;


import board.Square;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public abstract class Piece extends Group {

	private static Piece active;
	private int color = 1;
	
	
	
	public Piece(Color c) {

		if (c==Color.BLACK){
			color=0;
		}
		else if(c==Color.WHITE){
			color=1;
		}
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

	public void makeActive(){
		active=this;
	}
	
	public static Piece getActive(){
		return active;
	}
	
	public static void removeActive(){
		active=null;
	}
	
	public int getColor(){
		return color;
	}

	
}
