import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09636_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            // Create a ServerSocket that listens on port 8080
            ServerSocket serverSocket = new ServerSocket(8080);

            while (true) {
                // Accept a connection
                Socket clientSocket = serverSocket.accept();

                // Get an output stream to write data to the client
                OutputStream outputStream = clientSocket.getOutputStream();

                // Send a message back to the client
                outputStream.write("Hello, client!\n".getBytes());

                // Close the output stream
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}