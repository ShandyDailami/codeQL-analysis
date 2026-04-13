import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38855_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(0);
        serverSocket.setReuseAddress(true);

        System.out.println("Server listening on port " + serverSocket.getLocalPort());

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

            InetAddress clientAddress = clientSocket.getInetAddress();
            System.out.println("Client's IP address is " + clientAddress.getHostAddress());

            // Send a welcome message to the client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Welcome to the SecureServer!");

            // Create input and output stream for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                // Here you can do your injection protection, for example, check if the input contains SQL commands
                // If it does, you can prevent it from executing by sending an error message
                if (inputLine.contains(";") || inputLine.contains("--") || inputLine.contains("/*")) {
                    out.println("Error: Injection detected!");
                    out.flush();
                    clientSocket.close();
                    serverSocket.close();
                    return;
                }
                out.println("Echo: " + inputLine);
                out.flush();
            }
            clientSocket.close();
        }
    }
}