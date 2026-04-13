import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_25116_XMLParser_A01 {

    private class MyHandler extends DefaultHandler {
        private String lastTag;

        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            if ("elementName".equals(qName)) {
                // If the element name matches the one we're looking for, print the value
                String value = attributes.getValue("attributeName");
                System.out.println("Found element: " + value);
            }
            lastTag = qName;
        }
    }

    public static void main(String[] args) {
        SecuritySensitiveExample example = new SecuritySensitiveExample();
        example.parseXml("path_to_your_file.xml");
    }

    public void parseXml(String fileName) {
        File file = new File(fileName);
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}