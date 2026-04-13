import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_19856_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            XMLDecoder decoder = new XMLDecoder(new FileInputStream("injection.xml"));
            decodeObject(decoder);
            decoder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void decodeObject(XMLDecoder decoder) {
        Injection obj = (Injection) decoder.readObject();
        obj.process();
    }

    public static class Injection {
        private String sensitiveData;

        public void setSensitiveData(String sensitiveData) {
            this.sensitiveData = sensitiveData;
        }

        public void process() {
            System.out.println("Processing sensitive data: " + this.sensitiveData);
        }
    }
}