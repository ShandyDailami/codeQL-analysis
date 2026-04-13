import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_09977_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DefaultHandler handler = new DefaultHandler();
        XMLReader reader = null;
        
        try {
            reader = XMLReaderFactory.createXMLReader(handler);
            reader.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd", false);
            reader.setFeature("http://xml.apache.org/xml-features/local-name/init", true);
            reader.setFeature("http://xml.apache.org/xml-features/nonvalidating/load-external-dtd", false);
            
            reader.setFeature("http://xml.apache.org/xml-features/namespaces/all", true);
            reader.setFeature("http://xml.apache.org/xml-features/namespace-prefixes/all", true);
            
            reader.setFeature("http://xml.apache.org/xml-features/validation/schema", true);
            reader.setFeature("http://xml.apache.org/xml-features/namespace-prefixes/all", true);

            reader.setFeature("http://xml.apache.org/xml-features/namespaces/prefix-map", handler);
            
            reader.setFeature("http://xml.apache.org/xml-features/namespaces/it", true);
            reader.setFeature("http://xml.apache.org/xml-features/namespaces/it-old", true);

            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}