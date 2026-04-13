import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class java_38272_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        // Create a new socket for the client
        Socket socket = new Socket("localhost", 5000);

        // Get the output stream from the socket
        OutputStream outputStream = socket.getOutputStream();

        // Wrap the output stream into a PrintWriter
        PrintWriter writer = new PrintWriter(outputStream, true);

        // Send a message to the client
        writer.println("Hello, client!");

        // Close the socket
        socket.close();
    }
}