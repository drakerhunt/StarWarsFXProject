package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.io.*;
import java.util.ArrayList;

public class CharacterWindow extends Pane {
	
	public CharacterWindow() throws IOException, ClassNotFoundException {
		
		GridPane charGP = new GridPane();
		
		File characterFile = new File("SavedCharacters.dat");
		ObjectInputStream input = new ObjectInputStream(new FileInputStream(characterFile));
		
		ArrayList<Characters> characterList = new ArrayList<Characters>();
		
		try {
			while (true) {
				characterList = (ArrayList)input.readObject();
			}
		}
		catch (EOFException ex) {
			
		}
		int counter = 0;
		for (int i = 0; i < characterList.size() / 3; i++) { 
			for (int c = 0; c < 3; c++) {
				charGP.getChildren().add(new Label(characterList.get(counter)), c, i);
				counter++;
			}
		}
			
	}
	
}