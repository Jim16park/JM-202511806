package pe.edu.upeu.repository;

import pe.edu.upeu.conn.SQLiteConnection;
import pe.edu.upeu.model.Infraccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InfraccionRepository {

    Connection conn = SQLiteConnection.getInstance().getConnection();

    Statement st;
    ResultSet rs;

    private static InfraccionRepository instance =
            new InfraccionRepository();

    public static InfraccionRepository getInstance(){

        if(instance == null){
            instance = new InfraccionRepository();
        }

        return instance;
    }

    List<Infraccion> infracciones = new ArrayList<>();

    // C = CREATE
    public void guardar(Infraccion i){

        String sql = """
                INSERT INTO infraccion
                (placa, infractor, fecha, tipo, monto, estado)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, i.getPlaca());
            ps.setString(2, i.getInfractor());
            ps.setString(3, i.getFecha());
            ps.setString(4, i.getTipo());
            ps.setDouble(5, i.getMonto());
            ps.setString(6, i.getEstado());

            ps.executeUpdate();

        } catch (Exception e){

            e.printStackTrace();
        }
    }

    // R = REPORT
    public List<Infraccion> listar(){

        infracciones.clear();

        try {

            st = conn.createStatement();

            rs = st.executeQuery("select * from infraccion");

            while(rs.next()){

                Infraccion i = new Infraccion(
                        rs.getString("placa"),
                        rs.getString("infractor"),
                        rs.getString("fecha"),
                        rs.getString("tipo"),
                        rs.getDouble("monto"),
                        rs.getString("estado")
                );

                infracciones.add(i);
            }

        } catch (Exception e){

            System.out.println(e.getMessage());
        }

        return infracciones;
    }

    // U = UPDATE
    public void actualizarEstado(String placa, String estado){

        String sql =
                "UPDATE infraccion SET estado = ? WHERE placa = ?";

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, estado);
            ps.setString(2, placa);

            ps.executeUpdate();

        } catch (Exception e){

            e.printStackTrace();
        }
    }

    // D = DELETE
    public void eliminar(String placa){

        String sql =
                "DELETE FROM infraccion WHERE placa = ?";

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, placa);

            ps.executeUpdate();

        } catch (Exception e){

            e.printStackTrace();
        }
    }

    // FILTRAR
    public List<Infraccion> filtrarPorEstado(String estado){

        List<Infraccion> lista = new ArrayList<>();

        try {

            String sql =
                    "SELECT * FROM infraccion WHERE estado = ?";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(1, estado);

            rs = ps.executeQuery();

            while(rs.next()){

                Infraccion i = new Infraccion(
                        rs.getString("placa"),
                        rs.getString("infractor"),
                        rs.getString("fecha"),
                        rs.getString("tipo"),
                        rs.getDouble("monto"),
                        rs.getString("estado")
                );

                lista.add(i);
            }

        } catch (Exception e){

            e.printStackTrace();
        }

        return lista;
    }

    public void eliminarTodo(){
        infracciones.clear();
    }

    public int getInfracciones(){
        return infracciones.size();
    }
}