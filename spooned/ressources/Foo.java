package ressources;


public class Foo {
    public boolean op(java.lang.Boolean a, java.lang.Boolean b) {
        return ((_unaryOperatorHotSpot1.is("NOT") && (!a)) || (_unaryOperatorHotSpot1.is("SAME") && (a))) || ((_unaryOperatorHotSpot2.is("NOT") && (!b)) || (_unaryOperatorHotSpot2.is("SAME") && (b)));
    }

    public boolean op2(java.lang.Integer a, java.lang.Integer b) {
        return ((_unaryOperatorHotSpot3.is("NOT") && (!a)) || (_unaryOperatorHotSpot3.is("SAME") && (a))) > ((_unaryOperatorHotSpot4.is("NOT") && (!b)) || (_unaryOperatorHotSpot4.is("SAME") && (b)));
    }

    public boolean op3(java.lang.Class c) {
        return ((_unaryOperatorHotSpot5.is("NOT") && (!(ressources.Foo.class))) || (_unaryOperatorHotSpot5.is("SAME") && ((ressources.Foo.class)))) == ((_unaryOperatorHotSpot6.is("NOT") && (!c)) || (_unaryOperatorHotSpot6.is("SAME") && (c)));
    }

    private static final metamutator.Selector _unaryOperatorHotSpot1 = metamutator.Selector.of(1,new metamutator.UnaryOperatorMetaMutator.UnaryOperator[]{java.lang.String.a,metamutator.UnaryOperatorMetaMutator.UnaryOperator.NOT,metamutator.UnaryOperatorMetaMutator.UnaryOperator.SAME}).in(ressources.Foo.class).id("_unaryOperatorHotSpot1");

    private static final metamutator.Selector _unaryOperatorHotSpot2 = metamutator.Selector.of(2,new metamutator.UnaryOperatorMetaMutator.UnaryOperator[]{java.lang.String.b,metamutator.UnaryOperatorMetaMutator.UnaryOperator.NOT,metamutator.UnaryOperatorMetaMutator.UnaryOperator.SAME}).in(ressources.Foo.class).id("_unaryOperatorHotSpot2");

    private static final metamutator.Selector _unaryOperatorHotSpot3 = metamutator.Selector.of(3,new metamutator.UnaryOperatorMetaMutator.UnaryOperator[]{java.lang.String.a,metamutator.UnaryOperatorMetaMutator.UnaryOperator.NOT,metamutator.UnaryOperatorMetaMutator.UnaryOperator.SAME}).in(ressources.Foo.class).id("_unaryOperatorHotSpot3");

    private static final metamutator.Selector _unaryOperatorHotSpot4 = metamutator.Selector.of(4,new metamutator.UnaryOperatorMetaMutator.UnaryOperator[]{java.lang.String.b,metamutator.UnaryOperatorMetaMutator.UnaryOperator.NOT,metamutator.UnaryOperatorMetaMutator.UnaryOperator.SAME}).in(ressources.Foo.class).id("_unaryOperatorHotSpot4");

    private static final metamutator.Selector _unaryOperatorHotSpot5 = metamutator.Selector.of(5,new metamutator.UnaryOperatorMetaMutator.UnaryOperator[]{java.lang.String.(ressources.Foo.class),metamutator.UnaryOperatorMetaMutator.UnaryOperator.NOT,metamutator.UnaryOperatorMetaMutator.UnaryOperator.SAME}).in(ressources.Foo.class).id("_unaryOperatorHotSpot5");

    private static final metamutator.Selector _unaryOperatorHotSpot6 = metamutator.Selector.of(6,new metamutator.UnaryOperatorMetaMutator.UnaryOperator[]{java.lang.String.c,metamutator.UnaryOperatorMetaMutator.UnaryOperator.NOT,metamutator.UnaryOperatorMetaMutator.UnaryOperator.SAME}).in(ressources.Foo.class).id("_unaryOperatorHotSpot6");
}

