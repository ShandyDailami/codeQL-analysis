import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.validation.SAXValidateResource;
import org.xml.sax.validation.Validator;

public class java_41001_XMLParser_A08 {

    public static void main(String[] args) {
        SAXValidateResource res = new SAXValidateResource(new XmlValidator());
        XMLReader reader = XMLReaderFactory.createXMLReader(res);

        try (FileInputStream fis = new FileInputStream("input.xml")) {
            reader.setEntityResolver(new XmlEntityResolver(fis));
            reader.parse(fis);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class XmlValidator implements Validator {

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            throw new SAXException("XML fatal error: " + e.getMessage());
        }

        @Override
        public void warning(SAXParseException e) throws SAXException {
            System.out.println("XML warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) throws SAXException {
            throw new SAXException("XML error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXErrorHandler handler, SAXParseException e) {
            handler.error(e);
        }

        @Override
        public void warning(SAXErrorHandler handler, SAXParseException e) {
            handler.warning(e);
        }

        @Override
        public void error(SAXErrorHandler handler, SAXParseException e) {
            handler.error(e);
        }
    }
}