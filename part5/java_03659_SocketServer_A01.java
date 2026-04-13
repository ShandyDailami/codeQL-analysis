import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03659_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(5454, null, null, null);
            System.out.println("Server started");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                SSLSocket sslSocket = (SSLSocket) clientSocket.createChannel(clientSocket.getChannel().getTransport().getSocket());
                sslSocket.startHandshake();
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Client says: " + request);
                    out.println("Server says: Hello, Client!");
                    out.flush();
                }
                sslSocket.close();
                System.out.println("Client disconnected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
            System.out.println("Server stopped");
        }
    }
}