import java.io.IOException;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class java_16498_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            // Create a new socket
            Socket socket = new Socket("localhost", 5000);

            // Get input and output streams
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Create a scanner for user input
            Scanner scanner = new Scanner(System.in);

            // Read a line from user
            System.out.println("Enter a message:");
            String message = scanner.nextLine();

            // Send the message to the server
            output.write(message.getBytes());

            // Read the server's response
            byte[] response = new byte[1024];
            input.read(response);
            System.out.println("Server's response: " + new String(response));

            // Close the resources
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}