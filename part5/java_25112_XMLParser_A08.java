import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import org.xml.sax.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_25112_XMLParser_A08 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");

        SAXSource source;
        try {
            source = new SAAXXMLReader(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
            return;
       
        xmlReader.setContentHandler(new DefaultHandler());
        xmlReader.parse(source);

    }
}

class SAAXXMLReader extends SAXSource {
    public java_25112_XMLParser_A08(File file) throws IOException {
        super(file);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
        super.characters(ch, start, length);
    }
}