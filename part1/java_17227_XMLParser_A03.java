import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class java_17227_XMLParser_A03 extends DefaultHandler {

    private String currentElement;
    private List<String> errorList;
    private String namespaceURI;
    private SchemaFactory schemaFactory;
    private Validator validator;

    public java_17227_XMLParser_A03(String xsdFile, List<String> errorList, String namespaceURI) {
        this.errorList = errorList;
        this.namespaceURI = namespaceURI;
        this.schemaFactory = SchemaFactory.newInstance(null);
        try {
            Schema schema = schemaFactory.newSchema(new File(xsdFile));
            this.validator = schema.newValidator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null) {
            String value = new String(ch, start, length);
            validate(value);
        }
    }

    private void validate(String value) {
        try {
            validator.validate(new InputSource(new StringReader(value)));
        } catch (SAXParseException e) {
            errorList.add(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> errorList = new ArrayList<>();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new XMLHandler(errorList, "http://www.w3.org/2001/XMLSchema"));
            parser.parse(new File("input.xml"), XMLHandler.DEBUG_OUTPUT);
            if (!errorList.isEmpty()) {
                for (String error : errorList) {
                    System.err.println("Error: " + error);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}