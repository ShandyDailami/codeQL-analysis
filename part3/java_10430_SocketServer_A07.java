import java.io.*;
import java.net.*;

public class java_10430_SocketServer_A07 {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    public static boolean validateUser(String user, String password) {
        return USERNAME.equals(user) && PASSWORD.equals(password);
    }

    public static void handleRequest(Socket socket) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String userRequest = reader.readLine();
            String[] userDetails = userRequest.split(" ");

            if (userDetails.length != 2 || !validateUser(userDetails[0], userDetails[1])) {
                writer.println("Auth failure");
                return;
            }

            writer.println("Authenticated");

        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8189);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_10430_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        handleRequest(socket);
    }
}