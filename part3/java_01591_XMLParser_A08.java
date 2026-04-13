import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_01591_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream(new File("path_to_your_xml_file.xml"));
            KeyStore keyStore = KeyStore.getInstance("JKS");
            char[] keyStorePassword = "your_key_store_password".toCharArray();
            keyStore.load(inputStream, keyStorePassword);
            
            Key key = getKey(keyStore, "your_key_alias", "your_key_store_password");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder(key.getStoreInputStream());
            builder.setEntityResolver(new EntityResolverImpl());
            Document document = builder.parse(new InputSource(new StringReader("")));
            
            XPath xpath = XPathFactory.newInstance().newXPath();
            String expression = "/book/title";
            NodeList nodeList = (NodeList) xpath.evaluate(expression, document, XPathConstants.NODESET);
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println(node.getNodeName());
            }
            
            key.getStoreInputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }
    
    private static Key getKey(KeyStore keyStore, String keyAlias, String keyStorePassword) throws KeyStoreException, NoSuchAlgorithmException, InvalidKeyException {
        Key key = keyStore.getKey(keyAlias, keyStorePassword);
        return key;
    }
}