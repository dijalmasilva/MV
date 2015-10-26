package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastrarCliente extends javax.swing.JFrame {

    private Principal p;
    private FinalVenda f;
    private boolean naVenda;
    private boolean podeFinalizar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JComboBox comboEstado;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;

    public CadastrarCliente(Principal p) {
        initComponents();
        setSize(806, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        this.p = p;
        naVenda = false;
        alterarIcone();
    }

    public CadastrarCliente(FinalVenda f, Principal p) {
        initComponents();
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        this.p = p;
        this.f = f;
        naVenda = true;
        alterarIcone();
    }

    public final void alterarIcone() {
        java.net.URL url = getClass().getResource("/imagens/newCliente.png");
        java.awt.Image imagemTitulo = java.awt.Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(imagemTitulo);
    }

    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private JTextField textFieldBairro;
    private JTextField textFieldCidade;

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
        jLabel12 = new JLabel();
        textFieldLimite = new JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new JLabel();
        textFieldTelefone = new javax.swing.JFormattedTextField();
        jLabel14 = new JLabel();
        textFieldEmail = new JTextField();
        btCancelar = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        textFieldTelefoneOpcional = new JTextField();

        setDefaultCloseOperation(2);
        setTitle("Cadastrar Cliente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                CadastrarCliente.this.formWindowClosing(evt);
            }

        });
        jLabel1.setText("Nome Completo:");

        textfieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                CadastrarCliente.this.textfieldNomeKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                CadastrarCliente.this.textfieldNomeKeyReleased(evt);
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
            public void actionPerformed(ActionEvent evt) {
                CadastrarCliente.this.textFieldCpfActionPerformed(evt);
            }
        });
        textFieldCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                CadastrarCliente.this.textFieldCpfKeyReleased(evt);
            }

        });
        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel4.setText("Endereço");

        jLabel5.setText("Rua:");

        textFieldRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CadastrarCliente.this.textFieldRuaActionPerformed(evt);
            }
        });
        textFieldRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                CadastrarCliente.this.textFieldRuaKeyReleased(evt);
            }

        });
        jLabel6.setText("Número:");

        jLabel7.setText("Bairro:");

        textFieldBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                CadastrarCliente.this.textFieldBairroKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                CadastrarCliente.this.textFieldBairroKeyReleased(evt);
            }

        });
        jLabel8.setText("Cidade:");

        textFieldCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                CadastrarCliente.this.textFieldCidadeKeyReleased(evt);
            }

        });
        jLabel9.setText("Estado:");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"ACRE", "ALAGOAS", "AMAPÁ", "AMAZONAS", "BAHIA", "CEARÁ", "DISTRITO FEDERAL", "ESPÍRITO SANTO", "GOIÁS", "MARANHÃO", "MATO GROSSO", "MATO GROSSO DO SUL", "MINAS GERAIS", "PARÁ", "PARAÍBA", "PARANÁ", "PERNAMBUCO", "PIAUÍ", "RIO DE JANEIRO", "RIO GRANDE DO NORTE", "RIO GRANDE DO SUL", "RONDÔNIA ", "RORAIMA", "SANTA CATARINA", "SÃO PAULO", "SERGIPE", "TOCANTINS"}));
        comboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CadastrarCliente.this.comboEstadoActionPerformed(evt);
            }

        });
        jLabel10.setText("Complemento:");

        textFieldComplemento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                CadastrarCliente.this.textFieldComplementoKeyReleased(evt);
            }

        });
        jLabel11.setFont(new java.awt.Font("sansserif", 1, 12));
        jLabel11.setText("Contato");

        jLabel12.setText("Limite:");

        textFieldLimite.setText("0.0");
        textFieldLimite.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CadastrarCliente.this.textFieldLimiteFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                CadastrarCliente.this.textFieldLimiteFocusLost(evt);
            }

        });
        jLabel13.setText("Telefone:");
        try {
            textFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) 9 ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textFieldTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CadastrarCliente.this.textFieldTelefoneActionPerformed(evt);
            }

        });
        jLabel14.setText("E-mail:");

        textFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CadastrarCliente.this.textFieldEmailActionPerformed(evt);
            }

        });
        btCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png")));
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CadastrarCliente.this.btCancelarActionPerformed(evt);
            }

        });
        btConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/yes.png")));
        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CadastrarCliente.this.btConfirmarActionPerformed(evt);
            }

        });
        jLabel15.setText("R$");

        jLabel16.setText("Telefone opcional:");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(246, 246, 246)
                                                        .addComponent(jLabel11))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(textFieldTelefone, -2, 220, -2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                                        .addComponent(jLabel16)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(textFieldTelefoneOpcional, -2, 250, -2))
                                                .addComponent(textFieldEmail, -2, 624, -2))
                                        .addContainerGap(-1, 32767))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                        .addComponent(btConfirmar, -2, 125, -2)
                                        .addGap(25, 25, 25))))
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
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
                                                        .addComponent(jLabel2, -2, 105, -2)))
                                        .addGap(0, 0, 32767)))
                        .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldCpf, -2, 224, -2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldLimite, -2, 252, -2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, -2, 26, -2)
                        .addGap(86, 86, 86))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(23, 32767)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(372, 372, 372))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1, -2, 95, -2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textfieldNome, -2, 623, -2)
                                        .addGap(59, 59, 59))))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)
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

    private void textFieldCpfActionPerformed(ActionEvent evt) {
    }

    private void comboEstadoActionPerformed(ActionEvent evt) {
    }

    private void btCancelarActionPerformed(ActionEvent evt) {
        int result = javax.swing.JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar?");
        if (result == 0) {
            if (naVenda) {
                f.setVisible(true);
            } else {
                p.setVisible(true);
            }
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

    private void btConfirmarActionPerformed(ActionEvent evt) {
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
        } else if (podeFinalizar) {
            classes.Cliente c = new classes.Cliente(cpf, nome, cidade, rua, bairro, numero, complemento, estado, limite, telefone, email, telefoneOpcional);
            DAO.ClienteDAO cd = new DAO.ClienteDAO();
            if (cd.add(c)) {
                if (naVenda) {
                    f.preencherComboClientePorNome(nome);
                    f.setClientes(cd.get());
                    f.comboForma();
                    f.setVisible(true);
                } else {
                    int n = javax.swing.JOptionPane.showConfirmDialog(null, "Deseja cadastrar um novo cliente?");
                    if (n == 0) {
                        new CadastrarCliente(p).setVisible(true);
                    } else {
                        p.setVisible(true);
                    }
                }
                dispose();
            }
        } else {
            textFieldCpf.requestFocusInWindow();
            javax.swing.JOptionPane.showMessageDialog(null, "Insira um CPF válido.");
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        p.setVisible(true);
    }

    private void textFieldTelefoneActionPerformed(ActionEvent evt) {
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

    private void textFieldRuaActionPerformed(ActionEvent evt) {
    }

    private void textFieldEmailActionPerformed(ActionEvent evt) {
    }

    private void textFieldCpfKeyReleased(KeyEvent evt) {
        if ((evt.getKeyCode() != 10)
                && (textFieldCpf.getText().charAt(12) != ' ')) {
            classes.VerificadorDeCPF v = new classes.VerificadorDeCPF(textFieldCpf.getText());
            if (v.verificarPrimeiroDigito()) {
                if (textFieldCpf.getText().charAt(13) != ' ') {
                    if (!v.verificarSegundoDigito()) {
                        javax.swing.JOptionPane.showMessageDialog(null, "CPF INVÁLIDO.");
                        podeFinalizar = false;
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

    public void preencherCPF(String cpf) {
        textFieldCpf.setText(cpf);
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
