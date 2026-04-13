import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class java_11176_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            String fileName = "example.xml";
            File file = new File(fileName);
            InputStream inputStream = new FileInputStream(file);
            parse(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parse(InputStream inputStream) throws XMLStreamException, NoSuchAlgorithmException {
        XMLStreamReader streamReader = XMLStreamReader.newReader(inputStream);
        while (streamReader.hasNext()) {
            int event = streamReader.next();
            if (event == XMLStreamConstants.START_DOCUMENT) {
                System.out.println("Start document");
            } else if (event == XMLStreamConstants.START_ELEMENT) {
                String elementName = streamReader.getLocalName();
                if (elementName.equals("node")) {
                    if (!isAuthFailure(streamReader)) {
                        System.out.println("Node element found, not an auth failure");
                    }
                }
            } else if (event == XMLStreamConstants.END_DOCUMENT) {
                System.out.println("End document");
            }
        }
    }

    private static boolean isAuthFailure(XMLStreamReader streamReader) throws XMLStreamException, NoSuchAlgorithmException {
        if (streamReader.getEventType() != XMLStreamConstants.START_ELEMENT)
            return false;

        String elementName = streamReader.getLocalName();
        if (elementName.equals("AuthFailure")) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int bytesNumRead = 0;
            while ((bytesNumRead = streamReader.read(buffer)) != -1) {
                md.update(buffer, 0, bytesNumRead);
            }
            byte[] digest = md.digest();
            String securePassword = Base64.getEncoder().encodeToString(digest);

            // Here you should check if the securePassword is equal to some secure password
            // This is just a simple example and in real world scenario, securePassword should be compared with some stored secure password
            return securePassword.equals("someSecurePassword");
        }
        return false;
    }
}