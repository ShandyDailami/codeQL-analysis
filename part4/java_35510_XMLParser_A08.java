import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_35510_XMLParser_A08 extends DefaultHandler {

    private List<String> integrityFailureElements = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("element")) {
            integrityFailureElements.add(localName);
        }
    }

    public List<String> getIntegrityFailureElements() {
        return integrityFailureElements;
    }

    public static void main(String[] args) {
        String xmlFile = "example.xml"; // example.xml is a file in your project folder
        MyXMLHandler handler = new MyXMLHandler();

        try {
            XMLReader parser = XMLParser.newSAXParser(new File(xmlFile));
            parser.setContentHandler(handler);
            parser.parse(new File(xmlFile));

            List<String> integrityFailureElements = handler.getIntegrityFailureElements();

            for (String element : integrityFailureElements) {
                System.out.println("Integrity failure element: " + element);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}