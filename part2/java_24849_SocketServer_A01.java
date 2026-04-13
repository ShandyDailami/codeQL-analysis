import java.io.*;
import java.net.*;

public class java_24849_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        int port = 12345;
        ServerSocket server = new ServerSocket(port);
        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
           
            }
            out.close();
            in.close();
            client.close();
        }
    }
}