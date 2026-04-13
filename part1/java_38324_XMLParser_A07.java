import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_38324_XMLParser_A07 {

    private static final String FILE_PATH = "path_to_your_file.zip";
    private static final String SECRET_KEY = "your_secret_key";
    private static final String SHA1 = "SHA-1";

    public static void main(String[] args) {
        try {
            parseFile();
        } catch (NoSuchAlgorithmException | ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseFile() throws NoSuchAlgorithmException, ParserConfigurationException, SAXException, IOException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser(null);
        XMLHandler xh = new XMLHandler();
        sp.parse(new File(FILE_PATH), xh);
    }

    private static String getFileMD5(String filename) {
        File file = new File(filename);
        MessageDigest md;
        byte[] bytes = new byte[(int) file.length()];
        try {
            md = MessageDigest.getInstance(SHA1);
            FileInputStream fis = new FileInputStream(file);
            fis.read(bytes);
            fis.close();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return null;
        }
        return bytesToHex(md.digest(bytes));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toHexString((bytes[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    public static class XMLHandler extends DefaultHandler {

        private List<String> entries = new ArrayList<String>();
        private String currentEntry;

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currentEntry = qName;
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals(currentEntry)) {
                entries.add(qName);
                currentEntry = null;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (currentEntry != null) {
                currentEntry += new String(ch, start, length);
            }
        }
    }
}