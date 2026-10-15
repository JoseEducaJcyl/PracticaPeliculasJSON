package com.example.practicapeliculasjson.cotroller;

import com.example.practicapeliculasjson.model.Pelicula;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    @FXML
    private Label welcomeText;

    @FXML
    private ListView<Pelicula> lvListaPeliculas;


    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            ArrayList<Pelicula> peliculas =
                    JSON_MAPPER.readValue(new File("src/main/resources/datos/peliculas.json"),
                            JSON_MAPPER.getTypeFactory().constructCollectionType
                                    (ArrayList.class, Pelicula.class));
            cargarDatosPeliculas(peliculas);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void cargarDatosPeliculas(ArrayList<Pelicula> peliculas){
        lvListaPeliculas.setItems(FXCollections.observableList(peliculas));
    }
}
