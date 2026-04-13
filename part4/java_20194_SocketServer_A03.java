import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_20194_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        // Creating socket on port 12345
        Socket socket = new Socket("localhost", 12345);

        // Getting read and write streams from socket
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        // Sending a request
        writer.println("Hello, client!");

        // Reading the response
        String response = reader.readLine();
        System.out.println("Server response: " + response);

        // Closing connection
        writer.close();
        reader.close();
        socket.close();
    }
}