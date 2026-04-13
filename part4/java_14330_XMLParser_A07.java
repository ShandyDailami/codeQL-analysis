import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_14330_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");

        try {
            SAXHandler handler = new SAXHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();

            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {

    boolean bContent = false;
    StringBuffer sbfContent = new StringBuffer();

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes atts) {
        bContent = true;
        sbfContent.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        bContent = false;

        if ("content".equalsIgnoreCase(localName)) {
            System.out.println("Content: " + sbfContent.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bContent) {
            sbfContent.append(new String(ch, start, length));
        }
    }
}