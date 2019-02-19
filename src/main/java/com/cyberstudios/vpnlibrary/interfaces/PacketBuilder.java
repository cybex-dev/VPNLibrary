package com.cyberstudios.vpnlibrary.interfaces;

/**
 * Allows a packet to be built of type T
 * @param <T> enclosing class
 *
 * @author Charles Dyason
 */
public interface PacketBuilder<T> {

    /**
     * Defines the build procedure of a packet.
     * @return type T
     */
    T build();
}
