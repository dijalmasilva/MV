package gui;

import DAO.ParcelasDAO;
import classes.Parcelas;
import classes.Venda;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

public class DetalhesDaVenda extends javax.swing.JFrame {

    private final Principal principal;
    private ArrayList<Parcelas> parcelasPagas;
    private Venda venda;
    java.text.DecimalFormat df = new java.text.DecimalFormat("#,###.00");
    private JButton btEditarParcela;
    private JButton btPagarParcela;
    private JButton btVoltar;
    private JLabel jLabel1;

    public DetalhesDaVenda(Principal principal) {
        initComponents();
        this.principal = principal;
        setLocationRelativeTo(null);
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public final void preencherCampos() {
        labelVenda.setText("Venda " + venda.getCodigo());
        labelCPF.setText(venda.getCpfCliente());
        labelDataDaVenda.setText(venda.getData().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yy")));
        labelNomeDoCliente.setText(new DAO.ClienteDAO().getNome(venda.getCpfCliente()));
        labelTotalDaVenda.setText(df.format(venda.getTotal()));
    }

    public final void preencherTabelaParcelas() {
        int size = venda.getParcelas().size();

        parcelasPagas = new ParcelasDAO().getParcelasPagasPorIDDeVenda(venda.getCodigo());

        size += parcelasPagas.size();

        Object[][] o = new Object[size][3];

        int cont = 0;

        for (Parcelas p : venda.getParcelas()) {
            o[cont][0] = Double.valueOf(p.getValor());
            o[cont][1] = p.getDataDeVencimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            o[(cont++)][2] = "Não";
        }

        if (!parcelasPagas.isEmpty()) {
            for (Parcelas p : parcelasPagas) {
                o[cont][0] = Double.valueOf(p.getValor());
                o[cont][1] = p.getDataDeVencimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                o[(cont++)][2] = "Sim";
            }
        }

        tableParcelas.setModel(new DefaultTableModel(o, new String[]{"Valor", "Vencimento", "Pago"}) {

            boolean[] canEdit = {false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });
        jScrollPane1.setViewportView(tableParcelas);

        if (tableParcelas.getColumnModel().getColumnCount() > 0) {
            tableParcelas.getColumnModel().getColumn(0).setResizable(false);
            tableParcelas.getColumnModel().getColumn(1).setResizable(false);
            tableParcelas.getColumnModel().getColumn(2).setResizable(false);
            tableParcelas.getColumnModel().getColumn(2).setPreferredWidth(2);
        }
    }

    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

    public final void preecherTabelaItensComprados() {
        Object[][] o = new Object[venda.getItens().size()][4];

        int cont = 0;

        for (classes.ItemDeVenda i : venda.getItens()) {
            o[cont][0] = i.getP().getCodigo();
            o[cont][1] = Integer.valueOf(i.getQtde());
            o[cont][2] = Double.valueOf(i.getP().getValorSaida());
            o[(cont++)][3] = Double.valueOf(i.getSubTotal());
        }

        tableItensComprados.setModel(new DefaultTableModel(o, new String[]{"Código", "Quantidade", "P. Unitário", "Total"}) {

            boolean[] canEdit = {false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });
        jScrollPane2.setViewportView(tableItensComprados);

        if (tableItensComprados.getColumnModel().getColumnCount() > 0) {
            tableItensComprados.getColumnModel().getColumn(0).setResizable(false);
            tableItensComprados.getColumnModel().getColumn(0).setPreferredWidth(130);
            tableItensComprados.getColumnModel().getColumn(1).setResizable(false);
            tableItensComprados.getColumnModel().getColumn(2).setResizable(false);
            tableItensComprados.getColumnModel().getColumn(3).setResizable(false);
        }
    }

    private JLabel labelCPF;
    private JLabel labelDataDaVenda;
    private JLabel labelNomeDoCliente;
    private JLabel labelNomeDoCliente2;
    private JLabel labelTotalDaVenda;
    private JLabel labelVenda;
    private JLabel labelVenda1;
    private JLabel labelVenda2;
    private JTable tableItensComprados;
    private JTable tableParcelas;

    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        tableParcelas = new JTable();
        labelVenda = new JLabel();
        jLabel1 = new JLabel();
        labelNomeDoCliente = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        labelCPF = new JLabel();
        labelVenda1 = new JLabel();
        labelDataDaVenda = new JLabel();
        jLabel6 = new JLabel();
        jScrollPane2 = new JScrollPane();
        tableItensComprados = new JTable();
        labelVenda2 = new JLabel();
        labelTotalDaVenda = new JLabel();
        labelNomeDoCliente2 = new JLabel();
        btVoltar = new JButton();
        btPagarParcela = new JButton();
        btEditarParcela = new JButton();

        setDefaultCloseOperation(2);
        setTitle("Detalhes da Venda");
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                DetalhesDaVenda.this.formWindowClosing(evt);
            }

        });
        tableParcelas.setModel(new DefaultTableModel(new Object[0][], new String[]{"Valor", "Vencimento", "Pago"}) {

            boolean[] canEdit = {false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableParcelas);
        if (tableParcelas.getColumnModel().getColumnCount() > 0) {
            tableParcelas.getColumnModel().getColumn(0).setResizable(false);
            tableParcelas.getColumnModel().getColumn(1).setResizable(false);
            tableParcelas.getColumnModel().getColumn(2).setResizable(false);
            tableParcelas.getColumnModel().getColumn(2).setPreferredWidth(2);
        }

        labelVenda.setFont(new java.awt.Font("sansserif", 1, 14));
        labelVenda.setText("Venda xx");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14));
        jLabel1.setText("Cliente:");

        labelNomeDoCliente.setText("Nome Do Cliente");

        jLabel2.setText("Parcelas");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14));
        jLabel3.setText("CPF:");

        labelCPF.setText("xxx.xxx.xxx-xx");

        labelVenda1.setFont(new java.awt.Font("sansserif", 1, 14));
        labelVenda1.setText("Data da Venda:");

        labelDataDaVenda.setText("dd/MM/yyyy");

        jLabel6.setText("Itens Comprados");

        tableItensComprados.setModel(new DefaultTableModel(new Object[0][], new String[]{"Código", "Quantidade", "P. Unitário", "Total"}) {

            boolean[] canEdit = {false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableItensComprados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DetalhesDaVenda.this.tableItensCompradosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableItensComprados);
        if (tableItensComprados.getColumnModel().getColumnCount() > 0) {
            tableItensComprados.getColumnModel().getColumn(0).setResizable(false);
            tableItensComprados.getColumnModel().getColumn(0).setPreferredWidth(130);
            tableItensComprados.getColumnModel().getColumn(1).setResizable(false);
            tableItensComprados.getColumnModel().getColumn(2).setResizable(false);
            tableItensComprados.getColumnModel().getColumn(3).setResizable(false);
        }

        labelVenda2.setFont(new java.awt.Font("sansserif", 1, 14));
        labelVenda2.setText("Total:");

        labelTotalDaVenda.setHorizontalAlignment(4);
        labelTotalDaVenda.setText("00,00");

        labelNomeDoCliente2.setHorizontalAlignment(4);
        labelNomeDoCliente2.setText("R$");

        btVoltar.setBackground(new java.awt.Color(255, 255, 255));
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DetalhesDaVenda.this.btVoltarActionPerformed(evt);
            }

        });
        btPagarParcela.setBackground(new java.awt.Color(255, 255, 255));
        btPagarParcela.setText("Pagar");
        btPagarParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DetalhesDaVenda.this.btPagarParcelaActionPerformed(evt);
            }

        });
        btEditarParcela.setBackground(new java.awt.Color(255, 255, 255));
        btEditarParcela.setText("Editar");
        btEditarParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DetalhesDaVenda.this.btEditarParcelaActionPerformed(evt);
            }

        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, -2, 280, -2)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(btPagarParcela)
                                        .addGap(27, 27, 27)
                                        .addComponent(btEditarParcela)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 32767)
                        .addComponent(jScrollPane2, -2, 370, -2)
                        .addGap(54, 54, 54))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(-1, 32767)
                        .addComponent(btVoltar)
                        .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(labelVenda)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(labelVenda2)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(labelTotalDaVenda, -2, 64, -2)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(labelNomeDoCliente2)))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1, GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
                                                .addComponent(labelVenda1, GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(169, 169, 169)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(labelCPF)
                                .addComponent(labelNomeDoCliente)
                                .addComponent(labelDataDaVenda))
                        .addGap(182, 182, 182)));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(labelNomeDoCliente)
                                .addComponent(labelVenda))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(labelCPF))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelVenda1)
                                .addComponent(labelDataDaVenda)
                                .addComponent(labelVenda2)
                                .addComponent(labelTotalDaVenda)
                                .addComponent(labelNomeDoCliente2))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel2))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, -1, 314, 32767)
                                .addComponent(jScrollPane2, -2, 0, 32767))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btPagarParcela)
                                .addComponent(btEditarParcela))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, 32767)
                        .addComponent(btVoltar, -2, 37, -2)
                        .addContainerGap()));

        pack();
    }

    private void btVoltarActionPerformed(ActionEvent evt) {
        dispose();
        new VisualizarVendas(principal).setVisible(true);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        new VisualizarVendas(principal).setVisible(true);
    }

    private void tableItensCompradosMouseClicked(java.awt.event.MouseEvent evt) {
        int linha = tableItensComprados.getSelectedRow();
        String nomeDoProduto = new DAO.ProdutoDAO().recuperaNome(tableItensComprados.getValueAt(linha, 0).toString());
        tableItensComprados.setToolTipText(nomeDoProduto);
    }

    private void btEditarParcelaActionPerformed(ActionEvent evt) {
        Parcelas parcela = retornarParcelaSelecionada();
        venda.getParcelas().remove(parcela);
        ParcelaDaVenda pv = new ParcelaDaVenda();
        pv.setVenda(venda);
        pv.setParcela(parcela);
        pv.setDetalhesDaVenda(this);
        pv.preecherCampos();
        pv.setVisible(true);
    }

    private void btPagarParcelaActionPerformed(ActionEvent evt) {
        Parcelas parcela = retornarParcelaSelecionada();
        venda.getParcelas().remove(parcela);
        Troco t = new Troco(parcela, this);
        t.setVisible(true);
    }

    public void addParcelasPagasAoBancoDeDados() {
        for (Parcelas p : parcelasPagas) {
            new ParcelasDAO().add(p);
        }
    }

    public void atualizarParcelasPagasENaoPagas() {
        venda.setParcelas(new ParcelasDAO().getParcelasNaoPagasPorIDDeVenda(venda.getCodigo()));
        parcelasPagas = new ParcelasDAO().getParcelasPagasPorIDDeVenda(venda.getCodigo());
        preencherTabelaParcelas();
    }

    public Parcelas retornarParcelaSelecionada() {
        Parcelas parcela = null;
        String data = tableParcelas.getValueAt(tableParcelas.getSelectedRow(), 1).toString();
        String[] um = data.split("/");
        int dayOfMonth = Integer.parseInt(um[0]);
        int month = Integer.parseInt(um[1]);
        int year = Integer.parseInt(um[2]);
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        for (Parcelas p : venda.getParcelas()) {
            if (p.getDataDeVencimento().isEqual(date)) {
                parcela = p;
                break;
            }
        }

        return parcela;
    }

    public void addParcelaPaga(Parcelas p) {
        parcelasPagas.add(p);
    }

    public void removerEAtualizarNoBancoDeDados() {
        ParcelasDAO pd = new ParcelasDAO();
        pd.removerParcelas(venda.getCodigo());
        for (Parcelas p : venda.getParcelas()) {
            pd.add(p);
        }
        for (Parcelas p : parcelasPagas) {
            pd.add(p);
        }

        atualizarParcelasPagasENaoPagas();
        preencherTabelaParcelas();
    }

    public void alterarProximaParcela(Parcelas p, double valorADescontar) {
        for (Parcelas par : venda.getParcelas()) {
            if (p.getDataDeVencimento().until(par.getDataDeVencimento()).getMonths() == 1) {
                par.setValor(par.getValor() - valorADescontar);
                break;
            }
        }
    }
}
