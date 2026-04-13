import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class java_02463_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234); // port number is arbitrary
            System.out.println("Server listening on port 1234");
            Socket client = server.accept();
            System.out.println("Client connected");

            // read from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String request = in.readLine();
            System.out.println("Client says: " + request);

            // send a response
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Hello, client, thanks for connecting!");

            // close the connection
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}