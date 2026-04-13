import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.BasicEntityResolver;
import org.xml.sax.ext.EntityResolver;
import java.io.File;
import java.io.IOException;

public class java_34383_XMLParser_A08 {
    public static void main(String[] args) {
        EntityResolver resolver = new BasicEntityResolver();
        resolver.setLoadDTD(true);
        resolver.setLoadExternalDTD(true);

        try {
            File inputFile = new File("input.xml");
            XMLReader xmlReader = XMLReaderFactory.createXMLReader(resolver);
            xmlReader.setEntityResolver(resolver);

            SAXHandler saxHandler = new SAXHandler();
            xmlReader.setContentHandler(saxHandler);

            xmlReader.parse(new FileInputStream(inputFile));

            System.out.println("Element Name\t Element Value");
            for (String name : saxHandler.getNames()) {
                System.out.println(name + "\t" + saxHandler.getValue(name));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}