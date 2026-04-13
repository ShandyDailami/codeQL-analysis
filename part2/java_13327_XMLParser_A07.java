import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

import java.io.File;
import java.io.IOException;

public class java_13327_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // create a new handler
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            // parse the xml file
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends BasicHandler {
    private boolean parsingTitle = false;
    private boolean parsingLink = false;
    private boolean parsingDescription = false;

    private String title = "";
    private String link = "";
    private String description = "";

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equals("title")) {
            parsingTitle = true;
        } else if (qName.equals("link")) {
            parsingLink = true;
        } else if (qName.equals("description")) {
            parsingDescription = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("title")) {
            parsingTitle = false;
        } else if (qName.equals("link")) {
            parsingLink = false;
        } else if (qName.equals("description")) {
            parsingDescription = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (parsingTitle) {
            title = new String(ch, start, length);
        } else if (parsingLink) {
            link = new String(ch, start, length);
        } else if (parsingDescription) {
            description = new String(ch, start, length);
        }
    }

    public void endDocument() {
        System.out.println("Title: " + title);
        System.out.println("Link: " + link);
        System.out.println("Description: " + description);
    }
}