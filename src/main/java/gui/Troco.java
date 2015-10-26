package gui;

import classes.Parcelas;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class Troco extends javax.swing.JFrame {

    private double total;
    private double pago;
    private double troco;
    private Parcelas parcela;
    private DetalhesDaVenda dv;
    private java.text.DecimalFormat df = new java.text.DecimalFormat("#,###.00");
    private JButton btOk;
    private JLabel jLabel1;

    public Troco() {
        initComponents();
    }

    public Troco(Parcelas p, DetalhesDaVenda dv) {
        initComponents();
        parcela = p;
        this.dv = dv;
        total = p.getValor();
        preencherCampo();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public final void preencherCampo() {
        labelTotal.setText(df.format(total));
    }

    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel labelTotal;
    private JLabel labelTroco;
    private JTextField textFieldQuantia;

    private void initComponents() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        labelTotal = new JLabel();
        labelTroco = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        btOk = new JButton();
        textFieldQuantia = new JTextField();

        setDefaultCloseOperation(2);
        setTitle("TROCO");
        setLocation(new java.awt.Point(20, 20));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                Troco.this.formWindowClosing(evt);
            }

        });
        jLabel1.setFont(new Font("Tahoma", 0, 24));
        jLabel1.setText("Quantia paga:");

        jLabel2.setFont(new Font("Tahoma", 0, 24));
        jLabel2.setText("TROCO:");

        jLabel3.setFont(new Font("Tahoma", 0, 24));
        jLabel3.setText("Total:");

        labelTotal.setFont(new Font("Tahoma", 0, 24));
        labelTotal.setHorizontalAlignment(4);
        labelTotal.setText("00,00");

        labelTroco.setFont(new Font("Tahoma", 0, 24));
        labelTroco.setHorizontalAlignment(4);
        labelTroco.setText("00,00");

        jLabel6.setFont(new Font("Tahoma", 0, 24));
        jLabel6.setText("R$");

        jLabel7.setFont(new Font("Tahoma", 0, 24));
        jLabel7.setText("R$");

        jLabel8.setFont(new Font("Tahoma", 0, 24));
        jLabel8.setText("R$");

        btOk.setBackground(new java.awt.Color(255, 255, 255));
        btOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/yes.png")));
        btOk.setText("OK");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Troco.this.btOkActionPerformed(evt);
            }
        });
        btOk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                Troco.this.btOkKeyReleased(evt);
            }

        });
        textFieldQuantia.setHorizontalAlignment(4);
        textFieldQuantia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                Troco.this.textFieldQuantiaKeyReleased(evt);
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
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(65, 65, 65)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel2, GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel3, GroupLayout.Alignment.TRAILING)))
                                                .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(labelTroco, -2, 137, -2)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel7))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(labelTotal, -1, 135, 32767)
                                                                .addComponent(textFieldQuantia))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jLabel8))))
                                        .addGap(0, 36, 32767))
                                .addComponent(btOk, GroupLayout.Alignment.TRAILING, -1, -1, 32767))
                        .addContainerGap()));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel8, -2, 36, -2)
                                                .addComponent(labelTotal, -2, 36, -2)))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel3, -2, 36, -2)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, -2, 36, -2)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, -2, 36, -2)
                                        .addComponent(textFieldQuantia, -2, 34, -2)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, -2, 36, -2)
                                .addComponent(labelTroco, -2, 36, -2)
                                .addComponent(jLabel2, -2, 36, -2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btOk, -2, 42, -2)
                        .addContainerGap(-1, 32767)));

        pack();
    }

    private void btOkKeyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            dispose();
        }
    }

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {
        if (parcela == null) {
            dispose();
        } else {
            try {
                pago = Double.parseDouble(textFieldQuantia.getText());

                if (pago > parcela.getValor()) {
                    int result = javax.swing.JOptionPane.showConfirmDialog(this, "Deseja descontar o troco na próxima parcela?");
                    if (result == 0) {
                        troco = (pago - parcela.getValor());
                        dv.alterarProximaParcela(parcela, troco);
                        parcela.setValor(pago);
                    }
                }
                parcela.setIsPago(true);
                dv.addParcelaPaga(parcela);
                dv.removerEAtualizarNoBancoDeDados();
                dv.requestFocusInWindow();
                dispose();
            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "Digite apenas número e .(ponto)");
            }
        }
    }

    private void textFieldQuantiaKeyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            btOk.requestFocusInWindow();
        }
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36) && (evt.getKeyCode() != 17) && (evt.getKeyCode() != 16) && (evt.getKeyCode() != 10)) {
            try {
                if (!textFieldQuantia.getText().equals("")) {
                    troco = (Double.parseDouble(textFieldQuantia.getText()) - total);
                    labelTroco.setText(df.format(troco));
                } else {
                    labelTroco.setText("00,00");
                }
            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Digite apenas número e ponto.");
            }
        }
    }

    private void formWindowClosing(WindowEvent evt) {
        if (parcela != null) {
            dv.getVenda().getParcelas().add(parcela);
        }
    }

    
}