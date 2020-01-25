/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.Consulta;
import Logica.ACatributos;
import java.awt.event.*;

//import java.sql.ResultSet;
//import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class Principal extends JFrame{

    private final JLabel lblBuscar;
    private final JLabel lblCiudad;
    private final JLabel lblNombre;
    private final JLabel lblApellido;
    private final JLabel lblID;
    
    private final JLabel lblTelefono;
    
    
    private final JTextField txtCiudad;
    private final JTextField txtBuscar;
    private final JTextField txtTelefono;
    private final JTextField txtNombre;
    private final JTextField txtApellido;
    private final JTextField txtID;
    
    private final JButton btnBuscar;
    private final JButton btnGuardar;
    private final JButton btnActualizar;
    private final JButton btnEliminar;
    private final JButton btnEditar;
    
    private final String []titulos={"Id","Nombre","Apellido","Ciudad","Telefono"};
    
    private final DefaultTableModel miModelo;
    private final JTable tblUsuario;
    private final JScrollPane scrUsuario;
    
    public Principal()
    {
        setTitle(".::Sistema::.");
        setSize(750,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        lblID=new JLabel("Id:");
        lblBuscar=new JLabel("Buscar");
        lblNombre=new JLabel("*Nombre:");
        lblApellido=new JLabel("*Apellido:");
        lblCiudad=new JLabel("Ciudad:");
        lblTelefono=new JLabel("Telefono:");
        
        btnBuscar=new JButton("Buscar");
        btnGuardar=new JButton("Agregar");
        btnActualizar=new JButton("Refresh...");
        btnEditar=new JButton("Editar");
        btnEliminar=new JButton("Eliminar");
        
        miModelo=new DefaultTableModel(null,titulos);
        tblUsuario=new JTable(miModelo);
        scrUsuario=new JScrollPane(tblUsuario);
        
        txtCiudad=new JTextField();
        txtTelefono=new JTextField();
        txtBuscar=new JTextField();
        txtNombre=new JTextField();
        txtApellido=new JTextField();
        txtID=new JTextField();
        
        add(txtCiudad);
        add(txtTelefono);
        add(txtBuscar);
        add(txtNombre);
        add(txtApellido);
        add(txtID);
        
        add(lblID);
        add(lblBuscar);
        add(lblNombre);
        add(lblApellido);
        add(lblCiudad);
        add(lblTelefono);
        add(scrUsuario);
        add(btnBuscar);
        add(lblNombre);
        add(lblApellido);
        
        add(btnGuardar);
        add(btnActualizar);
        add(btnEditar);
        add(btnEliminar);
                
        lblID.setBounds(50,350,100,25);
        txtID.setBounds(110,350,100,25);
        
        lblNombre.setBounds(50,380,100,25);
        txtNombre.setBounds(110,380,100,25);
        
        lblApellido.setBounds(50,410,100,25);
        txtApellido.setBounds(110,410,100,25);
        
        lblTelefono.setBounds(300,380,100,25);
        txtTelefono.setBounds(360,380,100,25);
        
        lblCiudad.setBounds(300,410,100,25);
        txtCiudad.setBounds(360,410,100,25);
        
        
        
        //lblBuscar.setBounds(50,300,100,25);
        txtBuscar.setBounds(150,300,150,25);
        
        btnBuscar.setBounds(50,300,100,25);
        btnGuardar.setBounds(490,380,100,25);
        btnActualizar.setBounds(50,250,100,20);
        btnEditar.setBounds(490,410,100,25);
        btnEliminar.setBounds(610,380,100,25);
        
        scrUsuario.setBounds(50,50,610,200);
        
        /*tblUsuario.addMouseListener(this::tblUsuarioMouseClicked);*/
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);
        btnEditar.addActionListener(this::btnEditarActionPerformed);
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);
        
        tblUsuario.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent evt)
        {
        tblUsuarioMouseClicked(evt);
        }
        });
        
        cargarUsu();
        NoEditable();
    }
    private void tblUsuarioMouseClicked(MouseEvent evt)
    {
    int fila=tblUsuario.rowAtPoint(evt.getPoint());
    
    txtID.setText(tblUsuario.getValueAt(fila, 0).toString());
    txtNombre.setText(tblUsuario.getValueAt(fila, 1).toString());
    txtApellido.setText(tblUsuario.getValueAt(fila, 2).toString());
    txtTelefono.setText(tblUsuario.getValueAt(fila, 3).toString());
    txtCiudad.setText(tblUsuario.getValueAt(fila, 4).toString());
    }
    
    private void btnEliminarActionPerformed(ActionEvent evt)
    {
        
            int conf=JOptionPane.showConfirmDialog(this, "De verdad quiere eliminar el registro?");
            if(conf==0)
            {
                ACatributos datos=new ACatributos();
                Consulta funciones=new Consulta();
                
                datos.setID(Integer.parseInt(txtID.getText()));
                datos.setNombre(txtNombre.getText());
                datos.setApellido(txtApellido.getText());
                datos.setTelefono(txtTelefono.getText());
                datos.setCiudad(txtCiudad.getText());
                
                String msj=funciones.Eliminar(datos);
                JOptionPane.showMessageDialog(this, msj);
            }
        
    }
    private void btnEditarActionPerformed(ActionEvent evt)
    {
        ACatributos datos=new ACatributos();
        Consulta funciones=new Consulta();
        
        datos.setID(Integer.parseInt(txtID.getText()));
        datos.setNombre(txtNombre.getText());
        datos.setApellido(txtApellido.getText());
        datos.setTelefono(txtTelefono.getText());
        datos.setCiudad(txtCiudad.getText());
        
        String msj=funciones.Editar(datos);
        JOptionPane.showMessageDialog(this, msj);
    }
    private void btnActualizarActionPerformed(ActionEvent evt)
    {
        cargarUsu();
    }
    private void btnGuardarActionPerformed(ActionEvent evt)
    {
    
            ACatributos datos=new ACatributos();
            Consulta funcion=new Consulta();
        
            datos.setNombre(txtNombre.getText());
            datos.setApellido(txtApellido.getText());
            datos.setTelefono(txtTelefono.getText());
            datos.setCiudad(txtCiudad.getText());
        
            String msj=funcion.AgregarCliente(datos);
            JOptionPane.showMessageDialog(this, msj);
  
        
        
    }
    private void cargarUsu()
    {
        DefaultTableModel model;
        Consulta con=new Consulta();
        model=con.mostrarUsuarios();
        
        tblUsuario.setModel(model);
    }
    private void btnBuscarActionPerformed(ActionEvent evt)
    {
        busca(txtBuscar.getText());
    }
    
    /*private void CargarUsuario()
    {
    try{
    
    String registro[]=new String[5];
    //miModelo= new DefaultTableModel(null,titulos);
    Consulta cons=new Consulta();
    ResultSet rs=cons.Obtener();
    while(rs.next())
    {
    registro[0]=rs.getString("ID");
    registro[1]=rs.getString("Nombre");
    registro[2]=rs.getString("Apellido");
    registro[3]=rs.getString("Telefono");
    registro[4]=rs.getString("Ciudad");
    miModelo.addRow(registro);
    }
    tblUsuario.setModel(miModelo);
    
    }
    catch(SQLException ex)
    {
    JOptionPane.showMessageDialog(this, ex);
    }
    }*/
    
    private void busca(String bus){
        DefaultTableModel miModel;
        Consulta con=new Consulta();
        miModel=con.Buscar(bus);
        tblUsuario.setModel(miModel);
        
    }
    private void NoEditable()
    {txtID.setEnabled(false);}
    //public void validarBusqueda(int n){if(n==0)JOptionPane.showMessageDialog(null, "No se encontro"); else if(n==1)JOptionPane.showMessageDialog(null, "Busqueda aceptada");}
}
