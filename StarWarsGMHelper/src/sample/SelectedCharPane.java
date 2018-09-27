package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.io.*;
import java.util.ArrayList;

public class SelectedCharPane extends Pane {
	
	String name;
	private int wounds, strain, soak;
	private double credits;
	
	VBox mainVB = new VBox(10);
	
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
		this.input = new ObjectInputStream(new FileInputStream("SavedCharacters.dat"));
		this.charList = (ArrayList<Characters>)(input.readObject());
		input.close();
		
		this.name = charList.get(i).getCharName();
		this.wounds = charList.get(i).getWounds();
		this.strain = charList.get(i).getStrain();
		this.soak = charList.get(i).getSoak();
		this.credits = charList.get(i).getSoak();
		
		this.nameLb.setText("Name: " + this.name);
		this.nameHB.getChildren().addAll(this.nameLb);
		
		this.woundsLb.setText("Wound Threshold: " + this.wounds);
		this.woundsTF.setText("0");
		this.woundsHB.getChildren().addAll(this.woundsLb, this.woundsTF);
		
		this.strainLb.setText("Strain Threshold: " + this.strain);
		this.strainTF.setText("0");
		this.strainHB.getChildren().addAll(this.strainLb, this.strainTF);
		
		this.soakLb.setText("Soak: " + this.soak);
		//this.soakTF.setText("0");
		this.soakHB.getChildren().addAll(this.soakLb, this.soakTF);
		
		this.creditsLB.setText("Credits: ");
		this.creditsTF.setText(this.credits + "");
		this.creditsHB.getChildren().addAll(this.creditsLB, this.creditsTF);
		
		this.mainVB.getChildren().addAll(this.nameHB, this.woundsLb, this.woundsTF, this.strainLb, this.strainTF, this.soakLb, this.creditsLB, this.creditsTF);
		
		this.getChildren().add(this.mainVB);
		this.setWidth(700 / 4 - 10);
	}
	
}