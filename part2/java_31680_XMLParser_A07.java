import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.xmlreader.XMLResourceLoader;

import java.io.StringReader;
import java.io.IOException;

public class java_31680_XMLParser_A07 extends DefaultHandler {
    private static final String LOGIN_TAG = "login";
    private static final String PASSWORD_TAG = "password";
    private static final String NAMESPACE = "http://example.com/security";
    private static final String RESOLVER_NAME = "default";

    private String login;
    private String password;
    private boolean logintagFound = false;
    private boolean passwordtagFound = false;

    public static void main(String[] args) {
        String xml = "<root><security><login>admin</login><password>pass123</password></security></root>";
        AuthFailureXMLParser parser = new AuthFailureXMLParser();
        parser.parse(new StringReader(xml));
    }

    public void parse(StringReader reader) {
        try {
            XMLReader xmlreader = XMLReaderFactory.createXMLReader();
            xmlreader.setEntityResolver(entityResolver());
            xmlreader.setContentHandler(this);
            xmlreader.parse(reader);

            if (!logintagFound) {
                System.out.println("Login tag not found");
            }

            if (!passwordtagFound) {
                System.out.println("Password tag not found");
           
        }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equals(LOGIN_TAG)) {
            logintagFound = true;
        }

        if (qName.equals(PASSWORD_TAG)) {
            passwordtagFound = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(LOGIN_TAG)) {
            logintagFound = false;
        }

        if (qName.equals(PASSWORD_TAG)) {
            passwordtagFound = false;
        }
    }

    private EntityResolver entityResolver() {
        return new EntityResolver() {
            public java.io.Reader resolveEntity(String arg0) throws IOException {
                return new StringReader(arg0);
            }
        };
    }
}