import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_07626_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XMLHandler());
            parser.parse(new File("sample.xml"), false); // parse the file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    private String currentElement;

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attributes) {
        currentElement = qualifiedName;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentElement != null) {
            String content = new String(ch, start, length);
            System.out.println(currentElement + ": " + content);
            currentElement = null;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName) {
        currentElement = null;
    }
}