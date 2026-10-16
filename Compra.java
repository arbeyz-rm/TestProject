import java.util.ArrayList;

public class Compra {
    private Usuario usuario;
    private ArrayList<Libro> libros;
    private ArrayList<Integer> unidades;
    private ArrayList<Bodega> bodegas;
    private double total;

    public Compra(Usuario usuario, ArrayList<Libro> libros, ArrayList<Integer> unidades) {
        this.usuario = usuario;
        this.libros = libros;
        this.unidades = unidades;
        this.bodegas = new ArrayList<>();
        double suma = 0;
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            suma += libro.getPrecio() * unidades.get(i);
            for (Bodega bodega : libro.getBodegas()) {
                if (!bodegas.contains(bodega)) {
                    bodegas.add(bodega);
                }
            }
        }
        this.total = suma;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public ArrayList<Integer> getUnidades() {
        return unidades;
    }

    public ArrayList<Bodega> getBodegas() {
        return bodegas;
    }

    public double getTotal() {
        return total;
    }
}
