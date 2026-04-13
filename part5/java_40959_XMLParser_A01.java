import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXParserFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLScanner;

import java.io.File;
import java.io.IOException;

public class java_40959_XMLParser_A01 extends DefaultHandler {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("your_xml_file_path.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            XMLReader xmlReader = saxParserFactory.newSAXParser(new org.xml.sax.InputSource(new FileReader(xmlFile))).getXMLReader();
            xmlReader.setContentHandler(new XMLParser());
            xmlReader.parse(new File(xmlFile.getPath()));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Element Value: " + new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End of Element: " + qName);
    }
}