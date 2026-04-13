import java.io.*;
import java.net.*;

public class java_31668_SocketServer_A01 {
    private static int port = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            while(true) {
                Socket client = server.accept();
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String inputLine;
                while((inputLine = in.readLine()) != null) {
                    out.println("Server received: " + inputLine);
                    out.flush();
                }
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}