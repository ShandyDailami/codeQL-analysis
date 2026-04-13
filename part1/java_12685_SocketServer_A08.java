import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12685_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Simulate integrity failure
                    if (message.equals("A08_IntegrityFailure")) {
                        out.println("A08_IntegrityFailure error occurred");
                    } else {
                        out.println("Received message: " + message);
                    }
                }

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}