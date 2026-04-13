import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05189_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // listen on port 8080
        while (true) {
            Socket client = server.accept(); // wait for a client to connect
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            OutputStream out = client.getOutputStream();

            String message = in.readLine(); // read a message from the client
            System.out.println("Received: " + message);

            out.write("Hello Client\n".getBytes()); // write a response back to the client
            out.flush();

            client.close();
        }
    }
}