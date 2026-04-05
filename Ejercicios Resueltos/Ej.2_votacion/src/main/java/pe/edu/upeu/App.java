package pe.edu.upeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class App {


        static class SistemaVotacion {
            private ArrayList<String> votos;


            public SistemaVotacion() {
                votos = new ArrayList<>();
            }


            public void votar(String candidato) {
                votos.add(candidato);
                System.out.println("Voto registrado para: " + candidato);
            }


            public int contarVotosPorCandidato(String candidato) {
                return Collections.frequency(votos, candidato);
            }


            public String obtenerGanador() {
                if (votos.isEmpty()) {
                    return "No hay votos registrados.";
                }

                ArrayList<String> candidatosUnicos = new ArrayList<>(new HashSet<>(votos));
                String ganador = candidatosUnicos.get(0);
                int maxVotos = contarVotosPorCandidato(ganador);

                for (String candidato : candidatosUnicos) {
                    int votosCandidato = contarVotosPorCandidato(candidato);
                    if (votosCandidato > maxVotos) {
                        maxVotos = votosCandidato;
                        ganador = candidato;
                    }
                }

                return ganador;
            }


            public void mostrarResultadosConPorcentaje() {
                if (votos.isEmpty()) {
                    System.out.println("No hay votos registrados.");
                    return;
                }

                ArrayList<String> candidatosUnicos = new ArrayList<>(new HashSet<>(votos));
                int totalVotos = votos.size();

                System.out.println("\n--- RESULTADOS DE LA VOTACIÓN ---");
                for (String candidato : candidatosUnicos) {
                    int cantidad = contarVotosPorCandidato(candidato);
                    double porcentaje = (cantidad * 100.0) / totalVotos;

                    System.out.println(candidato + ": " + cantidad + " votos (" + porcentaje + "%)");
                }
            }


            public void detectarEmpates() {
                if (votos.isEmpty()) {
                    System.out.println("No hay votos registrados.");
                    return;
                }

                ArrayList<String> candidatosUnicos = new ArrayList<>(new HashSet<>(votos));
                int maxVotos = 0;


                for (String candidato : candidatosUnicos) {
                    int cantidad = contarVotosPorCandidato(candidato);
                    if (cantidad > maxVotos) {
                        maxVotos = cantidad;
                    }
                }


                ArrayList<String> empatados = new ArrayList<>();
                for (String candidato : candidatosUnicos) {
                    if (contarVotosPorCandidato(candidato) == maxVotos) {
                        empatados.add(candidato);
                    }
                }

                if (empatados.size() > 1) {
                    System.out.println("Hay empate entre: " + empatados + " con " + maxVotos + " votos.");
                } else {
                    System.out.println("No hay empate. Ganador: " + empatados.get(0));
                }
            }


            public void mostrarVotos() {
                System.out.println("Votos registrados: " + votos);
            }
        }


        public static void main(String[] args) {
            SistemaVotacion sistema = new SistemaVotacion();

            sistema.votar("Candidato A");
            sistema.votar("Candidato B");
            sistema.votar("Candidato A");
            sistema.votar("Candidato C");
            sistema.votar("Candidato B");
            sistema.votar("Candidato A");

            sistema.mostrarVotos();

            System.out.println("\nVotos de Candidato A: " + sistema.contarVotosPorCandidato("Candidato A"));
            System.out.println("Ganador: " + sistema.obtenerGanador());

            sistema.mostrarResultadosConPorcentaje();
            sistema.detectarEmpates();
        }
    }
