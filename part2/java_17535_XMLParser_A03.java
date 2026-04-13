import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_17535_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Load the properties file
            Properties prop = new Properties();
            prop.load(new FileInputStream("config.properties"));

            // Get the properties value
            String xmlFile = prop.getProperty("xmlFile");

            // Create an instance of SAXParser
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Parse the XML file
            reader.setContentHandler(new XMLContentHandler());
            reader.setErrorHandler(new XMLErrorHandler());
            reader.parse(new FileInputStream(xmlFile));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

// Implement the SAX Content and Error Handler here...
class XMLContentHandler implements org.xml.sax.ContentHandler {

    @Override
    public void startDocument() throws SAXException {
        // Implement your security-sensitive operation here...
    }

    // Implement the other methods...

    @Override
    public void endDocument() throws SAXException {
        // Implement your security-sensitive operation here...
    }

    // Implement the other methods...
}

class XMLErrorHandler implements org.xml.sax.ErrorHandler {

    @Override
    public void fatalError(SAXException e) throws SAXException {
        // Implement your security-sensitive operation here...
    }

    // Implement the other methods...

    @Override
    public void error(SAXException e) throws SAXException {
        // Implement your security-sensitive operation here...
    }

    // Implement the other methods...

    @Override
    public void warning(SAXWarning warning) throws SAXException {
        // Implement your security-sensitive operation here...
    }

    // Implement the other methods...
}