package com.cyberstudios.vpnlibrary.SSTP;


/**
 * Defines basic packet operations to enclose the {@link SSTPPacket.Builder#data} packet
 *
 * @author Charles Dyason
 */
public class Packet {

    /**
     * Enum defining packet types
     */
    enum PacketType {
        Data,
        Control
    }

    // Packet Type
    private PacketType packetType;

    /**
     * Default constructor
     */
    Packet(){ }

    /**
     * Sets the packet type of this packet
     * @param type {@link PacketType}
     */
    protected void setPacketType(PacketType type) {
        this.packetType = type;
    }

    public PacketType getPacketType(){
        return packetType;
    }

}
