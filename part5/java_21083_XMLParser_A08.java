import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_21083_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyHandler myHandler = new MyHandler();
            saxParser.setContentHandler(myHandler);

            saxParser.parse(xmlFile, xmlReader);

            System.out.println("Data extracted: " + myHandler.getData());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends AbstractHandler {
    private String data;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("element")) {
            data = attributes.getValue("attribute");
        }
    }

    public String getData() {
        return data;
    }
}

abstract class AbstractHandler extends DefaultHandler {
    public abstract void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException;
}