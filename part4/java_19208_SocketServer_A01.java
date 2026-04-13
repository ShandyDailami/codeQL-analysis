import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_19208_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 4444;
        Socket serverSocket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            serverSocket = new Socket("localhost", port);
            in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            out = new PrintWriter(serverSocket.getOutputStream(), true);

            String userInput;
            while (true) {
                userInput = in.readLine();
                System.out.println("Received: " + userInput);

                // Let's simulate an unauthorized user trying to access the server.
                if (userInput.equals("try_access")) {
                    System.out.println("Access denied!");
                    out.println("Access denied");
                    out.flush();
                } else {
                    System.out.println("Access granted!");
                    out.println("Access granted");
                    out.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (serverSocket != null) serverSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}