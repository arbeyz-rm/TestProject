import java.time.LocalDateTime;

public class Evaluacion {
    private Usuario autor;
    private Libro libro;
    private LocalDateTime fecha;
    private int estrellas;
    private String comentario;
    private int likes;
    private int dislikes;

    public Evaluacion(Usuario autor, Libro libro, LocalDateTime fecha, int estrellas, String comentario) {
        this.autor = autor;
        this.libro = libro;
        this.fecha = fecha;
        this.estrellas = estrellas;
        this.comentario = comentario;
        this.likes = 0;
        this.dislikes = 0;
    }

    public void addLike() {
        likes++;
    }

    public void addDislike() {
        dislikes++;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public String getComentario() {
        return comentario;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }
}
