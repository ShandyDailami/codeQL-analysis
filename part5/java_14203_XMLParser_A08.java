import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_14203_XMLParser_A08 {

    public static void main(String[] args) {
        // Create a new instance of DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file
        Document document = builder.parse(XmlParser.class.getResourceAsStream("/example.xml"));

        // Find the elements with the name "item"
        NodeList nodeList = document.getElementsByTagName("item");

        // Print the data of each "item"
        List<String> itemData = Stream.of(nodeList)
                .flatMap(n -> Stream.of(n.getChildNodes())
                        .filter(cn -> cn.getNodeType() == Node.ELEMENT_NODE)
                        .map(cn -> ((Element) cn).getElementsByTagName("data")
                                .item(0).getTextContent()))
                .collect(Collectors.toList());

        itemData.forEach(System.out::println);
    }
}