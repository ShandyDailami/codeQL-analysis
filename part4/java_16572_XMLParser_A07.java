import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class java_16572_XMLParser_A07 extends DefaultHandler {

    public boolean startDocument() {
        System.out.println("Start of document");
        return true;
    }

    public boolean endDocument() {
        System.out.println("End of document");
        return true;
    }

    public boolean startElement(String uri, String localName, String qName, Element element) {
        System.out.println("Start of " + qName);
        return true;
    }

    public boolean endElement(String uri, String localName, String qName) {
        System.out.println("End of " + qName);
        return true;
    }

    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length);
        System.out.println("Data: " + data);
    }

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("example.xml");

            MyXMLParser handler = new MyXMLParser();
            doc.getDomConfig().setElementNamespacePrefixMapping(new NamespacePrefixMapping("a", "http://a"));
            doc.setElementNamespace("http://a", "a");
            doc.normalize();

            NodeList nl = doc.getElementsByTagName("a:MyElement");

            for (int i = 0; i < nl.getLength(); i++) {
                Element element = (Element) nl.item(i);

                // Perform security sensitive operations related to A07_AuthFailure
                // ...
            }

        } catch (ParserConfigurationException | SAXException | IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}