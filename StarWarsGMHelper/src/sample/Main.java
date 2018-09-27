package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.collections.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.io.*;


public class Main extends Application {
    
    ArrayList<String> charStringList = new ArrayList<String>();
    ObservableList<String> charNameList = FXCollections.observableArrayList(charStringList);
    int size1, size2 = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        int width = 700;
        int height = 500;
        double centerX = width / 3;
        double centerY = height / 3;

        //Create Panes
        BorderPane pane = new BorderPane();
        Pane titlePane = new Pane();
        Label titleLabel = new Label("Star Wars GM Helper");
        titleLabel.setFont(Font.font("Ariel", 30));
        titleLabel.setLayoutX(centerX / 1.5);
        titlePane.getChildren().add(titleLabel);

        VBox mainVB = new VBox(150);
        mainVB.setMaxSize(width, height);

        HBox characterHB = new HBox(10);
        characterHB.setStyle("-fx-padding: 0;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 3;" +
                "-fx-border-insets: 0;" +
                "-fx-border-color: black;");
        characterHB.setMaxWidth(width);
        characterHB.setMaxHeight(height);
        
        HBox buttonHB = new HBox(5);
        
        //Buttons
        Button newCharButton = new Button("New Character");
        Button mainMenuBtn = new Button("Main Menu");
        Button clearBtn = new Button("Clear");
        Button char1Btn = new Button("See Character List");
        Button char2Btn = new Button("See Character List");
        Button char3Btn = new Button("See Character List");
        Button char4Btn = new Button("See Character List");
        
        //ComboBox Observable List
        
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("SavedCharacters.dat"));
            ArrayList<Characters> charList = new ArrayList<Characters>();
            charList = (ArrayList<Characters>)in.readObject();
            in.close();
            for (int i = 0; i < charList.size(); i++) {
                charStringList.add(charList.get(i).getCharName());
            }
        }
        catch (Exception ex) {
            System.out.println("COMBOBOX");
        }
        charNameList = FXCollections.observableArrayList(charStringList);
        
        //ComboBox for Character Selection
        ComboBox charCB1 = new ComboBox(charNameList);
        ComboBox charCB2 = new ComboBox(charNameList);
        ComboBox charCB3 = new ComboBox(charNameList);
        ComboBox charCB4 = new ComboBox(charNameList);
        
        //charCB1.getItems().addAll(charNameList);
        
        //Formatting ComboBox
        charCB1.setPrefWidth(width / 4 - 15);
        charCB2.setPrefWidth(width / 4 - 15);
        charCB3.setPrefWidth(width / 4 - 15);
        charCB4.setPrefWidth(width / 4 - 15);
        
        
        charCB1.setValue("Characters");
        charCB2.setValue("Characters");
        charCB3.setValue("Characters");
        charCB4.setValue("Characters");
        
        //Character panes
        VBox charVB1 = new VBox();
        VBox charVB2 = new VBox();
        VBox charVB3 = new VBox();
        VBox charVB4 = new VBox();
        
        //Set character pane borders
        charVB1.setStyle("-fx-padding: 10;" +
            "-fx-border-style: solid inside;" +
            "-fx-padding: 10;" +
            "-fx-border-width: 1;" +
            "-fx-border-insets: 0;" +
            "-fx-border-color: black;");
        charVB2.setStyle("-fx-padding: 10;" +
            "-fx-border-style: solid inside;" +
            "-fx-padding: 10;" +
            "-fx-border-width: 1;" +
            "-fx-border-insets: 0;" +
            "-fx-border-color: black;");
        charVB3.setStyle("-fx-padding: 10;" +
            "-fx-border-style: solid inside;" +
            "-fx-padding: 10;" +
            "-fx-border-width: 1;" +
            "-fx-border-insets: 0;" +
            "-fx-border-color: black;");
        charVB4.setStyle("-fx-padding: 10;" +
            "-fx-border-style: solid inside;" +
            "-fx-padding: 10;" +
            "-fx-border-width: 1;" +
            "-fx-border-insets: 0;" +
            "-fx-border-color: black;");
        
        //Character Labels
        Label charLabel1 = new Label("Empty");
        Label charLabel2 = new Label("Empty");
        Label charLabel3 = new Label("Empty");
        Label charLabel4 = new Label("Empty");
        
        //set character panes width
        charVB1.setPrefWidth(width / 4);
        charVB2.setPrefWidth(width / 4);
        charVB3.setPrefWidth(width / 4);
        charVB4.setPrefWidth(width / 4);

        //Add character labels to character panes
        charVB1.getChildren().addAll(charCB1, char1Btn);
        charVB2.getChildren().addAll(charCB2, char2Btn);
        charVB3.getChildren().addAll(charCB3, char3Btn);
        charVB4.getChildren().addAll(charCB4, char4Btn);
        
        //Adding nodes to panes and setting alignment
        characterHB.getChildren().addAll(charVB1, charVB2, charVB3, charVB4);
        buttonHB.getChildren().addAll(newCharButton, mainMenuBtn, clearBtn);
        pane.setTop(titlePane);
        pane.setCenter(characterHB);
        pane.setBottom(buttonHB);
        pane.setMargin(buttonHB, new Insets(5, 5, 5, 5));
        characterHB.setAlignment(Pos.CENTER);
        //mainVB.getChildren().addAll(titlePane, characterHB);

        //Set Scene
        Scene mainScene = new Scene(pane, width, height);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Star Wars GM Helper");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        
        newCharButton.setOnAction(e -> {
            NewCharacterWindow nCWindow = new NewCharacterWindow();
            characterHB.getChildren().clear();
            characterHB.getChildren().addAll(nCWindow);
        });
        mainMenuBtn.setOnAction(e -> {
            
            characterHB.getChildren().clear();
            characterHB.getChildren().addAll(charVB1, charVB2, charVB3, charVB4);
            
            
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("SavedCharacters.dat"));
                ArrayList<Characters> charList = new ArrayList<Characters>();
                charList.clear();
                charNameList.clear();
                charStringList.clear();
                charList = (ArrayList<Characters>)in.readObject();
                in.close();
                for (int i = 0; i < charList.size(); i++) {
                    charStringList.add(charList.get(i).getCharName());
                }
                charNameList = FXCollections.observableArrayList(charStringList);
                charCB1.setItems(charNameList);
                charCB2.setItems(charNameList);
                charCB3.setItems(charNameList);
                charCB4.setItems(charNameList);
                
                charCB1.setValue("Characters");
                charCB2.setValue("Characters");
                charCB3.setValue("Characters");
                charCB4.setValue("Characters");
            }
            catch (Exception ex) {
                System.out.println("MAIN");
            }
        });
        
        //Select Buttons
        char1Btn.setOnAction(e -> {
            try {
                CharacterWindow cW = new CharacterWindow();
                characterHB.getChildren().clear();
                characterHB.getChildren().addAll(cW);
            }
            catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        });
        
        char2Btn.setOnAction(e -> {
            try {
                CharacterWindow cW = new CharacterWindow();
                characterHB.getChildren().clear();
                characterHB.getChildren().addAll(cW);
            }
            catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        });
        
        char3Btn.setOnAction(e -> {
            try {
                CharacterWindow cW = new CharacterWindow();
                characterHB.getChildren().clear();
                characterHB.getChildren().addAll(cW);
            }
            catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        });
        
        char4Btn.setOnAction(e -> {
            try {
                CharacterWindow cW = new CharacterWindow();
                characterHB.getChildren().clear();
                characterHB.getChildren().addAll(cW);
            }
            catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        });
        
        //Clear Button
        clearBtn.setOnAction(e -> {
            charVB1.getChildren().clear();
            charVB2.getChildren().clear();
            charVB3.getChildren().clear();
            charVB4.getChildren().clear();
            
            charVB1.getChildren().addAll(charCB1, char1Btn);
            charVB2.getChildren().addAll(charCB2, char2Btn);
            charVB3.getChildren().addAll(charCB3, char3Btn);
            charVB4.getChildren().addAll(charCB4, char4Btn);
        });
        
        //ComboBox listeners
        charCB1.setOnAction(e -> {
            try {
                SelectedCharPane sChar = new SelectedCharPane(charStringList.indexOf(charCB1.getValue()));
                charVB1.getChildren().clear();
                charVB1.getChildren().addAll(sChar);
            }
            catch (Exception ex) {
                System.out.println("COMBOBOX1");
            }
        });
        charCB2.setOnAction(e -> {
            try {
                SelectedCharPane sChar = new SelectedCharPane(charStringList.indexOf(charCB2.getValue()));
                charVB2.getChildren().clear();
                charVB2.getChildren().addAll(sChar);
            }
            catch (Exception ex) {
                System.out.println("COMBOBOX2");
            }
        });
        charCB3.setOnAction(e -> {
            try {
                SelectedCharPane sChar = new SelectedCharPane(charStringList.indexOf(charCB3.getValue()));
                charVB3.getChildren().clear();
                charVB3.getChildren().addAll(sChar);
            }
            catch (Exception ex) {
                System.out.println("COMBOBOX3");
            }
        });
        charCB4.setOnAction(e -> {
            try {
                SelectedCharPane sChar = new SelectedCharPane(charStringList.indexOf(charCB4.getValue()));
                charVB4.getChildren().clear();
                charVB4.getChildren().addAll(sChar);
            }
            catch (Exception ex) {
                System.out.println("COMBOBOX4");
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
