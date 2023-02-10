package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duvan.ramirez
 */
public class UsuarioDAO {
    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List<Usuario>datos = new ArrayList<>();
        String sql = "select * from usuarios";
        try
        {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next())
            {
                Usuario p= new Usuario();
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setEmail(rs.getString(3));
                p.setCelular(rs.getString(4));
                p.setTelefono(rs.getString(5));
                p.setDireccion(rs.getString(6));
                p.setPerfil(rs.getString(7));
                p.setUsuario(rs.getString(8));
                p.setCargo(rs.getString(9));
                datos.add(p);
            }
        }
        catch (Exception e)
        {
            
        }
        return datos;
    }
    public int agregar(Usuario p){
       int r=0;
       String sql="insert into usuarios(nombres,email,celular,telefono,direccion,perfil,usuario,cargo)values(?,?,?,?,?,?,?,?)";
       
       try
       {
           con = conectar.getConnection();
           
           ps=con.prepareStatement(sql);
           ps.setString(1, p.getNombres());
           ps.setString(2, p.getEmail());
           ps.setString(3, p.getCelular());
           ps.setString(4, p.getTelefono());
           ps.setString(5, p.getDireccion());
           ps.setString(6, p.getPerfil());
           ps.setString(7, p.getUsuario());
           ps.setString(8, p.getCargo());
           
           ps.executeUpdate();
          
           if(r==1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (Exception e) {
        }  
        return r;
    }  
    public int Actualizar(Usuario p) {  
        int r=0;
        String sql="update usuarios set nombres=?,email=?,celular=?,telefono=?,direccion=?,perfil=?,usuario=?,cargo=? where id=?"; 
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,p.getNombres());
            ps.setString(2,p.getEmail());
            ps.setString(3,p.getCelular());
            ps.setString(4,p.getTelefono());
            ps.setString(5,p.getDireccion());
            ps.setString(6,p.getPerfil());
            ps.setString(7,p.getUsuario());
            ps.setString(8, p.getCargo());
            ps.setInt(9,p.getId());
            
            r=ps.executeUpdate();    
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (Exception e) {
        }  
        return r;
    }
    public int Eliminar(int id){
        int r=0;
        String sql="delete from usuarios where id="+id;
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
