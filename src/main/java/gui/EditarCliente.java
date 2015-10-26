package gui;

import javax.swing.JTextField;

public class EditarCliente extends javax.swing.JFrame {

    private final Principal p;
    private final classes.Cliente c;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JComboBox comboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;

    public EditarCliente(Principal p, classes.Cliente c) {
        initComponents();
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        this.p = p;
        this.c = c;
        preencherCampos();
    }

    public final void preencherCampos() {
        textFieldBairro.setText(c.getBairro());
        textFieldCidade.setText(c.getCidade());
        textFieldComplemento.setText(c.getComplemento());
        textFieldCpf.setText(c.getCpf());
        textFieldEmail.setText(c.getEmail());
        textFieldLimite.setText(c.getLimite() + "");
        textFieldNumero.setText(c.getNumero() + "");
        textFieldTelefone.setText(c.getTelefone());
        textFieldTelefoneOpcional.setText(c.getTelefoneOpcional());
        textfieldNome.setText(c.getNome());
        textFieldRua.setText(c.getRua());
        comboEstado.setSelectedItem(c.getEstado());
    }

    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private JTextField textFieldBairro;
    private JTextField textFieldCidade;

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        textfieldNome = new JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textFieldCpf = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textFieldRua = new JTextField();
        jLabel6 = new javax.swing.JLabel();
        textFieldNumero = new JTextField();
        jLabel7 = new javax.swing.JLabel();
        textFieldBairro = new JTextField();
        jLabel8 = new javax.swing.JLabel();
        textFieldCidade = new JTextField();
        jLabel9 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        textFieldComplemento = new JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textFieldLimite = new JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        textFieldTelefone = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        textFieldEmail = new JTextField();
        btCancelar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        textFieldTelefoneOpcional = new JTextField();

        setDefaultCloseOperation(2);
        setTitle("Editar Cliente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                EditarCliente.this.formWindowClosing(evt);
            }

        });
        jLabel1.setText("Nome Completo:");

        textfieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EditarCliente.this.textfieldNomeKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditarCliente.this.textfieldNomeKeyReleased(evt);
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
                EditarCliente.this.textFieldCpfActionPerformed(evt);
            }

        });
        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel4.setText("Endereço");

        jLabel5.setText("Rua:");

        textFieldRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarCliente.this.textFieldRuaActionPerformed(evt);
            }
        });
        textFieldRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditarCliente.this.textFieldRuaKeyReleased(evt);
            }

        });
        jLabel6.setText("Número:");

        jLabel7.setText("Bairro:");

        textFieldBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EditarCliente.this.textFieldBairroKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditarCliente.this.textFieldBairroKeyReleased(evt);
            }

        });
        jLabel8.setText("Cidade:");

        textFieldCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditarCliente.this.textFieldCidadeKeyReleased(evt);
            }

        });
        jLabel9.setText("Estado:");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"ACRE", "ALAGOAS", "AMAPÁ", "AMAZONAS", "BAHIA", "CEARÁ", "DISTRITO FEDERAL", "ESPÍRITO SANTO", "GOIÁS", "MARANHÃO", "MATO GROSSO", "MATO GROSSO DO SUL", "MINAS GERAIS", "PARÁ", "PARAÍBA", "PARANÁ", "PERNAMBUCO", "PIAUÍ", "RIO DE JANEIRO", "RIO GRANDE DO NORTE", "RIO GRANDE DO SUL", "RONDÔNIA ", "RORAIMA", "SANTA CATARINA", "SÃO PAULO", "SERGIPE", "TOCANTINS"}));
        comboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarCliente.this.comboEstadoActionPerformed(evt);
            }

        });
        jLabel10.setText("Complemento:");

        textFieldComplemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditarCliente.this.textFieldComplementoKeyReleased(evt);
            }

        });
        jLabel11.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel11.setText("Contato");

        jLabel12.setText("Limite:");

        textFieldLimite.setText("0.0");
        textFieldLimite.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EditarCliente.this.textFieldLimiteFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                EditarCliente.this.textFieldLimiteFocusLost(evt);
            }

        });
        jLabel13.setText("Telefone:");
        try {
            textFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) 9 ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textFieldTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarCliente.this.textFieldTelefoneActionPerformed(evt);
            }

        });
        jLabel14.setText("E-mail:");

        textFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarCliente.this.textFieldEmailActionPerformed(evt);
            }

        });
        btCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png")));
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarCliente.this.btCancelarActionPerformed(evt);
            }

        });
        btConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/yes.png")));
        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarCliente.this.btConfirmarActionPerformed(evt);
            }

        });
        jLabel15.setText("R$");

        jLabel16.setText("Telefone opcional:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
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
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(textfieldNome, -2, 635, -2)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(textFieldCpf)
                                                        .addGap(74, 74, 74)
                                                        .addComponent(jLabel12)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(textFieldLimite, -2, 252, -2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel15, -2, 26, -2)))
                                        .addGap(49, 49, 49))))
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
                                                                        .addComponent(textFieldTelefoneOpcional, -2, 269, -2)))))
                                        .addGap(0, 0, 32767))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                        .addComponent(btConfirmar, -2, 125, -2)
                                        .addGap(25, 25, 25))))
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
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
                                                        .addComponent(comboEstado, 0, 201, 32767))
                                                .addComponent(textFieldComplemento)
                                                .addComponent(textFieldRua)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(textFieldNumero, -2, 100, -2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(textFieldBairro))))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(358, 358, 358)
                                        .addComponent(jLabel2, -2, 105, -2))
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jSeparator1))
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap()));

        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, -2, 26, -2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, -2, 28, -2)
                                .addComponent(textfieldNome, -2, -1, -2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(textFieldCpf, -2, -1, -2)
                                .addComponent(jLabel12)
                                .addComponent(textFieldLimite, -2, -1, -2)
                                .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, -2, 10, -2)
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
                                .addComponent(textFieldComplemento, -2, -1, -2)
                                .addComponent(jLabel10))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(textFieldCidade, -2, -1, -2)
                                .addComponent(jLabel9)
                                .addComponent(comboEstado, -2, -1, -2))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, -2, 10, -2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, 32767)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btConfirmar, -2, 44, -2)
                                .addComponent(btCancelar))
                        .addGap(17, 17, 17)));

        pack();
    }

    private void textFieldCpfActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void comboEstadoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        int result = javax.swing.JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar?");
        if (result == 0) {
            new VisualizarClientes(p).setVisible(true);
            dispose();
        }
    }

    private void textFieldLimiteFocusGained(java.awt.event.FocusEvent evt) {
        if (textFieldLimite.getText().equals("0.0")) {
            textFieldLimite.setText("");
        }
    }

    private void textFieldLimiteFocusLost(java.awt.event.FocusEvent evt) {
        if (textFieldLimite.getText().equals("")) {
            textFieldLimite.setText("0.0");
        }
    }

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
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
        int numero = 0;
        try {
            numero = Integer.parseInt(textFieldNumero.getText());
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Preencha apenas com número.");
            textFieldNumero.setText("");
            textFieldNumero.requestFocusInWindow();
        }
        double limite = Double.parseDouble(textFieldLimite.getText());

        if ((nome.equals("")) || (cpf.equals("   .   .   -  ")) || (rua.equals("")) || (bairro.equals("")) || (cidade.equals(""))
                || (telefone.equals("(  ) 9     -    "))) {
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
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Preecha o número de telefone.");
                textFieldTelefone.requestFocusInWindow();
            }
        } else {
            classes.Cliente cn = new classes.Cliente(cpf, nome, cidade, rua, bairro, numero, complemento, estado, limite, telefone, email, telefoneOpcional);
            DAO.ClienteDAO cd = new DAO.ClienteDAO();
            cd.edit(c, cn);
            dispose();
            new VisualizarClientes(p).setVisible(true);
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        new VisualizarClientes(p).setVisible(true);
    }

    private void textFieldTelefoneActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void textfieldNomeKeyReleased(java.awt.event.KeyEvent evt) {
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36)) {
            textfieldNome.setText(retornaTextoMaiusculo(textfieldNome.getText()));
        }
    }

    private void textfieldNomeKeyPressed(java.awt.event.KeyEvent evt) {
    }

    private void textFieldRuaKeyReleased(java.awt.event.KeyEvent evt) {
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36)) {
            textFieldRua.setText(retornaTextoMaiusculo(textFieldRua.getText()));
        }
    }

    private void textFieldBairroKeyPressed(java.awt.event.KeyEvent evt) {
    }

    private void textFieldBairroKeyReleased(java.awt.event.KeyEvent evt) {
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36)) {
            textFieldBairro.setText(retornaTextoMaiusculo(textFieldBairro.getText()));
        }
    }

    private void textFieldComplementoKeyReleased(java.awt.event.KeyEvent evt) {
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36)) {
            textFieldComplemento.setText(retornaTextoMaiusculo(textFieldComplemento.getText()));
        }
    }

    private void textFieldCidadeKeyReleased(java.awt.event.KeyEvent evt) {
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36)) {
            textFieldCidade.setText(retornaTextoMaiusculo(textFieldCidade.getText()));
        }
    }

    private void textFieldRuaActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void textFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public String retornaTextoMaiusculo(String text) {
        return text.toUpperCase();
    }

    private JTextField textFieldComplemento;
    private javax.swing.JFormattedTextField textFieldCpf;
    private JTextField textFieldEmail;
    private JTextField textFieldLimite;
    private JTextField textFieldNumero;
    private JTextField textFieldRua;
    private javax.swing.JFormattedTextField textFieldTelefone;
    private JTextField textFieldTelefoneOpcional;
    private JTextField textfieldNome;

}
