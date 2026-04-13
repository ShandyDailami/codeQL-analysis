import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.net.URL;
import java.security.AccessControlException;
import java.security.GuardedBy;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.util.Properties;

public class java_15139_XMLParser_A07 {

    private static class MyCallbackHandler implements CallbackHandler {
        public Subject getSubject(Callback[] callbacks, Principal[] principals)
                throws IOException, CertificateException, UnsupportedCallbackException {
            return null;
        }
    }

    private static class MyCallbackHandler2 implements CallbackHandler {
        public Subject getSubject(Callback[] callbacks, Principal[] principals)
                throws IOException, CertificateException, UnsupportedCallbackException {
            return null;
        }
    }

    public static void main(String[] args) {
        URL url = new URL("file:///C:/path/to/xml/file.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setFeature("http://xml.org/sax/features/external-parameter", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            reader.setFeature("http://xml.org/sax/features/validation", true);
            reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            reader.setFeature("http://xml.org/sax/features/external-dtd", false);
            reader.setContentHandler(new MyContentHandler());
            reader.parse(url.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyContentHandler implements org.xml.sax.ContentHandler {
        @GuardedBy("this")
        private int count = 0;

        public synchronized void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            count++;
        }

        public synchronized void endElement(String uri, String localName, String qName) throws SAXException {
            count--;
        }

        public synchronized void characters(char[] ch, int start, int length) throws SAXException {
            count--;
        }

        public synchronized void warning(SAXException e) {
            count--;
        }

        public synchronized void error(SAXException e) {
            count--;
        }

        public synchronized void fatalError(SAXException e) {
            count--;
        }
    }
}