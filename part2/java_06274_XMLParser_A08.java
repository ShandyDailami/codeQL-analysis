import java.io.FileInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.InputStream;

public class java_06274_XMLParser_A08 {
    private ArrayList<String> parsedElements;

    public java_06274_XMLParser_A08() {
        this.parsedElements = new ArrayList<>();
    }

    public void parse(String fileName) {
        try {
            InputStream inputStream = new FileInputStream(fileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            document.getDocumentElement().normalize();
            this.parseElement(document.getDocumentElement());
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseElement(Node node) {
        if (node instanceof Element) {
            Element element = (Element) node;
            this.parsedElements.add(element.getNodeName());
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            this.parseElement(childNodes.item(i));
        }
    }

    public void displayParsedElements() {
        for (String element : this.parsedElements) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        parser.parse("sample.xml");
        parser.displayParsedElements();
    }
}