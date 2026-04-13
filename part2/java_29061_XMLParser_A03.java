import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XercesSAXParser;

public class java_29061_XMLParser_A03 extends DefaultHandler {

    private List<String> tags;
    private StringBuilder text;

    public java_29061_XMLParser_A03() {
        tags = new ArrayList<>();
        text = new StringBuilder();
    }

    @Override
    public void startDocument() throws SAXException {
        tags.clear();
        text.setLength(0);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tags.add(qName);
        text.append("<");
        text.append(qName);
        List<String> attrs = new ArrayList<>();
        for (int i = 0; i < attributes.getLength(); i++) {
            attrs.add(attributes.getQName(i) + "='" + attributes.getValue(i) + "'");
        }
        text.append(" ");
        text.append(String.join(" ", attrs));
        text.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        text.append("</");
        text.append(qName);
        text.append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(new String(ch, start, length));
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(text.toString());
    }

    public static void main(String[] args) {
        try {
            XMLParser parser = new XercesSAXParser();
            MyXMLParser handler = new MyXMLParser();
            parser.setContentHandler(handler);
            parser.parse(new File("path_to_your_xml_file.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}