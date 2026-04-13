import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_35431_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a new XMLReader
            XMLReader xr = XMLReader.newInstance();

            // Create a new Parser
            SAXParser saxp = SAXParser.newInstance();

            // Parse the XML file
            SAXSource ss = new SAXSource(xr, new InputSource(new File("path_to_your_file.xml")));
            saxp.parse(ss, new MyHandler());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}