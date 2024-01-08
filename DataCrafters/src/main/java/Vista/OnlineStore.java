

package Vista;
import Controlador.Controlador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class OnlineStore extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OnlineStore.class.getResource("/Pantallas/start-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setTitle("OnlineStore App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        try (Controlador controlador = new Controlador()) {
            GestionOS gestion = new GestionOS(controlador);
            gestion.inicio();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

