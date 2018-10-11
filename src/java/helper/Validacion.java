package helper;

import connection.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Emmnanuel
 */
public class Validacion extends Conexion {

    public Validacion() {

    }

    public boolean transferirCapacitacion() {
        int Id;

        try {
            //Querys
            String selectUltCapacitacion = "SELECT Id FROM capacitaciones ORDER BY id DESC LIMIT 1;";
            String updateCandidato = "UPDATE candidatos SET Capacitaciones = ? ORDER BY id DESC LIMIT 1;";

            //st and rs para el select
            Statement stSelect = getConexion()
                    .createStatement();

            ResultSet rs = stSelect
                    .executeQuery(selectUltCapacitacion);

            //para el update
            PreparedStatement psUpdate = getConexion()
                    .prepareStatement(updateCandidato);

            while (rs.next()) {
                //select
                Id = rs.getInt("Id");

                //update
                psUpdate.setInt(1, Id);
                psUpdate.executeUpdate();
            }
            return true;

        } catch (SQLException e) {
            System.out.println("Hay una serpiente en mi bota " + e);
        }
        return false;
    }

    public boolean transferirExperiencialaboral() {
        int Id;

        try {
            //Querys
            String selectUltExperiencia = "SELECT Id FROM experiencia_laboral ORDER BY id DESC LIMIT 1";
            String updateCandidato = "UPDATE candidatos SET Experiencia_Laboral = ? ORDER BY id DESC LIMIT 1";

            //st and rs para el select
            Statement stSelect = getConexion()
                    .createStatement();

            ResultSet rs = stSelect
                    .executeQuery(selectUltExperiencia);

            //para el update
            PreparedStatement psUpdate = getConexion()
                    .prepareStatement(updateCandidato);

            while (rs.next()) {
                //select
                Id = rs.getInt("Id");

                //update
                psUpdate.setInt(1, Id);
                psUpdate.executeUpdate();
            }
            return true;

        } catch (SQLException e) {
            System.out.println("Hay una serpiente en mi bota " + e);
        }
        return false;
    }

    public boolean transferirCandidato(int id) {

        int status = 0;

        String Cedula = null;
        String Nombre = null;
        double Salario_Mensual;
        int Puesto;

        try {
            //Querys
            String SelectCandidato = "SELECT `candidatos`.`Cedula`,`candidatos`.`Nombre`, `candidatos`.`Salario_Aspira`,`candidatos`.`Puesto_Aspira` FROM `srsdb`.`candidatos` WHERE `candidatos`.`Id` = '" + id + "'";
            String InsertEmpleado = "INSERT INTO `srsdb`.`empleado` (`Cedula`,`Nombre`,`Salario_Mensual`,`Puesto`) VALUES (?,?,?,?)";
            String DeleteCandidato = "DELETE FROM candidatos WHERE candidatos.Id = ?";

            Statement st = getConexion()
                    .createStatement();

            ResultSet rs = st.executeQuery(SelectCandidato);

            PreparedStatement ps = getConexion()
                    .prepareStatement(InsertEmpleado);

            PreparedStatement psDelete = getConexion().prepareStatement(DeleteCandidato);

            while (rs.next()) {

                //DEL SELECT
                Cedula = rs.getString("Cedula");
                Nombre = rs.getString("Nombre");
                Salario_Mensual = rs.getDouble("Salario_Aspira");
                Puesto = rs.getInt("Puesto_Aspira");

                //DEL INSERT
                ps.setString(1, Cedula);
                ps.setString(2, Nombre);
                ps.setDouble(3, Salario_Mensual);
                ps.setInt(4, Puesto);
                status = ps.executeUpdate();

                //DELETE
                psDelete.setInt(1, id);
                psDelete.executeUpdate();

            }
            return true;

        } catch (SQLException e) {
            System.out.println("Hay una serpiente en mi bota " + e);
        }

        return false;
    }

    public boolean iniciarSesion(String email, String contrasena) {
        PreparedStatement Validacion = null;
        ResultSet Result = null;

        String SentenciaSQL
                = "SELECT `usuario`.`Id`,`usuario`.`email`, `usuario`.`contrasena`, `usuario`.`Rol` FROM `srsdb`.`usuario` WHERE `usuario`.`email` = ? AND `usuario`.`contrasena` = ?;";
        try {
            Validacion = getConexion().prepareStatement(SentenciaSQL);
            Validacion.setString(1, email);
            Validacion.setString(2, contrasena);
            Result = Validacion.executeQuery();

            if (Result.absolute(1)) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar el usuario" + e);

        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (Validacion != null) {
                    Validacion.close();
                }
                if (Result != null) {
                    Result.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Validacion vali = new Validacion();
        System.out.println(vali.transferirCapacitacion());
    }
}
