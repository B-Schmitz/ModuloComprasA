
package br.compra.telas;

import br.compra.dao.RequisicaoDao;
import br.compra.getset.RequisicaoGetSet;
import br.compra.listeners.ConsultaReqListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;


public class ConsultarRequisicao extends javax.swing.JInternalFrame {

    private final RequisicaoDao reqDao = new RequisicaoDao();
    private List<RequisicaoGetSet> req;
    private DefaultTableModel model;
    private DefaultTableModel model1;
    private Principal p;
 
    public ConsultarRequisicao() {
        initComponents();
        bnt_aprovar.addActionListener(new ConsultaReqListener(this));
        bnt_reprovar.addActionListener(new ConsultaReqListener(this));
         this.setFrameIcon(new ImageIcon("src/br/compra/icones/search_field.png"));
        
      
    }
    public void AtualizaReq(){
          req = reqDao.read();
        
         model = (DefaultTableModel) TabelaAprovReq.getModel();
         model1 = (DefaultTableModel) TabelaAprovProd.getModel();
         
         model.setNumRows(0);

        for (int i = 0; i < req.size(); i++) {

            model.addRow(new Object[]{req.get(i).getNumRequisicao(),req.get(i).getSetor(),
            req.get(i).getSolicitante(),req.get(i).getChefe(),req.get(i).getPrioridade(),req.get(i).getData(),req.get(i).getObservacoes()});
            
          
        }
    }
    
    public void reprovar(){
        int linha = TabelaAprovReq.getSelectedRow();
        
        if(linha != -1){
        Integer idReq  = (Integer)model.getValueAt(linha, 0);
       
        for(int i = 0; i < req.size(); i ++){
            
            if(idReq.equals(req.get(i).getNumRequisicao())){
                reqDao.Delete(req.get(i));
                break;
            }
            
        }
        model1.setNumRows(0);
        
        AtualizaReq();
        }
    }
    
    
      public void setPrincipal(Principal p){
        
        this.p = p;
      
        
    }
      
      public void inicia(){
          model = (DefaultTableModel) TabelaAprovReq.getModel();
          
          if(TabelaAprovReq.getSelectedRow() != -1){
          String id = model.getValueAt(TabelaAprovReq.getSelectedRow(), 0) +"";
          
          
          p.IniciaColeta(req ,Integer.parseInt(id));
      }
      }
    public void MostraProdutos(){
        
          model1.setNumRows(0);
          int i = -1;
          i = TabelaAprovReq.getSelectedRow();
          for(int j = 0; j < req.get(i).getLisproduto().size(); j++){

            model1.addRow(new Object[]{req.get(i).getLisproduto().get(j).getCodigo(),req.get(i).getLisproduto().get(j).getNome(),req.get(i).getQuantidade().get(j)});
            
            }
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaAprovReq = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaAprovProd = new javax.swing.JTable();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        bnt_reprovar = new javax.swing.JButton();
        bnt_aprovar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Consultar Requisição");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aprovar Requisições", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        TabelaAprovReq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Requisição", "Setor", "Solicitante", "Chefe", "Prioridade", "Data", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaAprovReq.getTableHeader().setReorderingAllowed(false);
        TabelaAprovReq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaAprovReqMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelaAprovReq);
        if (TabelaAprovReq.getColumnModel().getColumnCount() > 0) {
            TabelaAprovReq.getColumnModel().getColumn(0).setResizable(false);
            TabelaAprovReq.getColumnModel().getColumn(1).setResizable(false);
            TabelaAprovReq.getColumnModel().getColumn(2).setResizable(false);
            TabelaAprovReq.getColumnModel().getColumn(3).setResizable(false);
            TabelaAprovReq.getColumnModel().getColumn(4).setResizable(false);
            TabelaAprovReq.getColumnModel().getColumn(5).setResizable(false);
            TabelaAprovReq.getColumnModel().getColumn(6).setResizable(false);
        }

        TabelaAprovProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.Prod", "Produto", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaAprovProd.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TabelaAprovProd);
        if (TabelaAprovProd.getColumnModel().getColumnCount() > 0) {
            TabelaAprovProd.getColumnModel().getColumn(0).setResizable(false);
            TabelaAprovProd.getColumnModel().getColumn(1).setResizable(false);
            TabelaAprovProd.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        bnt_reprovar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        bnt_reprovar.setForeground(new java.awt.Color(51, 51, 55));
        bnt_reprovar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/delete.png"))); // NOI18N
        bnt_reprovar.setText("Reprovar");

        bnt_aprovar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        bnt_aprovar.setForeground(new java.awt.Color(51, 51, 55));
        bnt_aprovar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/compra/icones/add.png"))); // NOI18N
        bnt_aprovar.setText("Aprovar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bnt_aprovar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bnt_reprovar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnt_aprovar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnt_reprovar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaAprovReqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaAprovReqMouseClicked
        if(evt.getClickCount() == 2){
            
            MostraProdutos();
        }
    }//GEN-LAST:event_TabelaAprovReqMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaAprovProd;
    private javax.swing.JTable TabelaAprovReq;
    private javax.swing.JButton bnt_aprovar;
    private javax.swing.JButton bnt_reprovar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
