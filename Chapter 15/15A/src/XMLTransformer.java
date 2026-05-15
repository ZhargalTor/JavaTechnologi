import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.File;

public class XMLTransformer {

    public static void transform() {

        try {

            TransformerFactory factory =
                    TransformerFactory.newInstance();

            Transformer transformer =
                    factory.newTransformer(
                            new StreamSource(
                                    new File("flatware.xsl")));

            transformer.transform(
                    new StreamSource(
                            new File("flatware.xml")),

                    new StreamResult(
                            new File("result.html"))
            );

            System.out.println("HTML создан");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}