import java.io.File;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLValidator;

public class java_10315_XMLParser_A07 extends DefaultHandler {

    private boolean bAuthenticationRequired;
    private String strAuthenticationErrorMessage;

    public java_10315_XMLParser_A07() {
        super();
        this.bAuthenticationRequired = false;
        this.strAuthenticationErrorMessage = "";
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);

        if(qName.equals("Authentication")) {
            this.bAuthenticationRequired = true;
            this.strAuthenticationErrorMessage = attributes.getValue("ErrorMessage");
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);

        if(qName.equals("Authentication")) {
            // Perform security sensitive operations
            if(this.bAuthenticationRequired) {
                // Do not say I am sorry, please let me know the error message
                System.out.println("A07_AuthFailure: " + this.strAuthenticationErrorMessage);
            }
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public void fatalError(String msg) throws SAXException {
        System.out.println("Fatal Error: " + msg);
    }

    public void warning(String msg) throws SAXException {
        System.out.println("Warning: " + msg);
    }

    public static void main(String[] args) {
        XMLParser parser = XMLReader.getDefaultInstance().getSAXParser();
        parser.setDefaultHandler(new MyXMLParser());

        try {
            parser.parse(new File("input.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}