import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_36881_XMLParser_A07 {

    public static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;
        private String tempValue = null;

        public void startElement(String uri, String localName, String qName,
                                                  Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("user")) {
                bName = true;
                bAge = true;
            } else if (bName) {
                if (qName.equalsIgnoreCase("name")) bName = false;
                else if (qName.equalsIgnoreCase("age")) bAge = false;
            } else if (bAge) {
                if (qName.equalsIgnoreCase("user")) bName = false;
                else if (qName.equalsIgnoreCase("name")) bName = false;
            }
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("user")) {
                System.out.println("Name: " + tempValue);
                System.out.println("Age: " + tempValue);
                bName = false;
                bAge = false;
            } else if (bName) {
                tempValue = localName;
            } else if (bAge) {
                tempValue = localName;
            }
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bName) {
                tempValue += new String(ch, start, length);
            }
        }

    }

    public static void main(String[] args) {
        try {
            SAXReader reader = XMLReaderFactory.createSAXReader();
            File xmlFile = new File("path_to_your_xml_file");
            reader.setContentHandler(new MyHandler());
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}