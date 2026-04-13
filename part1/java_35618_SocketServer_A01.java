import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_35618_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // create a new Socket for a specific port (e.g. 8080)
        Socket socket = new Socket("localhost", 8080);

        // get the input stream from the socket
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // get the output stream from the socket
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        // read the response from the server
        String response = reader.readLine();
        System.out.println("Server response: " + response);

        // close the streams and the socket
        reader.close();
        writer.close();
        socket.close();
    }
}