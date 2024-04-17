package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;



public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;
    private long startTimer = System.currentTimeMillis();
    private long endTimer = startTimer+20*1000;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        Obstacle obstacle1 = new Obstacle(20,20,60,60);
        Obstacle obstacle2 = new Obstacle(200,100,100,100);
        Obstacle obstacle3 = new Obstacle(150, 200, 80, 80);
        Obstacle obstacle4 = new Obstacle(300, 30, 80, 60);
        Obstacle obstacle5 = new Obstacle(100, 250, 120, 120);
        Obstacle obstacle6 = new Obstacle(250, 200, 60, 140);
        Obstacle obstacle7 = new Obstacle(400, 150, 80, 80);
        Obstacle obstacle8 = new Obstacle(50, 400, 100, 50);
        Obstacle obstacle9 = new Obstacle(200, 350, 150, 100);
        ArrayList<Obstacle> liste =  new ArrayList<>(Arrays.asList(obstacle1,obstacle2,obstacle3,obstacle4,obstacle5,obstacle6,obstacle7,obstacle8,obstacle9));
        Iterator<Obstacle> iter = liste.iterator();
        while(iter.hasNext()) {
            jeu.getChildren().add(iter.next());
        }
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome,liste);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene); 
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2, ArrayList<Obstacle> liste) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            if(System.currentTimeMillis()>endTimer){
                System.out.println("FIN DU JEU");
                System.exit(100);
            }
            double j1X = j1.getLayoutX();
            double j1Y = j1.getLayoutY();
            double j2X = j2.getLayoutX();
            double j2Y = j2.getLayoutY();
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;

            }
            if(j1.estEnCollision(j2)){
                System.out.println("Collision");
                System.exit(99);
            }
            for (Obstacle obstacle : liste) {
                if (j1.estEnCollisionAvecMur(obstacle)) {
                    j1.setLayoutX(j1X);
                    j1.setLayoutY(j1Y);
                    System.out.println("Collision détectée avec un obstacle !");
                    break;
                }
                if (j2.estEnCollisionAvecMur(obstacle)) {
                    j2.setLayoutX(j2X);
                    j2.setLayoutY(j2Y);
                    System.out.println("Collision détectée avec un obstacle !");
                    break;
                }
            }

        });
    }


}
