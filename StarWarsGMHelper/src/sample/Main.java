package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.*;


public class Main extends Application {

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
        Button char1Btn = new Button("Select Character");
        Button char2Btn = new Button("Select Character");
        Button char3Btn = new Button("Select Character");
        Button char4Btn = new Button("Select Character");
        
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
        charVB1.getChildren().addAll(charLabel1, char1Btn);
        charVB2.getChildren().addAll(charLabel2, char2Btn);
        charVB3.getChildren().addAll(charLabel3, char3Btn);
        charVB4.getChildren().addAll(charLabel4, char4Btn);
        
        //Adding nodes to panes and setting alignment
        characterHB.getChildren().addAll(charVB1, charVB2, charVB3, charVB4);
        buttonHB.getChildren().addAll(newCharButton, mainMenuBtn);
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
    }


    public static void main(String[] args) {
        launch(args);
    }
}
