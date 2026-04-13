import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08295_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Step 1: Create a server socket
        ServerSocket serverSocket = new ServerSocket(5000);

        // Step 2: Accept a client socket
        Socket socket = serverSocket.accept();

        // Step 3: Create input and output streams
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Step 4: Receive and send data
        String input;
        while ((input = in.readLine()) != null) {
            out.println("Echo: " + input);
        }

        // Close the streams
        out.close();
        in.close();

        // Close the socket
        socket.close();
        serverSocket.close();
    }
}