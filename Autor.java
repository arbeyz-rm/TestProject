import java.util.ArrayList;

public class Autor extends Persona {
    private ArrayList<Libro> libros;

    public Autor(int id, String nombre, int telefono, String direccion) {
        super(id, nombre, telefono, direccion);
        this.libros = new ArrayList<>();
    }

    public void addLibro(Libro libro) {
        if (!libros.contains(libro)) {
            libros.add(libro);
        }
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
}
