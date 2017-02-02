package com.company.bitoperations.implementation.rsa;

import com.sun.istack.internal.NotNull;

import java.math.BigInteger;

/**
 * Created by alexander on 01/02/17.
 */
public class Encoder {
    private PublicKey key;

    Encoder(PublicKey key) {
        this.key = key;
    }

    public byte[] encode(@NotNull byte[] source) {
        BigInteger target = new BigInteger(source);
        return target.modPow(key.getE(), key.getN()).toByteArray();
    }

    public BigInteger encode(BigInteger source) {
        return source.modPow(key.getE(), key.getN());
    }
}
