import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_03214_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 8080; // Change port number as needed
        Socket serverSocket = null;
        try {
            serverSocket = new Socket("localhost", port);
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            String serverMessage;
            while ((serverMessage = in.readLine()) != null) {
                System.out.println("Server: " + serverMessage);
                // This is a placeholder for real-world security-sensitive operations.
                String clientMessage = "Hello, client";
                out.println(clientMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}