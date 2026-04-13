import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;

import java.io.File;
import java.io.IOException;

public class java_33410_XMLParser_A08 extends DefaultHandler {
    private StringBuilder data = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        data.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        data.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if ("employee".equals(localName)) {
            System.out.println(data.toString());
        }
    }

    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            File file = new File("employees.xml");
            reader.setContentHandler(new MyHandler());
            reader.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}