
package Modelo;

/**
 *
 * @author duvan.ramirez
 */
public class Usuario {

    int id;
    String nombres;
    String email;
    String celular;
    String telefono;
    String direccion;
    String perfil;
    String usuario;
    String cargo;

   
    
    public Usuario()
    {
    }
    public Usuario (int id, String nombres, String email, String celular, String telefono, String direccion, String perfil,
                    String usuario, String contrasena,String cargo)
    {
        this.id= id;
        this.nombres= nombres;
        this.email = email;
        this.celular = celular;
        this.telefono= telefono;
        this.direccion= direccion;
        this.perfil=perfil;
        this.usuario=usuario;
        this.cargo=cargo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

     public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
