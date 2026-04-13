import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.List;

public class java_27411_XMLParser_A01 {

    private static final String XmlFile = "sample.xml";

    public List<String> parse() {
        return AccessController.doPrivileged(new PrivilegedAction<List<String>>() {
            public List<String> run() {
                return parseXML(XmlFile);
            }
        });
    }

    private List<String> parseXML(String xmlFile) {
        // This will be our implementation of a robust XML parser.
        // For the sake of this exercise, we'll use a simplistic approach.
        return null;
    }
}