package com.company.bitoperations.test;

import com.company.bitoperations.implementation.counter.BitCounter;
import org.junit.jupiter.api.Test;

/**
 * Created by alexander on 02/02/17.
 */
class BitCounterTest {
    @Test
    public void bitsCountTest() {
        assert BitCounter.byteBitCount() == 8;
        assert BitCounter.shortBitCount() == 16;
        assert BitCounter.intBitCount() == 32;
        assert BitCounter.longBitCount() == 64;
    }
}