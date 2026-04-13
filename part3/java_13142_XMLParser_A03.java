import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_13142_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SecurityHandler());
            parser.parse(new File("data.xml"), SecurityHandler.getHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SecurityHandler extends DefaultHandler {
        private static final String ALLOWED_TAGS[] = {"tag1", "tag2", "tag3"};

        public boolean handleStartTag(int startTag, String tag, Attributes attributes) {
            if (tag == null) {
                return false;
            }
            for (String allowedTag : ALLOWED_TAGS) {
                if (allowedTag.equals(tag)) {
                    return true;
                }
            }
            System.out.println("Detected attempt to inject data into " + tag);
            return false;
        }
    }
}