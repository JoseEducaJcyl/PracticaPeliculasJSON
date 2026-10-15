package com.example.practicapeliculasjson;

import com.example.practicapeliculasjson.util.R;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {
    public static void main(String[] args) {

        Application.launch(Launcher.class, args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(R.getUI("peliculas_app.fxml"));
        Scene scene = new Scene(loader.load(), 639.0, 400.0);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
