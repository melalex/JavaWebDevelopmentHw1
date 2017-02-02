package com.company.bitoperations.implementation.rsa;

import com.sun.istack.internal.NotNull;

import java.math.BigInteger;

/**
 * Created by alexander on 01/02/17.
 */
public class PublicKey {
    private final BigInteger E;
    private final BigInteger N;

    PublicKey(@NotNull BigInteger e, @NotNull BigInteger n) {
        this.E = e;
        this.N = n;
    }

    BigInteger getE() {
        return E;
    }

    BigInteger getN() {
        return N;
    }
}
