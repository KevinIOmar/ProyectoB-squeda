/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.Consulta;
//import Logica.Cuenta;
import java.awt.event.*;
//import java.awt.event.KeyEvent;

import javax.swing.*;

/**
 *
 * @author Salome
 */
public class Plogin extends JFrame{
    
    private final JLabel lblUsuario;
    private final JLabel lblClave;
    private final JTextField txtUsuario;
    private final JPasswordField txtClave;
    
    private final JButton btnIngresar;
    private final JButton btnCancelar;
    
    public Plogin(){
        setTitle("Ingresar al sistema");
        //ancho largo
        setSize(500,260);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        lblUsuario=new JLabel("Usuario:");
        txtUsuario=new JTextField();
        lblClave=new JLabel("Contraseña:");
        
        txtClave=new JPasswordField();
        
        btnIngresar=new JButton("Ingresar");
        btnCancelar=new JButton("Cancelar");
        
        
        add(lblUsuario);
        add(txtUsuario);
        
        add(lblClave);
        add(txtClave);
        
        add(btnIngresar);
        add(btnCancelar);
        
        
        lblUsuario.setBounds(150,50,100,25);
        txtUsuario.setBounds(250,50,150,25);
        
        lblClave.setBounds(150,80,100,25);
        txtClave.setBounds(250,80,150,25);
        
        btnIngresar.setBounds(150,145,100,25);
        btnCancelar.setBounds(250,145,150,25);
        
        btnIngresar.addActionListener(this::btnIngresarActionPerformed);
        
                
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
    }
    
    private void btnIngresarActionPerformed(ActionEvent evt)
    {
        Consulta con=new Consulta();
        String pass=String.valueOf(txtClave.getPassword());
        //int n=Integer.parseInt(pass);
        
        
        if(con.Cuenta(txtUsuario.getText(), pass)==1)
        {
            this.dispose();
            Principal miPrincipal=new Principal();
            miPrincipal.setLocationRelativeTo(null);
            miPrincipal.setVisible(true);
            
            //JOptionPane.showMessageDialog(this,"Correcto");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrecta");
            txtUsuario.setText("");
            txtClave.setText("");
            txtUsuario.requestFocusInWindow();
        }
            

    }
    private void btnCancelarActionPerformed(ActionEvent evt)
    {
        System.exit(0);
    }
  
}
