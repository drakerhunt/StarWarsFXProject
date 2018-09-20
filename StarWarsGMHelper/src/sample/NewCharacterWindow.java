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


public class NewCharacterWindow extends Application {
	
	@Override
	public void start(Stage secondStage) {
			
		//Create panes
		VBox mainVB = new VBox();
		HBox nameHB = new HBox();
		HBox woundHB = new HBox();
		HBox strainHB = new HBox();
		HBox soakHB = new HBox();
		HBox creditsHB = new HBox();
		
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
		nameHB.getChildren().addAll(nameLabel, nameTF);
		
		Scene secondScene = new Scene(mainVB, 300, 400);
	}
}
