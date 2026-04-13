import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_36495_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";
        XMLParserExample handler = new XMLParserExample();
        XMLLoader loader = new XMLLoader();
        try {
            loader.setDefaultHandler(new DefaultHandler() {
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
            });
            XMLParser parser = loader.load(new File(xmlFile));
            parser.parse(new InputSource(new StringReader(xmlFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}