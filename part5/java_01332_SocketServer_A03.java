import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01332_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        int port = 5000; // you can set your port number
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting for client on port " + port);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client");

            // Read and write operations
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String input;
            while ((input = in.readLine()) != null) {
                System.out.println("Received: " + input);
                out.println("Echo: " + input);
            }
            clientSocket.close();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}