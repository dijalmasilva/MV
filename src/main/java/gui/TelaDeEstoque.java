package gui;

import DAO.ProdutoDAO;
import classes.Estoque;
import classes.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TelaDeEstoque extends javax.swing.JFrame {

    private final Principal p;
    private final DAO.EstoqueDAO ed;
    private final ProdutoDAO pd;
    private ArrayList<Produto> produtos;
    private ArrayList<Estoque> estoque;
    private int linha = -1;
    private JButton btEditar;
    private JButton btVoltar;
    private JLabel jLabel1;
    private JLabel jLabel2;

    public TelaDeEstoque(Principal p) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        this.p = p;
        ed = new DAO.EstoqueDAO();
        pd = new ProdutoDAO();
        carregarEstoque();
        carregarProdutos();
        estoqueVazio();
        alterarIcone();
    }

    public final void alterarIcone() {
        java.net.URL url = getClass().getResource("/imagens/estoque.png");
        java.awt.Image imagemTitulo = java.awt.Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(imagemTitulo);
    }

    public final void carregarProdutos() {
        produtos = pd.get();

        if (produtos.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Não há produtos cadastrados no banco de dados.");
        } else {
            carregarTabela();
        }
    }

    public void carregarProdutosPorNome(String nome) {
        produtos = pd.getByNames(nome);

        if (produtos.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Não há produtos com esse nome.");
        } else {
            carregarTabela();
        }
    }

    public void carregarProdutosPorCodigo(String codigo) {
        produtos = pd.getByCodigo(codigo);

        if (produtos.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Não há produtos com esse código.");
        } else {
            carregarTabela();
        }
    }

    public final void carregarEstoque() {
        estoque = ed.get();
    }

    public final boolean estoqueVazio() {
        for (Estoque e : estoque) {
            if (e.getQuantidade() > 0) {
                return false;
            }
        }

        return true;
    }

    public void carregarTabela() {
        int n = produtos.size();

        Object[][] o = new Object[n][4];
        int cont = 0;
        for (Produto p : produtos) {
            o[cont][0] = p.getCodigo();
            o[cont][1] = p.getNome();
            o[cont][2] = Double.valueOf(p.getValorSaida());
            o[(cont++)][3] = Integer.valueOf(retornaQuantidadeNoEstoque(p.getCodigo()));
        }

        jTable2.setModel(new javax.swing.table.DefaultTableModel(o, new String[]{"Código", "Nome", "Valor de Saída", "Quantidade"}) {

            boolean[] canEdit = {false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(180);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(25);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(5);
        }
    }

    public int retornaQuantidadeNoEstoque(String codigo) {
        for (Estoque e : estoque) {
            if (e.getCodigo().equals(codigo)) {
                return e.getQuantidade();
            }
        }

        return 0;
    }

    public Produto acharProduto(String codigo) {
        for (Produto pr : produtos) {
            if (pr.getCodigo().equals(codigo)) {
                return pr;
            }
        }

        return null;
    }

    public Estoque acharNoEstoque(String codigo) {
        for (Estoque es : estoque) {
            if (es.getCodigo().equals(codigo)) {
                return es;
            }
        }

        return null;
    }

    private javax.swing.JScrollPane jScrollPane2;

    private JTable jTable2;

    private JTextField textFieldCodigo;
    private JTextField textFieldNome;

    private void initComponents() {
        textFieldCodigo = new JTextField();
        textFieldNome = new JTextField();
        jLabel2 = new JLabel();
        jLabel1 = new JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new JTable();
        btEditar = new JButton();
        btVoltar = new JButton();

        setDefaultCloseOperation(2);
        setTitle("Estoque");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                TelaDeEstoque.this.formWindowClosing(evt);
            }

        });
        textFieldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                TelaDeEstoque.this.textFieldCodigoKeyReleased(evt);
            }

        });
        textFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                TelaDeEstoque.this.textFieldNomeKeyReleased(evt);
            }

        });
        jLabel2.setText("Nome:");

        jLabel1.setText("Código:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(new Object[0][], new String[]{"Código", "Nome", "Valor de Saída", "Quantidade"}) {

            boolean[] canEdit = {false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                TelaDeEstoque.this.jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        btEditar.setBackground(new java.awt.Color(255, 255, 255));
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TelaDeEstoque.this.btEditarActionPerformed(evt);
            }

        });
        btVoltar.setBackground(new java.awt.Color(255, 255, 255));
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TelaDeEstoque.this.btVoltarActionPerformed(evt);
            }

        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, 32767)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(btEditar)
                                                                .addComponent(jScrollPane2, -2, 565, -2))
                                                        .addGap(23, 23, 23))
                                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(btVoltar, -2, 75, -2)
                                                        .addContainerGap())))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldCodigo, -2, 170, -2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textFieldNome)
                                        .addGap(23, 23, 23)))));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(textFieldCodigo, -2, -1, -2)
                                .addComponent(jLabel2)
                                .addComponent(textFieldNome, -2, -1, -2))
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane2, -2, -1, -2)
                        .addGap(18, 18, 18)
                        .addComponent(btEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btVoltar)
                        .addContainerGap(-1, 32767)));

        pack();
    }

    private void textFieldCodigoKeyReleased(KeyEvent evt) {
        String cod = textFieldCodigo.getText();
        if (evt.getKeyCode() != 10) {
            if (cod.equals("")) {
                carregarProdutos();
            } else {
                carregarProdutosPorCodigo(textFieldCodigo.getText());
                carregarTabela();
            }
        }
    }

    private void textFieldNomeKeyReleased(KeyEvent evt) {
        String name = textFieldNome.getText().toUpperCase();
        if ((evt.getKeyCode() != 10) && (evt.getKeyCode() != 37) && (evt.getKeyCode() != 39)) {
            if (name.equals("")) {
                carregarProdutos();
            } else {
                textFieldNome.setText(name);
                carregarProdutosPorNome(name);
                carregarTabela();
            }
        }
    }

    private void btEditarActionPerformed(ActionEvent evt) {
        try {
            int n = jTable2.getSelectedRow();
            String cod = jTable2.getValueAt(n, 0).toString();
            EditarProduto ep = new EditarProduto(p, acharProduto(cod), acharNoEstoque(cod));
            ep.setVisible(true);
            dispose();
        } catch (ArrayIndexOutOfBoundsException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Selecione algum produto na tabela.");
        }
    }

    private void btVoltarActionPerformed(ActionEvent evt) {
        dispose();
        p.setVisible(true);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        p.setVisible(true);
    }

    private void jTable2MouseClicked(MouseEvent evt) {
        int ln = jTable2.getSelectedRow();
        if (ln == linha) {
            btEditarActionPerformed(null);
        }
        linha = jTable2.getSelectedRow();
    }
}
