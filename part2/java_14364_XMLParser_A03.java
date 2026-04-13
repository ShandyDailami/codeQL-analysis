import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXParseException;

public class java_14364_XMLParser_A03 {

    private MessageDigest md;

    public java_14364_XMLParser_A03() throws NoSuchAlgorithmException {
        md = MessageDigest.getInstance("SHA-1");
    }

    public String hash(String input) {
        byte[] inputBytes = input.getBytes();
        md.reset();
        byte[] digestBytes = md.digest(inputBytes);
        return bytesToHex(digestBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Character.forDigit((bytes[i] >> 4) & 0xf, 16));
            sb.append(Character.forDigit(bytes[i] & 0xf, 16));
        }
        return sb.toString();
    }

    public void parse(String filename) throws FileNotFoundException, SAXException {
        File file = new File(filename);
        if (file.exists() && file.canRead()) {
            FileInputStream fis = new FileInputStream(file);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XMLContentHandler(this));
            reader.parse(new InputSource(fis));
            fis.close();
        } else {
            throw new FileNotFoundException("File not found: " + filename);
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException, SAXException {
        InjectionSafeXMLParser parser = new InjectionSafeXMLParser();
        parser.parse("somelargexmlfile.xml");
    }
}