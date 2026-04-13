import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_35199_XMLParser_A07 {

    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file";
        parseXmlFile(filePath);
    }

    private static void parseXmlFile(String filePath) {
        DefaultHandler handler = new DefaultHandler() {
            boolean isName = false;
            String name = null;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equals("name")) {
                    isName = true;
                    name = "";
                }
            }

            @Override
            public void characters(char[] chars, int start, int length) throws SAXException {
                if (isName) {
                    name += new String(chars, start, length);
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (qName.equals("name")) {
                    System.out.println(name);
                    isName = false;
                    name = null;
                }
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }
}