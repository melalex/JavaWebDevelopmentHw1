package com.room414.homework1.rsa.datastructures;

import com.room414.homework1.rsa.cryptosystem.Encoder;

import java.math.BigInteger;

/**
 * Stores public key that used to encode message in Encoder
 * @see Encoder
 *
 * Created by alexander on 01/02/17.
 */
public class PublicKey {
    private final BigInteger E;
    private final BigInteger N;

    public PublicKey(BigInteger e, BigInteger n) {
        this.E = e;
        this.N = n;
    }

    public BigInteger getE() {
        return E;
    }

    public BigInteger getN() {
        return N;
    }
}
