import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_25345_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected...");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String clientInput;

                while ((clientInput = in.readLine()) != null) {
                    System.out.println("Received: " + clientInput);

                    // Perform security-sensitive operations related to injection.
                    // For instance, a command injection attack:
                    if (clientInput.contains("command=")) {
                        String command = clientInput.split("command=")[1];
                        System.out.println("Running command: " + command);
                    }

                    out.println("Server response: Hello, client!");
                }

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}