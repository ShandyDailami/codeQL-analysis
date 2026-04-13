import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class java_13073_SocketServer_A08 {

    public static void main(String[] args) throws IOException {

        // Create a server socket
        Socket socket = new Socket("localhost", 9000);

        // Get the output stream from the socket
        OutputStream outputStream = socket.getOutputStream();

        // Write a message to the socket
        outputStream.write("Hello, client!".getBytes());

        // Close the output stream
        outputStream.close();

        // Close the socket
        socket.close();
    }
}