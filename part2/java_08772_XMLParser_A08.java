//Starting of the XMLParser Example

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_08772_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            MyHandler handler = new MyHandler();

            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);

            reader.parse("src/sample.xml");

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private int depth = 0;
    private String lastElement = null;
    private boolean integrityFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName,
            org.xml.sax.Attributes attributes) throws SAXException {
        depth++;
        lastElement = qName;

        if (depth > 1) {
            if (lastElement.equals("IntegrityFailure")) {
                integrityFailure = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        depth--;
        lastElement = qName;

        if (depth == 1 && integrityFailure) {
            System.out.println("Security: IntegrityFailure detected in element: " + lastElement);
            integrityFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
    }
}

//Ending of the XMLParser Example