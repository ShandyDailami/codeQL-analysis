import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_36222_XMLParser_A08 extends DefaultHandler {
    private boolean isIntrusionDetected = false;
    private boolean isPasswordStrengthWeak = false;
    private boolean isAccountLocked = false;
    private boolean isPasswordChangedRecently = false;

    public boolean isIntrusionDetected() {
        return isIntrusionDetected;
    }

    public boolean isPasswordStrengthWeak() {
        return isPasswordStrengthWeak;
    }

    public boolean isAccountLocked() {
        return isAccountLocked;
    }

    public boolean isPasswordChangedRecently() {
        return isPasswordChangedRecently;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "IntrusionDetection":
                isIntrusionDetected = true;
                break;
            case "PasswordStrength":
                isPasswordStrengthWeak = true;
                break;
            case "AccountLocked":
                isAccountLocked = true;
                break;
            case "PasswordChangedRecently":
                isPasswordChangedRecently = true;
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        File xmlFile = new File("src/main/resources/sample.xml");
        parser.parse(xmlFile, new SecurityHandler());

        if (new SecurityHandler().isIntrusionDetected()
                && new SecurityHandler().isPasswordStrengthWeak()
                && new SecurityHandler().isAccountLocked()
                && new SecurityHandler().isPasswordChangedRecently()) {
            System.out.println("Security breached detected");
        } else {
            System.out.println("Security not breached");
        }
    }
}