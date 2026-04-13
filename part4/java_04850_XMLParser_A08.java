import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.validation.Validator;
import org.xml.sax.validation.ValidatorHandler;

import java.io.File;
import java.io.IOException;

public class java_04850_XMLParser_A08 implements ValidatorHandler {

    private static final String SCHEMA_FILE = "integrity_failure.xsd";
    private static final String INPUT_FILE = "test.xml";
    private static final String ERROR_FILE = "errors.xml";

    private Validator validator;

    public java_04850_XMLParser_A08() {
        try {
            validator = SAXValidator.newInstance(XMLReaderFactory.createXMLReader());
            validator.setValidatorHandler(this);
            validator.validate(new File(SCHEMA_FILE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal error: " + e.getMessage());
    }

    public void warning(SAXException e) throws SAXException {
        System.out.println("Warning: " + e.getMessage());
    }

    public void validate(String file) throws SAXException {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new MyEntityResolver(file));

            XMLParser parser = new XMLParser(reader);
            parser.setValidation(true);
            parser.setDTDFullValidation(true);
            parser.setValidateSchema(true);

            reader.parse(new File(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyXMLParser().validate(INPUT_FILE);
    }
}