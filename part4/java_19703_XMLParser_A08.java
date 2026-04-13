import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_19703_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = XMLReaderFactory.createXMLReader();

            SAXHandler handler = new SAXHandler();
            sp.parse(xmlFile, handler);
            xr.setContentHandler(handler);

            xr.parse(new File(xmlFile.getAbsolutePath()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class SAXHandler implements org.xml.sax.helpers.DefaultHandler {

    private boolean bName;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        bName = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bName = false;
        if (qName.equals("element")) {
            // Here you can add the code to extract the value of the element you are interested in.
            // For example:
            System.out.println("Value of the element is: " + currentElement);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            // Here you can add the code to handle the characters.
            // For example:
            String s = new String(ch, start, length);
            System.out.println("Character data: " + s);
        }
    }

}