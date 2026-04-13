import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_35181_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        // Create SSL Server Socket
        serverSocket = (SSLServerSocket) new SSLServerSocket(4444);
        socket = (SSLSocket) serverSocket.accept();

        // Get input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String inputLine;

        // Read message from client
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            out.println("Server: Hello, you wrote: " + inputLine);
        }

        // Close the connection
        socket.close();
        serverSocket.close();
    }
}