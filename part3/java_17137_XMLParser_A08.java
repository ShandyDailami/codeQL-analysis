import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.xml.sax.SAXParseException;
import org.w3c.dom.Element;

import javax.crypto.Cipher;
import javax.crypto.NoSuchProviderException;
import javax.crypto.spec.PSSParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class java_17137_XMLParser_A08 {

    private PrivateKey privateKey;
    private SecretKeySpec secretKey;
    private Cipher cipher;

    public java_17137_XMLParser_A08(String privateKeyFile, String secretKey) throws IOException, NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException {
        this.privateKey = readPrivateKey(privateKeyFile);
        this.secretKey = new SecretKeySpec(secretKey.getBytes(), "AES");
        this.cipher = Cipher.getInstance("AES");
        this.cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
    }

    private PrivateKey readPrivateKey(String filename) throws IOException {
        return (PrivateKey) new java.security.pkcs11.Pkcs11Provider().getKey(filename, "password".toCharArray()).getPrivateKey();
    }

    public String decrypt(String encryptedData) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source encryptedDataSource = new StringSource(encryptedData);
        Result decryptedDataTarget = new StringResult();

        transformer.setParameter("encryption", this.cipher);
        transformer.transform(new StreamSource(encryptedDataSource), decryptedDataTarget);

        return decryptedDataTarget.getResult();
    }

    public void parse(String xmlFilePath) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.setProperty("class", "com.sun.org.apache.xerces.internal.parsers.SAXParser");

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(xmlFilePath));

            System.out.println("XML Parsed Successfully");
        } catch (CertificateException | KeyManagementException | NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}