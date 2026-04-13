import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class java_37165_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Create a socket for a server and a client
        Socket socket = new Socket("localhost", 1234);

        // Create input and output streams to read/write data
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // Read the client's username and password
        String clientUsername = input.readUTF();
        String clientPassword = input.readUTF();

        // Define the correct username and password
        String correctUsername = "admin";
        String correctPassword = "password";

        // Check if the client's credentials match the correct credentials
        if (clientUsername.equals(correctUsername) && clientPassword.equals(correctPassword)) {
            // Send a response back to the client if they're authenticated
            output.writeUTF("Authentication successful!");
        } else {
            // Send a response back to the client if they're not authenticated
            output.writeUTF("Authentication failed!");
        }

        // Close the streams and the socket
        input.close();
        output.close();
        socket.close();
    }
}