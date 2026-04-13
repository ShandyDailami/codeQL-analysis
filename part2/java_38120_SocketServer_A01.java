import java.io.*;
import java.net.*;
import java.util.*;

public class java_38120_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);

        while(true) {
            Socket sock = server.accept();

            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                out.println("Handshake successful");
            }

            sock.close();
        }
    }
}