import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Optional;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_41248_XMLParser_A01 {

    public Optional<Document> loadDocument(String filePath) {
        return Optional.ofNullable(AccessController.doPrivileged(
                (PrivilegedAction<Document>) () -> {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    factory.setIgnoringElementContentWhitespace(true);
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document document;
                    try {
                        document = builder.parse(new FileInputStream(filePath));
                    } catch (SAXException | IOException e) {
                        throw new AccessControlException("Access to the file was denied: " + filePath);
                    }
                    return document;
                }
        ));
    }
}