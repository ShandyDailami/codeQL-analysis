import java.net.*;
import java.io.*;

public class java_08119_SocketServer_A01 {
    public static void main(String[] args) {
        Socket sock;
        ServerSocket servSock;
        try {
            servSock = new ServerSocket(5000);
            System.out.println("Waiting for connection...");
            sock = servSock.accept();
            System.out.println("Connection established");
            InputStream is = sock.getInputStream();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(is));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Received: " + line);
            }
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}