package gui;

import classes.Usuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends javax.swing.JFrame {

    private final java.util.ArrayList<Usuario> usuarios;
    private JButton buttonCancelar;
    private JButton buttonConfirmar;
    private JPasswordField jPasswordField1;
    private JLabel labelNome;
    private JLabel labelSenha;
    private JTextField textFieldNome;

    public Login(java.util.ArrayList<Usuario> usuarios) {
        initComponents();
        setResizable(false);
        setSize(400, 400);
        setBackground(Color.RED);
        setLocationRelativeTo(null);
        this.usuarios = usuarios;
    }

    private void initComponents() {
        textFieldNome = new JTextField();
        labelSenha = new JLabel();
        labelNome = new JLabel();
        buttonConfirmar = new JButton();
        buttonCancelar = new JButton();
        jPasswordField1 = new JPasswordField();

        setDefaultCloseOperation(3);
        setTitle("Logar");
        setBackground(new Color(204, 0, 0));
        getContentPane().setLayout(null);

        textFieldNome.setFont(new java.awt.Font("Calibri", 0, 18));
        textFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                Login.this.textFieldNomeKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                Login.this.textFieldNomeKeyReleased(evt);
            }
        });
        getContentPane().add(textFieldNome);
        textFieldNome.setBounds(71, 88, 265, 49);

        labelSenha.setFont(new java.awt.Font("sansserif", 0, 18));
        labelSenha.setText("Senha");
        labelSenha.setToolTipText("Logar");
        getContentPane().add(labelSenha);
        labelSenha.setBounds(176, 155, 52, 24);

        labelNome.setFont(new java.awt.Font("sansserif", 0, 18));
        labelNome.setText("Nome de Usuário");
        labelNome.setToolTipText("Logar");
        getContentPane().add(labelNome);
        labelNome.setBounds(137, 46, 139, 24);

        buttonConfirmar.setBackground(new Color(255, 255, 255));
        buttonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/yes.png")));
        buttonConfirmar.setText("Confirmar");
        buttonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Login.this.buttonConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonConfirmar);
        buttonConfirmar.setBounds(241, 319, 130, 45);

        buttonCancelar.setBackground(new Color(255, 255, 255));
        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png")));
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Login.this.buttonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCancelar);
        buttonCancelar.setBounds(30, 319, 100, 45);

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                Login.this.jPasswordField1KeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                Login.this.jPasswordField1KeyReleased(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(71, 197, 265, 49);

        getAccessibleContext().setAccessibleName("");

        pack();
    }

    private void buttonCancelarActionPerformed(ActionEvent evt) {
        int sair = javax.swing.JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar?");
        if (sair == 0) {
            System.exit(0);
        }
    }

    private void buttonConfirmarActionPerformed(ActionEvent evt) {
        String nome = textFieldNome.getText();
        char[] s = jPasswordField1.getPassword();
        String senha = "";

        for (char t : s) {
            senha = senha + t;
        }

        if (verificaLogin(nome, senha)) {
            dispose();
            Principal p = new Principal();
            p.controletotal(verificaAdmin(nome, senha));
            p.setVisible(true);
        }
    }

    private void textFieldNomeKeyReleased(KeyEvent evt) {
    }

    private void jPasswordField1KeyReleased(KeyEvent evt) {
    }

    private void textFieldNomeKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buttonConfirmarActionPerformed(null);
        } else if (evt.getKeyCode() == 9) {
            jPasswordField1.requestFocus();
        }
    }

    private void jPasswordField1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buttonConfirmarActionPerformed(null);
        }
    }

    public boolean verificaLogin(String user, String senha) {
        for (Usuario us : usuarios) {
            if (user.equals(us.getUser())) {
                if (senha.equals(us.getSenha())) {
                    return true;
                }
                javax.swing.JOptionPane.showMessageDialog(null, "Senha inválida!");
                jPasswordField1.requestFocusInWindow();
                return false;
            }
        }

        javax.swing.JOptionPane.showMessageDialog(null, "Nome de usuário inválido!");
        textFieldNome.requestFocusInWindow();
        return false;
    }

    public boolean verificaAdmin(String user, String senha) {
        for (Usuario us : usuarios) {
            if ((user.equals(us.getUser()))
                    && (senha.equals(us.getSenha()))) {
                return us.isAdministrador();
            }
        }

        return false;
    }

}
