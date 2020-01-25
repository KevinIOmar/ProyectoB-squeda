
package Logica;


public class ACatributos {
    private int ID;
    private  String Nombre;
    private  String Apellido;
    private  String Telefono;
    private  String Ciudad;
    
   
            public ACatributos(){}
            public ACatributos(int Id,String telefono,String ciudad,String nombre,String apellido)
            {
            this.ID=Id;
            this.Telefono=telefono;
            this.Ciudad=ciudad;
            this.Nombre=nombre;
            this.Apellido=apellido;
            }
    
    
            public int getID(){return ID;}
            public void setID(int Id){this.ID=Id;}
            
    public String getNombre(){return Nombre;}
    public void setNombre(String nombre){this.Nombre=nombre;}
    
    public String getApellido(){return Apellido;}
    public void setApellido(String apellido){this.Apellido=apellido;}
    
    public String getTelefono(){return Telefono;}
    public void setTelefono(String telefono){this.Telefono=telefono;}
    
    public String getCiudad(){return Ciudad;}
    public void setCiudad(String ciudad){this.Ciudad=ciudad;}
    
}
