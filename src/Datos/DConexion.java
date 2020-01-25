
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DConexion {
    public DConexion()
    {
        
    }
    public Connection ConectarDB()
    {
        Connection miConexion=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/lista","kevin","botcasa2001");
            

        }catch(ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        return miConexion;
        
    }
    
}
