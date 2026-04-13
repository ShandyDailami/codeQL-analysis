import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class java_07339_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            String inputFilePath = "input.xml"; // provide your input file path
            parse(inputFilePath);
        } catch (IOException | SAXParseException e) {
            e.printStackTrace();
        }
    }

    private static void parse(String inputFilePath) throws IOException, SAXParseException {
        File inputFile = new File(inputFilePath);
        SAXReaderFactory saxReaderFactory = new SAXReaderFactory();
        SAXReader saxReader = saxReaderFactory.newSAXReader();
        DefaultHandler defaultHandler = new DefaultHandler();

        EntityResolver entityResolver = new EntityResolver() {
            public InputSource resolveEntity(String systemId) throws SAXParseException {
                return new InputSource(new StringReader("")); // return a dummy input source
            }
        };

        saxReader.setEntityResolver(entityResolver);

        XMLReader xmlReader = saxReader.buildXMLReader(defaultHandler);

        xmlReader.setValidation(false); // disable validation

        xmlReader.parse(inputFile);
    }
}