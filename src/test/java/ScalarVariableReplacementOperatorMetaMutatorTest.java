import static org.junit.Assert.*;

import metamutator.Selector;
import metamutator.ScalarVariableReplacementOperatorMetaMutator;

import org.junit.Test;

import spoon.Launcher;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.visitor.filter.NameFilter;
import bsh.Interpreter;
import static org.apache.commons.lang.reflect.MethodUtils.*;

public class ScalarVariableReplacementOperatorMetaMutatorTest {

    @Test
    public void testScalarVariableReplacementMetaMutator() throws Exception {
        // build the model and apply the transformation
        Launcher l = new Launcher();
        l.addInputResource("src/test/java/ressources/");
        l.addProcessor(new ScalarVariableReplacementOperatorMetaMutator());
        l.run();

        // now we get the code of Foo
        CtClass c = (CtClass) l.getFactory().Package().getRootPackage().getElements(new NameFilter("Foo")).get(0);
        
        // printing the metaprogram
        System.out.println("// Metaprogram: ");
        System.out.println(c.toString());

        // we prepare an interpreter for the transformed code
        Interpreter bsh = new Interpreter();
        // creating a new instance of the class
        Object o = ((Class)bsh.eval(c.toString())).newInstance();
        
        // test with the second mutation hotspot
        Selector sel1=Selector.getSelectorByName(ScalarVariableReplacementOperatorMetaMutator.PREFIX + "1");
        
        sel1.choose(0);// SAME
        assertEquals(-1, invokeExactMethod(o, "add", new Object[] {3, -4}));   
        sel1.choose(1);// INC
        assertEquals(0, invokeExactMethod(o, "add", new Object[] {3, -4}));  
        sel1.choose(2);// DEC
        assertEquals(-2, invokeExactMethod(o, "add", new Object[] {3, -4}));
        
        ScalarVariableReplacementOperatorMetaMutator scalarPROC = new ScalarVariableReplacementOperatorMetaMutator();
       
        CtVariableRead candidate = l.getFactory().Core().createVariableRead();
        // Fail On NOT declared variable
        assertEquals(false,scalarPROC.isToBeProcessed(candidate));
    }
}