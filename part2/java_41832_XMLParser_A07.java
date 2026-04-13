import com.sun.org.apache.xerces.internal.parsers.SAXParser;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_41832_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParser saxParser = new SAXParser();
        File xmlFile = new File("path_to_your_xml_file.xml");

        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setFeature("http://apache.org/xml/features/nonvalidating/strict", false);
            xmlReader.setEntityResolver(new MyEntityResolver());
            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(xmlFile, saxHandler);
            saxHandler.printResults();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}