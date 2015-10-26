package classes;

import DAO.UsuarioDAO;
import gui.CadastrarUsuario;
import gui.Login;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Principal {

    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        ArrayList<Usuario> usuarios = new UsuarioDAO().get();
        if (usuarios.isEmpty()) {
            new CadastrarUsuario().setVisible(true);
        } else {
            new Login(usuarios).setVisible(true);
        }
    }
}