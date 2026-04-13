import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class java_06643_XMLParser_A01 {
    private Key key;
    private Cipher cipher;

    public java_06643_XMLParser_A01() throws Exception {
        this.key = KeyGenerator.getInstance("AES").generateKey();
        this.cipher = Cipher.getInstance("AES");
        this.cipher.init(Cipher.ENCRYPT_MODE, this.key);
    }

    public String encrypt(String data) throws Exception {
        byte[] encrypted = this.cipher.doFinal(data.getBytes());
        return new String(encrypted);
    }

    public String decrypt(String data) throws Exception {
        byte[] encrypted = data.getBytes();
        byte[] decrypted = this.cipher.doFinal(encrypted);
        return new String(decrypted);
    }

    public void parse(String xmlFile) throws IOException, SAXException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new SAXContentHandler(this));
        reader.parse(xmlFile);
    }
}