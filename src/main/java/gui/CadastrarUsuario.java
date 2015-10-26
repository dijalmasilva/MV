package gui;

import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastrarUsuario extends javax.swing.JFrame {

    private Principal p;
    private String senha;
    private final boolean primeiraVez;
    private boolean podeFinalizar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JComboBox comboAdministrador;
    private javax.swing.JComboBox comboEstado;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;

    public CadastrarUsuario(Principal p) {
        initComponents();
        setSize(810, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        this.p = p;
        primeiraVez = false;
        alterarIcone();
    }

    public CadastrarUsuario() {
        initComponents();
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        comboAdministrador.setEnabled(false);
        primeiraVez = true;
        alterarIcone();
    }

    public final void alterarIcone() {
        java.net.URL url = getClass().getResource("/imagens/newUser.png");
        java.awt.Image imagemTitulo = java.awt.Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(imagemTitulo);
    }

    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;

    private void initComponents() {
        jLabel1 = new JLabel();
        textfieldNome = new JTextField();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        textFieldCpf = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        textFieldRua = new JTextField();
        jLabel6 = new JLabel();
        textFieldNumero = new JTextField();
        jLabel7 = new JLabel();
        textFieldBairro = new JTextField();
        jLabel8 = new JLabel();
        textFieldCidade = new JTextField();
        jLabel9 = new JLabel();
        comboEstado = new javax.swing.JComboBox();
        jLabel10 = new JLabel();
        textFieldComplemento = new JTextField();
        jLabel11 = new JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new JLabel();
        textFieldTelefone = new javax.swing.JFormattedTextField();
        jLabel14 = new JLabel();
        textFieldEmail = new JTextField();
        btCancelar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        jLabel16 = new JLabel();
        textFieldTelefoneOpcional = new JTextField();
        jLabel17 = new JLabel();
        textFieldUser = new JTextField();
        jLabel12 = new JLabel();
        jLabel15 = new JLabel();
        password = new javax.swing.JPasswordField();
        jLabel18 = new JLabel();
        comboAdministrador = new javax.swing.JComboBox();
        jLabel19 = new JLabel();
        textFieldSalario = new JTextField();
        jLabel20 = new JLabel();

        setDefaultCloseOperation(2);
        setTitle("Cadastrar Usuário");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                CadastrarUsuario.this.formWindowClosing(evt);
            }

        });
        jLabel1.setText("Nome Completo:");

        textfieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                CadastrarUsuario.this.textfieldNomeKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                CadastrarUsuario.this.textfieldNomeKeyReleased(evt);
            }

        });
        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel2.setText("Dados Pessoais");

        jLabel3.setText("CPF:");
        try {
            textFieldCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textFieldCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarUsuario.this.textFieldCpfActionPerformed(evt);
            }
        });
        textFieldCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                CadastrarUsuario.this.textFieldCpfKeyReleased(evt);
            }

        });
        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel4.setText("Endereço");

        jLabel5.setText("Rua:");

        textFieldRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarUsuario.this.textFieldRuaActionPerformed(evt);
            }
        });
        textFieldRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                CadastrarUsuario.this.textFieldRuaKeyReleased(evt);
            }

        });
        jLabel6.setText("Número:");

        jLabel7.setText("Bairro:");

        textFieldBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                CadastrarUsuario.this.textFieldBairroKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                CadastrarUsuario.this.textFieldBairroKeyReleased(evt);
            }

        });
        jLabel8.setText("Cidade:");

        textFieldCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                CadastrarUsuario.this.textFieldCidadeKeyReleased(evt);
            }

        });
        jLabel9.setText("Estado:");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"ACRE", "ALAGOAS", "AMAPÁ", "AMAZONAS", "BAHIA", "CEARÁ", "DISTRITO FEDERAL", "ESPÍRITO SANTO", "GOIÁS", "MARANHÃO", "MATO GROSSO", "MATO GROSSO DO SUL", "MINAS GERAIS", "PARÁ", "PARAÍBA", "PARANÁ", "PERNAMBUCO", "PIAUÍ", "RIO DE JANEIRO", "RIO GRANDE DO NORTE", "RIO GRANDE DO SUL", "RONDÔNIA ", "RORAIMA", "SANTA CATARINA", "SÃO PAULO", "SERGIPE", "TOCANTINS"}));
        comboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarUsuario.this.comboEstadoActionPerformed(evt);
            }

        });
        jLabel10.setText("Complemento:");

        textFieldComplemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                CadastrarUsuario.this.textFieldComplementoKeyReleased(evt);
            }

        });
        jLabel11.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel11.setText("Contato");

        jLabel13.setText("Telefone:");
        try {
            textFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) 9 ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textFieldTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarUsuario.this.textFieldTelefoneActionPerformed(evt);
            }

        });
        jLabel14.setText("E-mail:");

        textFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarUsuario.this.textFieldEmailActionPerformed(evt);
            }

        });
        btCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png")));
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarUsuario.this.btCancelarActionPerformed(evt);
            }

        });
        btConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/yes.png")));
        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarUsuario.this.btConfirmarActionPerformed(evt);
            }

        });
        jLabel16.setText("Telefone opcional:");

        jLabel17.setText("Nome de Usuário:");

        jLabel12.setText("Senha:");

        jLabel15.setFont(new java.awt.Font("sansserif", 0, 10));
        jLabel15.setText("min: 8; max: 20");

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarUsuario.this.passwordActionPerformed(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                CadastrarUsuario.this.passwordKeyReleased(evt);
            }

        });
        jLabel18.setText("Administrador:");

        comboAdministrador.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Sim", "Não"}));

        jLabel19.setText("Sálario:");

        jLabel20.setText("R$");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap(-1, 32767)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(372, 372, 372))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel1, -2, 106, -2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addGap(19, 19, 19)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(textFieldCpf, -2, 145, -2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel17)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(textFieldUser, -2, 153, -2)
                                                        .addGap(30, 30, 30)
                                                        .addComponent(jLabel12))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(textfieldNome, -2, 282, -2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel19)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(textFieldSalario, -2, 110, -2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel20)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(password, -2, 155, -2)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel18)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(comboAdministrador, -2, 74, -2)))
                                        .addGap(55, 55, 55))))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, 32767)
                        .addComponent(jLabel15)
                        .addGap(73, 73, 73))
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(358, 358, 358)
                                        .addComponent(jLabel2, -2, 105, -2))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jSeparator2, -2, 772, -2)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jLabel10)
                                                                .addComponent(jLabel8))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(textFieldCidade, -2, 373, -2)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jLabel9)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(comboEstado, 0, -1, 32767))
                                                                .addComponent(textFieldRua)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(textFieldNumero, -2, 100, -2)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jLabel7)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(textFieldBairro))
                                                                .addComponent(textFieldComplemento, -2, 634, -2)))
                                                .addComponent(jSeparator1, -2, 772, -2))))
                        .addContainerGap(-1, 32767))
                .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14)
                                .addComponent(btCancelar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(textFieldEmail)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(textFieldTelefone, -2, 220, -2)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(24, 24, 24)
                                                                        .addComponent(jLabel11))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jLabel16)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(textFieldTelefoneOpcional, -2, 269, -2))))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                        .addComponent(btConfirmar, -2, 124, -2)
                                        .addGap(29, 29, 29)))));

        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, -2, 26, -2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18)
                                        .addComponent(comboAdministrador, -2, -1, -2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, -2, 28, -2)
                                        .addComponent(textfieldNome, -2, -1, -2)
                                        .addComponent(jLabel19)
                                        .addComponent(textFieldSalario, -2, -1, -2)
                                        .addComponent(jLabel20)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(textFieldCpf, -2, -1, -2)
                                .addComponent(textFieldUser, -2, -1, -2)
                                .addComponent(jLabel12)
                                .addComponent(jLabel17)
                                .addComponent(password, -2, -1, -2))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, -2, 2, -2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(textFieldRua, -2, -1, -2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(textFieldNumero, -2, -1, -2)
                                .addComponent(jLabel7)
                                .addComponent(textFieldBairro, -2, -1, -2))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(textFieldComplemento, -2, -1, -2))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(textFieldCidade, -2, -1, -2)
                                .addComponent(jLabel9)
                                .addComponent(comboEstado, -2, -1, -2))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, -2, 10, -2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel13)
                                                .addComponent(textFieldTelefone, -2, -1, -2)
                                                .addComponent(jLabel16)
                                                .addComponent(textFieldTelefoneOpcional, -2, -1, -2))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel14)
                                                .addComponent(textFieldEmail, -2, -1, -2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, 32767)
                                        .addComponent(btConfirmar, -2, 44, -2))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, 32767)
                                        .addComponent(btCancelar)))
                        .addGap(17, 17, 17)));

        pack();
    }

    private void textFieldCpfActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void comboEstadoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        if (primeiraVez) {
            javax.swing.JOptionPane.showMessageDialog(null, "Você tem que cadastrar um usuário administrador para poder usar o sistema.");
        } else {
            int result = javax.swing.JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar?");
            if (result == 0) {
                p.setVisible(true);
                dispose();
            }
        }
    }

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        String user = textFieldUser.getText();
        String nome = textfieldNome.getText();
        String cpf = textFieldCpf.getText();
        String rua = textFieldRua.getText();
        String bairro = textFieldBairro.getText();
        String cidade = textFieldCidade.getText();
        String complemento = textFieldComplemento.getText();
        String telefone = textFieldTelefone.getText();
        String email = textFieldEmail.getText();
        String telefoneOpcional = textFieldTelefoneOpcional.getText();
        String estado = comboEstado.getSelectedItem().toString();
        boolean administrador;
        if (comboAdministrador.getSelectedItem().toString().equals("Sim")) {
            administrador = true;
        } else {
            administrador = false;
        }
        int numero = 0;
        double salario = 0.0D;
        try {
            numero = Integer.parseInt(textFieldNumero.getText());
            salario = Double.parseDouble(textFieldSalario.getText());
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Preencha apenas com número.");
            textFieldNumero.setText("");
            textFieldNumero.requestFocusInWindow();
        }

        if ((salario < 0.0D) || (nome.equals("")) || (cpf.equals("   .   .   -  ")) || (rua.equals("")) || (bairro.equals("")) || (cidade.equals(""))
                || (telefone.equals("(  ) 9     -    ")) || (user.equals("")) || (senha.equals("")) || (senha.length() < 8) || (senha.length() > 19)) {
            if (nome.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Preencha o nome.");
                textfieldNome.requestFocusInWindow();
            } else if (cpf.equals("   .   .   -  ")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Preecha o CPF.");
                textFieldCpf.requestFocusInWindow();
            } else if (rua.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Preecha o nome da Rua.");
                textFieldRua.requestFocusInWindow();
            } else if (bairro.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Preecha o nome do Bairro.");
                textFieldBairro.requestFocusInWindow();
            } else if (cidade.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Preecha o nome da Cidade.");
                textFieldCidade.requestFocusInWindow();
            } else if (user.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Preencha o nome de usuário.");
                textFieldUser.requestFocusInWindow();
            } else if ((senha.equals("")) || (senha.length() < 8) || (senha.length() > 19)) {
                javax.swing.JOptionPane.showMessageDialog(null, "Digite uma senha com no mínimo 8 e no máximo 20 caracteres.");
                password.requestFocusInWindow();
            } else if (salario < 0.0D) {
                javax.swing.JOptionPane.showMessageDialog(null, "Informe um salário válido");
                textFieldSalario.setText("");
                textFieldSalario.requestFocusInWindow();
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Preecha o número de telefone.");
                textFieldTelefone.requestFocusInWindow();
            }
        } else if (podeFinalizar) {
            classes.Usuario u = new classes.Usuario(user, senha, cpf, nome, cidade, rua, bairro, numero, complemento, estado, telefone, telefoneOpcional, email, java.time.LocalDate.now(), administrador, salario);
            new DAO.UsuarioDAO().add(u);
            dispose();
            if (!primeiraVez) {
                int n = javax.swing.JOptionPane.showConfirmDialog(null, "Deseja cadastrar um novo usuário?");
                if (n == 0) {
                    new CadastrarUsuario(p).setVisible(true);
                } else {
                    p.setVisible(true);
                }
            } else {
                new Principal().setVisible(true);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Informe um CPF válido.");
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        if (primeiraVez) {
            System.exit(0);
        } else {
            p.setVisible(true);
        }
    }

    private void textFieldTelefoneActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void textfieldNomeKeyReleased(KeyEvent evt) {
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36) && (evt.getKeyCode() != 17) && (evt.getKeyCode() != 16) && (evt.getKeyCode() != 8)) {
            textfieldNome.setText(retornaTextoMaiusculo(textfieldNome.getText()));
        }
    }

    private void textfieldNomeKeyPressed(KeyEvent evt) {
    }

    private void textFieldRuaKeyReleased(KeyEvent evt) {
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36) && (evt.getKeyCode() != 17) && (evt.getKeyCode() != 16) && (evt.getKeyCode() != 8)) {
            textFieldRua.setText(retornaTextoMaiusculo(textFieldRua.getText()));
        }
    }

    private void textFieldBairroKeyPressed(KeyEvent evt) {
    }

    private void textFieldBairroKeyReleased(KeyEvent evt) {
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36) && (evt.getKeyCode() != 17) && (evt.getKeyCode() != 16) && (evt.getKeyCode() != 8)) {
            textFieldBairro.setText(retornaTextoMaiusculo(textFieldBairro.getText()));
        }
    }

    private void textFieldComplementoKeyReleased(KeyEvent evt) {
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36) && (evt.getKeyCode() != 17) && (evt.getKeyCode() != 16) && (evt.getKeyCode() != 8)) {
            textFieldComplemento.setText(retornaTextoMaiusculo(textFieldComplemento.getText()));
        }
    }

    private void textFieldCidadeKeyReleased(KeyEvent evt) {
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36) && (evt.getKeyCode() != 17) && (evt.getKeyCode() != 16) && (evt.getKeyCode() != 8)) {
            textFieldCidade.setText(retornaTextoMaiusculo(textFieldCidade.getText()));
        }
    }

    private JLabel jLabel8;
    private JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField password;
    private JTextField textFieldBairro;

    private void textFieldRuaActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void textFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void passwordKeyReleased(KeyEvent evt) {
        boolean numero = false;

        char[] s = password.getPassword();
        senha = "";

        for (char t : s) {
            senha += t;
            if ((t == '0') || (t == '1') || (t == '2') || (t == '3') || (t == '4') || (t == '5') || (t == '6') || (t == '7') || (t == '8') || (t == '9')) {
                numero = true;
            }
        }

        if ((senha.length() > 7) && (senha.length() <= 20)) {
            if ((senha.length() > 9) && (numero)) {
                password.setBackground(java.awt.Color.GREEN);
            } else {
                password.setBackground(java.awt.Color.orange);
            }
        } else {
            password.setBackground(java.awt.Color.RED);
        }
    }

    private void textFieldCpfKeyReleased(KeyEvent evt) {
        if ((evt.getKeyCode() != 10)
                && (textFieldCpf.getText().charAt(12) != ' ')) {
            classes.VerificadorDeCPF v = new classes.VerificadorDeCPF(textFieldCpf.getText());
            if (v.verificarPrimeiroDigito()) {
                if (textFieldCpf.getText().charAt(13) != ' ') {
                    if (!v.verificarSegundoDigito()) {
                        podeFinalizar = false;
                        javax.swing.JOptionPane.showMessageDialog(null, "CPF INVÁLIDO.");
                    } else {
                        podeFinalizar = true;
                    }
                }
            } else {
                podeFinalizar = false;
                javax.swing.JOptionPane.showMessageDialog(null, "CPF INVÁLIDO.");
            }
        }
    }

    public String retornaTextoMaiusculo(String text) {
        return text.toUpperCase();
    }

    private JTextField textFieldCidade;
    private JTextField textFieldComplemento;
    private javax.swing.JFormattedTextField textFieldCpf;
    private JTextField textFieldEmail;
    private JTextField textFieldNumero;
    private JTextField textFieldRua;
    private JTextField textFieldSalario;
    private javax.swing.JFormattedTextField textFieldTelefone;
    private JTextField textFieldTelefoneOpcional;
    private JTextField textFieldUser;
    private JTextField textfieldNome;

}