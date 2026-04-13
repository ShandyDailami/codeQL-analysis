import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_15817_XMLParser_A01 extends DefaultHandler {

    private List<String> elementsWithAttribute;
    private String attributeName;

    public java_15817_XMLParser_A01(String attributeName) {
        this.attributeName = attributeName;
        this.elementsWithAttribute = new ArrayList<>();
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attributes) {
        if (attributes.getValue(this.attributeName) != null) {
            this.elementsWithAttribute.add(qualifiedName);
        }
    }

    public void parse(String xml) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new CustomXMLHandler(this.attributeName));
            parser.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String xml = "<root><element1 attribute='test'></element1><element2 attribute='test'></element2></root>";
        new CustomXMLParser("test").parse(xml);
        for (String element : new CustomXMLParser("test").getElementsWithAttribute()) {
            System.out.println("Element with attribute: " + element);
        }
    }
}