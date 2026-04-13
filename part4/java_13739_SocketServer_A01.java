import java.io.*;
import java.net.*;

public class java_13739_SocketServer_A01 {
    private static int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;

            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // This is a simple echo service, you could implement a more complex
                // protocol here.
                out.println("ECHO: " + message);
           
                // Adding a delay to simulate a security issue.
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            socket.close();
        }
    }
}