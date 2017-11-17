package br.compra.xls;

import br.compra.getset.FornecedorGetSet;
import br.compra.getset.ProdutoGetSet;
import br.compra.getset.RequisicaoGetSet;
import br.compra.telas.BarraProgresso;
import br.compra.telas.Principal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GerarXls {

    private FileOutputStream planilha = null;
    private final RequisicaoGetSet req;
    private String caminho = "C:\\Users\\Public\\";
    private String[] info = {"Código", "produto", "Quantidade", "Preço unitário", "Total", "Data Prevista", "Fornecedor"};
    private String msg = "Em anexo um formulario de coleta de preço.\n Por favor preencha conforme o padrão";
    private EnviaEmail envia;
    private BarraProgresso bar;
    private int tamf;
    public GerarXls(RequisicaoGetSet req) {
        this.req = req;
    }

    public void geraxls() {
        List<ProdutoGetSet> p = req.getLisproduto();
        List<FornecedorGetSet> f = new ArrayList<>();
        List<String> lis = new ArrayList<>();
        bar = new BarraProgresso();
        Thread t = new Thread(bar);
        bar.setVisible(true);
        t.start();
        
        for (int i = 0; i < p.size(); i++) {
            
            for (int j = 0; j < p.get(i).getF().size(); j++) {

                if (!lis.contains(p.get(i).getF().get(j).getCodigo())) {

                    f.add(p.get(i).getF().get(j));

                    f.get(f.size() - 1).setP(p.get(i));
                    lis.add(p.get(i).getF().get(j).getCodigo());

                } else {

                    for (int y = 0; y < f.size(); y++) {

                        if (f.get(y).getCodigo().equals(p.get(i).getF().get(j).getCodigo())) {

                            f.get(y).setP(p.get(i));
                        }

                    }
                }

            }

        }

        try {

            tamf = f.size();

            for (int i = 0; i < f.size(); i++) {
                bar.AtualizaBarra(i+1, f.size());
                File file = new File(caminho + f.get(i).getNome() + ".xlsx");
                planilha = new FileOutputStream(file);
                Workbook wb = new XSSFWorkbook();

                Sheet sheet = wb.createSheet("Coleta de preço");
                Row linha;
                Cell cel;

                int tam = info[3].length() * 250;

                sheet.setColumnWidth(0, tam);
                sheet.setColumnWidth(1, tam);
                sheet.setColumnWidth(2, tam);
                sheet.setColumnWidth(3, tam);
                sheet.setColumnWidth(4, tam);
                sheet.setColumnWidth(5, tam);
                sheet.setColumnWidth(6, tam);
                linha = sheet.createRow(0);
                for (int h = 0; h < info.length; h++) {
                    cel = linha.createCell(h);
                    cel.setCellValue(info[h]);

                }

                for (int j = 0; j < f.get(i).getP().size(); j++) {
                    linha = sheet.createRow(j + 1);
                    cel = linha.createCell(0);
                    cel.setCellValue(f.get(i).getP().get(j).getCodigo());
                    cel = linha.createCell(1);
                    cel.setCellValue(f.get(i).getP().get(j).getNome());
                    cel = linha.createCell(2);
                    cel.setCellValue(Integer.parseInt(f.get(i).getP().get(j).getquant()));
                    cel = linha.createCell(6);
                    cel.setCellValue(f.get(i).getNome());
                

              }
                    wb.write(planilha);
                    planilha.close();
                envia = new EnviaEmail();
              
              
                
                envia.emailFornecedor(msg, caminho + f.get(i).getNome() + ".xlsx", f.get(i).getEmail());
            }

          
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                planilha.close();
            } catch (IOException ex) {
            }

        }

        bar.dispose();
        JOptionPane.showMessageDialog(null, "Enviado!");
        
    }

}
