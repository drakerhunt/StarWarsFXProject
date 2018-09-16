package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
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

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        int width = 500;
        int height = 450;
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

        HBox characterHB = new HBox(100);
        characterHB.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-padding: 10;" +
                "-fx-border-width: 3;" +
                "-fx-border-insets: 5;" +
                "-fx-border-color: black;");
        characterHB.setMaxWidth(500);
        characterHB.setMaxHeight(450);

        //Character Buttons
        Button char1, char2, char3, char4 = new Button("New Character");

        //Stats Labels
        Label charLabel1 = new Label("Empty");
        Label charLabel2 = new Label("Empty");
        Label charLabel3 = new Label("Empty");
        Label charLabel4 = new Label("Empty");

        //Adding nodes to panes and setting alignment
        characterHB.getChildren().addAll(charLabel1, charLabel2, charLabel3, charLabel4);

        pane.setTop(titlePane);
        pane.setCenter(characterHB);
        characterHB.setAlignment(Pos.CENTER);
       // mainVB.getChildren().addAll(titlePane, characterHB);

        //Set Scene
        Scene mainScene = new Scene(pane, width, height);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Star Wars GM Helper");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
