package com.room414.rsa;

import com.room414.rsa.datastructures.Chunks;
import com.room414.rsa.cryptosystem.Decoder;
import com.room414.rsa.cryptosystem.Encoder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by alexander on 02/02/17.
 */
class RsaAlgorithmTest {
    @Test
    void testRsaAlgorithmWithBigBytes() {
        RsaAlgorithm rsaAlgorithm = new RsaAlgorithm();
        Decoder decoder = rsaAlgorithm.createDecoder();
        Encoder encoder = rsaAlgorithm.createEncoder(decoder.getPublicKey());
        String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean bibendum magna ut nunc " +
                "tristique, quis malesuada justo volutpat. Donec augue neque, hendrerit quis nisi a, lacinia suscipit " +
                "lorem. Fusce ex nibh, sodales eu ipsum placerat, ultrices pretium lorem. Mauris hendrerit consequat " +
                "neque sagittis pretium. Morbi in metus et lacus rhoncus vestibulum eu a ligula. Etiam dictum, velit " +
                "id hendrerit pharetra, mi massa posuere quam, quis faucibus risus purus a tortor. Ut porta tempor " +
                "pellentesque. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos " +
                "himenaeos. Quisque sed orci nibh. Maecenas vitae mi ante. Vestibulum et massa eros. ";

        Chunks encodedMessage = encoder.encode(message.getBytes());
        String decodedMessage = new String(decoder.decode(encodedMessage));

        assertEquals(message, decodedMessage);
    }
}