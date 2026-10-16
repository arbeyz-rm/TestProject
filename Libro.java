import java.util.ArrayList;

public class Libro {
    private int id;
    private String titulo;
    private ArrayList<Autor> autores;
    private String editorial;
    private ArrayList<Integer> ediciones;
    private String isbn;
    private String caracteristicas;
    private Genero genero;
    private double precio;
    private ArrayList<Bodega> bodegas;
    private ArrayList<Evaluacion> evaluaciones;

    public Libro(int id, String titulo, ArrayList<Autor> autores, String editorial, ArrayList<Integer> ediciones,
                 String isbn, String caracteristicas, Genero genero, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.ediciones = ediciones;
        this.isbn = isbn;
        this.caracteristicas = caracteristicas;
        this.genero = genero;
        this.precio = precio;
        this.bodegas = new ArrayList<>();
        this.evaluaciones = new ArrayList<>();
        for (Autor autor : autores) {
            autor.addLibro(this);
        }
    }

    public void addBodega(Bodega bodega) {
        if (!bodegas.contains(bodega)) {
            bodegas.add(bodega);
        }
    }

    public void addEvaluacion(Evaluacion evaluacion) {
        evaluaciones.add(evaluacion);
    }

    public double getPromedioEstrellas() {
        if (evaluaciones.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Evaluacion e : evaluaciones) {
            suma += e.getEstrellas();
        }
        return suma / evaluaciones.size();
    }

    public int getTotalExistencias() {
        int total = 0;
        for (Bodega b : bodegas) {
            total += b.getExistencias(this);
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public ArrayList<Integer> getEdiciones() {
        return ediciones;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public Genero getGenero() {
        return genero;
    }

    public double getPrecio() {
        return precio;
    }

    public ArrayList<Bodega> getBodegas() {
        return bodegas;
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }
}
