import java.io.InputStream;
import java.util.Scanner;

public class java_07595_XMLParser_A03 {

    public static void main(String[] args) {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";
        parseXml(xml);
    }

    private static void parseXml(String xml) {
        try (InputStream in = new StringInputStream(xml)) {
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}