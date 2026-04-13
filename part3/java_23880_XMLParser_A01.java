import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_23880_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nlist = doc.getElementsByTagName("item");

            for (int temp = 0; temp < nlist.getLength(); temp++) {
                Element element = (Element) nlist.item(temp);
                System.out.println("Element Name: " + element.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Element Value: " + element.getElementsByTagName("value").item(0).getTextContent());
           
            }

            SAXParserFactory saxParserFactory = (SAXParserFactory) DocumentBuilderFactory.newInstance();
            saxParserFactory.setNamespaceAware(true);
            SAXParser saxParser = saxParserFactory.newSAXParser(new DefaultHandler());
            saxParser.parse(new File("input.xml"), new SAXHandler());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Element Name: " + localName);
    }
    public void endElement(String uri, String localName, String qName) {
        System.out.println("Element Value: " + qName);
    }
}