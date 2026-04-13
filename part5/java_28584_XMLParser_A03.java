import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_28584_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new MyEntityResolver());
            reader.setValidation(true);
            reader.setDoNamespaces(true);

            XMLParserHandler handler = new XMLParserHandler();
            reader.setContentHandler(handler);

            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}