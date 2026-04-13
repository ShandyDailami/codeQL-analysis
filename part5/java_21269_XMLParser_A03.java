import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_21269_XMLParser_A03 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();
    private String currentElement;
    private String currentText;
    private static final String INJECTION_IN_XML = "<script>alert('Injection detected!')</script>";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        stack.push(currentElement);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentText = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = qName;
        if (stack.pop().equals(currentElement)) {
            if (currentText.contains("<script>") || currentText.contains("</script>")) {
                currentText = INJECTION_IN_XML;
            }
            System.out.println("Element: " + currentElement + ", Text: " + currentText);
        }
    }

    public static void main(String[] args) throws Exception {
        XMLParser parser = new XMLParser();
        org.xml.sax.SAXParserFactory factory = org.xml.sax.SAXParserFactory.newInstance();
        org.xml.sax.SAXParser saxParser = factory.newSAXParser(null);
        saxParser.parse("src/main/resources/example.xml", parser);
    }
}