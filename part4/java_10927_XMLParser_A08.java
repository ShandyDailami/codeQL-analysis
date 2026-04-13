import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLValidator;
import org.xml.sax.parser.XercesDOMParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class java_10927_XMLParser_A08 extends DefaultHandler {

    private StringBuilder data = new StringBuilder();
    private int depth = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        depth++;
        data.append("  ").append("<").append(qName);
        if (attributes.getLength() > 0) {
            data.append(" ");
            for (int i = 0; i < attributes.getLength(); i++) {
                data.append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\" ");
            }
        }
        data.append(">\n");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        depth--;
        data.append("  ").append("</").append(qName).append(">\n");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (depth != 0) {
            data.append("  ").append(new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws IOException, SAXException {
        XMLParser parser = new XercesDOMParser();
        MySAXHandler handler = new MySAXHandler();
        parser.setContentHandler(handler);
        parser.parse(new File("example.xml"));
        System.out.println(handler.data.toString());
    }
}