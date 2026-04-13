import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_06647_XMLParser_A03 {

    private static final String KEYSTORE_PATH = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_ALIAS = "your_key_alias";

    public void parseXML(String fileName) {

        // Load the key store
        KeyStore keyStore = loadKeyStore();

        // Load the key and setup the key store
        Key key = loadKey(keyStore);

        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create a DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the document
        Document doc = builder.parse(fileName);

        // Get the root element
        Element root = doc.getDocumentElement();

        // Call the recursive method
        recursiveSearch(root);
    }

    private KeyStore loadKeyStore() {
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());
        } catch (Exception e) {
            throw new InvalidParameterException("Error loading keystore: " + e.getMessage());
        }
        return keyStore;
    }

    private Key loadKey(KeyStore keyStore) {
        Key key = null;
        try {
            key = keyStore.getKey(KEY_ALIAS, KEYSTORE_PASSWORD.toCharArray());
        } catch (Exception e) {
            throw new InvalidParameterException("Error loading key: " + e.getMessage());
        }
        return key;
    }

    private void recursiveSearch(Node node) {
        if (node instanceof Element) {
            Element element = (Element) node;

            // Use the element here
            // You can do anything you want with the element, like get its attributes, text, etc.

            // Get the child nodes
            NodeList childNodes = element.getChildNodes();

            // Iterate over the child nodes
            for (int i = 0; i < childNodes.getLength(); i++) {
                recursiveSearch(childNodes.item(i));
            }
        }
    }
}