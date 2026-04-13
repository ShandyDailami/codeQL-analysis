import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_12079_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            MyHandler mh = new MyHandler();
            XMLReader xr = sp.getXMLReader();
            xr.setContentHandler(mh);
            xr.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder data = new StringBuilder();
    private String tagName;
    private String namespace;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tagName = qName;
        namespace = uri;
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (namespace != null) {
            data.append("End of ");
            data.append(qName);
            data.append(" in ");
            data.append(namespace);
            System.out.println(data.toString());
            tagName = null;
            namespace = null;
            data = new StringBuilder();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (tagName != null) {
            data.append(ch, start, length);
        }
    }
}