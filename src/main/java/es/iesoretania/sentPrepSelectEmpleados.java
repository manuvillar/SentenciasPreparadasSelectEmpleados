package es.iesoretania;
import java.sql.*;

public class sentPrepSelectEmpleados{
    public static void main(String[] args){
        
        //Recogemos los valores de los argumentos al programa.
        String dep = args[0];
        String oficio = args[1];
        
        try {
            Connection conexion = DriverManager.getConnection
            ("jdbc:mysql://localhost/practica","root", "practica");

            //construimos la orden INSERT
            String sql = "SELECT apellido, salario FROM empleados WHERE dept_no = ? AND oficio = ? ORDER BY 1";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, Integer.parseInt(dep));
            sentencia.setString(2, oficio);

            ResultSet rs = sentencia.executeQuery();
            while(rs.next())
                System.out.printf("%s => %.2f %n", rs.getString("apellido")
                    ,rs.getFloat("salario"));
            
            rs.close();
            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            System.out.println("ERROR: "+ e.getMessage());
        }
        


    }
}