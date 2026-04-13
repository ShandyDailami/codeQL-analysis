import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_19191_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        SSLServerSocket sslServer = (SSLServerSocket) server;

        while (true) {
            SSLSocket socket = (SSLSocket) sslServer.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("Hello, client, you connected to our secure server!");

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
           
                // For security sensitive operations, add code here.
                // You may want to validate the message, check for SQL Injection,
                // or any other type of attack

                out.println("Server: " + message);
            }
        }
    }
}