import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_41783_XMLParser_A08 {

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        try {
            parser.parse("src/test.xml");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public void parse(String fileName) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileName));

        doc.getDocumentElement().normalize();

        List<String> nodes = new ArrayList<>();
        parseNode(doc.getElementsByTagName("node"), nodes);

        // Security-sensitive operations related to A08_IntegrityFailure
        // ...

        for (String node : nodes) {
            System.out.println(node);
        }
    }

    private void parseNode(NodeList nodes, List<String> result) {
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            result.add(element.getTagName());
            parseNode(element.getElements(), result);
        }
    }
}