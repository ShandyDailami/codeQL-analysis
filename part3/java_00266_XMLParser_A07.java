import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import sun.security.x509.X509Subject;

public class java_00266_XMLParser_A07 {
    private PrivateKey privateKey;
    private MessageDigest messageDigest;

    public java_00266_XMLParser_A07(PrivateKey privateKey) throws NoSuchAlgorithmException {
        this.privateKey = privateKey;
        this.messageDigest = MessageDigest.getInstance("SHA1");
    }

    public String parseXML(String xml) throws CertificateException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xml)));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();

        StringBuffer sb = new StringBuffer();
        NodeList nodes = (NodeList) xpath.evaluate("//element", document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); ++i) {
            Node node = nodes.item(i);
            sb.append(node.getTextContent());
        }

        String result = sb.toString();
        return decryptData(result);
    }

    private String decryptData(String data) {
        byte[] decryptedData = decryptDataUsingSHA1(data, privateKey);
        return new String(decryptedData);
    }

    private byte[] decryptDataUsingSHA1(String data, PrivateKey privateKey) {
        try {
            messageDigest.update(data.getBytes());
            byte[] keyBytes = privateKey.getEncoded();
            byte[] decryptedData = new String(keyBytes).getBytes();

            return decryptedData;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}