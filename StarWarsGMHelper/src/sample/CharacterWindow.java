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
		charGP.setGridLinesVisible(true);
		
		try {
			File characterFile = new File("SavedCharacters.dat");
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(characterFile));
			
			ArrayList<Characters> characterList = new ArrayList<Characters>();
			//while (true) {
				Characters charTemp = new Characters();
				characterList.equals(input.readObject());
				charTemp = characterList.get(0);
				System.out.println("NO");
			//}
			
			int counter = 0;
			Label gridLabel = new Label(charTemp.toString()); 
			/*for (int i = 0; i < characterList.size() / 3; i++) { 
				for (int c = 0; c < 2; c++) {
					String temp = characterList.get(counter).toString();
					gridLabel.setText(temp);
					charGP.getChildren().add(gridLabel);
					charGP.setRowIndex(gridLabel, c);
					charGP.setColumnIndex(gridLabel, i);
					counter++;
				}
			}*/
			charGP.getChildren().add(gridLabel);
			this.getChildren().add(charGP);
		}
		catch (EOFException ex) {
			System.out.println("nope");
		}
	}
}