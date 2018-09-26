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

public class SelectedCharPane extends Pane {
	
	String name;
	private int wounds, strain, soak;
	private double credits;
	
	VBox mainVB = new VBox();
	
	//charName
	HBox nameHB = new HBox();
	Label nameLb = new Label();
	
	//wounds
	HBox woundsHB = new HBox();
	Label woundsLb = new Label();
	TextField woundsTF = new TextField();
	
	//strain
	HBox strainHB = new HBox();
	Label strainLb = new Label();
	TextField strainTF = new TextField();
	
	//soak
	HBox soakHB = new HBox();
	Label soakLb = new Label();
	TextField soakTF = new TextField();
	
	//credits
	HBox creditsHB = new HBox();
	Label creditsLB = new Label();
	TextField creditsTF = new TextField();
	
	ArrayList<Characters> charList;
	ObjectInputStream input; 
	
	public SelectedCharPane(int i) throws IOException, ClassNotFoundException {
		this.input = new ObjectInputStream(new FileInputStream("SavedCharacter.dat"));
		this.charList = (ArrayList<Characters>)(input.readObject());
		
		this.name = charList.get(i).getCharName();
		this.wounds = charList.get(i).getWounds();
		this.strain = charList.get(i).getStrain();
		this.soak = charList.get(i).getSoak();
		this.credits = charList.get(i).getSoak();
		
		this.nameLb.setText("Name: " + this.name);
		this.nameHB.getChildren().addAll(this.nameLb);
		
		this.woundsLb.setText("Wound Threshold: ");
		this.woundsTF.setText(this.wounds + "");
		this.woundsHB.getChildren().addAll(this.woundsLb, this.woundsTF);
		
		this.strainLb.setText("Strain Threshold: ");
		this.strainTF.setText(this.strain + "");
		this.strainHB.getChildren().addAll(this.strainLb, this.strainTF);
		
		this.soakLb.setText("Soak: ");
		this.soakTF.setText(this.soak + "");
		this.soakHB.getChildren().addAll(this.soakLb, this.soakTF);
		
		this.creditsLB.setText("Credits: ");
		this.creditsTF.setText(this.credits + "");
		this.creditsHB.getChildren().addAll(this.creditsLB, this.creditsTF);
		
		this.mainVB.getChildren().addAll(this.nameHB, this.woundsHB, this.strainHB, this.soakHB, this.creditsHB);
		
		this.getChildren().add(this.mainVB);
	}
	
}