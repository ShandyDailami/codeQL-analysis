import java.io.File;
import java.io.IOException;
import java.security.AccessControlException;
import java.util.Stack;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_37204_XMLParser_A01 extends DefaultHandler {
    private Stack<String> stack = new Stack<>();

    public java_37204_XMLParser_A01() {
        // Creating a SAXParserFactory with SAX parser
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = spf.newSAXParser(null);
            saxParser.parse("example.xml", this);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.schema.QName qNs, javax.xml.bind.Unmarshaller.UnmarshallerInfo info) {
        // Push the namespace URI and local name onto the stack
        stack.push(qNs.getNamespaceURI() + ":" + qNs.getPrefix() + "." + localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // Pop the top of the stack and print out the element
        if (!stack.isEmpty()) {
            String popped = stack.pop();
            System.out.println(popped + " = " + qName);
        }
    }

    public static void main(String[] args) {
        new XMLParser();
    }
}