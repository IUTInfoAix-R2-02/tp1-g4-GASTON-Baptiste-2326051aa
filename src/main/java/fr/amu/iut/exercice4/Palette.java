package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.label = new Label("choisi");
        this.label.setFont(Font.font("Courier", FontWeight.NORMAL,25));
        this.panneau = new Pane();
        this.vert = new Button("Vert");
        this.rouge = new Button("Rouge");
        this.bleu = new Button("Bleu");
        this.bas = new HBox(rouge,vert,bleu);
        this.bas.setAlignment(Pos.CENTER);
        this.bas.setPadding(new Insets(10));
        HBox haut = new HBox(label);
        haut.setAlignment(Pos.CENTER);


        this.bas.setSpacing(5);

        this.rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            this.nbRouge+=1;
            this.label.setText( rouge.getText() + " choisi "+ nbRouge +" fois ");
            this.panneau.setStyle("-fx-background-color: #F00");
        });

        this.vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            this.nbVert+=1;
            this.label.setText( vert.getText() + " choisi "+ nbVert +" fois ");
            this.panneau.setStyle("-fx-background-color: #0F0");
        });

        this.bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            this.nbBleu+=1;
            this.label.setText( bleu.getText() + " choisi "+ nbBleu +" fois ");
            this.panneau.setStyle("-fx-background-color: #00F");
        });

        this.root = new BorderPane();
        this.root.setPrefSize(400.0,200.0);
        this.root.setTop(haut);
        this.root.setCenter(panneau);
        this.root.setBottom(bas);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(400.0);
        primaryStage.setHeight(400.0);
        primaryStage.show();
    }
}

