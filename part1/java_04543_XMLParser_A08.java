import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class java_04543_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";

        // Write to XML
        OutputStream out = new FileOutputStream(xmlFile);
        XMLEncoder encoder = new XMLEncoder(out);
        encoder.writeObject(createSampleObject());
        encoder.close();
        out.close();

        // Read from XML
        InputStream in = new FileInputStream(xmlFile);
        XMLDecoder decoder = new XMLDecoder(in);
        SampleObject sampleObject = (SampleObject) decoder.readObject();
        decoder.close();
        in.close();

        System.out.println(sampleObject);
    }

    private static SampleObject createSampleObject() {
        return new SampleObject("Hello, World!");
    }

    // Sample object
    public static class SampleObject {
        private String message;

        public java_04543_XMLParser_A08(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "SampleObject: " + message;
        }
    }

}