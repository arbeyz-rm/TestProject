import java.time.LocalDateTime;
import java.util.ArrayList;

public class Usuario extends Persona {
    private ArrayList<Compra> compras;
    private ArrayList<Evaluacion> evaluaciones;

    public Usuario(int id, String nombre, int telefono, String direccion) {
        super(id, nombre, telefono, direccion);
        this.compras = new ArrayList<>();
        this.evaluaciones = new ArrayList<>();
    }

    public void addCompra(Compra compra) {
        compras.add(compra);
    }

    public void makeEvaluacion(Libro libro, LocalDateTime fecha, int estrellas, String comentario) {
        Evaluacion evaluacion = new Evaluacion(this, libro, fecha, estrellas, comentario);
        evaluaciones.add(evaluacion);
        libro.addEvaluacion(evaluacion);
    }

    public void like(Evaluacion evaluacion) {
        evaluacion.addLike();
    }

    public void dislike(Evaluacion evaluacion) {
        evaluacion.addDislike();
    }

    public Evaluacion getEvaluacion(int index) {
        return evaluaciones.get(index);
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public double getMayorCompra() {
        double max = 0;
        for (Compra compra : compras) {
            if (compra.getTotal() > max) {
                max = compra.getTotal();
            }
        }
        return max;
    }

    public int getTotalLikes() {
        int total = 0;
        for (Evaluacion e : evaluaciones) {
            total += e.getLikes();
        }
        return total;
    }

    public int getTotalDislikes() {
        int total = 0;
        for (Evaluacion e : evaluaciones) {
            total += e.getDislikes();
        }
        return total;
    }
}
