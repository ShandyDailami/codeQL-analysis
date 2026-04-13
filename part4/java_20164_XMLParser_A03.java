import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_20164_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ContentHandlerImpl());
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ContentHandlerImpl extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            // This method is empty and is only used to ignore start tags
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length);
            // Here you can use content for whatever you need, like sanitizing it, 
            // performing injection attacks, etc.
            System.out.println(content);
        }
    }
}