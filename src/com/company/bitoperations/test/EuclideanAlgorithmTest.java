package com.company.bitoperations.test;

import com.company.bitoperations.implementation.EuclideanAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by alexander on 31/01/17.
 */
class EuclideanAlgorithmTest {
    @Test
    void findGsd() {
        int testA = 1;
        int testB = 10;
        int testResult = 1;

        assert EuclideanAlgorithm.findGsd(testA, testB) == testResult;

        testA = 5;
        testB = 10;
        testResult = 5;

        assert EuclideanAlgorithm.findGsd(testA, testB) == testResult;

        testA = 24;
        testB = 24;
        testResult = 24;

        assert EuclideanAlgorithm.findGsd(testA, testB) == testResult;

        testA = 0;
        testB = 0;
        testResult = 0;

        assert EuclideanAlgorithm.findGsd(testA, testB) == testResult;

        testA = 5;
        testB = 10;
        testResult = 5;

        assert EuclideanAlgorithm.findGsd(testA, testB) == testResult;

        testA = 5;
        testB = 0;
        testResult = 5;

        assert EuclideanAlgorithm.findGsd(testA, testB) == testResult;

        testA = 0;
        testB = 15;
        testResult = 15;

        assert EuclideanAlgorithm.findGsd(testA, testB) == testResult;

        testA = -5;
        testB = 10;
        testResult = 5;

        assert EuclideanAlgorithm.findGsd(testA, testB) == testResult;
    }

}