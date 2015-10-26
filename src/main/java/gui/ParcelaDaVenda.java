package gui;

import classes.Parcelas;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ParcelaDaVenda extends javax.swing.JFrame {

    private Parcelas p;
    private classes.Venda v;
    private DetalhesDaVenda d;
    private JButton btCancelar;
    private JButton btConfirmar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel labelIdVenda;
    private JTextField textFieldDataVencimento;
    private JTextField textFieldValor;

    public ParcelaDaVenda() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(330, 200);
    }

    public void setDetalhesDaVenda(DetalhesDaVenda d) {
        this.d = d;
    }

    public void setParcela(Parcelas p) {
        this.p = p;
    }

    public void setVenda(classes.Venda v) {
        this.v = v;
    }

    public void preecherCampos() {
        labelIdVenda.setText(p.getIdVenda() + "");
        textFieldDataVencimento.setText(p.getDataDeVencimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        textFieldValor.setText(p.getValor() + "");
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        textFieldDataVencimento = new JTextField();
        jLabel2 = new JLabel();
        textFieldValor = new JTextField();
        btConfirmar = new JButton();
        btCancelar = new JButton();
        labelIdVenda = new JLabel();

        setDefaultCloseOperation(2);
        setTitle("Parcela");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                ParcelaDaVenda.this.formWindowClosing(evt);
            }

        });
        jLabel1.setText("Data de Vencimento:");

        jLabel2.setText("Valor:");

        btConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/yes.png")));
        btConfirmar.setText("Confirmar");
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParcelaDaVenda.this.btConfirmarActionPerformed(evt);
            }

        });
        btCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png")));
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParcelaDaVenda.this.btCancelarActionPerformed(evt);
            }

        });
        labelIdVenda.setText("ID");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(labelIdVenda))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btCancelar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                                                .addComponent(btConfirmar))
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(textFieldValor, -2, 166, -2)
                                                        .addComponent(textFieldDataVencimento, -2, 166, -2)))))
                        .addContainerGap(-1, 32767)));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelIdVenda)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(textFieldDataVencimento, -2, -1, -2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textFieldValor, -2, -1, -2)
                                .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btConfirmar)
                                .addComponent(btCancelar))
                        .addContainerGap(-1, 32767)));

        pack();
    }

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
        boolean atualizouOsDados = false;

        String[] um = textFieldDataVencimento.getText().split("/");
        int dayOfMonth = Integer.parseInt(um[0]);
        int month = Integer.parseInt(um[1]);
        int year = Integer.parseInt(um[2]);
        java.time.LocalDate date = java.time.LocalDate.of(year, month, dayOfMonth);

        if (!date.isEqual(p.getDataDeVencimento())) {
            atualizouOsDados = true;
            p.setDataDeVencimento(date);
        }

        double valor = Double.parseDouble(textFieldValor.getText());

        if (p.getValor() != valor) {
            atualizouOsDados = true;
            p.setValor(valor);
        }

        v.getParcelas().add(p);

        if (atualizouOsDados) {
            DAO.ParcelasDAO pd = new DAO.ParcelasDAO();
            pd.removerParcelas(v.getCodigo());
            for (Parcelas par : v.getParcelas()) {
                pd.add(par);
            }

            d.addParcelasPagasAoBancoDeDados();
            d.atualizarParcelasPagasENaoPagas();
        }

        d.requestFocusInWindow();
        dispose();
    }

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        v.getParcelas().add(p);
        d.requestFocusInWindow();
        dispose();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        v.getParcelas().add(p);
        d.requestFocusInWindow();
    }
}
