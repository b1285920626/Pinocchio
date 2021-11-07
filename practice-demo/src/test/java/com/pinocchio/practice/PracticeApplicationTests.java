package com.pinocchio.practice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pinocchio.practice.leetcode.Solution;


class PracticeApplicationTests {

    @Test
    void myTest() {
        System.out.println(Solution.fib(1));
        System.out.println(Solution.fib(2));
        System.out.println(Solution.fib(4));
        System.out.println(Solution.fib(5));
        System.out.println(Solution.fib(44));
    }


}
