import java.util.LinkedList;

/**
 *
 * @author Benjamin Bardy
 */
public class Branch extends Instr{
    private final LinkedList<Instr> code1, code2;
    
    public Branch(LinkedList<Instr> c1, LinkedList<Instr> c2){
        code1 = c1;
        code2 = c2;
    }
    
    
    @Override
    void exec_instr(Config cf) {
        cf.get_code().pop();
        
        //Valeur du sommet du stack
        Value x = ((ValueSE)cf.get_stack().pop()).get_valeur();
        
        boolean b = ((BoolV)cf.get_value()).get_bool();
        
        cf.set_value(x);
        cf.get_stack().addFirst(new CodeSE(cf.get_code()));
        
        //Copie du code de la branche pour empêcher les problèmes
        cf.set_code(b ? new LinkedList<>(code1) : new LinkedList<>(code2));
       
    }
    
}
