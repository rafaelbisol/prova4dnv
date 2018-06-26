
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.pratica.Lancamento;
import utfpr.ct.dainf.pratica.ProcessaLancamentos;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author Bisol
 */
public class Pratica {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Scanner entradaScanner = new Scanner(System.in);
        String path;
        
        System.out.print("Por favor, digite o caminho completo para o arquivo de lançamentos: ");
        path = entradaScanner.next();
        
        ProcessaLancamentos pl = new ProcessaLancamentos(path);
        List<Lancamento> lancamentos = pl.getLancamentos();
        
        int numeroConta;
        
        do {
            
            System.out.print("Digite um número de conta: ");

            while(!entradaScanner.hasNextInt()) {
                System.out.print("Por favor, informe um valor numérico: ");
                String str = entradaScanner.next();
            }
            
            numeroConta = entradaScanner.nextInt();
            
            exibeLancamentosConta(lancamentos, numeroConta);
            
        } while(numeroConta != 0);
        
    }
    
    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {

        int inicio = lancamentos.indexOf(conta);
        int fim = lancamentos.lastIndexOf(conta);
        
        if(inicio < 0) {
            System.out.println("Conta inexistente.");
            return;
        }
        
        for(int i = inicio; i < fim; i++) {
            System.out.println(lancamentos.get(i));
        }
    }
 
}