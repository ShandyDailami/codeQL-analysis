import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class java_13375_XMLParser_A08 {

    private SSLContext sslContext;
    private String server;
    private String port;

    public java_13375_XMLParser_A08(String server, String port) {
        this.server = server;
        this.port = port;

        try {
            SSLSocketFactory sslSocketFactory = new BasicSSLSocketFactory();
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] { new TrustAllCerts() }, new java.security.SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parse() {
        try {
            URL url = new URL("https", server, port, "/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Referer", url.toString());
            connection.setRequestProperty("Accept-Encoding", "UTF-8");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new DTDHandler());
            saxParser.parse(inputStream, new XMLHandler(connection.getContentEncoding()));

            inputStream.close();
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class XMLHandler extends DefaultHandler {
        private String encoding;

        public java_13375_XMLParser_A08(String encoding) {
            this.encoding = encoding;
        }

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start of Element : " + localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of Element : " + localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length, encoding);
            System.out.println("Characters: " + content);
        }
    }

    class TrustAllCerts extends X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
            return;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
            return;
        }
    }
}