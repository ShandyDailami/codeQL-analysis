import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17315_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client is connected");

                // Creating new thread for each client
                Thread thread = new Thread(new SocketHandler(clientSocket));
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {

    private Socket clientSocket;

    public java_17315_SocketServer_A08(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // TODO: Implement security-sensitive operations related to A08_IntegrityFailure
            }

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}