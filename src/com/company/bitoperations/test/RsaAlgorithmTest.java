package com.company.bitoperations.test;

import com.company.bitoperations.implementation.rsa.Decoder;
import com.company.bitoperations.implementation.rsa.Encoder;
import com.company.bitoperations.implementation.rsa.RsaAlgorithm;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by alexander on 02/02/17.
 */
class RsaAlgorithmTest {
    @Test
    void testRsaAlgorithmWithBigNumbers() {
        RsaAlgorithm rsaAlgorithm = new RsaAlgorithm();
        Decoder decoder = rsaAlgorithm.createDecoder();
        Encoder encoder = rsaAlgorithm.createEncoder(decoder.getPublicKey());
        BigInteger message = BigInteger.TEN;

        BigInteger encodedMessage = encoder.encode(message);
        BigInteger decodedMessage = decoder.decode(encodedMessage);

        assertEquals(message, decodedMessage);
    }

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

        byte[] encodedMessage = encoder.encode(message.getBytes());
        String decodedMessage = new String(decoder.decode(encodedMessage));

        assertEquals(message, decodedMessage);
    }
}