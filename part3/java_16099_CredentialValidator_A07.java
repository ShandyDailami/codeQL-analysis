import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16099_CredentialValidator_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234); // Creating a server socket
        System.out.println("Waiting for client...");

        while (true) {
            Socket socket = serverSocket.accept(); // Accepting a client socket
            System.out.println("Client accepted: " + socket.getInetAddress().getHostAddress());

            BufferedReader reader = new BufferedReader(socket.getInputStream()); // Getting a reader from the input stream
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true); // Getting a writer to the output stream

            String clientMessage = reader.readLine(); // Reading a client message
            System.out.println("Client message: " + clientMessage);

            // Here you can add your own logic to validate the client's credentials
            // In this example, we just validate that the client's IP address is not null or empty
            if (InetAddress.getLocalHost().getHostAddress().isEmpty()) {
                writer.println("Invalid Credentials");
            } else {
                writer.println("Valid Credentials");
            }

            socket.close(); // Closing the socket
        }
    }
}