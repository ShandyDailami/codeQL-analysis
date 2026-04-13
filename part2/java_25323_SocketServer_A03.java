import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25323_SocketServer_A03 {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(1234); // port number is arbitrary
        System.out.println("Waiting for client on port 1234");

        while (true) {

            Socket socket = serverSocket.accept(); // waits for client to connect
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;

            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // This is a simple example of injection, in a real application,
                // you should avoid this kind of injection if possible
                String command = message + "command";

                out.println(command);
            }

            socket.close();
        }
    }
}