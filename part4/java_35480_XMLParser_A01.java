import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_35480_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader reader;
        
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XmlContentHandler());
            
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}