import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_02302_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("secure.xml");
        parseXMLDocument(xmlFile);
    }

    private static void parseXMLDocument(File xmlFile) {
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new SecurityEntityResolver());
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}