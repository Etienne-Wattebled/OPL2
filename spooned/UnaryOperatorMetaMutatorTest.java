// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class UnaryOperatorMetaMutatorTest {
    @org.junit.Test
    public void testUnaryOperatorMetaMutator() throws java.lang.Exception {
        spoon.Launcher l = new spoon.Launcher();
        l.addInputResource("src/test/java");
        l.addProcessor(new metamutator.UnaryOperatorMetaMutator());
        l.run();
    }

    private static final metamutator.Selector _unaryOperatorHotSpot85 = metamutator.Selector.of(85,new String[]{"new metamutator.UnaryOperatorMetaMutator()","NOT"}).in(UnaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot85");

    private static final metamutator.Selector _unaryOperatorHotSpot86 = metamutator.Selector.of(86,new String[]{"l.addProcessor(new metamutator.UnaryOperatorMetaMutator())","NOT"}).in(UnaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot86");
}

