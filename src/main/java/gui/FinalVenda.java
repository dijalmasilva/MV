package gui;

import DAO.ClienteDAO;
import DAO.VendaDAO;
import classes.Cliente;
import classes.Estoque;
import classes.Venda;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;

public class FinalVenda extends javax.swing.JFrame {

    private Principal p;
    private Venda v;
    private ArrayList<Cliente> clientes;
    private ClienteDAO cd;
    private Cliente cliente;
    private VendaDAO vd;
    private ArrayList<Estoque> estoque;
    private double descontoAdicional = 0.0D;
    private DecimalFormat df = new DecimalFormat("#,###.00");

    private JButton btCancelar;
    private JButton btConcluir;
    private JButton btNovoCliente;
    private JButton btTroco;
    private javax.swing.JCheckBox checkDesconto;

    public FinalVenda(Venda v, ArrayList<Estoque> estoque, Principal p) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(481, 450);
        this.v = v;
        labelTotal.setText("" + df.format(v.getTotal()));
        labelPrecoDesconto.setText("" + df.format(v.getTotalComDesconto()));
        camposPrazo(false);
        cd = new ClienteDAO();
        vd = new VendaDAO();
        clientes = cd.get();
        preencherComboCliente();
        labelLimite.setText("0.00");
        this.estoque = estoque;
        this.p = p;
    }

    public FinalVenda(Principal p) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(498, 420);
        camposPrazo(false);
        cd = new ClienteDAO();
        vd = new VendaDAO();
        clientes = cd.get();
        preencherComboCliente();
        labelLimite.setText("0.00");
        this.p = p;
    }

    public final void camposPrazo(boolean b) {
        textFieldCliente.setEnabled(b);
        textFieldParcelamento.setEnabled(b);
        comboClientes.setEnabled(b);
        btNovoCliente.setEnabled(b);
    }

    private JComboBox comboClientes;

    public void comboForma() {
        comboClientesActionPerformed(null);
    }

    private JComboBox comboFormaDePagamento;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;

    private void initComponents() {
        comboFormaDePagamento = new JComboBox();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        textFieldCliente = new JTextField();
        comboClientes = new JComboBox();
        jLabel3 = new JLabel();
        labelTotal = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        labelPrecoDesconto = new JLabel();
        jLabel8 = new JLabel();
        btConcluir = new JButton();
        btCancelar = new JButton();
        jLabel9 = new JLabel();
        textFieldParcelamento = new JTextField();
        jLabel10 = new JLabel();
        btNovoCliente = new JButton();
        jLabel4 = new JLabel();
        labelLimite = new JLabel();
        jLabel11 = new JLabel();
        btTroco = new JButton();
        checkDesconto = new javax.swing.JCheckBox();

        setDefaultCloseOperation(2);
        setTitle("Venda");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(ComponentEvent evt) {
                FinalVenda.this.formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                FinalVenda.this.formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                FinalVenda.this.formKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                FinalVenda.this.formKeyReleased(evt);
            }

        });
        comboFormaDePagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"A vista", "Prazo"}));
        comboFormaDePagamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FinalVenda.this.comboFormaDePagamentoActionPerformed(evt);
            }
        });
        comboFormaDePagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                FinalVenda.this.comboFormaDePagamentoKeyReleased(evt);
            }

        });
        jLabel1.setText("Forma de Pagamento:");

        jLabel2.setText("Cliente:");

        textFieldCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FinalVenda.this.textFieldClienteActionPerformed(evt);
            }
        });
        textFieldCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                FinalVenda.this.textFieldClienteKeyReleased(evt);
            }

        });
        comboClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FinalVenda.this.comboClientesActionPerformed(evt);
            }

        });
        jLabel3.setFont(new Font("sansserif", 0, 36));
        jLabel3.setText("Total:");

        labelTotal.setFont(new Font("sansserif", 0, 36));
        labelTotal.setHorizontalAlignment(4);
        labelTotal.setText("0.0");

        jLabel5.setFont(new Font("sansserif", 0, 36));
        jLabel5.setText("R$");

        jLabel6.setFont(new Font("sansserif", 0, 14));
        jLabel6.setText("Com desconto:");

        labelPrecoDesconto.setFont(new Font("sansserif", 0, 14));
        labelPrecoDesconto.setHorizontalAlignment(4);
        labelPrecoDesconto.setText("0.0");

        jLabel8.setFont(new Font("sansserif", 0, 14));
        jLabel8.setText("R$");

        btConcluir.setBackground(new Color(255, 255, 255));
        btConcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/yes.png")));
        btConcluir.setText("Concluir");
        btConcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FinalVenda.this.btConcluirActionPerformed(evt);
            }

        });
        btCancelar.setBackground(new Color(255, 255, 255));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png")));
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FinalVenda.this.btCancelarActionPerformed(evt);
            }

        });
        jLabel9.setFont(new Font("Tahoma", 1, 14));
        jLabel9.setText("Parcelamento:");

        textFieldParcelamento.setText("1");

        jLabel10.setFont(new Font("Tahoma", 1, 14));
        jLabel10.setHorizontalAlignment(4);
        jLabel10.setText("x");

        btNovoCliente.setBackground(new Color(255, 255, 255));
        btNovoCliente.setText("Novo Cliente");
        btNovoCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FinalVenda.this.btNovoClienteActionPerformed(evt);
            }

        });
        jLabel4.setText("Limite:");

        labelLimite.setHorizontalAlignment(4);
        labelLimite.setText("0.0");

        jLabel11.setText("R$");

        btTroco.setBackground(new Color(255, 255, 255));
        btTroco.setText("Gerar Troco");
        btTroco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FinalVenda.this.btTrocoActionPerformed(evt);
            }

        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btCancelar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                        .addComponent(btConcluir, -2, 121, -2)
                        .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelTotal, -2, 165, -2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4, -2, 44, -2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(labelLimite, -2, 45, -2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                                .addComponent(btNovoCliente))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(textFieldCliente))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel1)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(comboFormaDePagamento, -2, 283, -2))
                                                .addComponent(comboClientes, 0, -1, 32767)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel9)
                                                        .addGap(24, 24, 24)
                                                        .addComponent(jLabel10, -2, 13, -2)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(textFieldParcelamento, -2, 79, -2)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                                                        .addComponent(btTroco, -2, 118, -2))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(0, 0, 32767)
                                                                        .addComponent(jLabel6)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(labelPrecoDesconto, -2, 76, -2)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jLabel8)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(checkDesconto)))))))
                        .addContainerGap(37, 32767)));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(comboFormaDePagamento, -2, -1, -2)
                                .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(textFieldCliente, -2, -1, -2))
                        .addGap(18, 18, 18)
                        .addComponent(comboClientes, -2, -1, -2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(labelLimite)
                                        .addComponent(jLabel11))
                                .addComponent(btNovoCliente))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel9)
                                                .addComponent(textFieldParcelamento, -2, 29, -2)
                                                .addComponent(jLabel10, -2, 16, -2))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, 32767)
                                        .addComponent(btTroco, -2, 48, -2)
                                        .addGap(39, 39, 39)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(checkDesconto)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelPrecoDesconto)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel6)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(labelTotal)
                                .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btConcluir, -2, 45, -2)
                                .addComponent(btCancelar))
                        .addContainerGap()));

        pack();
    }

    private void comboFormaDePagamentoActionPerformed(ActionEvent evt) {
        String s = comboFormaDePagamento.getSelectedItem().toString();
        if (s.equals("Prazo")) {
            camposPrazo(true);
            comboClientesActionPerformed(evt);
            btTroco.setEnabled(false);
        } else {
            camposPrazo(false);
            btTroco.setEnabled(true);
            labelLimite.setText("0.00");
        }
    }

    private void btCancelarActionPerformed(ActionEvent evt) {
        int i = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar?");
        if (i == 0) {
            dispose();
            p.setVisible(true);
        }
    }

    private void btConcluirActionPerformed(ActionEvent evt) {
        boolean podeConcluir = false;
        boolean compraPrazo = false;
        int parcelas = 1;
        boolean duasformasdepagar = false;
        double restante = 0.0D;
        try {
            parcelas = Integer.parseInt(textFieldParcelamento.getText());
        } catch (NumberFormatException localNumberFormatException) {
        }

        if (comboFormaDePagamento.getSelectedItem().toString().equals("Prazo")) {
            compraPrazo = true;
            try {
                acharClientePeloNome(comboClientes.getSelectedItem().toString());
                if (parcelas > 0) {
                    if (cliente.getLimite() < v.getTotal()) {
                        restante = v.getTotal() - cliente.getLimite();
                        int result = JOptionPane.showConfirmDialog(null, "O total da compra é superior ao seu limite de compra. \nDeseja usar o limite e pagar os " + restante + " R$ restantes à vista?");

                        if (result == 0) {
                            podeConcluir = true;
                            duasformasdepagar = true;
                        } else {
                            podeConcluir = false;
                        }
                    } else {
                        podeConcluir = true;
                    }
                } else {
                    podeConcluir = false;
                    JOptionPane.showMessageDialog(null, "Divida em pelo menos uma parcela!");
                    textFieldParcelamento.requestFocusInWindow();
                }
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Você deve ter um cliente cadastrado para continuar a compra.");
            }
        } else {
            podeConcluir = true;
        }

        if (podeConcluir) {
            Cliente novo;
            if (!compraPrazo) {
                v.setCodigo(vd.retornaProximoID());
                v.mudarDataParaAgora();
                v.setFormaDePagamento("Vista");
                try {
                    boolean darDesconto = checkDesconto.isSelected();
                    vd.addVista(v, darDesconto, descontoAdicional);
                } catch (com.itextpdf.text.DocumentException | java.io.FileNotFoundException ex) {
                    Logger.getLogger(FinalVenda.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FinalVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                v.setCodigo(vd.retornaProximoID());
                v.setQtdeParcelas(parcelas);
                v.setCpfCliente(cliente.getCpf());
                v.mudarDataParaAgora();
                v.setFormaDePagamento("Prazo");
                novo = cliente;

                if (duasformasdepagar) {
                    try {
                        v.setFormaDePagamento("Vista");
                        v.setTotal(restante);
                        vd.addVistaOutro(v);
                        v.setTotal(cliente.getLimite());
                        v.setFormaDePagamento("Prazo");
                        vd.addPrazo(v);
                    } catch (com.itextpdf.text.DocumentException | IOException ex) {
                        Logger.getLogger(FinalVenda.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cliente.setLimite(0.0D);
                } else {
                    try {
                        vd.addPrazo(v);
                    } catch (com.itextpdf.text.DocumentException | IOException ex) {
                        Logger.getLogger(FinalVenda.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cliente.setLimite(cliente.getLimite() - v.getTotal());
                }

                cd.edit(cliente, novo);

                for (int i = 0; i < v.getQtdeParcelas(); i++) {
                    new DAO.ParcelasDAO().add(new classes.Parcelas(v.getCodigo(), v.getTotal() / v.getQtdeParcelas(), v.getData().plusMonths(i + 1), false));
                }
            }

            for (classes.ItemDeVenda item : v.getItens()) {
                new DAO.ItemDeVendaDAO().add(item, v);
            }

            for (Estoque e : estoque) {
                new DAO.EstoqueDAO().editQuantidade(e);
            }
            int r = JOptionPane.showConfirmDialog(null, "Compra realizada com sucesso! \nDeseja realizar uma nova venda?");

            if (r == 0) {
                dispose();
                new RealizarVenda(p).setVisible(true);
            } else {
                dispose();
                p.setVisible(true);
            }
        }
    }

    private void textFieldClienteKeyReleased(KeyEvent evt) {
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36)) {
            textFieldCliente.setText(textFieldCliente.getText().toUpperCase());
            if (textFieldCliente.equals("")) {
                preencherComboCliente();
            } else {
                preencherComboClientePorNome(textFieldCliente.getText());
            }
        }
    }

    private void comboClientesActionPerformed(ActionEvent evt) {
        try {
            String nome = comboClientes.getSelectedItem().toString();
            for (Cliente c : clientes) {
                if (c.getNome().equals(nome)) {
                    labelLimite.setText("" + df.format(c.getLimite()));
                    cliente = c;
                    break;
                }
            }
        } catch (NullPointerException ex) {
            String nome;
            labelLimite.setText("0.00");
        }
    }

    private void formWindowClosing(WindowEvent evt) {
        p.setVisible(true);
    }

    private void btNovoClienteActionPerformed(ActionEvent evt) {
        setVisible(false);
        new CadastrarCliente(this, p).setVisible(true);
    }

    private void textFieldClienteActionPerformed(ActionEvent evt) {
        if (textFieldCliente.getText().equals("")) {
            preencherComboCliente();
        }
    }

    private void btTrocoActionPerformed(ActionEvent evt) {
        Troco t = new Troco();
        t.setTotal(v.getTotalComDesconto());
        t.preencherCampo();
        t.setVisible(true);
    }

    private void formComponentResized(ComponentEvent evt) {
    }

    private void formKeyReleased(KeyEvent evt) {
    }

    private void formKeyPressed(KeyEvent evt) {
    }

    private void comboFormaDePagamentoKeyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == 17) {
            if (comboFormaDePagamento.getSelectedItem().toString().equals("A vista")) {
                try {
                    descontoAdicional = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a descontar."));
                    labelPrecoDesconto.setText(df.format(v.getTotalComDesconto() - descontoAdicional));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite apenas número e .(Ponto)");
                } catch (NullPointerException ex) {
                    System.out.println("Cancelou");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione a venda a vista.", "Desconto", 1);
            }
        }
    }

    public final void preencherComboCliente() {
        comboClientes.removeAllItems();
        for (Cliente c : clientes) {
            comboClientes.addItem(c.getNome());
        }
    }

    public void acharClientePeloNome(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equals(nome)) {
                cliente = c;
                break;
            }
        }
    }

    public final void preencherComboClientePorNome(String nome) {
        ArrayList<Cliente> cs = cd.getByNames(nome);
        comboClientes.removeAllItems();
        for (Cliente c : cs) {
            comboClientes.addItem(c.getNome());
        }
    }

    public Venda getV() {
        return v;
    }

    public void setV(Venda v) {
        this.v = v;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ClienteDAO getCd() {
        return cd;
    }

    public void setCd(ClienteDAO cd) {
        this.cd = cd;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void mudarTextFieldCliente(String name) {
        textFieldCliente.setText(name);
    }

    private JLabel jLabel8;
    private JLabel jLabel9;
    private JLabel labelLimite;
    private JLabel labelPrecoDesconto;
    private JLabel labelTotal;
    private JTextField textFieldCliente;
    private JTextField textFieldParcelamento;

}