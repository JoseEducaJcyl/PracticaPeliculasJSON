package com.example.practicapeliculasjson.model;

public class Pelicula {
    private int id;
    private String titulo;
    private String fecha;
    private String director;
    private String genero;

    public Pelicula() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        /*

         */
        return "ID: " + id + "\nTitulo: " + titulo +
                "\nFecha: " + fecha +
                "\nDirector: " + director +
                "\nGenero: "+ genero;
    }
}
