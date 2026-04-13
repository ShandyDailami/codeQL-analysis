import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_38108_XMLParser_A03 {

    // Use a StringBuilder for constructing and modifying the XML string
    private StringBuilder xmlString;

    public java_38108_XMLParser_A03() {
        xmlString = new StringBuilder();
    }

    public void addElement(String elementName, String elementValue) {
        xmlString.append("<").append(elementName);
        addAttribute("value", elementValue);
        xmlString.append("/>");
    }

    public void addAttribute(String attributeName, String attributeValue) {
        xmlString.append(" ").append(attributeName).append("=\"");
        attributeValue = sanitizeInput(attributeValue);
        xmlString.append(attributeValue).append("\"");
    }

    private String sanitizeInput(String input) {
        // Simple input sanitization for demonstration purposes
        // This can be expanded for a real-world use case
        return new StringBuilder(input).reverse().toString();
    }

    public String getParsedXML() {
        // Create a SHA-256 hash of the XML string for security
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(xmlString.toString().getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        VanillaXMLParser parser = new VanillaXMLParser();
        parser.addElement("root", "<script>alert('INJECTION!')</script>");
        System.out.println(parser.getParsedXML());
    }
}