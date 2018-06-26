package utfpr.ct.dainf.pratica;

import java.util.Comparator;

/**
 * Linguagem Java
 * @author Bisol
 */
public class LancamentoComparator implements Comparator<Lancamento> {

    
    /**
     * Comparação por número da conta e data, ambos em ordem ascendente.
     * @param l1
     * @param l2
     * @return 
     */
    @Override
    public int compare(Lancamento l1, Lancamento l2) {
        
       if(l1.getConta() < l2.getConta()) {
           
           return -1;
           
       } else if(l1.getConta() > l2.getConta()) {
       
           return 1;
       
       } else {
         
           if(l1.getData().compareTo(l2.getData()) > 0) {
            
               return 1;
           
           } else if(l1.getData().compareTo(l2.getData()) < 0) {
               
               return -1;
               
           } else {
               
               return 0;
               
           }   
       }
    }
    
}
