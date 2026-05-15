//1. Создать файл XML и соответствующую ему схему XSD.
//        7. Столовые приборы.
//        Столовые приборы можно структурировать по следующей схеме:
//        — Type — тип (нож, вилка, ложка и т.д.);
//        — Origin — страна производства;
//        — Visual (должно быть несколько) — визуальные характеристики: лезвие,
//        зубец (длина лезвия, зубца [10–n см], ширина лезвия [10–n мм]), материал
//        (лезвие [сталь, чугун, медь и т.д.]), рукоять (деревянная [если да, то ука-
//        зать тип дерева], пластик, металл);
//        — Value — коллекционный либо нет.
//        Корневой элемент назвать FlatWare.
//        С помощью XSL преобразовать XML-файл в формат HTML, при выводе
//        отсортировать по длине лезвия, зубца, объему.
//
//ТОРЯШИЕВ ЖАРГАЛ Б763-2А

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.File;

public class Main {

  public static void main(String[] args) {

    try {

      TransformerFactory factory =
              TransformerFactory.newInstance();

      Source xslt =
              new StreamSource(new File("flatware.xsl"));

      Transformer transformer =
              factory.newTransformer(xslt);

      Source xml =
              new StreamSource(new File("flatware.xml"));

      transformer.transform(
              xml,
              new StreamResult(new File("result.html"))
      );

      System.out.println("HTML файл создан!");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}