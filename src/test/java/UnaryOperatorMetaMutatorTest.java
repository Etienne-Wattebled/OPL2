import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import static org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod;
import bsh.Interpreter;
import metamutator.BinaryOperatorMetaMutator;
import metamutator.Selector;
import metamutator.UnaryOperatorMetaMutator;
import metamutator.UnaryOperatorMetaMutator.UnaryOperator;
import spoon.Launcher;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.visitor.filter.NameFilter;

public class UnaryOperatorMetaMutatorTest {
	@Test
	 public void testUnaryOperatorMetaMutator() throws Exception {
		 Launcher l = new Launcher();
		 
		 l.addInputResource("src/test/java/Foo.java");
		 l.addProcessor(new UnaryOperatorMetaMutator());
		 l.run();
		 
	     CtClass c = (CtClass) l.getFactory().Package().getRootPackage().getElements(new NameFilter("Foo")).get(0);

	     System.out.println("// Metaprogram: ");
	     System.out.println(c.toString());
	        
	     Interpreter bsh = new Interpreter();
	     
	     // there is no selector before loading the class
	     assertEquals(0,Selector.getAllSelectors().size());

	     // creating a new instance of the class
	     Object o = ((Class) bsh.eval(c.toString())).newInstance();   
	     assertEquals(4,Selector.getAllSelectors().size()); 
	     
	     //test with the first
	     Selector sel = Selector.getSelectorByName(UnaryOperatorMetaMutator.PREFIX + "1");
	     
	     //now we activate the first metamutation
	     sel.choose(1);
	     assertEquals(true, invokeExactMethod(o, "op", new Object[] {Boolean.TRUE, Boolean.FALSE}));
	     assertEquals(true, invokeExactMethod(o, "op", new Object[] {Boolean.TRUE, Boolean.TRUE}));
	     assertEquals(true, invokeExactMethod(o, "op", new Object[] {Boolean.FALSE, Boolean.TRUE}));
	     assertEquals(false, invokeExactMethod(o, "op", new Object[] {Boolean.FALSE, Boolean.FALSE}));

	     //impossible option
	     try {
	    	 sel.choose(2);
	    	 fail();
	     }
	     catch (IllegalArgumentException expected){}
		     
	 }
}
