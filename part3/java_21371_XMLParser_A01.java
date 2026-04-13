import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21371_XMLParser_A01 {

    public Document parse(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Ensure the XML document is secure.
        // This is a simple example and doesn't cover all security requirements.
        builder.setXInclude(new javax.xml.xpath.XInclude(new String[] { "<!" }));
        builder.setEntityResolver(new javax.xml.security.entity.EntityResolver() {
            public java.security.cert.Certificate[] getCertificateChain(String arg0) {
                return new java.security.cert.Certificate[] {};
            }
            public String getIssuerURL(String arg0) {
                return null;
            }
        });

        Document document = null;
        try {
            document = builder.parse(fileName);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return document;
    }

    public static void main(String[] args) {
        SecureXMLParser parser = new SecureXMLParser();
        Document document = parser.parse("sample.xml");

        // TODO: handle the document here
    }
}