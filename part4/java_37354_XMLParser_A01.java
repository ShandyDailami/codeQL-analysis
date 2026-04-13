import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Validator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_37354_XMLParser_A01 extends DefaultHandler {

    private String schemaLocation;
    private Validator validator;

    public java_37354_XMLParser_A01(String schemaLocation) {
        this.schemaLocation = schemaLocation;
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = spf.newSAXParser();
            saxParser.setProperty("http://xml.org/sax/properties/external-generalized-element", Boolean.TRUE);
            saxParser.setProperty("http://xml.org/sax/properties/external-preserve-namespaces", Boolean.FALSE);
            validator = saxParser.getXMLReader().getParser().getFeature("http://xml.org/sax/features/external-parameter-filtering")
                    ? saxParser.getXMLReader().getParser().getFeature("http://xml.org/sax/features/external-parameter-filtering")
                    : saxParser.getXMLReader().getParser();
            saxParser.getXMLReader().setContentHandler(this);
            validator.getSupportedFeatures().add(javax.xml.validation.event.ValidationEventConstants.VALIDATION_EVENT_FINALIZE);
            validator.getSupportedFeatures().add(javax.xml.validation.event.ValidationEventConstants.VALIDATION_EVENT_ERROR);
            validator.getSupportedFeatures().add(javax.xml.validation.event.ValidationEventConstants.VALIDATION_EVENT_WARNING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validate(String xmlFile) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser();
            saxParser.setProperty("http://xml.org/sax/properties/external-generalized-element", Boolean.TRUE);
            saxParser.setProperty("http://xml.org/sax/properties/external-preserve-namespaces", Boolean.FALSE);
            saxParser.getXMLReader().setContentHandler(this);
            validator = saxParser.getXMLReader().getParser();
            validator.getSupportedFeatures().add(javax.xml.validation.event.ValidationEventConstants.VALIDATION_EVENT_FINALIZE);
            validator.getSupportedFeatures().add(javax.xml.validation.event.ValidationEventConstants.VALIDATION_EVENT_ERROR);
            validator.getSupportedFeatures().add(javax.xml.validation.event.ValidationEventConstants.VALIDATION_EVENT_WARNING);
            SAXParserFactory spf2 = SAXParserFactory.newInstance();
            saxParser = spf2.newSAXParser();
            saxParser.getXMLReader().parse(new File(xmlFile), this);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // TODO Auto-generated method stub
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // TODO Auto-generated method stub
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        validator.validate(new org.xml.sax.InputSource(new StringReader(content)));
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser("path_to_your_schema.xsd");
        System.out.println(parser.validate("path_to_your_xml_file.xml"));
    }
}