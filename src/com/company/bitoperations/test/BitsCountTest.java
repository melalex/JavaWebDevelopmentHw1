package com.company.bitoperations.test;

import com.company.bitoperations.implementation.BitsCount;
import org.junit.jupiter.api.Test;

/**
 * Created by alexander on 02/02/17.
 */
class BitsCountTest {
    @Test
    public void bitsCountTest() {
        assert BitsCount.byteBitCount() == 8;
        assert BitsCount.shortBitCount() == 16;
        assert BitsCount.intBitCount() == 32;
        assert BitsCount.longBitCount() == 64;
    }
}