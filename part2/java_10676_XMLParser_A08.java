import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.helpers.DefaultHandler;

public class java_10676_XMLParser_A08 extends DefaultHandler {

    boolean bNodeFound = false;
    String thisValue = null;

    public static void main(String[] args) {
        String inputFile = "input.xml";
        MyXMLParser parser = new MyXMLParser();
        parser.parse(inputFile);
    }

    public void parse(String inputFile) {

        try {
            File inputXmlFile = new File(inputFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputXmlFile);
            doc.getDocumentElement().normalize();
            printElements(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("element")) {
            bNodeFound = true;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("element")) {
            bNodeFound = false;
       
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (bNodeFound) {
            thisValue = new String(ch, start, length);
        }
    }

    private void printElements(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("element");
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node node = nodeList.item(temp);
            Element element = (Element) node;
            String name = element.getAttribute("name");
            String value = element.getAttribute("value");
            System.out.println("Element name : " + name + " , Element value : " + value);
        }
    }
}