import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_37852_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new FileInputSource(xmlFile));
            MyHandler myHandler = new MyHandler();

            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(myHandler);

            saxParser.parse(xmlFile, myHandler);

            System.out.println(myHandler.getResult());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {

    private String result;

    public void startDocument() throws SAXException {
        result = "";
    }

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
        result += "<" + qName + ">";
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        result += "</" + qName + ">";
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        result += new String(ch, start, length);
    }

    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal Error: " + error);
    }

    public String getResult() {
        return result;
    }
}