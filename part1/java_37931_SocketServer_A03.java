import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37931_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started at port 5000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Here we use a simple way to perform a "command injection" attack.
                    // This is a very basic form of injection and should be used with caution.
                    if (message.contains("command=")) {
                        String command = message.substring(message.indexOf('&') + 1);
                        out.println("Executing command: " + command);
                    } else {
                        out.println("Unknown command");
                    }
                }

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}