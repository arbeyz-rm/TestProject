import java.util.ArrayList;

public class Bodega {
    private double latitud;
    private double longitud;
    private ArrayList<Libro> libros;
    private ArrayList<Integer> existencias;

    public Bodega(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.libros = new ArrayList<>();
        this.existencias = new ArrayList<>();
    }

    public void addExistencias(Libro libro, int cantidad) {
        int index = libros.indexOf(libro);
        if (index >= 0) {
            existencias.set(index, existencias.get(index) + cantidad);
        } else {
            libros.add(libro);
            existencias.add(cantidad);
            libro.addBodega(this);
        }
    }

    public int getExistencias(Libro libro) {
        int index = libros.indexOf(libro);
        return index >= 0 ? existencias.get(index) : 0;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public ArrayList<Integer> getExistencias() {
        return existencias;
    }
}
