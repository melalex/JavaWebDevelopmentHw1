package com.company.bitoperations.implementation.rsa;


import java.math.BigInteger;
import java.util.Random;

/**
 * Created by alexander on 31/01/17.
 */
public class RsaAlgorithm {
    private static final int BIT_LENGTH = 1024;

    private BigInteger p;
    private BigInteger q;

    public RsaAlgorithm() {
        p = BigInteger.probablePrime(BIT_LENGTH, new Random());
        q = BigInteger.probablePrime(BIT_LENGTH, new Random());
    }

    public RsaAlgorithm(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
    }

    public Decoder createDecoder() {
        return new Decoder(p, q);
    }

    public Encoder createEncoder(PublicKey key) {
        return new Encoder(key);
    }
}
