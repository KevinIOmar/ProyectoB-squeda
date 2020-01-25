/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


import Logica.ACatributos;
import Logica.Cuenta;
import Presentacion.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Consulta {
    DConexion con=new DConexion();
    Connection cn=con.ConectarDB();
            
            public DefaultTableModel mostrarUsuarios()
            {
                try{
                    DefaultTableModel modelo;
                    String tit[]={"ID","Nombre","Apellido","Telefono","Ciudad"};
                    String datos[]=new String[5];
                    modelo=new DefaultTableModel(null,tit);
                    String sql="select * from usu";
                    PreparedStatement pst=cn.prepareStatement(sql);
                    ResultSet rt=pst.executeQuery();
                    while(rt.next())
                    {
                        datos[0]=rt.getString("ID");
                        datos[1]=rt.getString("Nombre");
                        datos[2]=rt.getString("Apellido");
                        datos[3]=rt.getString("Telefono");
                        datos[4]=rt.getString("Ciudad");
                        modelo.addRow(datos);
                    }
                    return modelo;
                }
                catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                    return null;
                }
            }
            
            public int Cuenta(String nomb,String clave)
            {
                try{
                    String queryOb= "select * from cuenta where Usuario='"+nomb+"' and Clave='"+clave+"'";
                    PreparedStatement st=cn.prepareStatement(queryOb);
                    ResultSet rt=st.executeQuery();
                    int result=0;
                    while(rt.next())
                    {
                        result=1;
                    }
                    return result;
                }catch(SQLException ex){

                    //JOptionPane.showMessageDialog(null, ex);
                    return 0;
                }
                
            }
            
            /* public ResultSet Obtener()
            {
            try{
            String queryOb= "select * from usu";
            Statement st=cn.createStatement();
            return st.executeQuery(queryOb);
            }
            catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
            
            }
            return null;
            }*/
            public DefaultTableModel Buscar(String bus)
            {
                int i=2;
                Principal aviso=new Principal();
                try{
                    DefaultTableModel miModelo;
                    String titulos[]={"ID","Nombre","Apellido","Telefono","Ciudad"};
                    String datos[]=new String[5];
                    miModelo=new DefaultTableModel(null,titulos);
                    String queryOb="select * from usu where ID='"+bus+"' or Nombre='"+bus+"' "
                            + "or Apellido='"+bus+"' or Telefono='"+bus+"' "
                            + "or Ciudad='"+bus+"'";
                    
                    PreparedStatement pst=cn.prepareStatement(queryOb);
                    ResultSet rt=pst.executeQuery();
                    
                    while(rt.next())
                    {
                        datos[0]=rt.getString("ID");
                        datos[1]=rt.getString("Nombre");
                        datos[2]=rt.getString("Apellido");
                        datos[3]=rt.getString("Telefono");
                        datos[4]=rt.getString("Ciudad");
                        miModelo.addRow(datos);
                    }
                  
                    return miModelo;
                }
                catch(SQLException ex){

                    JOptionPane.showMessageDialog(null, ex);
                    return null;
                }
                
            }
                    
           public String AgregarCliente(ACatributos misAtributos)
           {
               try{
                   String sql="insert into usu(Nombre,Apellido,Telefono,Ciudad) values('"+misAtributos.getNombre()+"',"
                           + "'"+misAtributos.getApellido()+"',"
                           + "'"+misAtributos.getTelefono()+"',"
                           + "'"+misAtributos.getCiudad()+"')";
                   
                   Statement st=cn.createStatement();
                   
                   st.executeUpdate(sql);
                   
                   return "Se registro con exito";
               }
               catch(SQLException ex)
               {
                   JOptionPane.showMessageDialog(null,ex);
                   return "Ocurrio un problema al Incertar";
               }
               
           }
           public String Editar(ACatributos atr)
           {
               try{
                   String sql="update usu set  Nombre=?,Apellido=?,Telefono='"+atr.getTelefono()+"',Ciudad='"+atr.getCiudad()+"' where ID=?";
                   PreparedStatement ps=cn.prepareStatement(sql);
                   
                 
                   ps.setString(1,atr.getNombre());
                   ps.setString(2,atr.getApellido());
                   //ps.setString(3,atr.getTelefono());
                   //ps.setString(4,atr.getCiudad());
                   ps.setInt(3, atr.getID());
                   ps.executeUpdate();
                   
                   return "Se actualizo de forma correcta";
               }
               catch(SQLException ex)
               {
                   JOptionPane.showMessageDialog(null, ex);
                   return "Ocurrio un problema al editar datos";
               }
           }
           public String Eliminar(ACatributos atr)
           {
                try{
                    String sql="delete from usu where ID=? and Nombre=? and Apellido=? and Telefono=? and Ciudad=? ";
                    PreparedStatement ps=cn.prepareStatement(sql);
                    ps.setInt(1,atr.getID());
                    ps.setString(2,atr.getNombre());
                    ps.setString(3, atr.getApellido());
                    ps.setString(4, atr.getTelefono());
                    ps.setString(5, atr.getCiudad());
                    
                    ps.executeUpdate();
               
                    return "Se elimino de forma correcta";
                }
                catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                    return "Error al tratar de eliminar";
                }
           }
}
