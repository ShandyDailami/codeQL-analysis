import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_36513_XMLParser_A07 extends DefaultHandler {
    private boolean isInAuthFailure = false;
    private String authFailureText = null;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equals("AuthFailure")) {
            isInAuthFailure = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (isInAuthFailure) {
            authFailureText = new String(ch, start, length);
            isInAuthFailure = false;
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            XMLReader xmlReader = saxParserFactory.newSAXParser().getXMLReader();
            AuthFailureParser handler = new AuthFailureParser();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new File("your_xml_file.xml"));
            System.out.println("AuthFailure text: " + handler.authFailureText);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}