import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXReader;
import org.xml.sax.helpers.DefaultHandler;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class java_26266_XMLParser_A07 extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

}

public class Main {

    public static void main(String[] args) {
        try {
            // Setup SSL for TrustManager
            TrustManagerFactory trustManagerFactory = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.initialize(null);
            TrustManager[] trustAllCerts = trustManagerFactory
                    .getTrustManagers();
            if (trustAllCerts.length != 4) {
                throw new Exception("Trust count mismatch");
            }
            ((X509TrustManager) trustAllCerts[3]).checkClientTrusted(
                    new Certificate[0], "");
            ((X509TrustManager) trustAllCerts[2]).checkServerTrusted(
                    new Certificate[0], "");

            SSLContext sc = SSLContext.getInstance("SSL", "sun-jsse-provider");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Parse XML
            SAXReader reader = new SAXReader();
            reader.setContentHandler(new MyHandler());
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidate(false);
            Document document = factory.newDocumentBuilder().parse(
                    new File("filename.xml"));

        } catch (NoSuchAlgorithmException | KeyStoreException | CertificateException | KeyManagementException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

}