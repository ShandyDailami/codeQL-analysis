import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_31530_XMLParser_A03 {

    public List<String> parse(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new StringReader(xmlString));
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("item");

        return nodeList.stream()
                .map(node -> node.getTextContent())
                .collect(Collectors.toList());
    }
}