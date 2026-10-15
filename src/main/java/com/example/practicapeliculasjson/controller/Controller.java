package com.example.practicapeliculasjson.controller;

import com.example.practicapeliculasjson.model.Pelicula;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    private final File archivoJson = new File("src/main/resources/datos/peliculas.json");

    private ArrayList<Pelicula> peliculas;

    @FXML
    private Button btImportar;

    @FXML
    private ListView<Pelicula> lvListaPeliculas;

    @FXML
    private TextField tfDirector;

    @FXML
    private TextField tfFecha;

    @FXML
    private TextField tfGenero;

    @FXML
    private TextField tfTitulo;


    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            peliculas =
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

    @FXML
    public void importarPelicula(Event event) {
        try {
            int idMax = 0;
            for (Pelicula p : peliculas){
                if (idMax < p.getId()){
                    idMax = p.getId() + 1;
                }
            }
            Pelicula peliculaNueva = new Pelicula();
            peliculaNueva.setId(idMax);
            peliculaNueva.setTitulo(tfTitulo.getText());
            peliculaNueva.setFecha(tfFecha.getText());
            peliculaNueva.setGenero(tfGenero.getText());
            peliculaNueva.setDirector(tfDirector.getText());

            peliculas.add(peliculaNueva);

            lvListaPeliculas.setItems(FXCollections.observableList(peliculas));

            JSON_MAPPER.writerWithDefaultPrettyPrinter().writeValue(archivoJson,
                    peliculas);

            tfTitulo.clear();
            tfFecha.clear();
            tfGenero.clear();
            tfDirector.clear();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
