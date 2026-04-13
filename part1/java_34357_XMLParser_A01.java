import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_34357_XMLParser_A01 {

    public static void parse(String xmlFilePath) {
        try {
            File xmlFile = new File(xmlFilePath);
            InputStream inputStream = new FileInputStream(xmlFile);
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            XMLHandler xmlHandler = new XMLHandler();
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            saxParser.parse(reader, xmlHandler);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XMLHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            // This method is not used in this example, but it's necessary for the SAXParser
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // This method is not used in this example, but it's necessary for the SAXParser
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // This method is not used in this example, but it's necessary for the SAXParser
        }
    }
}