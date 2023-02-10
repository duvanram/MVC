
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.Clientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author duvan.ramirez
 */
public class Controlador implements ActionListener{
    UsuarioDAO dao = new UsuarioDAO();
    Usuario p = new Usuario();
    Clientes vista = new Clientes();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Controlador (Clientes v){
        this.vista = v;
        this.vista.btListar.addActionListener(this);
        this.vista.btAgregar.addActionListener(this);
        this.vista.btActualizar.addActionListener(this);
        this.vista.btEditar.addActionListener(this);
        this.vista.btEliminar.addActionListener(this);
        this.vista.btNuevo.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btListar) {
            limpiarTabla();
            listar(vista.tablaUsuarios);
            nuevo();
        }
        if (e.getSource() == vista.btAgregar) {
            agregar();
            listar(vista.tablaUsuarios);
            nuevo();
        }
        if (e.getSource() == vista.btNuevo) {
            nuevo();
        }
       if (e.getSource() == vista.btEditar) {
            int fila = vista.tablaUsuarios.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Por favor selecciona una fila, clic en la celda.");
            } else {
                int id = Integer.parseInt((String) vista.tablaUsuarios.getValueAt(fila, 0).toString());
                String nombres = (String) vista.tablaUsuarios.getValueAt(fila, 1);
                String email = (String) vista.tablaUsuarios.getValueAt(fila, 2);
                String celular = (String) vista.tablaUsuarios.getValueAt(fila, 3);
                String telefono = (String) vista.tablaUsuarios.getValueAt(fila, 4);
                String direccion = (String) vista.tablaUsuarios.getValueAt(fila, 5);
                String perfil = (String) vista.tablaUsuarios.getValueAt(fila, 6);
                String usuario = (String) vista.tablaUsuarios.getValueAt(fila, 7);
                String cargo = (String) vista.tablaUsuarios.getValueAt(fila, 8);
                
                vista.lbId.setText("" + id);
                vista.txtNombres.setText(nombres);
                vista.txtCorreo.setText(email);
                vista.txtCelular.setText(celular);
                vista.txtTelefono.setText(telefono);
                vista.txtDireccion.setText(direccion);
                vista.cmbPerfil.setSelectedItem(perfil);
                vista.txtUsuario.setText(usuario);
                vista.cmbCargo.setSelectedItem(cargo);
            }
        }
       if (e.getSource() == vista.btActualizar) {
            Actualizar();
            listar(vista.tablaUsuarios);
            nuevo();

        }
        if (e.getSource() == vista.btEliminar) {
            eliminar();
            listar(vista.tablaUsuarios);
            nuevo();
        }
        if (e.getSource() == vista.btNuevo) {
            nuevo();
        }
    }
    void nuevo() {
        vista.lbId.setText("");
        vista.txtNombres.setText("");
        vista.txtCorreo.setText("");
        vista.txtCelular.setText("");
        vista.txtTelefono.setText("");
        vista.txtDireccion.setText("");
        vista.cmbPerfil.setSelectedIndex(0);
        vista.txtUsuario.setText("");
        vista.cmbCargo.setSelectedIndex(0);
        
        vista.txtNombres.requestFocus();
    }
    public void listar(JTable tablaUsuarios){
        modelo=(DefaultTableModel)tablaUsuarios.getModel();
        List<Usuario>lista = dao.listar();
        Object[]object = new Object[9];
        for (int i=0; i < lista.size();i++){
            
            object[0]=lista.get(i).getId();
            object[1]=lista.get(i).getNombres();
            object[2]=lista.get(i).getEmail();
            object[3]=lista.get(i).getCelular();
            object[4]=lista.get(i).getTelefono();
            object[5]=lista.get(i).getDireccion();
            object[6]=lista.get(i).getPerfil();
            object[7]=lista.get(i).getUsuario();
            object[8]=lista.get(i).getCargo();
           
            modelo.addRow(object);
        }
        vista.tablaUsuarios.setModel(modelo);
    }
    public void agregar()
    {       
        String nombres =  vista.txtNombres.getText();
        String email =  vista.txtCorreo.getText();
        String celular =  vista.txtCelular.getText();
        String telefono =  vista.txtTelefono.getText();
        String direccion =  vista.txtDireccion.getText();
        String perfil =  vista.cmbPerfil.getSelectedItem().toString();
        String usuario =  vista.txtUsuario.getText();
        String cargo =  vista.cmbCargo.getSelectedItem().toString();
        
 
        p.setNombres(nombres);
        p.setEmail(email);
        p.setCelular(celular);
        p.setTelefono(telefono);
        p.setDireccion(direccion);
        p.setPerfil(perfil);
        p.setUsuario(usuario);
        p.setCargo(cargo);
        
        int r = dao.agregar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "El usuario ha sido agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(vista, "Error: No pudo ser agregado el usuario");
        }
        limpiarTabla();
    }
    public void Actualizar() {
        if (vista.lbId.getText().equals("") || vista.lbId.getText().equals("...")){
            JOptionPane.showMessageDialog(vista, "Por favor selecciona la opción editar antes de actualizar el registro");
        } else {
            int id = Integer.parseInt(vista.lbId.getText());
            String nombres = vista.txtNombres.getText();
            String email = vista.txtCorreo.getText();
            String celular = vista.txtCelular.getText();
            String telefono = vista.txtTelefono.getText();
            String direccion = vista.txtDireccion.getText();
            String perfil = vista.cmbPerfil.getSelectedItem().toString();
            String usuario = vista.txtUsuario.getText();
            String cargo = vista.cmbCargo.getSelectedItem().toString();
            
            p.setId(id);
            p.setNombres(nombres);
            p.setEmail(email);
            p.setCelular(celular);
            p.setTelefono(telefono);
            p.setDireccion(direccion);
            p.setPerfil(perfil);
            p.setUsuario(usuario);
            p.setCargo(cargo);
            
            int r = dao.Actualizar(p);
            if (r == 1) {
                JOptionPane.showMessageDialog(vista, "Usuario actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(vista, "Error, el usuario no pudo ser actualizado");
            }
        }
        limpiarTabla();
    }
    public void eliminar() {
        int fila = vista.tablaUsuarios.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Por favor seleccione la fila a eliminar");
        } else {
            int id = Integer.parseInt((String) vista.tablaUsuarios.getValueAt(fila, 0).toString());
            dao.Eliminar(id);
            System.out.println("El usuario eliminado es:" + id);
            JOptionPane.showMessageDialog(vista, "Usuario Eliminado correctamente");
        }
        limpiarTabla();
    }
    void limpiarTabla() {
        for (int i = 0; i < vista.tablaUsuarios.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
 
}
