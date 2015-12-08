// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class Foo {
    public boolean op(java.lang.Boolean a, java.lang.Boolean b) {
        return a || b;
    }

    public boolean op2(java.lang.Integer a, java.lang.Integer b) {
        return a > b;
    }

    public boolean op3(java.lang.Class c) {
        return (Foo.class) == c;
    }

    private static final metamutator.Selector _unaryOperatorHotSpot76 = metamutator.Selector.of(76,new String[]{"a","NOT"}).in(Foo.class).id("_unaryOperatorHotSpot76");

    private static final metamutator.Selector _unaryOperatorHotSpot77 = metamutator.Selector.of(77,new String[]{"b","NOT"}).in(Foo.class).id("_unaryOperatorHotSpot77");

    private static final metamutator.Selector _unaryOperatorHotSpot78 = metamutator.Selector.of(78,new String[]{"a || b","NOT"}).in(Foo.class).id("_unaryOperatorHotSpot78");

    private static final metamutator.Selector _unaryOperatorHotSpot79 = metamutator.Selector.of(79,new String[]{"a","NOT"}).in(Foo.class).id("_unaryOperatorHotSpot79");

    private static final metamutator.Selector _unaryOperatorHotSpot80 = metamutator.Selector.of(80,new String[]{"b","NOT"}).in(Foo.class).id("_unaryOperatorHotSpot80");

    private static final metamutator.Selector _unaryOperatorHotSpot81 = metamutator.Selector.of(81,new String[]{"a > b","NOT"}).in(Foo.class).id("_unaryOperatorHotSpot81");

    private static final metamutator.Selector _unaryOperatorHotSpot82 = metamutator.Selector.of(82,new String[]{"(Foo.class)","NOT"}).in(Foo.class).id("_unaryOperatorHotSpot82");

    private static final metamutator.Selector _unaryOperatorHotSpot83 = metamutator.Selector.of(83,new String[]{"c","NOT"}).in(Foo.class).id("_unaryOperatorHotSpot83");

    private static final metamutator.Selector _unaryOperatorHotSpot84 = metamutator.Selector.of(84,new String[]{"(Foo.class) == c","NOT"}).in(Foo.class).id("_unaryOperatorHotSpot84");
}

