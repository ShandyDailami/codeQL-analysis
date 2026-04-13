import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_38208_XMLParser_A03 {

    private static final String ALGORITHM = "SHA-256";

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(false);

            InputStream inputStream = new FileInputStream("path_to_your_file.xml");
            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(inputStream, saxHandler);

            List<String> hashedPasswords = saxHandler.getHashedPasswords();
            System.out.println("Hashed Passwords: " + hashedPasswords);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class SAXHandler implements org.xml.sax.helpers.DefaultHandler {

        private List<String> hashedPasswords = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
            if ("password".equals(qName)) {
                String password = attributes.getValue("password");
                String hashedPassword = hashPassword(password);
                hashedPasswords.add(hashedPassword);
            }
        }

        private String hashPassword(String password) {
            MessageDigest messageDigest;
            try {
                messageDigest = MessageDigest.getInstance(ALGORITHM);
                byte[] passwordBytes = password.getBytes();
                byte[] hashBytes = messageDigest.digest(passwordBytes);
                return convertByteArrayToHexString(hashBytes);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }

        private String convertByteArrayToHexString(byte[] bytes) {
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : bytes) {
                stringBuilder.append(String.format("%02x", b));
            }
            return stringBuilder.toString();
        }

        public List<String> getHashedPasswords() {
            return hashedPasswords;
        }
    }
}