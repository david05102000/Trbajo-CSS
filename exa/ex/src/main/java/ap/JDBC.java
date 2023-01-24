package ap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JDBC {
    private static final String Usuaio= "root";
    private static final String Contraseña= "";
    private static final String Dbnombre= "jdbc:mysql://localhost:3306/examenjdbc";
    private static final String Driver= "com.mysql.cj.jdbc.Driver";

    public static Connection conectar() throws SQLException, ClassNotFoundException {
        Connection con=null;
        Class.forName(Driver);
        con = DriverManager.getConnection(Dbnombre,Usuaio,Contraseña);
        return con;
    }
    public static void insertC(List<Ciclo>data){
        data.forEach(c ->{
                    try (Connection con = conectar()){
                        PreparedStatement insert = con.prepareStatement("INSERT INTO ciclo(CODIGO, NOMBRE) values(?,?)");
                        insert.setInt(1,c.getCodigo());
                        insert.setString(2,c.getNombre());
                        insert.execute();

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println("Se ha producido un error en la insercion.");
                    }
                }
                );
    }
    public static void insertA(List<Asignatura>data){
        data.forEach(a ->{
                    try (Connection con = conectar()){
                        PreparedStatement insert = con.prepareStatement("INSERT INTO asignatura(CODIGO, NOMBRE, IDCICLO) values(?,?,?)");
                        insert.setInt(1,a.getCodigo());
                        insert.setString(2,a.getNombre());
                        insert.setInt(3,a.getCodCiclo());
                        insert.execute();

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println("Se ha producido un error en la insercion.");
                    }
                }
        );
    }
}
