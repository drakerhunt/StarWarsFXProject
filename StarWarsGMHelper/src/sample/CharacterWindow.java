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
	
	ArrayList<Characters> characterList = new ArrayList<Characters>();
	
	public CharacterWindow() throws IOException, ClassNotFoundException {
		
		GridPane charGP = new GridPane();
		charGP.setGridLinesVisible(true);
		charGP.setHgap(10);
		charGP.setVgap(10);
		
		try {
			File characterFile = new File("SavedCharacters.dat");
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("SavedCharacters.dat"));
			
			Characters charTemp = new Characters();
			characterList = (ArrayList<Characters>)(input.readObject());
			
			//charTemp = characterList.get(0);
			System.out.println("NO");
			
			ArrayList<VBox> vbList = new ArrayList<VBox>();
			
			ArrayList<Button> btnList = new ArrayList<Button>();
			
			ArrayList<Label> labelList = new ArrayList<Label>();
			int counter = 0; 
			System.out.println(characterList.size());
			
			if (characterList.size() > 3) {
				for (int i = 0; i < characterList.size() / 3; i++) {
					System.out.println(characterList.size()); 
					for (int c = 0; c < 2; c++) {
						Label gridLabel = new Label(characterList.get(counter).toString());
						labelList.add(gridLabel);
						
						Button selectBtn = new Button("Select");
						btnList.add(selectBtn);
						
						VBox charWinVB = new VBox();
						charWinVB.getChildren().addAll(labelList.get(counter), btnList.get(counter));
						vbList.add(charWinVB);
						
						charGP.getChildren().add(vbList.get(counter));
						charGP.setRowIndex(vbList.get(counter), c);
						charGP.setColumnIndex(vbList.get(counter), i);
						counter++;
					}
				}
			}
			else {
				for (int i = 0; i < characterList.size(); i++) {
					System.out.println(characterList.size());
					Label gridLabel = new Label(characterList.get(counter).toString());
					labelList.add(gridLabel);
					
					Button selectBtn = new Button("Select");
					btnList.add(selectBtn);
					
					VBox charWinVB = new VBox();
					charWinVB.getChildren().addAll(labelList.get(counter), btnList.get(counter));
					vbList.add(charWinVB);
					
					
					charGP.getChildren().add(vbList.get(counter));
					//charGP.setRowIndex(labelList.get(counter), c);
					charGP.setColumnIndex(vbList.get(counter), i);
					counter++;
				}
			}
			
			input.close();
			this.getChildren().add(charGP);
		}
		catch (EOFException ex) {
			System.out.println("nope");
		}
	}
}