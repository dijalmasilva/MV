package gui;

import classes.Parcelas;
import classes.Venda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class VisualizarVendas extends javax.swing.JFrame {

    private final Principal principal;
    private ArrayList<Venda> vendas;
    private ArrayList<Venda> vendasBuscadas;
    private int formaDeBusca;
    private int linha = -1;
    private int cont = 0;
    private JButton btVendasDoDia;
    private JButton btVendasDoDia1;
    private JButton btVisualizarVenda;
    private JButton btVoltar;
    private JLabel jLabel1;
    private JLabel jLabel2;

    public VisualizarVendas(Principal principal) {
        initComponents();
        setSize(600, 630);
        setLocationRelativeTo(null);
        this.principal = principal;
        carregarVendasAprazo();
        vendasBuscadas = new ArrayList();
        formaDeBusca = 1;
        buscar();
        preecherTabela();
        alterarIcone();
    }

    public final void alterarIcone() {
        java.net.URL url = getClass().getResource("/imagens/seeVendas.png");
        java.awt.Image imagemTitulo = java.awt.Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(imagemTitulo);
    }

    public final void carregarVendasAprazo() {
        vendas = new DAO.VendaDAO().getPrazo();
        if (vendas.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Ainda não foram realizadas compras a Prazo.");
        }
    }

    public final void buscar() {
        vendasBuscadas.clear();
        for (Venda v : vendas) {
            buscarVendas(v);
        }
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private JRadioButton radio5dias;
    private JRadioButton radioEmAtraso;
    private JRadioButton radioParaHoje;
    private JTable tableVendas;
    private JTextField textFieldNomeDoCliente;

    public void buscarVendas(Venda v) {
        switch (formaDeBusca) {
            case 1:
                for (Parcelas p : v.getParcelas()) {
                    if (p.verificarAtraso()) {
                        vendasBuscadas.add(v);
                        break;
                    }
                }

                break;
            case 2:
                for (Parcelas p : v.getParcelas()) {
                    if (p.seVenceHoje()) {
                        vendasBuscadas.add(v);
                        break;
                    }
                }

                break;
            case 3:
                for (Parcelas p : v.getParcelas()) {
                    int dias = 0;
                    if (p.CompararVencimento().getYears() > 0) {
                        dias += 365 * p.CompararVencimento().getYears();
                    }
                    if (p.CompararVencimento().getMonths() > 0) {
                        dias += 30 * p.CompararVencimento().getMonths();
                    }
                    if (p.CompararVencimento().getDays() > 0) {
                        dias += p.CompararVencimento().getDays();
                    }

                    if ((dias > 0) && (dias < 6)) {
                        vendasBuscadas.add(v);
                        break;
                    }
                }

                break;

            case 4:
                break;

            case 5:
                if (v.getData().isEqual(java.time.LocalDate.now())) {
                    vendasBuscadas.add(v);
                }
                break;
        }

    }

    public Parcelas retornaParcelaMaisProximaDoVencimento(Venda v) {
        Parcelas p = null;
        int cont = 0;
        for (Parcelas par : v.getParcelas()) {
            if (cont == 0) {
                p = par;
                cont++;
            } else if (par.getDataDeVencimento().isBefore(p.getDataDeVencimento())) {
                p = par;
            }
        }

        return p;
    }

    public final void preecherTabela() {
        Object[][] o = new Object[vendasBuscadas.size()][3];

        int cont = 0;

        for (Venda v : vendasBuscadas) {
            o[cont][0] = Integer.valueOf(v.getCodigo());
            o[cont][1] = new DAO.ClienteDAO().getNome(v.getCpfCliente());
            Parcelas p = retornaParcelaMaisProximaDoVencimento(v);
            o[(cont++)][2] = p.getDataDeVencimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yy"));
        }

        tableVendas.setModel(new javax.swing.table.DefaultTableModel(o, new String[]{"Código", "Cliente", "Vencimento"}) {

            boolean[] canEdit = {false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });
        jScrollPane1.setViewportView(tableVendas);

        if (tableVendas.getColumnModel().getColumnCount() > 0) {
            tableVendas.getColumnModel().getColumn(0).setResizable(false);
            tableVendas.getColumnModel().getColumn(0).setPreferredWidth(2);
            tableVendas.getColumnModel().getColumn(1).setResizable(false);
            tableVendas.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableVendas.getColumnModel().getColumn(2).setResizable(false);
            tableVendas.getColumnModel().getColumn(2).setPreferredWidth(17);
        }
    }

    public Venda retornarVendaPeloCodigo(int cod) {
        for (Venda v : vendas) {
            if (v.getCodigo() == cod) {
                return v;
            }
        }

        return null;
    }

    private void initComponents() {
        radioEmAtraso = new JRadioButton();
        radioParaHoje = new JRadioButton();
        radio5dias = new JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVendas = new JTable();
        btVendasDoDia = new JButton();
        btVoltar = new JButton();
        btVisualizarVenda = new JButton();
        jLabel2 = new JLabel();
        btVendasDoDia1 = new JButton();
        jLabel1 = new JLabel();
        textFieldNomeDoCliente = new JTextField();

        setDefaultCloseOperation(2);
        setTitle("Vendas");
        setPreferredSize(new java.awt.Dimension(620, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(620, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                VisualizarVendas.this.formWindowClosing(evt);
            }

        });
        radioEmAtraso.setSelected(true);
        radioEmAtraso.setText("Em Atraso");
        radioEmAtraso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VisualizarVendas.this.radioEmAtrasoActionPerformed(evt);
            }

        });
        radioParaHoje.setText("Para Hoje");
        radioParaHoje.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VisualizarVendas.this.radioParaHojeActionPerformed(evt);
            }

        });
        radio5dias.setText("Próximo 5 dias");
        radio5dias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VisualizarVendas.this.radio5diasActionPerformed(evt);
            }

        });
        jSeparator2.setOrientation(1);

        tableVendas.setModel(new javax.swing.table.DefaultTableModel(new Object[0][], new String[]{"Código", "Cliente", "Vencimento"}) {

            boolean[] canEdit = {false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                VisualizarVendas.this.tableVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableVendas);
        if (tableVendas.getColumnModel().getColumnCount() > 0) {
            tableVendas.getColumnModel().getColumn(0).setResizable(false);
            tableVendas.getColumnModel().getColumn(0).setPreferredWidth(2);
            tableVendas.getColumnModel().getColumn(1).setResizable(false);
            tableVendas.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableVendas.getColumnModel().getColumn(2).setResizable(false);
            tableVendas.getColumnModel().getColumn(2).setPreferredWidth(17);
        }

        btVendasDoDia.setBackground(new java.awt.Color(255, 255, 255));
        btVendasDoDia.setText("Vendas do dia");
        btVendasDoDia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VisualizarVendas.this.btVendasDoDiaActionPerformed(evt);
            }

        });
        btVoltar.setBackground(new java.awt.Color(255, 255, 255));
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VisualizarVendas.this.btVoltarActionPerformed(evt);
            }

        });
        btVisualizarVenda.setBackground(new java.awt.Color(255, 255, 255));
        btVisualizarVenda.setText("Visualizar");
        btVisualizarVenda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VisualizarVendas.this.btVisualizarVendaActionPerformed(evt);
            }

        });
        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14));
        jLabel2.setText("Vencimento");

        btVendasDoDia1.setBackground(new java.awt.Color(255, 255, 255));
        btVendasDoDia1.setText("Vendas Finalizadas");
        btVendasDoDia1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VisualizarVendas.this.btVendasDoDia1ActionPerformed(evt);
            }

        });
        jLabel1.setText("Nome do Cliente:");

        textFieldNomeDoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                VisualizarVendas.this.textFieldNomeDoClienteKeyReleased(evt);
            }

        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, -1, 528, 32767)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btVisualizarVenda)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                                        .addComponent(btVoltar, -2, 71, -2))
                                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel1)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(textFieldNomeDoCliente))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel2)
                                                                        .addGap(0, 0, 32767))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(radioEmAtraso)
                                                                        .addGap(27, 27, 27)
                                                                        .addComponent(radioParaHoje)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                                                        .addComponent(radio5dias)))
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jSeparator2, -2, 10, -2)
                                                        .addGap(26, 26, 26)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(btVendasDoDia, GroupLayout.Alignment.TRAILING, -2, 151, -2)
                                                                .addComponent(btVendasDoDia1, GroupLayout.Alignment.TRAILING, -2, 151, -2))
                                                        .addGap(21, 21, 21)))))
                        .addGap(22, 22, 22)));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btVendasDoDia, -2, 39, -2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btVendasDoDia1, -2, 39, -2))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator2, -2, 79, -2)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(radioEmAtraso)
                                                        .addComponent(radioParaHoje)
                                                        .addComponent(radio5dias))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(textFieldNomeDoCliente, -2, -1, -2)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, -2, -1, -2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, 32767)
                                        .addComponent(btVoltar))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(btVisualizarVenda)
                                        .addGap(0, 0, 32767)))
                        .addContainerGap()));

        pack();
    }

    private void radioEmAtrasoActionPerformed(ActionEvent evt) {
        if (!radioEmAtraso.isSelected()) {
            radioEmAtraso.setSelected(true);
        } else {
            radio5dias.setSelected(false);
            radioParaHoje.setSelected(false);
            formaDeBusca = 1;
            buscar();
            preecherTabela();
        }
    }

    private void radioParaHojeActionPerformed(ActionEvent evt) {
        if (!radioParaHoje.isSelected()) {
            radioParaHoje.setSelected(true);
        } else {
            radio5dias.setSelected(false);
            radioEmAtraso.setSelected(false);
            formaDeBusca = 2;
            buscar();
            preecherTabela();
        }
    }

    private void radio5diasActionPerformed(ActionEvent evt) {
        if (!radio5dias.isSelected()) {
            radio5dias.setSelected(true);
        } else {
            radioParaHoje.setSelected(false);
            radioEmAtraso.setSelected(false);
            formaDeBusca = 3;
            buscar();
            preecherTabela();
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        dispose();
        principal.setVisible(true);
    }

    private void btVendasDoDiaActionPerformed(ActionEvent evt) {
        radio5dias.setSelected(false);
        radioEmAtraso.setSelected(false);
        radioParaHoje.setSelected(false);
        formaDeBusca = 5;
        buscar();
        preecherTabela();
    }

    private void btVoltarActionPerformed(ActionEvent evt) {
        dispose();
        principal.setVisible(true);
    }

    private void btVisualizarVendaActionPerformed(ActionEvent evt) {
        Venda v = retornarVendaPeloCodigo(Integer.parseInt(tableVendas.getValueAt(linha, 0).toString()));
        dispose();
        DetalhesDaVenda dv = new DetalhesDaVenda(principal);
        dv.setVenda(v);
        dv.preencherCampos();
        dv.preecherTabelaItensComprados();
        dv.preencherTabelaParcelas();
        dv.setVisible(true);
    }

    private void tableVendasMouseClicked(MouseEvent evt) {
        int l = tableVendas.getSelectedRow();

        if (l == linha) {
            btVisualizarVendaActionPerformed(null);
        }

        linha = l;
    }

    private void btVendasDoDia1ActionPerformed(ActionEvent evt) {
    }

    private void textFieldNomeDoClienteKeyReleased(KeyEvent evt) {
        vendasBuscadas.clear();
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36) && (evt.getKeyCode() != 17) && (evt.getKeyCode() != 16) && (evt.getKeyCode() != 8)) {
            textFieldNomeDoCliente.setText(textFieldNomeDoCliente.getText().toUpperCase());
            ArrayList<classes.Cliente> clientes = new DAO.ClienteDAO().getByNames(textFieldNomeDoCliente.getText());

            for (classes.Cliente c : clientes) {
                verificarVendaComAlgumCPF(c.getCpf());
            }

            preecherTabela();
        }
    }

    public void verificarVendaComAlgumCPF(String cpf) {
        for (Venda v : vendas) {
            if (v.getCpfCliente().equals(cpf)) {
                vendasBuscadas.add(v);
                break;
            }
        }
    }
}