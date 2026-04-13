import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.security.Permission;
import java.security.SecurityManager;
import java.util.ArrayList;
import java.util.List;

public class java_31679_XMLParser_A07 {
    private SecurityManager securityManager;

    public java_31679_XMLParser_A07(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public List<String> parse(String xml) {
        // Enforce the security manager to prevent potential failures
        Permission perm = new Permission("auth failure");
        securityManager.checkPermission(perm);

        SAXHandler saxHandler = new SAXHandler();
        try {
            org.xml.sax.helpers.DefaultHandler dHandler = new org.xml.sax.helpers.DefaultHandler();
            org.xml.sax.XMLReader xr = org.xml.sax.XMLReaderFactory.createXMLReader(new org.xml.sax.InputSource(new StringReader(xml)));
            xr.setContentHandler(saxHandler);
            xr.setErrorHandler(saxHandler);
            xr.parse("<root>" + xml + "</root>");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return saxHandler.getData();
    }

    private class SAXHandler extends DefaultHandler {
        private List<String> data = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            data.add(qName);
        }
    }
}