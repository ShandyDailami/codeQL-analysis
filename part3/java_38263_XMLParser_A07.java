import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;

public class java_38263_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        parseXml(xmlFile);
    }

    private static void parseXml(File xmlFile) {
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setValidation(true);
            reader.setEntityResolver(new MyEntityResolver());
            reader.setContentHandler(new MyContentHandler());
            reader.parse(xmlFile.getAbsolutePath());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {

    private boolean usernameFound = false;
    private boolean passwordFound = false;
    private String username = null;
    private String password = null;

    @Override
    public void startDocument() {}

    @Override
    public void endDocument() {}

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        if ("username".equals(qName)) {
            usernameFound = true;
        } else if ("password".equals(qName)) {
            passwordFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {}

    @Override
    public void characters(char[] ch, int start, int length) {
        if (usernameFound) {
            username = new String(ch, start, length);
            usernameFound = false;
        } else if (passwordFound) {
            password = new String(ch, start, length);
            passwordFound = false;
        }
    }
}

class MyEntityResolver implements org.xml.sax.EntityResolver {

    @Override
    public org.xml.sax.InputSource resolveEntity(String systemId) throws SAXException {
        return new InputSource(new StringReader(""));
    }
}