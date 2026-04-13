import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ValidationEvent;
import org.xml.sax.ValidationEventListener;
import org.xml.sax.helpers.XMLValidator;
import java.io.File;
import java.io.IOException;

public class java_13988_XMLParser_A01 {
    private static final String SCHEMA_FILE = "schema.xsd";
    private static final String XML_FILE = "data.xml";

    public static void main(String[] args) {
        validateXML();
    }

    private static void validateXML() {
        DefaultHandler defaultHandler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                System.out.println("End element: " + qName);
           
            }

            public void characters(char[] ch, int start, int length) {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        XMLReader reader = null;
        try {
            XMLValidator validator = new XMLValidator(SCHEMA_FILE);
            reader = XMLReaderFactory.createXMLReader(defaultHandler);
            validator.setValidate(true);
            validator.setSaveSchema(true);
            validator.setSaveSchemaLocation(SCHEMA_FILE);
            validator.setDTDValidate(false);
            validator.setNamespaceAware(false);
            validator.setRelaxValidate(false);
            validator.setSaveState(false);
            validator.getValidationEventHandler().setValidate(true);

            reader.setValidationEventHandler(validator.getValidationEventHandler());
        } catch (SAXException e) {
            e.printStackTrace();
            return;
        }

        try {
            reader.read(new File(XML_FILE));
            System.out.println("Validation successful");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            reader.setValidationEventHandler(validator.getValidationEventHandler());
        } catch (SAXException e) {
            e.printStackTrace();
            return;
        }
    }
}