import java.net.*;
import java.io.*;

public class java_16196_SocketServer_A07 {
    public static void main(String args[]) {
        Socket sock;
        ServerSocket servSock;
        try {
            servSock = new ServerSocket(4242);
            System.out.println("Waiting for connection ...");
            sock = servSock.accept();
            System.out.println("Connected!");
            
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                // This is a basic authentication. 
                // In a real-world application, you would want to use SSL/TLS and possibly a secure socket layer.
                if ("authFailure".equals(inputLine)) {
                    out.println("Server: Auth failure, closing connection.");
                    sock.close();
                    servSock.close();
                    System.out.println("Connection closed!");
                    return;
                }
                out.println("Server: Server received!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}