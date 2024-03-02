package dmytro.bozhor.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;

public class SocketRunner {
    public static void main(String[] args) throws IOException {

        var inetAddress = Inet4Address.getByName("localhost");

        try (var socket = new Socket(inetAddress, 7777);
             var response = new DataInputStream(socket.getInputStream());
             var request = new DataOutputStream(socket.getOutputStream())) {

            request.writeUTF("Hello world!");
            var serverResponseMessage = response.readUTF();
            System.out.println(serverResponseMessage);

//            var serverResponseMessage = request.readAllBytes();
//            System.out.println(new String(response));
        }

    }
}
