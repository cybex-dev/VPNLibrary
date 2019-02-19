package com.cyberstudios.vpnlibrary.SSTP;

import com.cyberstudios.vpnlibrary.interfaces.PacketBuilder;

public class SSTPPacket {

    public static final int SSTP_VERSION = 10;

    /**
     * Constant defining a SSTP control packet
     */
    public static final int SSTP_PACKET_TYPE_CONTROL = 1;

    /**
     * Constant defining a SSTP data packet
     */
    public static final int SSTP_PACKET_TYPE_DATA = 0;

    /**
     * SSTP Packet factory
     */
    class Builder implements PacketBuilder<SSTPPacket> {

        // reserved for future use, must be 0;
        byte reserved = 0;

        // Contains the packet data to be sent
        private Packet data;

        private Builder setVersion(){
            byte version = SSTP_VERSION;
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
