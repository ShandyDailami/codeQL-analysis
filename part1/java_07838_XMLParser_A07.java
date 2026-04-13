import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_07838_XMLParser_A07 extends DefaultHandler {
    
    boolean bAuthFailure = false;
    boolean bAuthSuccess = false;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            bAuthFailure = true;
        } else if (qName.equalsIgnoreCase("AuthSuccess")) {
            bAuthSuccess = true;
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            bAuthFailure = false;
        } else if (qName.equalsIgnoreCase("AuthSuccess")) {
            bAuthSuccess = false;
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAuthFailure) {
            // Do something here, such as reading the XML character data and checking for auth failures.
            System.out.println("AuthFailure: " + new String(ch, start, length));
        } else if (bAuthSuccess) {
            // Do something else here, such as reading the XML character data and checking for auth successes.
            System.out.println("AuthSuccess: " + new String(ch, start, length));
        }
    }
}

public class XMLParserExample {
    public static void main(String[] args) {
        try {
            KeyStore keystore = KeyStore.getInstance("JKS");
            // Load your keystore here.
            
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(new java.net.URLStreamHandlerFactory() {
                public java.net.URLConnection openConnection(URL u) throws IOException {
                    return new URLConnection(u) {
                        @Override
                        public InputStream getInputStream() throws IOException {
                            return new ByteArrayInputStream(keystore.getKey("alias", "aliaspassword".toCharArray()).getCertificate().getBytes());
                        }
                    };
                }
            });
            
            MyHandler myHandler = new MyHandler();
            saxParser.parse("http://www.example.com/auth.xml", myHandler);
        } catch (KeyStoreException e1) {
            e1.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (CertificateException e3) {
            e3.printStackTrace();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }
}