package gui;

import javax.swing.JMenuItem;

public class Principal extends javax.swing.JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    private JMenuItem jMenuItem6;
    private JMenuItem jMenuItem7;
    private JMenuItem jMenuItem8;
    private JMenuItem jMenuItem9;
    private JMenuItem menuAlterar;
    private javax.swing.JMenu menuCadastrar;
    private javax.swing.JMenu menuVisualizar;

    public Principal() {
        initComponents();
        setResizable(false);
        setSize(500, 400);
        setLocationRelativeTo(null);
        alterarIcone();
    }

    public final void alterarIcone() {
        java.net.URL url = getClass().getResource("/imagens/mv.png");
        java.awt.Image imagemTitulo = java.awt.Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(imagemTitulo);
    }

    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCadastrar = new javax.swing.JMenu();
        jMenuItem2 = new JMenuItem();
        jMenuItem3 = new JMenuItem();
        jMenuItem8 = new JMenuItem();
        menuAlterar = new JMenuItem();
        jMenuItem1 = new JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new JMenuItem();
        menuVisualizar = new javax.swing.JMenu();
        jMenuItem7 = new JMenuItem();
        jMenuItem5 = new JMenuItem();
        jMenuItem6 = new JMenuItem();
        jMenuItem9 = new JMenuItem();

        setDefaultCloseOperation(3);
        setTitle("MV.COM");
        setBackground(new java.awt.Color(255, 255, 255));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Principal.this.formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logout.png")));
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(393, 20, 100, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mv.jpg")));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 380);

        jMenu1.setText("Arquivo");

        menuCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/register.png")));
        menuCadastrar.setText("Cadastrar");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(67, 8));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/newCliente.png")));
        jMenuItem2.setText("Cliente");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.jMenuItem2ActionPerformed(evt);
            }
        });
        menuCadastrar.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(80, 8));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/newProduto.png")));
        jMenuItem3.setText("Produto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.jMenuItem3ActionPerformed(evt);
            }
        });
        menuCadastrar.add(jMenuItem3);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(85, 8));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/newUser.png")));
        jMenuItem8.setText("Usuário");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.jMenuItem8ActionPerformed(evt);
            }
        });
        menuCadastrar.add(jMenuItem8);

        jMenu1.add(menuCadastrar);

        menuAlterar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(83, 8));
        menuAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterKey.png")));
        menuAlterar.setText("Alterar Usuário/Senha");
        jMenu1.add(menuAlterar);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(81, 2));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit.png")));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Venda");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(86, 8));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/venda.png")));
        jMenuItem4.setText("Realizar Venda");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        menuVisualizar.setText("Visualizar");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(67, 9));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/clientes.png")));
        jMenuItem7.setText("Clientes");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.jMenuItem7ActionPerformed(evt);
            }
        });
        menuVisualizar.add(jMenuItem7);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(69, 8));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/estoque.png")));
        jMenuItem5.setText("Estoque");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.jMenuItem5ActionPerformed(evt);
            }
        });
        menuVisualizar.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(70, 8));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/financas.png")));
        jMenuItem6.setText("Finanças");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.jMenuItem6ActionPerformed(evt);
            }
        });
        menuVisualizar.add(jMenuItem6);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(86, 9));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/seeVendas.png")));
        jMenuItem9.setText("Vendas");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.jMenuItem9ActionPerformed(evt);
            }
        });
        menuVisualizar.add(jMenuItem9);

        jMenuBar1.add(menuVisualizar);

        setJMenuBar(jMenuBar1);

        pack();
    }

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        CadastrarProduto cp = new CadastrarProduto(this);
        cp.setVisible(true);
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        int n = javax.swing.JOptionPane.showConfirmDialog(null, "Você deseja realmene sair?");
        if (n == 0) {
            dispose();
        }
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        CadastrarCliente cc = new CadastrarCliente(this);
        cc.setVisible(true);
    }

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        RealizarVenda venda = new RealizarVenda(this);
        venda.setVisible(true);
    }

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        new CadastrarUsuario(this).setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        new Login(new DAO.UsuarioDAO().get()).setVisible(true);
    }

    private void formKeyReleased(java.awt.event.KeyEvent evt) {
    }

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        new VisualizarClientes(this).setVisible(true);
    }

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        TelaDeEstoque t = new TelaDeEstoque(this);
        t.setVisible(true);
    }

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {
        VisualizarVendas vendas = new VisualizarVendas(this);
        vendas.setVisible(true);
        dispose();
    }

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public void controletotal(boolean b) {
        menuAlterar.setEnabled(b);
        menuCadastrar.setEnabled(b);
        menuVisualizar.setEnabled(b);
    }

    public void cadastrarNovoCliente(String cpf) {
        CadastrarCliente c = new CadastrarCliente(this);
        c.preencherCPF(cpf);
        c.setVisible(true);
        dispose();
    }
}
