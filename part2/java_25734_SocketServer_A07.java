import java.net.*;
import java.util.*;
import java.io.*;
import java.security.*;

public class java_25734_SocketServer_A07 {
    private static final String HASH_ALGORITHM = "MD5";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received message: " + clientMessage);

            String serverMessage = authenticateUser(clientMessage);
            out.writeUTF(serverMessage);
            out.flush();

            socket.close();
        }
    }

    private static String authenticateUser(String username) throws NoSuchAlgorithmException, NoSuchProviderException {
        String hashedPassword = getHashedPassword(username);
        return hashedPassword;
    }

    private static String getHashedPassword(String password) throws NoSuchAlgorithmException, NoSuchProviderException {
        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
        md.update(password.getBytes());
        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}