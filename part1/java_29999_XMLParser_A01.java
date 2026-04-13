import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_29999_XMLParser_A01 {

    public static void main(String[] args) {
        File inputFile = new File("sample.xml");
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);

            SAXParserHandler saxParserHandler = new SAXParserHandler();
            xmlReader.setContentHandler(saxParserHandler);

            xmlReader.parse(inputFile);

        } catch (IOException e) {
            e.printStackTrace();
       
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}