import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_20961_XMLParser_A07 {

    public static void parseFile(String filePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean inAuthFailure = false;
                String lastElement = null;

                @Override
                public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) throws SAXException {
                    if (qName.equals("AuthFailure")) {
                        inAuthFailure = true;
                    }
                    lastElement = qName;
                }

                @Override
                public java_20961_XMLParser_A07(String uri, String localName, String qName) throws SAXException {
                    if (inAuthFailure && qName.equals("AuthFailure")) {
                        System.out.println("Detected AuthFailure: " + lastElement);
                        inAuthFailure = false;
                    }
                }
            };

            parser.parse(new File(filePath), handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parseFile("path_to_your_xml_file");
    }
}