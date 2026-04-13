import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_35707_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket socketserver = new ServerSocket(8080);
        SSLServerSocket server = (SSLServerSocket) socketserver;
        server.setNeedClientAuth(true);

        System.out.println("Waiting for Client Connection....");

        SSLSocket socket = (SSLSocket) server.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        System.out.println("Client Connected");

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
            out.writeBytes(message + "\n");
       
            if (message.equalsIgnoreCase("exit")) {
                System.out.println("Client Exited");
                break;
            }
        }

        socket.close();
    }
}