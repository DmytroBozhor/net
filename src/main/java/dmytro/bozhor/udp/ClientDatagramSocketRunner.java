package dmytro.bozhor.udp;

import java.io.IOException;
import java.net.*;

public class ClientDatagramSocketRunner {

    public static void main(String[] args) throws IOException {
        var inetAddress = Inet4Address.getByName("localhost");
        var buffer = "Message from client via UDP protocol".getBytes();
        try (var datagramSocket = new DatagramSocket()) {
            var datagramPacket = new DatagramPacket(buffer, buffer.length, inetAddress, 7777);
            datagramSocket.send(datagramPacket);
        }
    }
}
