import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33085_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read the message from the client
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // perform security-sensitive operation related to integrity check failures
            if (!checkIntegrity(message)) {
                out.writeUTF("Failure in integrity check");
                System.out.println("Failure in integrity check, closing connection");
                socket.close();
                continue;
            }

            // send a response back to the client
            out.writeUTF("Successful message received");
        }
    }

    private static boolean checkIntegrity(String message) {
        // here you would implement the security-related operation such as integrity check
        // for example, calculate the hash of the message and compare it to a known value
        // return the result
        return false;
    }
}