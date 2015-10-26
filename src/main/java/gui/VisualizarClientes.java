package gui;

import DAO.ClienteDAO;
import classes.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VisualizarClientes extends javax.swing.JFrame {

    private final Principal p;
    private ClienteDAO cd;
    private java.util.ArrayList<Cliente> clientes;
    private int linha;
    private int ContarCliks = 0;
    private JButton btEditar;
    private JButton btRemover;
    private JButton btVoltar;
    private JLabel jLabel2;

    public VisualizarClientes(Principal p) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(615, 630);
        this.p = p;
        cd = new ClienteDAO();
        clientes = cd.get();
        preencherTabela();
        linha = -10;
        alterarIcone();
    }

    public final void alterarIcone() {
        java.net.URL url = getClass().getResource("/imagens/clientes.png");
        java.awt.Image imagemTitulo = java.awt.Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(imagemTitulo);
    }

    public final void preencherTabela() {
        Object[][] o = new Object[clientes.size()][4];
        int cont = 0;
        for (Cliente c : clientes) {
            o[cont][0] = c.getNome();
            o[cont][1] = c.getCpf();
            o[cont][2] = c.getCidade();
            o[(cont++)][3] = Double.valueOf(c.getLimite());
        }

        tableClientes.setModel(new javax.swing.table.DefaultTableModel(o, new String[]{"Nome", "CPF", "Cidade", "Limite"}) {

            boolean[] canEdit = {false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }

        });
        jScrollPane1.setViewportView(tableClientes);

        if (tableClientes.getColumnModel().getColumnCount() > 0) {
            tableClientes.getColumnModel().getColumn(0).setResizable(false);
            tableClientes.getColumnModel().getColumn(0).setPreferredWidth(120);
            tableClientes.getColumnModel().getColumn(1).setResizable(false);
            tableClientes.getColumnModel().getColumn(1).setPreferredWidth(15);
            tableClientes.getColumnModel().getColumn(2).setResizable(false);
            tableClientes.getColumnModel().getColumn(2).setPreferredWidth(10);
            tableClientes.getColumnModel().getColumn(3).setResizable(false);
            tableClientes.getColumnModel().getColumn(3).setPreferredWidth(2);
        }
    }

    private JLabel jLabel3;

    private javax.swing.JScrollPane jScrollPane1;
    private JTable tableClientes;
    private JFormattedTextField textCPF;
    private JTextField textFieldNome;

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClientes = new JTable();
        btEditar = new JButton();
        btRemover = new JButton();
        btVoltar = new JButton();
        jLabel2 = new JLabel();
        textFieldNome = new JTextField();
        jLabel3 = new JLabel();
        textCPF = new JFormattedTextField();

        setDefaultCloseOperation(2);
        setTitle("Clientes");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                VisualizarClientes.this.formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                VisualizarClientes.this.formWindowClosing(evt);
            }

        });
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(new Object[0][], new String[]{"Nome", "CPF", "Cidade", "Limite"}) {

            boolean[] canEdit = {false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                VisualizarClientes.this.nenhum(evt);
            }
        });
        jScrollPane1.setViewportView(tableClientes);
        if (tableClientes.getColumnModel().getColumnCount() > 0) {
            tableClientes.getColumnModel().getColumn(0).setResizable(false);
            tableClientes.getColumnModel().getColumn(0).setPreferredWidth(120);
            tableClientes.getColumnModel().getColumn(1).setResizable(false);
            tableClientes.getColumnModel().getColumn(1).setPreferredWidth(15);
            tableClientes.getColumnModel().getColumn(2).setResizable(false);
            tableClientes.getColumnModel().getColumn(2).setPreferredWidth(10);
            tableClientes.getColumnModel().getColumn(3).setResizable(false);
            tableClientes.getColumnModel().getColumn(3).setPreferredWidth(2);
        }

        btEditar.setBackground(new java.awt.Color(255, 255, 255));
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VisualizarClientes.this.btEditarActionPerformed(evt);
            }

        });
        btRemover.setBackground(new java.awt.Color(255, 255, 255));
        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VisualizarClientes.this.btRemoverActionPerformed(evt);
            }

        });
        btVoltar.setBackground(new java.awt.Color(255, 255, 255));
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VisualizarClientes.this.btVoltarActionPerformed(evt);
            }

        });
        jLabel2.setText("Nome:");

        textFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                VisualizarClientes.this.textFieldNomeKeyReleased(evt);
            }

        });
        jLabel3.setText("CPF:");
        try {
            textCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VisualizarClientes.this.textCPFActionPerformed(evt);
            }
        });
        textCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                VisualizarClientes.this.textCPFKeyReleased(evt);
            }

        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(-1, 32767)
                                        .addComponent(btVoltar))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(33, 33, 33)
                                                        .addComponent(btEditar, -2, 69, -2)
                                                        .addGap(36, 36, 36)
                                                        .addComponent(btRemover))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(20, 20, 20)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING, -2, 534, -2)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel3)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(textCPF, -2, 163, -2)
                                                                        .addGap(10, 10, 10)
                                                                        .addComponent(jLabel2)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(textFieldNome, -2, 302, -2)))))
                                        .addGap(0, 17, 32767)))
                        .addContainerGap()));

        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap(17, 32767)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(textFieldNome, -2, -1, -2)
                                .addComponent(textCPF, -2, -1, -2))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, -2, 446, -2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btVoltar)
                                        .addContainerGap())
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(btEditar, -2, 37, -2)
                                                .addComponent(btRemover, -2, 37, -2))
                                        .addGap(37, 37, 37)))));

        pack();
    }

    private void btVoltarActionPerformed(ActionEvent evt) {
        dispose();
        p.setVisible(true);
    }

    private void btRemoverActionPerformed(ActionEvent evt) {
        int r = javax.swing.JOptionPane.showConfirmDialog(null, "Deseja realmente remover esse cliente?");
        if (r == 0) {
            String cpf = tableClientes.getValueAt(linha, 1).toString();
            if (cpf.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Selecione algum cliente.");
            } else {
                Cliente c = retornaCliente(cpf);
                cd.remove(c);
                clientes = cd.get();
            }
        }
    }

    private void btEditarActionPerformed(ActionEvent evt) {
        String cpf = tableClientes.getValueAt(linha, 1).toString();
        if (cpf.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(null, "Selecione algum cliente.");
        } else {
            dispose();
            new EditarCliente(p, retornaCliente(cpf)).setVisible(true);
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        p.setVisible(true);
    }

    private void nenhum(MouseEvent evt) {
        int ln = tableClientes.getSelectedRow();

        if (linha == ln) {
            btEditarActionPerformed(null);
        }

        linha = ln;
    }

    private void textCPFActionPerformed(ActionEvent evt) {
    }

    private void textCPFKeyReleased(KeyEvent evt) {
        if (textCPF.getText().equals("   .   .   -  ")) {
            clientes = cd.get();
            preencherTabela();
        } else if (textCPF.getText().lastIndexOf(" ") == -1) {
            procurarClientesPeloCPF(textCPF.getText());
            preencherTabela();
            if (clientes.isEmpty()) {
                int result = javax.swing.JOptionPane.showConfirmDialog(null, "Cliente não cadastrado. \nDeseja cadastrar um cliente com esse CPF?");
                if (result == 0) {
                    dispose();
                    p.cadastrarNovoCliente(textCPF.getText());
                }
            }
        }
    }

    private void textFieldNomeKeyReleased(KeyEvent evt) {
        if ((evt.getKeyCode() != 37) && (evt.getKeyCode() != 39) && (evt.getKeyCode() != 127) && (evt.getKeyCode() != 36)) {
            textFieldNome.setText(textFieldNome.getText().toUpperCase());
            procurarClientesPeloNome(textFieldNome.getText());
            preencherTabela();
        }
    }

    private void formMouseClicked(MouseEvent evt) {
    }

    public void procurarClientesPeloCPF(String cpf) {
        if (cpf.equals("   .   .   -  ")) {
            clientes = cd.get();
        } else {
            clientes = cd.getByCPF(cpf);
        }
    }

    public void procurarClientesPeloNome(String nome) {
        if (nome.equals("")) {
            clientes = cd.get();
        } else {
            clientes = cd.getByNames(nome);
        }
    }

    public Cliente retornaCliente(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }

        return null;
    }

}
