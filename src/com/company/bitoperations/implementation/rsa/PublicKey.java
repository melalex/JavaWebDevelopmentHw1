package com.company.bitoperations.implementation.rsa;

import java.math.BigInteger;

/**
 * Created by alexander on 01/02/17.
 */
public class PublicKey {
    private final BigInteger E;
    private final BigInteger N;

    PublicKey(BigInteger e, BigInteger n) {
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
