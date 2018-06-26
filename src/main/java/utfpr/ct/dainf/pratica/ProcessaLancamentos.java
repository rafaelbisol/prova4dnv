package utfpr.ct.dainf.pratica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Linguagem Java
 * @author Bisol
 */
public class ProcessaLancamentos {
    private BufferedReader reader;
    
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ProcessaLancamentos(File arquivo) throws FileNotFoundException {
        reader = new BufferedReader( new FileReader(arquivo) );
    }

    public ProcessaLancamentos(String path) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(new File(path)));
    }
    
    private String getNextLine() throws IOException {
        return reader.readLine();
    }
    
    /**
     * Lê a linha do arquivo, e devolve um objeto Lançamento preenchido, conforme especificação do arquivo.
     * @param linha
     * @return 
     */
    private Lancamento processaLinha(String linha) {
        Integer conta = Integer.valueOf(linha.substring(0, 6));
        
        // Data
        int ano = Integer.valueOf(linha.substring(6, 10)) - 1900;
        int mes = Integer.valueOf(linha.substring(10,12)) - 1;
        int dia = Integer.valueOf(linha.substring(12,14));
        Date data = new Date(ano, mes, dia);
        
        String descricao = linha.substring(14, 73).trim();
        
        Double valor = Double.valueOf(linha.substring(74, 84) + "." + linha.substring(84,  86));
        
        System.out.println(
                String.format("%d - %s - %s - %f", conta, dateFormat.format(data), descricao, valor)
        );
        
        return new Lancamento(conta, data, descricao, valor);
    }
    
    private Lancamento getNextLancamento() throws IOException {
        String linha = getNextLine();
        
        if(linha == null)
            return null;
        else        
            return processaLinha(linha);
    }
    
    public List<Lancamento> getLancamentos() throws IOException {
        List<Lancamento> lista = new ArrayList<>();
        Lancamento l;
        
        while( (l = getNextLancamento()) != null ) {
            lista.add(l);
        }
        
        lista.sort(new LancamentoComparator());
        
        reader.close(); 
        return lista;
    }
    
}
