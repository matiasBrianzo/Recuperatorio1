package usuario.example.recuperatorio1.modelo;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private String titulo;
    private String duracion;
    private String director;
    private String year;

    public Pelicula(String titulo, String duracion, String director, String year) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.director = director;
        this.year = year;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
