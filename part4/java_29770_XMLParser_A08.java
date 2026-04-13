import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class java_29770_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            parseXML("sample.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (token.startsWith("<int>") && st.hasMoreTokens()) {
                    String value = st.nextToken();
                    if (value.matches("[0-9]+")) {
                        System.out.println("Integer: " + value);
                    } else {
                        System.out.println("Error: Invalid integer value: " + value);
                    }
                } else if (token.equalsIgnoreCase("</int>")) {
                    System.out.println("End of integer tag");
                } else {
                    System.out.println("Error: Unrecognized tag: " + token);
                }
            }
        }
        br.close();
    }
}