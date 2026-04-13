import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.StringReader;
import java.io.IOException;

public class java_35738_XMLParser_A08 {
    public static void main(String[] args) {
        String xml = "<document><name>John Doe</name><age>30</age></document>";

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XMLElementHandler(new MyContentHandler()));
            reader.parse(new StringReader(xml));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements ContentHandler {
    private String mCurrentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        mCurrentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("name".equals(mCurrentElement)) {
            System.out.println("Name: " + parser.getCurrentValue());
        } else if ("age".equals(mCurrentElement)) {
            System.out.println("Age: " + parser.getCurrentValue());
        }
        mCurrentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (mCurrentElement != null) {
            parser.setCurrentValue(new String(ch, start, length));
        }
    }
}