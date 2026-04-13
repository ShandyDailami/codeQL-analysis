import org.xml.sax.SAXException;
import org.xml.sax.SAXReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;

public class java_09469_XMLParser_A08 {

    private static final SecureRandom secureRandom = new SecureRandom();

    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        DefaultHandler handler = new DefaultHandler();
        try {
            List<File> files = FileUtils.listFiles(new File("src/main/resources/"), new String[]{"xml"}, true);
            for (File file : files) {
                reader.setContentHandler(handler);
                reader.parse(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            sb.append(characters.charAt(secureRandom.nextInt(characters.length())));
        }
        return sb.toString();
    }

}