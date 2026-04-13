import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.events.StartElement;
import org.xml.sax.events.EndElement;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_30712_XMLParser_A07 {
    public static void main(String[] args) {
        String fileName = "example.xml";

        // create a new instance of the MyXMLHandler
        MyXMLHandler handler = new MyXMLHandler();

        // create a new XMLReader instance
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        // set the handler for the reader
        reader.setContentHandler(handler);

        // parse the XML file
        File xmlFile = new File(fileName);
        try {
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyXMLHandler extends DefaultHandler {
    private boolean bName;
    private boolean bAge;

    @Override
    public void startElement(StartElement e) throws SAXException {
        String elementName = e.getName().getLocalPart();

        if (elementName.equals("person")) {
            bName = false;
            bAge = false;
        } else if (elementName.equals("name")) {
            bName = true;
        } else if (elementName.equals("age")) {
            bAge = true;
        }
    }

    @Override
    public void endElement(EndElement e) throws SAXException {
        String elementName = e.getName().getLocalPart();

        if (elementName.equals("person")) {
            // do nothing
        } else if (elementName.equals("name")) {
            // do nothing
        } else if (elementName.equals("age")) {
            // do nothing
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            // process the name here
            System.out.println("Name: " + new String(ch, start, length));
        } else if (bAge) {
            // process the age here
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}