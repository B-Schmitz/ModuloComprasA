package br.compra.xls;

import br.compra.dao.ColetaDao;
import br.compra.dao.FornecedorDao;
import br.compra.getset.ColetaGetSet;
import br.compra.getset.FornecedorGetSet;
import br.compra.getset.ProdutoGetSet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Lexls {

    private FileInputStream fisPlanilha = null;
    private List<ColetaGetSet> lisColta ;
    private ColetaGetSet c = new ColetaGetSet();
    private int linha;
    private int coluna;
    private String DataP;

    public List<ColetaGetSet> ler(DefaultListModel dl, String LocalAquivos) {
        lisColta = new ArrayList<>();
        for (int i = 0; i < dl.size(); i++) {
            File file = new File(LocalAquivos + "\\" + dl.get(i));

            System.out.println("te: " + LocalAquivos + "\\" + dl.get(i));
            try {
                fisPlanilha = new FileInputStream(file);

                //cria um workbook = planilha toda com todas as abas
                XSSFWorkbook workbook = new XSSFWorkbook(fisPlanilha);

                //recuperamos apenas a primeira aba ou primeira planilha
                XSSFSheet sheet = workbook.getSheetAt(0);

                //retorna todas as linhas da planilha 0 (aba 1)
                Iterator<Row> rowIterator = sheet.iterator();

                //varre todas as linhas da planilha 0
                while (rowIterator.hasNext()) {

                    //recebe cada linha da planilha
                    Row row = rowIterator.next();

                    //pegamos todas as celulas desta linha
                    Iterator<Cell> cellIterator = row.iterator();

                    //varremos todas as celulas da linha atual
                    while (cellIterator.hasNext()) {

                        //criamos uma celula
                        Cell cell = cellIterator.next();
                        linha = cell.getRowIndex();
                        coluna = cell.getColumnIndex();
                        if (linha > 0) {
                            {

                                if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                                    System.out.println("TIPO STRING: " + cell.getStringCellValue());
                                    String str = cell.getStringCellValue();

                                    switch (coluna) {
                                        case 0:
                                            ProdutoGetSet p = new ProdutoGetSet();
                                            p.setCodigo(str);
                                            c.setP(p);
                                            break;
                                        case 1:
                                            c.getP().setNome(str);
                                            break;

                                        case 6:
                                            FornecedorGetSet f = new FornecedorGetSet();
                                            f.setNome(str);
                                            c.setF(f);
                                            FornecedorDao fd = new FornecedorDao();
                                             {
                                                try {
                                                    c.setF(fd.BuscaNome(c.getF()));
                                                } catch (SQLException ex) {
                                                    Logger.getLogger(Lexls.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                            break;
                                    }

                                } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                                    System.out.println("TIPO NUMERICO: " + cell.getNumericCellValue());
                                    Double str1 = cell.getNumericCellValue();
                                    String str = str1.toString();
                                    switch (coluna) {

                                        case 2:
                                            double d = Double.valueOf(str);
                                            c.setQuantidade((int)d);
                                            break;

                                        case 3:
                                            c.setPreco_unitario(Double.valueOf(str.replace("[,]", ".")));
                                            break;

                                        case 4:
                                            c.setValorEstimado(Double.valueOf(str));
                                            break;
                                        case 5:

                                             {

                                                SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                                                DataP = data.format(cell.getDateCellValue());
                                                c.setDataPrevista(DataP);

                                            }
                                            break;

                                    }
                                }

                            }
                        }
                        //  lisColta.add(c);
                        /* case Cell.CELL_TYPE_FORMULA:
                            System.out.println("TIPO FORMULA: " + cell.getCellFormula());*/
                    }
                    if (linha > 0) {

                        lisColta.add(c);
                        c = new ColetaGetSet();
                    }
                }

            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            } finally {
                try {
                    fisPlanilha.close();
                } catch (IOException ex) {
                }
            }
        }
        ColetaDao cd = new ColetaDao();
        cd.Insert(lisColta);
          return lisColta;
        
        
    }
}
