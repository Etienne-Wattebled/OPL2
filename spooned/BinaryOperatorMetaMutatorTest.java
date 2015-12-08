// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class BinaryOperatorMetaMutatorTest {
    @org.junit.Test
    public void testBinaryOperatorMetaMutator() throws java.lang.Exception {
        spoon.Launcher l = new spoon.Launcher();
        l.addInputResource("src/test/java");
        l.addProcessor(new metamutator.BinaryOperatorMetaMutator());
        l.run();
        spoon.reflect.declaration.CtClass c = ((spoon.reflect.declaration.CtClass)(l.getFactory().Package().getRootPackage().getElements(new spoon.reflect.visitor.filter.NameFilter("Foo")).get(0)));
        java.lang.System.out.println("// Metaprogram: ");
        java.lang.System.out.println(c.toString());
        bsh.Interpreter bsh = new bsh.Interpreter();
        org.junit.Assert.assertEquals(0, metamutator.Selector.getAllSelectors().size());
        java.lang.Object o = ((java.lang.Class)(bsh.eval(c.toString()))).newInstance();
        org.junit.Assert.assertEquals(3, metamutator.Selector.getAllSelectors().size());
        metamutator.Selector sel = metamutator.Selector.getSelectorByName(((metamutator.BinaryOperatorMetaMutator.PREFIX) + "1"));
        org.junit.Assert.assertEquals(true, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op", new java.lang.Object[]{ java.lang.Boolean.TRUE , java.lang.Boolean.FALSE }));
        sel.choose(0);
        org.junit.Assert.assertEquals(true, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op", new java.lang.Object[]{ java.lang.Boolean.TRUE , java.lang.Boolean.FALSE }));
        sel.choose(1);
        org.junit.Assert.assertEquals(false, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op", new java.lang.Object[]{ java.lang.Boolean.TRUE , java.lang.Boolean.FALSE }));
        try {
            sel.choose(2);
            org.junit.Assert.fail();
        } catch (java.lang.IllegalArgumentException expected) {
        }
        metamutator.Selector sel1 = metamutator.Selector.getSelectorByName(((metamutator.BinaryOperatorMetaMutator.PREFIX) + "2"));
        sel1.choose(0);
        org.junit.Assert.assertEquals(false, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 3 , 3 }));
        org.junit.Assert.assertEquals(true, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 5 , 4 }));
        sel1.choose(1);
        org.junit.Assert.assertEquals(true, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 3 , 3 }));
        org.junit.Assert.assertEquals(false, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 4 , 3 }));
        sel1.choose(2);
        org.junit.Assert.assertEquals(false, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 3 , 3 }));
        org.junit.Assert.assertEquals(true, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 4 , 3 }));
        sel1.choose(3);
        org.junit.Assert.assertEquals(false, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 3 , 3 }));
        org.junit.Assert.assertEquals(true, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 3 , 4 }));
    }

    private static final metamutator.Selector _unaryOperatorHotSpot1 = metamutator.Selector.of(1,new String[]{"@org.junit.Test
","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot1");

    private static final metamutator.Selector _unaryOperatorHotSpot2 = metamutator.Selector.of(2,new String[]{"new spoon.Launcher()","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot2");

    private static final metamutator.Selector _unaryOperatorHotSpot3 = metamutator.Selector.of(3,new String[]{"l","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot3");

    private static final metamutator.Selector _unaryOperatorHotSpot4 = metamutator.Selector.of(4,new String[]{""src/test/java"","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot4");

    private static final metamutator.Selector _unaryOperatorHotSpot5 = metamutator.Selector.of(5,new String[]{"l.addInputResource("src/test/java")","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot5");

    private static final metamutator.Selector _unaryOperatorHotSpot6 = metamutator.Selector.of(6,new String[]{"new metamutator.BinaryOperatorMetaMutator()","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot6");

    private static final metamutator.Selector _unaryOperatorHotSpot7 = metamutator.Selector.of(7,new String[]{"l.addProcessor(new metamutator.BinaryOperatorMetaMutator())","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot7");

    private static final metamutator.Selector _unaryOperatorHotSpot8 = metamutator.Selector.of(8,new String[]{"l.run()","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot8");

    private static final metamutator.Selector _unaryOperatorHotSpot9 = metamutator.Selector.of(9,new String[]{"l.getFactory()","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot9");

    private static final metamutator.Selector _unaryOperatorHotSpot10 = metamutator.Selector.of(10,new String[]{"l.getFactory().Package()","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot10");

    private static final metamutator.Selector _unaryOperatorHotSpot11 = metamutator.Selector.of(11,new String[]{"l.getFactory().Package().getRootPackage()","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot11");

    private static final metamutator.Selector _unaryOperatorHotSpot12 = metamutator.Selector.of(12,new String[]{""Foo"","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot12");

    private static final metamutator.Selector _unaryOperatorHotSpot13 = metamutator.Selector.of(13,new String[]{"new spoon.reflect.visitor.filter.NameFilter("Foo")","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot13");

    private static final metamutator.Selector _unaryOperatorHotSpot14 = metamutator.Selector.of(14,new String[]{"l.getFactory().Package().getRootPackage().getElements(new spoon.reflect.visitor.filter.NameFilter("Foo"))","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot14");

    private static final metamutator.Selector _unaryOperatorHotSpot15 = metamutator.Selector.of(15,new String[]{"0","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot15");

    private static final metamutator.Selector _unaryOperatorHotSpot16 = metamutator.Selector.of(16,new String[]{"((spoon.reflect.declaration.CtClass)(l.getFactory().Package().getRootPackage().getElements(new spoon.reflect.visitor.filter.NameFilter("Foo")).get(0)))","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot16");

    private static final metamutator.Selector _unaryOperatorHotSpot17 = metamutator.Selector.of(17,new String[]{"java.lang.System.out","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot17");

    private static final metamutator.Selector _unaryOperatorHotSpot18 = metamutator.Selector.of(18,new String[]{""// Metaprogram: "","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot18");

    private static final metamutator.Selector _unaryOperatorHotSpot19 = metamutator.Selector.of(19,new String[]{"java.lang.System.out.println("// Metaprogram: ")","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot19");

    private static final metamutator.Selector _unaryOperatorHotSpot20 = metamutator.Selector.of(20,new String[]{"c","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot20");

    private static final metamutator.Selector _unaryOperatorHotSpot21 = metamutator.Selector.of(21,new String[]{"c.toString()","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot21");

    private static final metamutator.Selector _unaryOperatorHotSpot22 = metamutator.Selector.of(22,new String[]{"java.lang.System.out.println(c.toString())","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot22");

    private static final metamutator.Selector _unaryOperatorHotSpot23 = metamutator.Selector.of(23,new String[]{"new bsh.Interpreter()","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot23");

    private static final metamutator.Selector _unaryOperatorHotSpot24 = metamutator.Selector.of(24,new String[]{"metamutator.Selector","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot24");

    private static final metamutator.Selector _unaryOperatorHotSpot25 = metamutator.Selector.of(25,new String[]{"metamutator.Selector.getAllSelectors()","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot25");

    private static final metamutator.Selector _unaryOperatorHotSpot26 = metamutator.Selector.of(26,new String[]{"metamutator.Selector.getAllSelectors().size()","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot26");

    private static final metamutator.Selector _unaryOperatorHotSpot27 = metamutator.Selector.of(27,new String[]{"org.junit.Assert.assertEquals(0, metamutator.Selector.getAllSelectors().size())","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot27");

    private static final metamutator.Selector _unaryOperatorHotSpot28 = metamutator.Selector.of(28,new String[]{"bsh","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot28");

    private static final metamutator.Selector _unaryOperatorHotSpot29 = metamutator.Selector.of(29,new String[]{"((java.lang.Class)(bsh.eval(c.toString())))","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot29");

    private static final metamutator.Selector _unaryOperatorHotSpot30 = metamutator.Selector.of(30,new String[]{"((java.lang.Class)(bsh.eval(c.toString()))).newInstance()","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot30");

    private static final metamutator.Selector _unaryOperatorHotSpot31 = metamutator.Selector.of(31,new String[]{"3","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot31");

    private static final metamutator.Selector _unaryOperatorHotSpot32 = metamutator.Selector.of(32,new String[]{"org.junit.Assert.assertEquals(3, metamutator.Selector.getAllSelectors().size())","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot32");

    private static final metamutator.Selector _unaryOperatorHotSpot33 = metamutator.Selector.of(33,new String[]{"(metamutator.BinaryOperatorMetaMutator.PREFIX)","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot33");

    private static final metamutator.Selector _unaryOperatorHotSpot34 = metamutator.Selector.of(34,new String[]{""1"","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot34");

    private static final metamutator.Selector _unaryOperatorHotSpot35 = metamutator.Selector.of(35,new String[]{"((metamutator.BinaryOperatorMetaMutator.PREFIX) + "1")","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot35");

    private static final metamutator.Selector _unaryOperatorHotSpot36 = metamutator.Selector.of(36,new String[]{"metamutator.Selector.getSelectorByName(((metamutator.BinaryOperatorMetaMutator.PREFIX) + "1"))","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot36");

    private static final metamutator.Selector _unaryOperatorHotSpot37 = metamutator.Selector.of(37,new String[]{"true","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot37");

    private static final metamutator.Selector _unaryOperatorHotSpot38 = metamutator.Selector.of(38,new String[]{"o","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot38");

    private static final metamutator.Selector _unaryOperatorHotSpot39 = metamutator.Selector.of(39,new String[]{""op"","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot39");

    private static final metamutator.Selector _unaryOperatorHotSpot40 = metamutator.Selector.of(40,new String[]{"java.lang.Boolean.TRUE","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot40");

    private static final metamutator.Selector _unaryOperatorHotSpot41 = metamutator.Selector.of(41,new String[]{"java.lang.Boolean.FALSE","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot41");

    private static final metamutator.Selector _unaryOperatorHotSpot42 = metamutator.Selector.of(42,new String[]{"new java.lang.Object[]{ java.lang.Boolean.TRUE , java.lang.Boolean.FALSE }","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot42");

    private static final metamutator.Selector _unaryOperatorHotSpot43 = metamutator.Selector.of(43,new String[]{"org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op", new java.lang.Object[]{ java.lang.Boolean.TRUE , java.lang.Boolean.FALSE })","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot43");

    private static final metamutator.Selector _unaryOperatorHotSpot44 = metamutator.Selector.of(44,new String[]{"org.junit.Assert.assertEquals(true, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op", new java.lang.Object[]{ java.lang.Boolean.TRUE , java.lang.Boolean.FALSE }))","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot44");

    private static final metamutator.Selector _unaryOperatorHotSpot45 = metamutator.Selector.of(45,new String[]{"sel","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot45");

    private static final metamutator.Selector _unaryOperatorHotSpot46 = metamutator.Selector.of(46,new String[]{"sel.choose(0)","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot46");

    private static final metamutator.Selector _unaryOperatorHotSpot47 = metamutator.Selector.of(47,new String[]{"1","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot47");

    private static final metamutator.Selector _unaryOperatorHotSpot48 = metamutator.Selector.of(48,new String[]{"sel.choose(1)","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot48");

    private static final metamutator.Selector _unaryOperatorHotSpot49 = metamutator.Selector.of(49,new String[]{"false","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot49");

    private static final metamutator.Selector _unaryOperatorHotSpot50 = metamutator.Selector.of(50,new String[]{"org.junit.Assert.assertEquals(false, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op", new java.lang.Object[]{ java.lang.Boolean.TRUE , java.lang.Boolean.FALSE }))","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot50");

    private static final metamutator.Selector _unaryOperatorHotSpot51 = metamutator.Selector.of(51,new String[]{"2","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot51");

    private static final metamutator.Selector _unaryOperatorHotSpot52 = metamutator.Selector.of(52,new String[]{"sel.choose(2)","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot52");

    private static final metamutator.Selector _unaryOperatorHotSpot53 = metamutator.Selector.of(53,new String[]{"org.junit.Assert.fail()","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot53");

    private static final metamutator.Selector _unaryOperatorHotSpot54 = metamutator.Selector.of(54,new String[]{""2"","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot54");

    private static final metamutator.Selector _unaryOperatorHotSpot55 = metamutator.Selector.of(55,new String[]{"((metamutator.BinaryOperatorMetaMutator.PREFIX) + "2")","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot55");

    private static final metamutator.Selector _unaryOperatorHotSpot56 = metamutator.Selector.of(56,new String[]{"metamutator.Selector.getSelectorByName(((metamutator.BinaryOperatorMetaMutator.PREFIX) + "2"))","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot56");

    private static final metamutator.Selector _unaryOperatorHotSpot57 = metamutator.Selector.of(57,new String[]{"sel1","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot57");

    private static final metamutator.Selector _unaryOperatorHotSpot58 = metamutator.Selector.of(58,new String[]{""op2"","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot58");

    private static final metamutator.Selector _unaryOperatorHotSpot59 = metamutator.Selector.of(59,new String[]{"new java.lang.Object[]{ 3 , 3 }","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot59");

    private static final metamutator.Selector _unaryOperatorHotSpot60 = metamutator.Selector.of(60,new String[]{"org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 3 , 3 })","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot60");

    private static final metamutator.Selector _unaryOperatorHotSpot61 = metamutator.Selector.of(61,new String[]{"org.junit.Assert.assertEquals(false, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 3 , 3 }))","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot61");

    private static final metamutator.Selector _unaryOperatorHotSpot62 = metamutator.Selector.of(62,new String[]{"5","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot62");

    private static final metamutator.Selector _unaryOperatorHotSpot63 = metamutator.Selector.of(63,new String[]{"4","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot63");

    private static final metamutator.Selector _unaryOperatorHotSpot64 = metamutator.Selector.of(64,new String[]{"new java.lang.Object[]{ 5 , 4 }","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot64");

    private static final metamutator.Selector _unaryOperatorHotSpot65 = metamutator.Selector.of(65,new String[]{"org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 5 , 4 })","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot65");

    private static final metamutator.Selector _unaryOperatorHotSpot66 = metamutator.Selector.of(66,new String[]{"org.junit.Assert.assertEquals(true, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 5 , 4 }))","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot66");

    private static final metamutator.Selector _unaryOperatorHotSpot67 = metamutator.Selector.of(67,new String[]{"org.junit.Assert.assertEquals(true, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 3 , 3 }))","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot67");

    private static final metamutator.Selector _unaryOperatorHotSpot68 = metamutator.Selector.of(68,new String[]{"new java.lang.Object[]{ 4 , 3 }","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot68");

    private static final metamutator.Selector _unaryOperatorHotSpot69 = metamutator.Selector.of(69,new String[]{"org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 4 , 3 })","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot69");

    private static final metamutator.Selector _unaryOperatorHotSpot70 = metamutator.Selector.of(70,new String[]{"org.junit.Assert.assertEquals(false, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 4 , 3 }))","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot70");

    private static final metamutator.Selector _unaryOperatorHotSpot71 = metamutator.Selector.of(71,new String[]{"org.junit.Assert.assertEquals(true, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 4 , 3 }))","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot71");

    private static final metamutator.Selector _unaryOperatorHotSpot72 = metamutator.Selector.of(72,new String[]{"sel1.choose(3)","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot72");

    private static final metamutator.Selector _unaryOperatorHotSpot73 = metamutator.Selector.of(73,new String[]{"new java.lang.Object[]{ 3 , 4 }","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot73");

    private static final metamutator.Selector _unaryOperatorHotSpot74 = metamutator.Selector.of(74,new String[]{"org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 3 , 4 })","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot74");

    private static final metamutator.Selector _unaryOperatorHotSpot75 = metamutator.Selector.of(75,new String[]{"org.junit.Assert.assertEquals(true, org.apache.commons.lang.reflect.MethodUtils.invokeExactMethod(o, "op2", new java.lang.Object[]{ 3 , 4 }))","NOT"}).in(BinaryOperatorMetaMutatorTest.class).id("_unaryOperatorHotSpot75");
}

