import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_28893_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            KeyStore ks = KeyStore.getInstance("JKS");
            FileInputStream fis = new FileInputStream("keystore.jks");
            ks.load(fis, "password".toCharArray());
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser(new DefaultHandler());
            saxParser.parse(new FileInputStream("sample.xml"), new XMLHandler(ks));
        } catch (KeyStoreException | CertificateException | ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private boolean bId = false;
    private String name;
    private int age;
    private String id;

    public java_28893_XMLParser_A07(KeyStore ks) {
        try {
            KeyStore trustStore = ks;
            String keyStorePassword = "password";
            String keyPassword = "password";
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, keyStorePassword.toCharArray());
            TrustManagerFactory tmf = new TrustManagerFactory();
            tmf.init(new KeyStoreProvider(keyStore, keyStorePassword));
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(new SSLSocketFactory(), tmf);
            HttpClient httpclient = new HttpClient();
            httpclient.getCredentialsProvider().setCredentials(
                AuthScope.ANY, new NamedValue("Basic", new String(Base64.encodeBase64((keyStorePassword + ":" + keyStorePassword).getBytes()))));
            httpClient.setHttpConnectionManager(new BasicHttpConnectionManager());
            httpclient.getParams().setConnectionTimeout(5000);
            httpclient.getParams().setSocketTimeout(5000);
            httpclient.getParams().setRedirectsEnabled(false);
            httpClientConnectionManager.setDefaultCredentialsProvider(new BasicCredentialsProvider());
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("person".equals(localName)) {
            bName = true;
            bAge = true;
            bId = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("name".equals(localName)) {
            bName = false;
        } else if ("age".equals(localName)) {
            bAge = false;
        } else if ("id".equals(localName)) {
            bId = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
        } else if (bAge) {
            age = Integer.parseInt(new String(ch, start, length));
        } else if (bId) {
            id = new String(ch, start, length);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Name: " + name + ", Age: " + age + ", ID: " + id);
    }
}