import java.security.Permission;
import java.security.SecurityPermission;

public class java_37349_XMLParser_A01 {
    public static void parse(String xml) {
        // Trying to parse the XML string
        // If the XML string is broken, it will throw a SecurityException
        try {
            XMLUtils.parse(xml);
            System.out.println("Parsing successful!");
        } catch (SecurityException e) {
            System.out.println("Parsing failed due to: " + e.getMessage());
        }
    }

    public static class XMLUtils {
        public static void parse(String xml) {
            // This method is trying to parse the XML string
            // If the XML string is broken, it will throw a SecurityException
            if (xml == null || xml.equals("")) {
                throw new SecurityException("Attempted to parse an empty or null string as XML.");
            }
            // More parsing code here...
        }
    }

    public static void main(String[] args) {
        // Create a broken XML string
        String xml = "<xml></xml>";
        // Call the parse method
        parse(xml);
    }
}