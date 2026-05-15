import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.*;

public class DOMParser {

    public static List<FlatWare> parse(String fileName) {

        List<FlatWare> list = new ArrayList<>();

        try {

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();

            DocumentBuilder builder =
                    factory.newDocumentBuilder();

            Document doc =
                    builder.parse(new File(fileName));

            NodeList items =
                    doc.getElementsByTagName("Item");

            for (int i = 0; i < items.getLength(); i++) {

                Element item = (Element) items.item(i);

                FlatWare fw = new FlatWare();

                fw.type =
                        item.getElementsByTagName("Type")
                                .item(0)
                                .getTextContent();

                fw.origin =
                        item.getElementsByTagName("Origin")
                                .item(0)
                                .getTextContent();

                Visual v = new Visual();

                Element visual =
                        (Element) item.getElementsByTagName("Visual")
                                .item(0);

                v.length =
                        Integer.parseInt(
                                visual.getElementsByTagName("Length")
                                        .item(0)
                                        .getTextContent());

                v.width =
                        Integer.parseInt(
                                visual.getElementsByTagName("Width")
                                        .item(0)
                                        .getTextContent());

                v.material =
                        visual.getElementsByTagName("Material")
                                .item(0)
                                .getTextContent();

                v.handle =
                        visual.getElementsByTagName("Handle")
                                .item(0)
                                .getTextContent();

                fw.visual = v;

                fw.value =
                        Boolean.parseBoolean(
                                item.getElementsByTagName("Value")
                                        .item(0)
                                        .getTextContent());

                list.add(fw);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}