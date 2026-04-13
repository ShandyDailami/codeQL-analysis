import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_03577_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new SumContentHandler());
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                xmlReader.close();
            }
        }
    }
}

class SumContentHandler implements org.xml.sax.ContentHandler {
    private int sum = 0;

    @Override
    public void startDocument() {}

    @Override
    public void endDocument() {}

    @Override
    public void startElement(String uri, String localName, String qName) {
        if (qName.equals("number")) {
            sum += 1;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {}

    @Override
    public void characters(char[] ch, int start, int length) {}

    public int getSum() {
        return sum;
    }
}