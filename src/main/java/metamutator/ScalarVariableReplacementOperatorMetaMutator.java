package metamutator;

import java.util.ArrayList;
import java.util.EnumSet;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.reference.CtVariableReference;
import spoon.support.reflect.code.CtBinaryOperatorImpl;
import spoon.support.reflect.code.CtUnaryOperatorImpl;

/**
 * inserts a mutation hotspot for each Scalar Variable
 */
public class ScalarVariableReplacementOperatorMetaMutator 
				extends AbstractProcessor<CtVariableRead> {

	public static final String PREFIX = "_scalarVariableReplacementOperatorHotSpot";
	
	public enum SVR {
		// NO CHANGE
		SAME,
		// Increment
		INC,
		// Decrement
		DEC
	};
	private static final EnumSet<SVR> svrSet = EnumSet
			.of(SVR.INC, SVR.DEC);
	
	/**
	 * 
	 */
	public static int thisIndex = 0;
	
	/**
	 * Accept Scalar Variable
	 */
	@Override
	public boolean isToBeProcessed(CtVariableRead candidate) {
		
		if(candidate.getVariable() == null) return false;
		if(candidate.getVariable().getModifiers().contains(ModifierKind.FINAL)) return false;
		
		if(candidate.getTypeCasts().size() > 0) return false;
		for(CtTypeReference type : candidate.getReferencedTypes()) {
			if(!this.isNumber(type)) return false;
		}
		
		if( candidate.getParent().getClass().equals(CtUnaryOperatorImpl.class)) return false;
		
		if(this.isNumber(candidate.getVariable().getType())){
			System.out.println(candidate);
			System.out.println(candidate.getParent());
			System.out.println(candidate.getParent().getClass());
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param ctVariableReference
	 * @return
	 */
	private boolean isNumber(CtTypeReference type) {
		return type.getSimpleName().equals("int")
			|| type.getSimpleName().equals("long")
			|| type.getSimpleName().equals("byte")
		|| type.getSimpleName().equals("float")
		|| type.getSimpleName().equals("double");
	}
	
	/**
	 * Add Increment or Decrement
	 */
	@Override
	public void process(CtVariableRead candidate) {
		thisIndex++;
		
		String expression = "(";
		for(SVR svr : svrSet){
			if(svr.equals(SVR.SAME)) continue;
			expression += PREFIX+thisIndex + ".is(\"" + svr.toString() + "\")?( " + ScalarVariableReplacementEquivalent(svr)  + candidate.toString() + ")):";
		}
		expression += "(" + candidate.toString() + "))";
		CtCodeSnippetExpression<Boolean> codeSnippet = getFactory().Core()
				.createCodeSnippetExpression();
		codeSnippet.setValue(expression);
		candidate.replace(codeSnippet);
		Selector.generateSelector(candidate, SVR.SAME.toString(), thisIndex, svrSet, PREFIX);
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	private String ScalarVariableReplacementEquivalent(SVR value) {
		switch(value) {
		case INC : return "(++";
		case DEC : return "(--";
		default : return "(";
		}
	}
}