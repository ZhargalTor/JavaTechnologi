import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import java.io.File;

public class XMLValidator {

    public static boolean validate(
            String xml,
            String xsd) {

        try {

            SchemaFactory factory =
                    SchemaFactory.newInstance(
                            XMLConstants.W3C_XML_SCHEMA_NS_URI);

            Schema schema =
                    factory.newSchema(new File(xsd));

            Validator validator =
                    schema.newValidator();

            validator.validate(
                    new StreamSource(new File(xml)));

            return true;

        } catch (Exception e) {

            System.out.println("Ошибка валидации");

            return false;
        }
    }
}