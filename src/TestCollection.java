import java.util.Arrays;

public class TestCollection {
    public static void main(String[] args) {

        Collection collection = new Collection();
        System.out.println("collection.size(): " + collection.size());
        System.out.println(collection.toString());

        System.out.println("collection.delete(0): " + collection.delete(0));
        System.out.println("collection.delete(null): " + collection.delete(null));
        System.out.println("collection.delete(\"000\"): " + collection.delete("000"));

        System.out.println("\ncollection.add(\"000\"): " + collection.add("000"));
        System.out.println("collection.add(\"001\"): " + collection.add("001"));
        System.out.println("collection.add(\"002\"): " + collection.add("002"));
        System.out.println("collection.add(\"003\"): " + collection.add("003"));
        System.out.println("collection.add(\"004\"): " + collection.add("004"));
        System.out.println("\ncollection.size(): " + collection.size());
        System.out.println(collection.toString());

        System.out.println("collection.get(4): " + collection.get(4));
        System.out.println("collection.get(99): " + collection.get(99));

        String[] testArray = new String[]{"testArray_00", "testArray_01", "testArray_02", null, "testArray_03",
                "testArray_03", null, "testArray_05"};
        System.out.println("\n" + Arrays.toString(testArray));
        System.out.println("collection.addAll(testArray): " + collection.addAll(testArray));
        System.out.println(collection.toString());

        Collection testCollection_01 = new Collection();
        testCollection_01.add("testElement_00");
        testCollection_01.add("testElement_01");
        testCollection_01.add("testElement_02");
        testCollection_01.add("testElement_03");
        testCollection_01.add("testElement_04");
        System.out.println(testCollection_01.toString());

        System.out.println("collection.addAll(testCollection_01): " + collection.addAll(testCollection_01));
        System.out.println(collection.toString());

        System.out.println("collection.delete(5): " + collection.delete(5));
        System.out.println("collection.delete(99): " + collection.delete(99));
        System.out.println("collection.delete(\"testArray_01\"): " + collection.delete("testArray_01"));
        System.out.println(collection.toString());

        System.out.println("collection.contains(\"\"): " + collection.contains(""));
        System.out.println("collection.contains(null): " + collection.contains(null));
        System.out.println("collection.contains(\"testArray_02\"): " + collection.contains("testArray_02"));
        System.out.println("collection.contains(\"theList000 002\"): " + collection.contains("theList000 002"));


        Collection testCollection_02 = new Collection();
        testCollection_02.add("testElement_00");
        testCollection_02.add("testElement_01");
        testCollection_02.add("testElement_02");
        testCollection_02.add("testElement_03");
        testCollection_02.add("testElement_04");

        System.out.println("\ncollection.compare(testCollection_01): " + testCollection_01.compare(testCollection_02));
        System.out.println("testCollection_01.add(\"newElement\"): " + testCollection_01.add("newElement"));
        System.out.println("collection.compare(testCollection_01): " + testCollection_01.compare(testCollection_02));

        System.out.println("\ncollection.clear(): " + collection.clear());
        System.out.println("collection.clear(): " + collection.clear());

        System.out.println("Size: " + collection.size());
        System.out.println(collection.toString());
    }
}
