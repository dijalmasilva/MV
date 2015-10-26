package gui;

import javax.swing.JTextField;

public class EditarProduto extends javax.swing.JFrame {

    private Principal principal;
    private classes.Produto produto;
    private classes.Estoque e;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btGerarCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton radioDesconto;
    private javax.swing.JSpinner spinnerQuantidade;
    public JTextField textFieldCodigo;
    private JTextField textFieldDesconto;
    private JTextField textFieldNome;
    private JTextField textFieldSaida;
    private JTextField textFieldValorEntrada;

    public EditarProduto(Principal p, classes.Produto produto, classes.Estoque e) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(650, 370);
        textFieldDesconto.setEnabled(false);
        principal = p;
        this.produto = produto;
        this.e = e;
        textFieldCodigo.setEnabled(false);
        btGerarCodigo.setEnabled(false);
        preencherCampos();
    }

    public EditarProduto(Principal p) {
        initComponents();
        principal = p;
    }

    public final void preencherCampos() {
        textFieldCodigo.setText(produto.getCodigo());
        textFieldNome.setText(produto.getNome());
        textFieldDesconto.setText(produto.getDesconto() + "");
        textFieldSaida.setText(produto.getValorSaida() + "");
        textFieldValorEntrada.setText(produto.getValorEntrada() + "");
        spinnerQuantidade.setValue(Integer.valueOf(e.getQuantidade()));
    }

    private void initComponents() {
        textFieldNome = new JTextField();
        textFieldCodigo = new JTextField();
        textFieldValorEntrada = new JTextField();
        btConfirmar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        textFieldSaida = new JTextField();
        radioDesconto = new javax.swing.JRadioButton();
        textFieldDesconto = new JTextField();
        spinnerQuantidade = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btGerarCodigo = new javax.swing.JButton();

        setDefaultCloseOperation(2);
        setTitle("Cadastrar Produto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                EditarProduto.this.formWindowClosing(evt);
            }

        });
        textFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarProduto.this.textFieldNomeActionPerformed(evt);
            }
        });
        textFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditarProduto.this.textFieldNomeKeyReleased(evt);
            }

        });
        textFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarProduto.this.textFieldCodigoActionPerformed(evt);
            }
        });
        textFieldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EditarProduto.this.textFieldCodigoKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditarProduto.this.textFieldCodigoKeyReleased(evt);
            }

            public void keyTyped(java.awt.event.KeyEvent evt) {
                EditarProduto.this.textFieldCodigoKeyTyped(evt);
            }

        });
        textFieldValorEntrada.setText("0.0");
        textFieldValorEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EditarProduto.this.textFieldValorEntradaFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                EditarProduto.this.textFieldValorEntradaFocusLost(evt);
            }

        });
        btConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/yes.png")));
        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarProduto.this.btConfirmarActionPerformed(evt);
            }

        });
        btCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png")));
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarProduto.this.btCancelarActionPerformed(evt);
            }

        });
        textFieldSaida.setText("0.0");
        textFieldSaida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EditarProduto.this.textFieldSaidaFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                EditarProduto.this.textFieldSaidaFocusLost(evt);
            }

        });
        radioDesconto.setText("Desconto");
        radioDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarProduto.this.radioDescontoActionPerformed(evt);
            }

        });
        textFieldDesconto.setText("0");
        textFieldDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EditarProduto.this.textFieldDescontoFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                EditarProduto.this.textFieldDescontoFocusLost(evt);
            }
        });
        textFieldDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarProduto.this.textFieldDescontoActionPerformed(evt);
            }

        });
        spinnerQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EditarProduto.this.spinnerQuantidadeFocusGained(evt);
            }

        });
        jLabel1.setText("Código:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Valor de Entrada:");

        jLabel4.setText("R$");

        jLabel5.setText("Valor de Venda:");

        jLabel6.setText("R$");

        jLabel7.setText("Quantidade:");

        jLabel8.setText("%");

        btGerarCodigo.setBackground(new java.awt.Color(255, 255, 255));
        btGerarCodigo.setText("Gerar Código");
        btGerarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarProduto.this.btGerarCodigoActionPerformed(evt);
            }

        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btCancelar)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1)
                                .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textFieldNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(textFieldValorEntrada)
                                                .addComponent(spinnerQuantidade, -1, 160, 32767))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addGap(51, 51, 51)
                                                        .addComponent(jLabel5))
                                                .addComponent(radioDesconto, -2, 89, -2))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(textFieldSaida, -2, 155, -2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel6))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(textFieldDesconto, -2, 155, -2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel8))))
                                .addComponent(btConfirmar)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(textFieldCodigo, -2, 319, -2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, 32767)
                                        .addComponent(btGerarCodigo)
                                        .addGap(24, 24, 24)))
                        .addContainerGap(-1, 32767)));

        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(textFieldCodigo, -2, -1, -2)
                                .addComponent(btGerarCodigo))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(textFieldNome, -2, -1, -2))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(textFieldValorEntrada, -2, -1, -2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(textFieldSaida, -2, -1, -2)
                                .addComponent(jLabel6))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(spinnerQuantidade, -2, -1, -2)
                                .addComponent(radioDesconto, -2, 29, -2)
                                .addComponent(textFieldDesconto, -2, -1, -2)
                                .addComponent(jLabel8))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btCancelar)
                                .addComponent(btConfirmar, -2, 45, -2))
                        .addContainerGap(32, 32767)));

        pack();
    }

    private void textFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        int n = javax.swing.JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar?");
        if (n == 0) {
            new TelaDeEstoque(principal).setVisible(true);
            dispose();
        }
    }

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        String codigo = textFieldCodigo.getText();
        String nome = textFieldNome.getText();
        int desconto = Integer.parseInt(textFieldDesconto.getText());
        double valorEntrada = Double.parseDouble(textFieldValorEntrada.getText());
        double valorSaida = Double.parseDouble(textFieldSaida.getText());
        int quantidade = Integer.parseInt(spinnerQuantidade.getValue().toString());

        if ((codigo.equals("")) || (nome.equals("")) || (valorEntrada == 0.0D) || (valorSaida == 0.0D)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            if (codigo.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Preencha o código do produto.");
                textFieldCodigo.requestFocusInWindow();
            } else if (nome.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Preencha o nome do produto.");
                textFieldNome.requestFocusInWindow();
            } else if (valorEntrada == 0.0D) {
                javax.swing.JOptionPane.showMessageDialog(null, "Preencha o campo de Valor de Entrada com valor diferente de 0.");
                textFieldValorEntrada.requestFocusInWindow();
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Preencha o campo de Valor de Saída com valor diferente de 0.");
                textFieldSaida.requestFocusInWindow();
            }
        } else {
            produto.setCodigo(codigo);
            produto.setNome(nome);
            produto.setValorEntrada(valorEntrada);
            produto.setValorSaida(valorSaida);
            produto.setDesconto(desconto);
            DAO.ProdutoDAO pd = new DAO.ProdutoDAO();
            if (pd.edit(produto)) {
                DAO.EstoqueDAO ed = new DAO.EstoqueDAO();
                e.setQuantidade(quantidade);
                ed.edit(e);
            }

            dispose();
            new TelaDeEstoque(principal).setVisible(true);
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        new TelaDeEstoque(principal).setVisible(true);
    }

    private void textFieldDescontoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void textFieldValorEntradaFocusGained(java.awt.event.FocusEvent evt) {
        if (textFieldValorEntrada.getText().equals("0.0")) {
            textFieldValorEntrada.setText("");
        }
    }

    private void textFieldValorEntradaFocusLost(java.awt.event.FocusEvent evt) {
        if (textFieldValorEntrada.getText().equals("")) {
            textFieldValorEntrada.setText("0.0");
        }
    }

    private void textFieldSaidaFocusGained(java.awt.event.FocusEvent evt) {
        if (textFieldSaida.getText().equals("0.0")) {
            textFieldSaida.setText("");
        }
    }

    private void textFieldSaidaFocusLost(java.awt.event.FocusEvent evt) {
        if (textFieldSaida.getText().equals("")) {
            textFieldSaida.setText("0.0");
        }
    }

    private void textFieldDescontoFocusGained(java.awt.event.FocusEvent evt) {
        if (textFieldDesconto.getText().equals("0")) {
            textFieldDesconto.setText("");
        }
    }

    private void textFieldDescontoFocusLost(java.awt.event.FocusEvent evt) {
        if (textFieldDesconto.getText().equals("")) {
            textFieldDesconto.setText("0");
        }
    }

    private void radioDescontoActionPerformed(java.awt.event.ActionEvent evt) {
        if (radioDesconto.getFocusTraversalKeysEnabled()) {
            textFieldDesconto.setEnabled(true);
        } else {
            textFieldDesconto.setEnabled(false);
        }
    }

    private void spinnerQuantidadeFocusGained(java.awt.event.FocusEvent evt) {
    }

    private void textFieldCodigoKeyReleased(java.awt.event.KeyEvent evt) {
    }

    private void textFieldCodigoKeyPressed(java.awt.event.KeyEvent evt) {
    }

    private void textFieldCodigoKeyTyped(java.awt.event.KeyEvent evt) {
    }

    private void textFieldNomeKeyReleased(java.awt.event.KeyEvent evt) {
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36) && (evt.getKeyCode() != 17) && (evt.getKeyCode() != 16) && (evt.getKeyCode() != 8)) {
            textFieldNome.setText(retornaTextoMaiusculo(textFieldNome.getText()));
        }
    }

    private void btGerarCodigoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void textFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public String retornaTextoMaiusculo(String text) {
        return text.toUpperCase();
    }
}
