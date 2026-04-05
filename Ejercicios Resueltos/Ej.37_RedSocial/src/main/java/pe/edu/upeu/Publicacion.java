package pe.edu.upeu;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Publicacion {
    private String autor;
    private String contenido;
    private ArrayList<Comentario> comentarios = new ArrayList<>();


    public Publicacion(String autor, String contenido) {
        this.autor = autor;
        this.contenido = contenido;
    }


    class Comentario {
        private String texto;
        private String autorComentario;
        private LocalDateTime fecha;

        public Comentario(String texto, String autorComentario) {
            this.texto = texto;
            this.autorComentario = autorComentario;
            this.fecha = LocalDateTime.now();
        }

        public void mostrarComentario() {
            System.out.println("Comentario de " + autorComentario + ": " + texto);
            System.out.println("Fecha: " + fecha);
        }

        public void notificarAutor() {
            System.out.println("Notificar a " + Publicacion.this.autor +
                    ": Nuevo comentario en tu publicación.");
        }
    }



    public void agregarComentario(String texto, String autorComentario) {
        Comentario nuevo = new Comentario(texto, autorComentario);
        comentarios.add(nuevo);
        System.out.println("Comentario agregado correctamente.");
        nuevo.notificarAutor();
    }

    public void eliminarComentario(int indice) {
        if (indice >= 0 && indice < comentarios.size()) {
            comentarios.remove(indice);
            System.out.println("Comentario eliminado correctamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public int contarComentarios() {
        return comentarios.size();
    }

    public void mostrarPublicacion() {
        System.out.println("\n=== PUBLICACIÓN ===");
        System.out.println("Autor: " + autor);
        System.out.println("Contenido: " + contenido);
        System.out.println("Cantidad de comentarios: " + contarComentarios());

        System.out.println("\n--- COMENTARIOS ---");
        if (comentarios.isEmpty()) {
            System.out.println("No hay comentarios.");
        } else {
            for (int i = 0; i < comentarios.size(); i++) {
                System.out.println("Comentario #" + (i + 1));
                comentarios.get(i).mostrarComentario();
                System.out.println("----------------------");
            }
        }
    }

 
    public static void main(String[] args) {
        Publicacion pub1 = new Publicacion("Jimena Lupaca", "Hoy aprendí clases internas en Java 😄");

        pub1.mostrarPublicacion();

        pub1.agregarComentario("¡Qué interesante publicación!", "Ana");
        pub1.agregarComentario("Muy buen tema 🔥", "Carlos");
        pub1.agregarComentario("Java está potente 😎", "Lucía");

        pub1.mostrarPublicacion();

        pub1.eliminarComentario(1); // elimina el segundo comentario

        pub1.mostrarPublicacion();
    }
}