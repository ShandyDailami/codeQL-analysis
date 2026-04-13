import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

public class java_02264_XMLParser_A08 {

    public static void main(String[] args) throws Exception {
        String urlStr = "http://www.example.com/sample.xml";
        String outputUrlStr = "http://www.example.com/output.xml";
        String userName = "username";
        String password = "password";

        URL url = new URL(urlStr);
        URL outputUrl = new URL(outputUrlStr);

        // setup connection
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((userName + ":" + password).getBytes()));

        // setup output stream
        FileOutputStream fos = new FileOutputStream(outputUrl.toString().substring(outputUrl.toString().lastIndexOf("/") + 1));

        // setup reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        // read and write
        String line;
        while ((line = reader.readLine()) != null) {
            fos.write((line + "\n").getBytes());
        }

        // close streams
        reader.close();
        fos.close();
    }
}