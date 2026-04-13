import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_19642_XMLParser_A07 extends DefaultHandler {

    private String lastElement = null;
    private boolean authFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElement = null;

        if ("AuthFailure".equals(qName)) {
            authFailure = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null && authFailure) {
            System.out.println("Security-sensitive operation related to AuthFailure detected: " + new String(ch, start, length));
            authFailure = false;
        }
    }
}

public class XMLParserExample {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            XMLLoader loader = new XMLLoader();
            XMLParser parser = loader.getParser();
            parser.setContentHandler(new MyHandler());
            parser.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}