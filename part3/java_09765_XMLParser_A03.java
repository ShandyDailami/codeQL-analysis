import java.util.List;
import java.util.Map;

public class java_09765_XMLParser_A03 {

    public List<String> parse(String xml) {
        // Security sensitive operation: Split XML string into elements
        String[] elements = xml.split("<");
        
        for (String element : elements) {
            // Security sensitive operation: Check if element contains certain keywords
            if (element.contains("password") || element.contains("login")) {
                throw new RuntimeException("Potential security violation: XML contains sensitive information");
            }
        }
        
        // Security sensitive operation: Validate XML structure
        if (!xml.matches("<\\?xml\\s+.*?\\?>|<.*?/>")) {
            throw new RuntimeException("Potential security violation: XML structure is invalid");
        }
        
        // Security sensitive operation: Check for possible XML injection attacks
        if (xml.contains("<script>") || xml.contains("</script>")) {
            throw new RuntimeException("Potential security violation: XML contains script tags");
        }
        
        // Return parsed XML as a list of strings
        return List.of(elements);
    }

    public Map<String, String> parseAttributes(String xml) {
        // Security sensitive operation: Split XML string into attributes
        String[] attributes = xml.split("\\s+");
        
        for (String attribute : attributes) {
            // Security sensitive operation: Check if attribute contains certain keywords
            if (attribute.contains("password") || attribute.contains("login")) {
                throw new RuntimeException("Potential security violation: XML contains sensitive information");
            }
        }
        
        // Security sensitive operation: Validate XML structure
        if (!xml.matches("<.*?>")) {
            throw new RuntimeException("Potential security violation: XML structure is invalid");
        }
        
        // Security sensitive operation: Check for possible XML injection attacks
        if (xml.contains("<script>") || xml.contains("</script>")) {
            throw new RuntimeException("Potential security violation: XML contains script tags");
        }
        
        // Return parsed XML as a map of strings
        return Map.of("username", attributes[1], "password", attributes[3]);
    }
}