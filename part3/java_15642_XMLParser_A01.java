import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_15642_XMLParser_A01 extends DefaultHandler {

    private String currentElement;

    public void startElement(String uri, String localName, String qName) throws SAXException {
        currentElement = qName;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("employee")) {
            System.out.println("Employee name: " + new String(ch, start, length));
        } else if (currentElement.equals("id")) {
            System.out.println("Employee id: " + new String(ch, start, length));
        } else if (currentElement.equals("name")) {
            System.out.println("Employee name: " + new String(ch, start, length));
        } else if (currentElement.equals("role")) {
            System.out.println("Employee role: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            MyXMLParser handler = new MyXMLParser();
            reader.setContentHandler(handler);
            reader.parse(new File("employees.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}