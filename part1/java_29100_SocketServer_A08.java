import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_29100_SocketServer_A08 {

    private static boolean isSecure = false;

    public static void main(String[] args) throws Exception {
        if (args.length > 0 && args[0].equals("secure")) {
            isSecure = true;
        }

        if (isSecure) {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(8080);
            System.out.println("Listening on port 8080...");
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected!");
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);
                    out.println("Hello, client");
                }
                clientSocket.close();
            }
        } else {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Listening on port 8080...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);
                    out.println("Hello, client");
                }
                clientSocket.close();
            }
        }
    }
}