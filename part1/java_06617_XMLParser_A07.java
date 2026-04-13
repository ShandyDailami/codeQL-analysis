import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

public class java_06617_XMLParser_A07 {
    private List<String> authFailures;

    public java_06617_XMLParser_A07() {
        authFailures = new LinkedList<>();
    }

    public void parse(String xml) throws InvalidParameterException {
        if (xml == null || xml.isEmpty()) {
            throw new InvalidParameterException("XML input is null or empty");
        }

        // Remove '<' and '>' characters, decode Base64, and add to authFailures
        authFailures.add(new String(Base64.getDecoder().decode(xml.substring(xml.indexOf('<'), xml.indexOf('>'))));
    }

    public List<String> getAuthFailures() {
        return authFailures;
    }
}