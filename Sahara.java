import java.util.ArrayList;
import java.util.Locale;

public class Sahara {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Libro> libros;
    private ArrayList<Bodega> bodegas;
    private ArrayList<Compra> compras;

    public Sahara() {
        this.usuarios = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.bodegas = new ArrayList<>();
        this.compras = new ArrayList<>();
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void addLibro(Libro libro) {
        libros.add(libro);
    }

    public void addBodega(Bodega bodega) {
        bodegas.add(bodega);
    }

    public void addCompra(Usuario usuario, ArrayList<Libro> librosCompra, ArrayList<Integer> unidadesCompra) {
        Compra compra = new Compra(usuario, librosCompra, unidadesCompra);
        compras.add(compra);
        usuario.addCompra(compra);
    }

    public Usuario getUsuario(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public Libro getLibro(int id) {
        for (Libro l : libros) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    public Bodega getBodega(int index) {
        return bodegas.get(index);
    }

    public void showLibroMayorPromedioEstrellasEvaluacion() {
        Libro mejor = null;
        for (Libro l : libros) {
            if (mejor == null || l.getPromedioEstrellas() > mejor.getPromedioEstrellas()) {
                mejor = l;
            }
        }
        if (mejor == null) {
            return;
        }
        System.out.println("La informacion del libro que tiene el mayor promedio en estrellas de sus evaluaciones es:");
        System.out.println("- ID: " + mejor.getId());
        System.out.println("- Titulo: " + mejor.getTitulo());
        System.out.println("- Autores: " + mejor.getAutores());
        System.out.println("- Editorial: " + mejor.getEditorial());
        System.out.println("- Ediciones: " + mejor.getEdiciones());
        System.out.println("- ISBN: " + mejor.getIsbn());
        System.out.println("- Caracteristicas: " + mejor.getCaracteristicas());
        System.out.println("- Genero: " + mejor.getGenero());
        System.out.println("- Precio: $" + String.format(Locale.US, "%.2f", mejor.getPrecio()));
        System.out.println("- Numero de Bodegas: " + mejor.getBodegas().size());
        System.out.println("- Total de Existencias: " + mejor.getTotalExistencias());
        System.out.println("- Numero de Evaluaciones: " + mejor.getEvaluaciones().size());
        System.out.println("- Estrellas Promedio: " + String.format(Locale.US, "%.2f", mejor.getPromedioEstrellas()));
        System.out.println();
    }

    public void showUsuarioMaxCompra() {
        Usuario mejor = null;
        for (Usuario u : usuarios) {
            if (mejor == null || u.getMayorCompra() > mejor.getMayorCompra()) {
                mejor = u;
            }
        }
        if (mejor == null) {
            return;
        }
        System.out.println("La informacion del usuario que registro la mayor compra es:");
        printUsuario(mejor);
        System.out.println("- Mayor Compra: $" + String.format(Locale.US, "%.2f", mejor.getMayorCompra()));
        System.out.println();
    }

    public void showUsuarioMaxLikes() {
        Usuario mejor = null;
        for (Usuario u : usuarios) {
            if (mejor == null || u.getTotalLikes() > mejor.getTotalLikes()) {
                mejor = u;
            }
        }
        if (mejor == null) {
            return;
        }
        System.out.println("La informacion del usuario que tiene el mayor numero de likes en todas sus evaluaciones es:");
        printUsuario(mejor);
        System.out.println("- Numero de Likes: " + mejor.getTotalLikes());
        System.out.println();
    }

    public void showUsuarioMaxDislikes() {
        Usuario mejor = null;
        for (Usuario u : usuarios) {
            if (mejor == null || u.getTotalDislikes() > mejor.getTotalDislikes()) {
                mejor = u;
            }
        }
        if (mejor == null) {
            return;
        }
        System.out.println("La informacion del usuario que tiene el mayor numero de dislikes en todas sus evaluaciones es:");
        printUsuario(mejor);
        System.out.println("- Numero de Dislikes: " + mejor.getTotalDislikes());
        System.out.println();
    }

    private void printUsuario(Usuario u) {
        System.out.println("- ID: " + u.getId());
        System.out.println("- Nombre: " + u.getNombre());
        System.out.println("- Telefono: " + u.getTelefono());
        System.out.println("- Direccion: " + u.getDireccion());
        System.out.println("- Numero de Compras: " + u.getCompras().size());
        System.out.println("- Numero de Evaluaciones: " + u.getEvaluaciones().size());
    }
}
