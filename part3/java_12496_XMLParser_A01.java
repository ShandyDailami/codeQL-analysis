import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_12496_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("example.xml"));

            // Use SAX to parse the XML document
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            saxFactory.setNamespaceAware(true);
            saxFactory.setValidating(false);
            saxFactory.setXincludeHandlingEnabled(false);
            SAXParser saxParser = saxFactory.newSAXParser(new DefaultHandler());
            MyHandler handler = new MyHandler();
            saxParser.parse(new org.xml.sax.InputSource(new StringReader(doc.getDocumentElement().getTagName())), handler);

            // Print the parsed XML
            System.out.println("Parsed XML: " + handler.getResult());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuffer result;

    public java_12496_XMLParser_A01() {
        this.result = new StringBuffer();
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        result.append("<" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            result.append(" " + attributes.getQName(i) + "=\"" + attributes.getValue(i) + "\"");
        }
        result.append(">");
    }

    public void endElement(String uri, String localName, String qName) {
        result.append("</" + qName + ">");
    }

    public void characters(char[] ch, int start, int length) {
        result.append(new String(ch, start, length));
    }

    public String getResult() {
        return result.toString();
    }
}