// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class Foo {
    public boolean op(java.lang.Boolean a, java.lang.Boolean b) {
        return ((_unaryOperatorHotSpot1.is("NOT") && (!(a || b))) || (_unaryOperatorHotSpot1.is("SAME") && (a || b)));
    }

    public boolean op2(java.lang.Integer a, java.lang.Integer b) {
        return ((_unaryOperatorHotSpot2.is("NOT") && (!(a > b))) || (_unaryOperatorHotSpot2.is("SAME") && (a > b)));
    }

    public boolean op3(java.lang.Class c) {
        return ((_unaryOperatorHotSpot3.is("NOT") && (!((Foo.class) == c))) || (_unaryOperatorHotSpot3.is("SAME") && ((Foo.class) == c)));
    }

    private static final metamutator.Selector _unaryOperatorHotSpot1 = metamutator.Selector.of(1,new metamutator.UnaryOperatorMetaMutator.UnaryOperator[]{java.lang.String.a || b,metamutator.UnaryOperatorMetaMutator.UnaryOperator.NOT,metamutator.UnaryOperatorMetaMutator.UnaryOperator.SAME}).in(Foo.class).id("_unaryOperatorHotSpot1");

    private static final metamutator.Selector _unaryOperatorHotSpot2 = metamutator.Selector.of(2,new metamutator.UnaryOperatorMetaMutator.UnaryOperator[]{java.lang.String.a > b,metamutator.UnaryOperatorMetaMutator.UnaryOperator.NOT,metamutator.UnaryOperatorMetaMutator.UnaryOperator.SAME}).in(Foo.class).id("_unaryOperatorHotSpot2");

    private static final metamutator.Selector _unaryOperatorHotSpot3 = metamutator.Selector.of(3,new metamutator.UnaryOperatorMetaMutator.UnaryOperator[]{java.lang.String.(Foo.class) == c,metamutator.UnaryOperatorMetaMutator.UnaryOperator.NOT,metamutator.UnaryOperatorMetaMutator.UnaryOperator.SAME}).in(Foo.class).id("_unaryOperatorHotSpot3");
}

