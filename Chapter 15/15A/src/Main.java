import java.util.*;

public class Main {

    public static void main(String[] args) {

        boolean valid =
                XMLValidator.validate(
                        "flatware.xml",
                        "flatware.xsd");

        System.out.println("XML valid: " + valid);

        List<FlatWare> list =
                DOMParser.parse("flatware.xml");

        list.sort(new FlatWareComparator());

        for (FlatWare f : list) {
            System.out.println(f);
        }

        XMLTransformer.transform();
    }
}