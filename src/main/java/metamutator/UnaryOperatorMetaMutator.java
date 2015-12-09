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
	
	private static final EnumSet<UnaryOperatorKind> UNARY_OPERATORS = EnumSet.of(UnaryOperatorKind.NOT);
	
	private Set<CtElement> hotSpots = Sets.newHashSet();
	
	@Override
	public boolean isToBeProcessed(CtExpression<Boolean> element) {
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
	
	private void mutateOperator(CtExpression<Boolean> booleanExpression, EnumSet<UnaryOperatorKind> operators) {
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
		String newExpression = originalExpression + "|| !" + originalExpression;
		
		CtCodeSnippetExpression<Boolean> codeSnippet = getFactory().Core()
				.createCodeSnippetExpression();
		codeSnippet.setValue('(' + newExpression + ')');
		
		booleanExpression.replace(codeSnippet);
		
		Selector.generateSelector(booleanExpression,originalExpression.toString(),thisIndex,UNARY_OPERATORS,PREFIX);
		
		hotSpots.add(booleanExpression);
	}
}
