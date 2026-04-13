import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;
import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper.NamespaceMapper;
import com.sun.xml.internal.bind.v2.marshaller.ItemAnnotationEnhancer;
import java.security.Key;
import java.util.Base64;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.helper.DefaultValidationEventHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.javaxmlsecurity.crypto.AES;
import com.javaxmlsecurity.crypto.KeyGenerator;

public class java_25392_XMLParser_A07 {

    public static void main(String[] args) {
        String xml = "<root>Content</root>";
        String password = "password";
        Key key = generateKey(password);
        String encryptedXml = encryptXml(xml, key);
        String decryptedXml = decryptXml(encryptedXml, key);

        System.out.println(decryptedXml);
    }

    private static Key generateKey(String password) {
        return KeyGenerator.generateKey(password);
    }

    private static String encryptXml(String xml, Key key) {
        byte[] encryptedXmlBytes = AES.encrypt(xml.getBytes(), key);
        return Base64.getEncoder().encodeToString(encryptedXmlBytes);
    }

    private static String decryptXml(String encryptedXml, Key key) {
        byte[] encryptedXmlBytes = Base64.getDecoder().decode(encryptedXml);
        byte[] decryptedXmlBytes = AES.decrypt(encryptedXmlBytes, key);
        return new String(decryptedXmlBytes);
    }
}