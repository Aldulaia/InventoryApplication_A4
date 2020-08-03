package aldulaia;

import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Altaher Al-Dulaimi
 */
public class Assign4 extends Application {

    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Assign4FXML.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Lab 4 S16");
        stage.show();
    }

}
