package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage){  // Création du conteneur principal
    VBox vbox = new VBox();


    // Création du conteneur correspondant à la ligne de contrôle haut dessus du tableau
    HBox topBar= new HBox();
    Menu File = new Menu("File");
    MenuItem New = new MenuItem("New");
    MenuItem Open = new MenuItem("Open");
    MenuItem Save = new MenuItem("Save");
    MenuItem Close = new MenuItem("Close");
    MenuItem Cut = new MenuItem("Cut");
    MenuItem Copy = new MenuItem("Copy");
    MenuItem Paste = new MenuItem("Paste");
    File.getItems().add(New);
    File.getItems().add(Open);
    File.getItems().add(Save);
    File.getItems().add(Close);
    Menu Edit = new Menu("Edit");
    Edit.getItems().add(Cut);
    Edit.getItems().add(Copy);
    Edit.getItems().add(Paste);
    Menu Help = new Menu("Help");
    MenuBar barre = new MenuBar();
    barre.getMenus().add(File);
    barre.getMenus().add(Edit);
    barre.getMenus().add(Help);
    topBar.getChildren().add(barre);
    vbox.getChildren().add(topBar);
    HBox.setHgrow(barre,Priority.ALWAYS);

    HBox mid = new HBox();
    vbox.getChildren().add(mid);
    VBox VertBouton = new VBox();
    mid.getChildren().add(VertBouton);
    Label Texte = new Label("Boutons :");
    VertBouton.getChildren().add(Texte);
    Button B1 = new Button("Bouton 1");
    Button B2= new Button("Bouton 2");
    Button B3 = new Button("Bouton 3");
    VertBouton.getChildren().add(B1);
    VertBouton.getChildren().add(B2);
    VertBouton.getChildren().add(B3);
    VertBouton.setSpacing(10);
    VertBouton.setAlignment(Pos.BASELINE_CENTER);

    GridPane Form = new GridPane();
    Form.add(new Label("Name :"),0,0);
    Form.add(new Label("Email :"),0,1);
    Form.add(new Label("Password :"),0,2);

    Form.add(new TextField(),1,0);
    Form.add(new TextField(),1,1);
    Form.add(new TextField(),1,2);
    mid.getChildren().add(Form);


    Button Submit = new Button("Submit");
    Button Cancel = new Button("Cancel");
    HBox BoxB = new HBox();
    BoxB.getChildren().addAll(Submit,Cancel);
    BoxB.setSpacing(5);
    VBox Middle = new VBox(Form,BoxB);
    mid.setAlignment(Pos.CENTER);
    HBox.setHgrow(Middle,Priority.ALWAYS);
    Middle.setAlignment(Pos.CENTER);
    mid.getChildren().add(Middle);

    Label label = new Label("Ceci est un label de bas de page");
    HBox BoxL = new HBox();
    vbox.getChildren().add(BoxL);
    BoxL.getChildren().add(label);
    BoxL.setAlignment(Pos.BOTTOM_CENTER);


    // Ajout du conteneur à la scene
    Scene scene = new Scene(vbox );

    // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

    // Affichage de la fenêtre
        primaryStage.show();
}

    public static void main(String[] args) {
        launch(args);

    }
}

