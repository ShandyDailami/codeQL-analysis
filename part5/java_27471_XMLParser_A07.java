import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_27471_XMLParser_A07 extends DefaultHandler {

    private List<String> names = new ArrayList<>();
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if(qName.equals("name")) {
            names.add(currentElement);
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if(currentElement != null && currentElement.length() > 0) {
            String elementContent = new String(ch, start, length).trim();
            if(elementContent.length() > 0) {
                names.add(elementContent);
            }
        }
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("input.xml"));
            document.getDocumentElement().normalize();
            parser.handleDocument(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(parser.getNames());
    }

    public List<String> getNames() {
        return names;
    }
}