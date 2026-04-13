import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_38040_XMLParser_A03 extends DefaultHandler {

    private Stack<String> elementStack = new Stack<>();
    private StringBuilder currentText = new StringBuilder();

    public java_38040_XMLParser_A03() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of the XML Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of the XML Document");
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        System.out.println("Start of an element: " + qualifiedName);
        elementStack.push(qualifiedName);
        currentText.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        System.out.println("End of an element: " + qualifiedName);
        elementStack.pop();
        currentText.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Character data: " + new String(ch, start, length));
        currentText.append(new String(ch, start, length));
    }

    public static void main(String[] args) {
        UniqueVanillaXmlParser parser = new UniqueVanillaXmlParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, parser);
            saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}