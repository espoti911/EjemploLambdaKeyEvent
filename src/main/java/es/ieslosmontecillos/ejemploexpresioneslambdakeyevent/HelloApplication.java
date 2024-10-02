package es.ieslosmontecillos.ejemploexpresioneslambdakeyevent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application
{
    //Cantidad de "distancia" que se movera el texto cuando se pulse alguna flecha
    public static final int MOVE_AMOUNT = 10;

    @Override
    public void start(Stage stage)
    {
        Pane pane = new Pane();
        Text text = new Text(20, 20,"A");

        //Eventos ejecutados cuando se presiona una tecla
        text.setOnKeyPressed(event -> {
            System.out.println("Key pressed: " + event.getCode());

            switch (event.getCode())
            {
                case UP:
                    text.setY(text.getY() - MOVE_AMOUNT);
                    break;

                case DOWN:
                    text.setY(text.getY() + MOVE_AMOUNT);
                    break;

                case LEFT:
                    text.setX(text.getX() - MOVE_AMOUNT);
                    break;

                case RIGHT:
                    text.setX(text.getX() + MOVE_AMOUNT);
                    break;

                default:
                    String letra = event.getCode().getChar();
                    //Nos aseguramos que la tecla introducida sea letra o numero
                    if (!letra.matches("[A-z]") && !letra.matches("[0-9]")) break;
                    text.setText(letra);
                    break;
            }
        });

        pane.getChildren().add(text);
        Scene scene = new Scene(pane, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        //Necesario para que el texto reciba los eventos
        text.requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }
}