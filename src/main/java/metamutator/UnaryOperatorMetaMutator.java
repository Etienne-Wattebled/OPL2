package metamutator;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;
import com.sun.javafx.fxml.expression.Expression;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.UnaryOperatorKind;
import spoon.reflect.declaration.CtAnonymousExecutable;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtField;

public class UnaryOperatorMetaMutator extends AbstractProcessor<CtExpression<Boolean>> {
	public static final String PREFIX =  "_unaryOperatorHotSpot";
	private static int index = 0;
	
	public enum UnaryOperator {
		NOT,
		SAME
	};
	
	private static final EnumSet<UnaryOperator> UNARY_OPERATORS = EnumSet.of(UnaryOperator.NOT,UnaryOperator.SAME);
	
	private Set<CtElement> hotSpots = Sets.newHashSet();
	
	@Override
	public boolean isToBeProcessed(CtExpression<Boolean> element) {
		String type = element.getType().toString();
		System.out.println(type);
		
		if (!type.toUpperCase().equals("BOOLEAN")) {
			return false;
		}
		try {
			Selector.getTopLevelClass(element);
		} catch (NullPointerException e) {
			return false;
		}
		
		if (element.getParent(CtConstructor.class) != null) {
			return false;
		}
		
		if (element.getParent(CtField.class) != null) {
				return false;
		}
		
		if (element.getParent(CtAnonymousExecutable.class) != null) {
			return false;
		}
		
		return true;
	}
	
	public void process(CtExpression<Boolean> booleanExpression) {
		mutateOperator(booleanExpression,UNARY_OPERATORS);
	}
	
	private boolean alreadyInHotsSpot(CtElement element) {
		return hotSpots.contains(element);
	}
	
	private void mutateOperator(CtExpression<Boolean> booleanExpression, EnumSet<UnaryOperator> operators) {
		if (alreadyInHotsSpot(booleanExpression)
				|| booleanExpression.toString().contains(".is(\"")) {
			System.out
					.println(String
							.format("Expression '%s' ignored because it is included in previous hot spot",
									booleanExpression));
			return;
		}
		int thisIndex = ++index;
		
		String originalExpression = booleanExpression.toString();
		
		String newExpression = UNARY_OPERATORS
				.stream()
				.map(op -> {
					String expr = originalExpression;
					if (op == UnaryOperator.NOT) {
						expr = "!(" + originalExpression + ")";
					}
					return String.format("("+ PREFIX + "%s.is(\"%s\") && (%s))",
							thisIndex,op, expr);
				}).collect(Collectors.joining(" || "));
		
		
		CtCodeSnippetExpression<Boolean> codeSnippet = getFactory().Core()
				.createCodeSnippetExpression();
		codeSnippet.setValue('(' + newExpression + ')');
		
		booleanExpression.replace(codeSnippet);
		
		Selector.generateSelector(booleanExpression,originalExpression.toString(),thisIndex,UNARY_OPERATORS,PREFIX);
		
		hotSpots.add(booleanExpression);
	}
}
