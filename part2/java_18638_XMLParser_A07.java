import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_18638_XMLParser_A07 {

    private AuthFailureListener authFailureListener;
    private XMLReader reader;

    public java_18638_XMLParser_A07(AuthFailureListener authFailureListener) {
        this.authFailureListener = authFailureListener;
        try {
            this.reader = XMLReaderFactory.createXMLReader();
            this.reader.setContentHandler(new AuthFailureContentHandler(authFailureListener));
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public void parse(File xmlFile) {
        try {
            this.reader.parse(xmlFile);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AuthFailureXMLParser parser = new AuthFailureXMLParser(new AuthFailureListener() {
            @Override
            public void authFailureDetected(String errorMessage) {
                System.out.println("AuthFailure: " + errorMessage);
            }
        });
        parser.parse(new File("src/main/resources/auth_failure.xml"));
    }
}