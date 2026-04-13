import java.io.*;
import java.net.*;
import java.util.*;

public class java_16807_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();

            // Use Basic Authentication
            String auth = "Basic " + Base64.getEncoder().encodeToString("username:password".getBytes());
            socket.setRequestProperty("Authorization", auth);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Received: " + line);
            }
            socket.close();
        }
    }
}