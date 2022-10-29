package com.benggrea.springredisstrategy.web;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void test() {
        int[] arr = {1, 3, 4};
        arr[0] = arr[1] = 0;

        System.out.println(arr);

    }
}
