import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.ext.SAXParser;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_22340_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new InputSource(new FileInputStream(inputFile)));
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            saxParser.setContentHandler(new ContentHandler());
            xmlReader.setContentHandler(new ContentHandler());

            saxParser.parse(new InputSource(new FileInputStream(inputFile)), true);
            xmlReader.parse(new InputSource(new FileInputStream(inputFile)), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}