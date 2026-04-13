import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_41277_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file_path");

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();

            // Create the listener
            XmlHandler handler = new XmlHandler();
            reader.setContentHandler(handler);

            // Parse the XML file
            reader.parse(xmlFile.getAbsolutePath());

            System.out.println("Tags in XML file: " + handler.getTags());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler implements org.xml.sax.helpers.DefaultHandler {

    private StringBuilder tags = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        tags.append(qName);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        tags.append("/");
        tags.append(qName);
    }

    public String getTags() {
        return tags.toString();
    }

}