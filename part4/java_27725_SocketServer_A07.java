import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_27725_SocketServer_A07 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String request;
            while ((request = in.readLine()) != null) {
                if (request.equals("A07_AuthFailure")) {
                    out.println("A07_AuthSuccess");
                } else {
                    out.println("Invalid request");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}