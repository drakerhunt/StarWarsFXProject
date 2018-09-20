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


public class NewCharacterWindow extends Pane {

	public NewCharacterWindow() {
		//Create panes
		VBox mainVB = new VBox();
		
		//Create createButton
		Button saveCharacterBtn = new Button("Save");
		
		//Create labels
		Label nameLabel = new Label("Name: ");
		Label woundTLabel = new Label("Wound Threshold: ");
		Label strainTLabel = new Label("Strain Threshold: ");
		Label soakLabel = new Label("Soak: ");
		Label creditsLabel = new Label("Credits: ");
		
		//Create textfields
		TextField nameTF = new TextField("");
		TextField woundTF = new TextField("");
		TextField strainTF = new TextField("");
		TextField soakTF = new TextField("");
		TextField creditsTF = new TextField("");
		
		//Add children to stats hboxes
		mainVB.getChildren().addAll(nameLabel, nameTF, woundTLabel, woundTF, strainTLabel, strainTF, soakLabel, soakTF, creditsLabel, creditsTF, saveCharacterBtn);
		mainVB.setMaxWidth(700 / 4 - 40);
		this.getChildren().addAll(mainVB);
		
		saveCharacterBtn.setOnAction(e -> {
			String name = nameTF.getText();
			int wound = Integer.parseInt(woundTF.getText());
			int strain = Integer.parseInt(strainTF.getText());
			int soak = Integer.parseInt(soakTF.getText());
			double credits = Double.parseDouble(creditsTF.getText());
			
			ArrayList<Characters> characterList = new ArrayList<Characters>();
			characterList.add(new Characters(name, wound, strain, soak, credits));
			
			File characterFile = new File("SavedCharacters.dat");
			try {
				if (!characterFile.exists()) {
					ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(characterFile));
					output.writeObject(characterList);
				}
			}
			catch (IOException ex) {
				System.out.println("Did not save!");
			}
		});
	}
}
