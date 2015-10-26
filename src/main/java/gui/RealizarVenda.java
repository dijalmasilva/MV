package gui;

import classes.Estoque;
import classes.ItemDeVenda;
import classes.Produto;
import classes.Venda;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class RealizarVenda extends javax.swing.JFrame {

    private final Principal p;
    private final DAO.ProdutoDAO pd;
    private final DAO.EstoqueDAO ed;
    private ArrayList<Produto> produtos;
    private final ArrayList<Estoque> estoque;
    private Produto produto;
    private String codigoProduto;
    private final Venda venda;
    private Object[][] ob;
    private int entrada;
    java.text.DecimalFormat df = new java.text.DecimalFormat("#,###.00");
    private JButton btAdicionaProduto;
    private JButton btRemover;
    private JButton jButton4;
    private JButton jButton5;
    private JComboBox jComboBox1;

    public RealizarVenda(Principal p) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(710, 680);
        this.p = p;
        pd = new DAO.ProdutoDAO();
        ed = new DAO.EstoqueDAO();
        carregarProdutos();
        estoque = ed.get();
        venda = new Venda();
        entrada = 0;
        preencheComboProdutosPorNome("");
        tableItens.removeAll();
        alterarIcone();
    }

    private JLabel jLabel1;

    public final void alterarIcone() {
        java.net.URL url = getClass().getResource("/imagens/venda.png");
        java.awt.Image imagemTitulo = java.awt.Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(imagemTitulo);
    }

    private JLabel jLabel10;

    public final void carregarProdutos() {
        produtos = pd.get();
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há produtos cadastrados!");
        }
    }

    private JLabel jLabel2;
    private JLabel jLabel3;

    public void carregarProdutosPorNome(String nome) {
        produtos = pd.getByNames(nome);

        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há nenhum produto com esse nome.");
        }
    }

    private JLabel jLabel4;
    private JLabel jLabel5;

    public void carregarProdutosPorCodigo(String codigo) {
        produtos = pd.getByCodigo(codigo);

        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há nenhum produto com esse código.");
        }
    }

    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private JLabel labelEmEstoque;

    private void initComponents() {
        jLabel2 = new JLabel();
        textFieldNomeProduto = new JTextField();
        spinnerQuantidade = new javax.swing.JSpinner();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        labelPrecoUnitario = new JLabel();
        jLabel6 = new JLabel();
        btAdicionaProduto = new JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableItens = new JTable();
        btRemover = new JButton();
        jLabel7 = new JLabel();
        labelTotal = new JLabel();
        jLabel9 = new JLabel();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jComboBox1 = new JComboBox();
        jLabel1 = new JLabel();
        jLabel5 = new JLabel();
        labelEmEstoque = new JLabel();
        jLabel8 = new JLabel();
        jLabel10 = new JLabel();
        textFieldCodigo = new JTextField();

        setDefaultCloseOperation(2);
        setTitle("Realizar Venda");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                RealizarVenda.this.formWindowClosing(evt);
            }

        });
        jLabel2.setText("Buscar Produto:");

        textFieldNomeProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                RealizarVenda.this.textFieldNomeProdutoFocusLost(evt);
            }
        });
        textFieldNomeProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                RealizarVenda.this.textFieldNomeProdutoKeyReleased(evt);
            }

        });
        spinnerQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                RealizarVenda.this.spinnerQuantidadeFocusGained(evt);
            }

        });
        jLabel3.setText("Quantidade:");

        jLabel4.setFont(new Font("sansserif", 0, 18));
        jLabel4.setText("Preço Unitário:");

        labelPrecoUnitario.setFont(new Font("sansserif", 0, 18));
        labelPrecoUnitario.setHorizontalAlignment(4);
        labelPrecoUnitario.setText("0.0");

        jLabel6.setFont(new Font("sansserif", 0, 18));
        jLabel6.setText("R$");

        btAdicionaProduto.setBackground(new java.awt.Color(255, 255, 255));
        btAdicionaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/addVenda.png")));
        btAdicionaProduto.setText("Adicionar Produto");
        btAdicionaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RealizarVenda.this.btAdicionaProdutoActionPerformed(evt);
            }

        });
        tableItens.setModel(new javax.swing.table.DefaultTableModel(new Object[0][], new String[]{"Nome", "Preco Unitário", "Quantidade", "Preço Total"}) {

            Class[] types = {String.class, Double.class, Integer.class, Double.class};

            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableItens);
        if (tableItens.getColumnModel().getColumnCount() > 0) {
            tableItens.getColumnModel().getColumn(0).setResizable(false);
            tableItens.getColumnModel().getColumn(0).setPreferredWidth(200);
            tableItens.getColumnModel().getColumn(1).setResizable(false);
            tableItens.getColumnModel().getColumn(1).setPreferredWidth(4);
            tableItens.getColumnModel().getColumn(2).setResizable(false);
            tableItens.getColumnModel().getColumn(2).setPreferredWidth(4);
            tableItens.getColumnModel().getColumn(3).setResizable(false);
            tableItens.getColumnModel().getColumn(3).setPreferredWidth(4);
        }

        btRemover.setBackground(new java.awt.Color(255, 255, 255));
        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/removeVenda.png")));
        btRemover.setText("Remover ");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RealizarVenda.this.btRemoverActionPerformed(evt);
            }

        });
        jLabel7.setFont(new Font("Calibri", 1, 24));
        jLabel7.setText("TOTAL:");

        labelTotal.setFont(new Font("Calibri", 1, 24));
        labelTotal.setHorizontalAlignment(4);
        labelTotal.setText("0.0");

        jLabel9.setFont(new Font("Calibri", 0, 24));
        jLabel9.setText("R$");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png")));
        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RealizarVenda.this.jButton4ActionPerformed(evt);
            }

        });
        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/yes.png")));
        jButton5.setText("Concluir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RealizarVenda.this.jButton5ActionPerformed(evt);
            }

        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RealizarVenda.this.jComboBox1ActionPerformed(evt);
            }

        });
        jLabel1.setText("Em estoque:");

        jLabel5.setFont(new Font("sansserif", 0, 14));
        jLabel5.setText("unidades");

        labelEmEstoque.setFont(new Font("sansserif", 0, 14));
        labelEmEstoque.setHorizontalAlignment(4);
        labelEmEstoque.setText("0");

        jLabel8.setText("Nome:");

        jLabel10.setText("Código:");

        textFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RealizarVenda.this.textFieldCodigoActionPerformed(evt);
            }
        });
        textFieldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                RealizarVenda.this.textFieldCodigoKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                RealizarVenda.this.textFieldCodigoKeyReleased(evt);
            }

        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(78, 78, 78)
                                                                        .addComponent(jLabel4)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(labelPrecoUnitario, -2, 73, -2)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(jLabel6)
                                                                        .addGap(0, 0, 32767))
                                                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addGap(20, 20, 20)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(jLabel10)
                                                                                        .addGap(10, 10, 10)
                                                                                        .addComponent(textFieldCodigo, -2, 179, -2)
                                                                                        .addGap(18, 18, 18)
                                                                                        .addComponent(jLabel2))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(jLabel1)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                                                                        .addComponent(jLabel3)))))
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(spinnerQuantidade, -2, 198, -2))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(81, 81, 81)
                                                                        .addComponent(btAdicionaProduto)))
                                                        .addGap(10, 10, 10))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jButton4)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                                        .addComponent(jButton5, -2, 110, -2))))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(0, 0, 32767)
                                                        .addComponent(labelEmEstoque, -2, 31, -2)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel5)
                                                        .addGap(463, 463, 463))
                                                .addComponent(jScrollPane1, -1, 670, 32767))
                                        .addGap(10, 10, 10))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(btRemover)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                        .addComponent(jLabel7, -2, 83, -2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelTotal, -2, 110, -2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9, -2, 56, -2)))
                        .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(-1, 32767)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBox1, -2, 615, -2)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldNomeProduto, -2, 367, -2)))
                        .addGap(21, 21, 21)));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textFieldNomeProduto, -2, -1, -2)
                                .addComponent(jLabel8)
                                .addComponent(jLabel10)
                                .addComponent(textFieldCodigo, -2, -1, -2))
                        .addGap(12, 12, 12)
                        .addComponent(jComboBox1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(spinnerQuantidade, -2, -1, -2)
                                                .addComponent(jLabel3)))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel5)
                                                .addComponent(labelEmEstoque))
                                        .addGap(0, 0, 32767)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(labelPrecoUnitario, -2, 28, -2)
                                .addComponent(jLabel6)
                                .addComponent(btAdicionaProduto, -2, 47, -2))
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, -2, 257, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(btRemover)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9, -2, 46, -2)
                                                        .addComponent(labelTotal, -2, 46, -2)
                                                        .addComponent(jLabel7, -2, 46, -2)))
                                        .addGap(49, 49, 49)
                                        .addComponent(jButton4))
                                .addComponent(jButton5, GroupLayout.Alignment.TRAILING, -2, 50, -2))
                        .addContainerGap()));

        pack();
    }

    private void textFieldNomeProdutoKeyReleased(KeyEvent evt) {
        if ((evt.getKeyCode() != 36) && (evt.getKeyCode() != 16) && (evt.getKeyCode() != 17) && (evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 10)) {
            textFieldNomeProduto.setText(retornaTextoMaiusculo(textFieldNomeProduto.getText()));
            preencheComboProdutosPorNome(textFieldNomeProduto.getText());
            labelEmEstoque.setForeground(java.awt.Color.BLACK);
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        p.setVisible(true);
    }

    private void jButton5ActionPerformed(ActionEvent evt) {
        if (venda.getItens().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Adicione pelo menos um produto a venda.");
        } else {
            dispose();
            new FinalVenda(venda, estoque, p).setVisible(true);
        }
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        int result = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar a compra?");
        if (result == 0) {
            dispose();
            p.setVisible(true);
        }
    }

    private void btAdicionaProdutoActionPerformed(ActionEvent evt) {
        boolean podeAdd = false;
        int quantidade = 1;
        try {
            quantidade = Integer.parseInt(spinnerQuantidade.getValue().toString());
        } catch (NumberFormatException localNumberFormatException) {
        }

        int qtde = Integer.parseInt(labelEmEstoque.getText());

        if ((produto == null) || (qtde == 0) || (quantidade > qtde) || (quantidade == 0)) {
            if (produto == null) {
                JOptionPane.showMessageDialog(null, "Você não selecionou nenhum produto!");
            } else if (qtde == 0) {
                JOptionPane.showMessageDialog(null, "Não há mais deste produto no estoque!");
                labelEmEstoque.setForeground(java.awt.Color.red);
            } else if (quantidade == 0) {
                JOptionPane.showMessageDialog(null, "Insira no mínimo 1 item do produto.");
                spinnerQuantidade.requestFocusInWindow();
            } else {
                labelEmEstoque.setForeground(java.awt.Color.red);
                int result = JOptionPane.showConfirmDialog(null, "Você selecionou uma quantidade de itens a mais do que existe no estoque. \nDeseja continuar a compra com o(s) " + qtde + " restantes?");

                if (result == 0) {
                    podeAdd = true;
                    quantidade = qtde;
                }
            }
        } else {
            podeAdd = true;
        }

        if (podeAdd) {
            boolean addItem = true;
            ArrayList<ItemDeVenda> itens = venda.getItens();
            for (ItemDeVenda it : itens) {
                if (produto.getNome().equals(it.getP().getNome())) {
                    addItem = false;
                    it.setQtde(it.getQtde() + quantidade);
                    it.setSubTotal();
                }
            }

            if (addItem) {
                ItemDeVenda item = new ItemDeVenda(produto, quantidade);
                venda.addItens(item);
            } else {
                venda.setItens(itens);
                venda.mudarTotal();
            }

            labelTotal.setText("" + df.format(venda.getTotal()));
            preecherTabela();

            Estoque e = acharNoEstoque(codigoProduto);
            e.setQuantidade(e.getQuantidade() - quantidade);
            textFieldNomeProduto.setText("");
            textFieldCodigo.setText("");
            textFieldCodigo.requestFocusInWindow();
            preencheComboProdutosPorCodigo("");
        }
    }

    private void jComboBox1ActionPerformed(ActionEvent evt) {
        preencherCampos2();
    }

    private void textFieldNomeProdutoFocusLost(FocusEvent evt) {
    }

    private void spinnerQuantidadeFocusGained(FocusEvent evt) {
    }

    private void btRemoverActionPerformed(ActionEvent evt) {
        try {
            int linha = tableItens.getSelectedRow();
            String nome = "" + tableItens.getValueAt(linha, 0);
            ItemDeVenda item = acharItemDeVenda(nome);
            Estoque e = acharNoEstoque(produto.getCodigo());
            e.setQuantidade(e.getQuantidade() + item.getQtde());
            venda.removerItens(item);
            labelTotal.setText("" + df.format(venda.getTotal()));
            preecherTabela();
            jComboBox1ActionPerformed(evt);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Selecione algum item na tabela!");
        }
    }

    private void textFieldCodigoKeyReleased(KeyEvent evt) {
        if ((evt.getKeyCode() != 65) && (evt.getKeyCode() != 36) && (evt.getKeyCode() != 16) && (evt.getKeyCode() != 17) && (evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 10)) {
            preencheComboProdutosPorCodigo(textFieldCodigo.getText());
        }
    }

    private void textFieldCodigoActionPerformed(ActionEvent evt) {
    }

    private void textFieldCodigoKeyPressed(KeyEvent evt) {
    }

    public String retornaTextoMaiusculo(String text) {
        return text.toUpperCase();
    }

    public final void preencheComboProdutosPorNome(String nome) {
        carregarProdutosPorNome(nome);
        jComboBox1.removeAllItems();
        int cont = 1;
        if (produtos != null) {
            for (Produto pr : produtos) {
                if (cont++ == 1) {
                    produto = pr;
                    codigoProduto = produto.getCodigo();
                }
                jComboBox1.addItem(pr.getNome());
            }
        }
        preencherCamposDoInicio();
    }

    public final void preencheComboProdutosPorCodigo(String codigo) {
        carregarProdutosPorCodigo(codigo);
        jComboBox1.removeAllItems();
        int cont = 1;
        if (produtos != null) {
            for (Produto pr : produtos) {
                if (cont++ == 1) {
                    produto = pr;
                    codigoProduto = produto.getCodigo();
                }
                jComboBox1.addItem(pr.getNome());
            }
        }
        preencherCamposDoInicio();
    }

    public Estoque acharNoEstoque(String idProduto) {
        for (Estoque es : estoque) {
            if (idProduto.equals(es.getCodigo())) {
                return es;
            }
        }
        return null;
    }

    public void preencherCamposDoInicio() {
        try {
            labelEmEstoque.setText("" + acharNoEstoque(codigoProduto).getQuantidade());
            labelPrecoUnitario.setText("" + df.format(produto.getValorSaida()));
        } catch (NullPointerException ex) {
            if (entrada < 1) {
                JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
                entrada += 1;
            }
        }
    }

    public void preencherCampos2() {
        try {
            String nome = jComboBox1.getSelectedItem().toString();

            for (Produto pr : produtos) {
                if (nome.equals(pr.getNome())) {
                    produto = pr;
                    codigoProduto = produto.getCodigo();
                }
            }
            preencherCamposDoInicio();
        } catch (NullPointerException localNullPointerException) {
        }
    }

    public void preecherTabela() {
        int size = venda.getItens().size();
        ob = new Object[size][4];

        int cont = 0;

        for (ItemDeVenda item : venda.getItens()) {
            ob[cont][0] = item.getP().getNome();
            ob[cont][1] = Double.valueOf(item.getP().getValorSaida());
            ob[cont][2] = Integer.valueOf(item.getQtde());
            ob[(cont++)][3] = Double.valueOf(item.getSubTotal());
        }

        tableItens.setModel(new javax.swing.table.DefaultTableModel(ob, new String[]{"Nome", "Preco Unitário", "Quantidade", "Preço Total"}) {

            Class[] types = {String.class, Double.class, Integer.class, Double.class};

            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });
        jScrollPane1.setViewportView(tableItens);

        if (tableItens.getColumnModel().getColumnCount() > 0) {
            tableItens.getColumnModel().getColumn(0).setResizable(false);
            tableItens.getColumnModel().getColumn(0).setPreferredWidth(200);
            tableItens.getColumnModel().getColumn(1).setResizable(false);
            tableItens.getColumnModel().getColumn(1).setPreferredWidth(4);
            tableItens.getColumnModel().getColumn(2).setResizable(false);
            tableItens.getColumnModel().getColumn(2).setPreferredWidth(4);
            tableItens.getColumnModel().getColumn(3).setResizable(false);
            tableItens.getColumnModel().getColumn(3).setPreferredWidth(4);
        }
    }

    public ItemDeVenda acharItemDeVenda(String nome) {
        ItemDeVenda item = null;

        for (ItemDeVenda i : venda.getItens()) {
            if (i.getP().getNome().equals(nome)) {
                return i;
            }
        }

        return item;
    }

    private JLabel labelPrecoUnitario;
    private JLabel labelTotal;
    private javax.swing.JSpinner spinnerQuantidade;
    private JTable tableItens;
    private JTextField textFieldCodigo;
    private JTextField textFieldNomeProduto;

}
