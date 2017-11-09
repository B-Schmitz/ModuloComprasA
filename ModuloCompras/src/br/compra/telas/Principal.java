package br.compra.telas;

import br.compra.getset.ColetaGetSet;
import br.compra.getset.RequisicaoGetSet;
import java.awt.Dimension;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    private final AddProdutoRequisicao Addprod = new AddProdutoRequisicao();

    private final RequisicaoCompra req = new RequisicaoCompra();
    private final CadastrarFornecedor forn = new CadastrarFornecedor();
    private final CadastrarProduto prod = new CadastrarProduto();
    private final PedidoCompra pedido = new PedidoCompra();
    private final MovimentacaoCompra mov = new MovimentacaoCompra();
    private final NotaFiscal nota = new NotaFiscal();
    private final ConsultarRequisicao consultar_requisicao = new ConsultarRequisicao();
    private final VisualizarEstoque visualizar_estoque;
    private final EnvioColetaDePreco coleta = new EnvioColetaDePreco();
    private final ColetaDePreco coletapreco = new ColetaDePreco();
    private final AlterarSaldo alterarSaldo = new AlterarSaldo();
    private final VisualizarPedidos visualizar_Pedidos = new VisualizarPedidos();

    private final ImageIcon icone;
    private String Tipo;
    private Dimension d;

    public Principal() {
        this.visualizar_estoque = new VisualizarEstoque();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        icone = new ImageIcon("src/br/compra/icones/logo.png");
        this.setIconImage(icone.getImage());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane_principal = new javax.swing.JDesktopPane();
        menu = new javax.swing.JMenuBar();
        menu_compras = new javax.swing.JMenu();
        menu_requisicao = new javax.swing.JMenuItem();
        menu_movimentacao = new javax.swing.JMenuItem();
        menu_coleta_preco = new javax.swing.JMenuItem();
        menu_estoque = new javax.swing.JMenu();
        menu_produto = new javax.swing.JMenuItem();
        menu_fornecedor = new javax.swing.JMenuItem();
        menu_visualizar = new javax.swing.JMenuItem();
        menu_consultar = new javax.swing.JMenu();
        menu_consultar_requisicao = new javax.swing.JMenuItem();
        menu_consultar_pedido = new javax.swing.JMenuItem();
        menu_notafiscal = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo Compras");

        desktopPane_principal.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout desktopPane_principalLayout = new javax.swing.GroupLayout(desktopPane_principal);
        desktopPane_principal.setLayout(desktopPane_principalLayout);
        desktopPane_principalLayout.setHorizontalGroup(
            desktopPane_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 866, Short.MAX_VALUE)
        );
        desktopPane_principalLayout.setVerticalGroup(
            desktopPane_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );

        menu_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/compra.png"))); // NOI18N
        menu_compras.setText("Compras");

        menu_requisicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/cart_add.png"))); // NOI18N
        menu_requisicao.setText("Requisição de Compras");
        menu_requisicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_requisicaoActionPerformed(evt);
            }
        });
        menu_compras.add(menu_requisicao);

        menu_movimentacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/cart_go.png"))); // NOI18N
        menu_movimentacao.setText("Movimentação de Compras");
        menu_movimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_movimentacaoActionPerformed(evt);
            }
        });
        menu_compras.add(menu_movimentacao);

        menu_coleta_preco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/money_dollar.png"))); // NOI18N
        menu_coleta_preco.setText("Coleta de Preço");
        menu_coleta_preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_coleta_precoActionPerformed(evt);
            }
        });
        menu_compras.add(menu_coleta_preco);

        menu.add(menu_compras);

        menu_estoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/estoque.png"))); // NOI18N
        menu_estoque.setText("Estoque");

        menu_produto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/box_closed.png"))); // NOI18N
        menu_produto.setText("Cadastrar Produto");
        menu_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_produtoActionPerformed(evt);
            }
        });
        menu_estoque.add(menu_produto);

        menu_fornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/lorry.png"))); // NOI18N
        menu_fornecedor.setText("Cadastrar Fornecedor");
        menu_fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_fornecedorActionPerformed(evt);
            }
        });
        menu_estoque.add(menu_fornecedor);

        menu_visualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/box_search.png"))); // NOI18N
        menu_visualizar.setText("Visualizar");
        menu_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_visualizarActionPerformed(evt);
            }
        });
        menu_estoque.add(menu_visualizar);

        menu.add(menu_estoque);

        menu_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/consultar.png"))); // NOI18N
        menu_consultar.setText("Consultar");

        menu_consultar_requisicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/search_field.png"))); // NOI18N
        menu_consultar_requisicao.setText("Requisições");
        menu_consultar_requisicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_consultar_requisicaoActionPerformed(evt);
            }
        });
        menu_consultar.add(menu_consultar_requisicao);

        menu_consultar_pedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/search_field.png"))); // NOI18N
        menu_consultar_pedido.setText("Pedidos");
        menu_consultar_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_consultar_pedidoActionPerformed(evt);
            }
        });
        menu_consultar.add(menu_consultar_pedido);

        menu_notafiscal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/receipt_invoice.png"))); // NOI18N
        menu_notafiscal.setText("Nota Fiscal");
        menu_notafiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_notafiscalActionPerformed(evt);
            }
        });
        menu_consultar.add(menu_notafiscal);

        menu.add(menu_consultar);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane_principal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane_principal, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void RecebeTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public void Janela(JInternalFrame frame) {
        desktopPane_principal.remove(frame);
        desktopPane_principal.add(frame);
        frame.moveToFront();
        frame.setVisible(true);
        Centralizar(frame);
    }

    public void Centralizar(JInternalFrame frame) {
        d = frame.getDesktopPane().getSize();
        frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
    }

    public void JanelaAddProd() {
        Janela(Addprod);
    }
    
     public void JanelaAlterarSaldo() {
        Janela(alterarSaldo);
    }

    public void IniciaColeta(List<RequisicaoGetSet> lisreq, int id) {
        Janela(coleta);
        coleta.setlisColeta(lisreq, id);
    }

    public void IniciaPedido(ColetaGetSet c) {

        Janela(pedido);
        pedido.setPedido(c);
        int op = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais produtos ao pedido de compras?", "Adicionar produtos", 0);
        if (op == 0) {
            coletapreco.moveToFront();
        } else {
            coletapreco.fecha();
        }

    }

    private void menu_requisicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_requisicaoActionPerformed
        Janela(req);
        req.AddProduto(this, Addprod);
    }//GEN-LAST:event_menu_requisicaoActionPerformed

    private void menu_fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_fornecedorActionPerformed
        if (Tipo.equals("A")) {
            Janela(forn);
            forn.atualizaCombo();
            
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui acesso a essa função", "Permissão negada!", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
        }
    }//GEN-LAST:event_menu_fornecedorActionPerformed

    private void menu_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_produtoActionPerformed
        if (Tipo.equals("A")) {
            Janela(prod);
           prod.AlterarSaldo(this,alterarSaldo);

        } else {
            JOptionPane.showMessageDialog(null, "Você não possui acesso a essa função", "Permissão negada!", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
        }
    }//GEN-LAST:event_menu_produtoActionPerformed

    private void menu_movimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_movimentacaoActionPerformed
        if (Tipo.equals("A")) {
            Janela(mov);
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui acesso a essa função", "Permissão negada!", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
        }
    }//GEN-LAST:event_menu_movimentacaoActionPerformed

    private void menu_notafiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_notafiscalActionPerformed
        Janela(nota);
        nota.AtualizaLista();
    }//GEN-LAST:event_menu_notafiscalActionPerformed

    private void menu_consultar_requisicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_consultar_requisicaoActionPerformed
        if (Tipo.equals("A")) {
            Janela(consultar_requisicao);
            consultar_requisicao.AtualizaReq();
            consultar_requisicao.setPrincipal(this);
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui acesso a essa função", "Permissão negada!", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
        }
    }//GEN-LAST:event_menu_consultar_requisicaoActionPerformed

    private void menu_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_visualizarActionPerformed
        Janela(visualizar_estoque);
        visualizar_estoque.AtualizaLista();

    }//GEN-LAST:event_menu_visualizarActionPerformed

    private void menu_coleta_precoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_coleta_precoActionPerformed
        if (Tipo.equals("A")) {
            Janela(coletapreco);
            coletapreco.setPrincipal(this);
        } else {
            JOptionPane.showMessageDialog(null, "Você não possui acesso a essa função", "Permissão negada!", JOptionPane.ERROR_MESSAGE, new ImageIcon("src/br/compra/icones/exclamation.png"));
        }
    }//GEN-LAST:event_menu_coleta_precoActionPerformed

    private void menu_consultar_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_consultar_pedidoActionPerformed
        Janela(visualizar_Pedidos);
        visualizar_Pedidos.AtualizaTabela();
    }//GEN-LAST:event_menu_consultar_pedidoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane_principal;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem menu_coleta_preco;
    private javax.swing.JMenu menu_compras;
    private javax.swing.JMenu menu_consultar;
    private javax.swing.JMenuItem menu_consultar_pedido;
    private javax.swing.JMenuItem menu_consultar_requisicao;
    private javax.swing.JMenu menu_estoque;
    private javax.swing.JMenuItem menu_fornecedor;
    private javax.swing.JMenuItem menu_movimentacao;
    private javax.swing.JMenuItem menu_notafiscal;
    private javax.swing.JMenuItem menu_produto;
    private javax.swing.JMenuItem menu_requisicao;
    private javax.swing.JMenuItem menu_visualizar;
    // End of variables declaration//GEN-END:variables
}
