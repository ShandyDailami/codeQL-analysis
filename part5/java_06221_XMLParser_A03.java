import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_06221_XMLParser_A03 extends DefaultHandler {
    private String lastElement;
    private boolean inElement;
    private List<String> injectionViolations;

    public java_06221_XMLParser_A03(List<String> injectionViolations) {
        this.injectionViolations = injectionViolations;
    }

    public void parse(String filename) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null);

        saxParser.parse(new File(filename), this);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
        inElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElement = null;
        inElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inElement) {
            String content = new String(ch, start, length).trim();

            if (!content.isEmpty()) {
                injectionViolations.add("Injection violation in element " + lastElement);
            }
        }
    }
}