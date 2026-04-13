import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_03018_SocketServer_A03 {
    private static final String PASSWORD = "secure";

    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;
        Socket connection = null;

        try {
            SSLServerSocket server = (SSLServerSocket) new SSLServerSocket(8080);
            server.setNeedClientAuth(true);

            System.out.println("Waiting for client...");

            connection = server.accept();

            System.out.println("Connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
           
                if (inputLine.equals(PASSWORD)) {
                    PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
                    out.println("Hello Client, Welcome to Secure Server!");
                } else {
                    PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
                    out.println("Access Denied, Password does not match!");
                }
            }
        } finally {
            connection.close();
            socket.close();
        }
    }
}