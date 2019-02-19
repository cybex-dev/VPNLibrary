package com.cyberstudios.vpnlibrary.SSTP;

import com.cyberstudios.vpnlibrary.interfaces.PacketBuilder;

public class SSTPPacket {

    // VERSION 16 in binary is  0001 0000
    // this resembles SSTP (v)     1.   0
    public static final byte VERSION = 16;

    enum PacketType {
        Control(1),
        Data(0);

        int type = 0;

        PacketType(int i) {
            this.type = i;
        }
    }

    /**
     * SSTP Packet factory
     */
    class Builder implements PacketBuilder<SSTPPacket> {

        // reserved for future use, must be 0;
        byte reserved = 0;

        // Contains the packet data to be sent
        private Packet data;

        private Builder setVersion(){
            byte version = VERSION;
            return this;
        }

        @Override
        public SSTPPacket build() {
            return null;
        }


    }

    public class ControlPacket extends Packet {

    }

    public class DataPacket extends Packet {

    }
}
