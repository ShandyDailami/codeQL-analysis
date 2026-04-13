import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_21669_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        MyHandler myHandler = new MyHandler();
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(myHandler);
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {

    private boolean bName;
    private boolean bAge;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.namespace.QName qNamespaces, org.xml.sax.Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;

            // Start processing child elements of 'person'
            return;
        }

        if (bName && qName.equalsIgnoreCase("name")) {
            bName = false;
            // Do something with name. e.g. print name
            return;
        }

        if (bAge && qName.equalsIgnoreCase("age")) {
            bAge = false;
            // Do something with age. e.g. print age
            return;
        }

        // Continue processing other child elements of 'person'

    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        // End processing of child elements of 'person'

        if (qName.equalsIgnoreCase("person")) {
            return;
        }

    }
}