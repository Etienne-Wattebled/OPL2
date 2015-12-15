import static org.junit.Assert.assertEquals;

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
     
	     Selector ba = Selector.getSelectorByName(UnaryOperatorMetaMutator.PREFIX + "1");	     
	     Selector bb = Selector.getSelectorByName(UnaryOperatorMetaMutator.PREFIX + "2");
	     // a || b
	     ba.choose(0);
	     bb.choose(0);
	     assertEquals(false,invokeExactMethod(o,"op",new Object[] { Boolean.FALSE, Boolean.FALSE }));
	     assertEquals(true,invokeExactMethod(o,"op",new Object[] { Boolean.TRUE, Boolean.FALSE }));
	     assertEquals(true,invokeExactMethod(o,"op",new Object[] { Boolean.FALSE, Boolean.TRUE }));
	     assertEquals(true,invokeExactMethod(o,"op",new Object[] { Boolean.TRUE, Boolean.TRUE }));

	     // !a || b
	     ba.choose(1);
	     bb.choose(0);
	     assertEquals(true,invokeExactMethod(o,"op",new Object[] { Boolean.FALSE, Boolean.FALSE }));
	     assertEquals(false,invokeExactMethod(o,"op",new Object[] { Boolean.TRUE, Boolean.FALSE }));
	     assertEquals(true,invokeExactMethod(o,"op",new Object[] { Boolean.FALSE, Boolean.TRUE }));
	     assertEquals(true,invokeExactMethod(o,"op",new Object[] { Boolean.TRUE, Boolean.TRUE }));
	     
	     // a || !b
	     ba.choose(0);
	     bb.choose(1);
	     assertEquals(true,invokeExactMethod(o,"op",new Object[] { Boolean.FALSE, Boolean.FALSE }));
	     assertEquals(true,invokeExactMethod(o,"op",new Object[] { Boolean.TRUE, Boolean.FALSE }));
	     assertEquals(false,invokeExactMethod(o,"op",new Object[] { Boolean.FALSE, Boolean.TRUE }));
	     assertEquals(true,invokeExactMethod(o,"op",new Object[] { Boolean.TRUE, Boolean.TRUE }));
	     
	     Selector asb = Selector.getSelectorByName(UnaryOperatorMetaMutator.PREFIX + "3");
	     
	     // a > b
	     asb.choose(0);
	     assertEquals(true,invokeExactMethod(o,"op2",new Object[] { 5, 4 }));
	     assertEquals(false,invokeExactMethod(o,"op2",new Object[] { 4, 5 }));
	     assertEquals(false,invokeExactMethod(o,"op2",new Object[] { 4, 4 }));

	     // !(a > b)
	     asb.choose(1);
	     assertEquals(false,invokeExactMethod(o,"op2",new Object[] { 5, 4 }));
	     assertEquals(true,invokeExactMethod(o,"op2",new Object[] { 4, 5 }));
	     assertEquals(true,invokeExactMethod(o,"op2",new Object[] { 4, 4 }));

	     Selector diff = Selector.getSelectorByName(UnaryOperatorMetaMutator.PREFIX + "4");
	     
	     // ((Foo.class) == c)
	     diff.choose(0);
	     assertEquals(true,invokeExactMethod(o,"op3",new Object[] { Foo.class }));
	     assertEquals(false,invokeExactMethod(o,"op3",new Object[] { UnaryOperatorMetaMutator.class }));
	     
	     // !((Foo.class) == c)
	     diff.choose(1);
	     assertEquals(false,invokeExactMethod(o,"op3",new Object[] { Foo.class }));
	     assertEquals(true,invokeExactMethod(o,"op3",new Object[] { UnaryOperatorMetaMutator.class }));
	 }
}
