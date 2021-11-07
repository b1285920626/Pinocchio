package com.pinocchio.practice.leetcode;

import com.pinocchio.practice.leetcode.domain.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * <p>
     * F(0) = 0, F(1)= 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 直接递归会超时, 这里按照参考用了滑动数组
     *
     * @param n 输入n
     * @return 返回第n项
     */
    public static int fib(int n) {
        int[] array = new int[3];

        int a = 0;
        int b = 1;
        int c;

        array[a] = 0;
        array[b] = 1;

        for (int i = 2; i < n + 1; i++) {
            c = i % 3;

            array[c] = array[a] + array[b];
            a = (a + 1) % 3;
            b = (b + 1) % 3;

            if (array[c] > 1000000007) {
                array[c] = array[c] % 1000000007;
            }
        }

        return array[n % 3];
    }

    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     *
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 两数之和
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int surplus = 0;

        ListNode result = new ListNode();
        ListNode header = result;

        int temp = l1.val + l2.val;
        if (temp >= 10) {
            temp = temp % 10;
            surplus = 1;
        }
        header.val = temp;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            temp = l1.val + l2.val;
            if (surplus == 1) {
                temp += 1;
                surplus = 0;
            }

            if (temp >= 10) {
                temp = temp % 10;
                surplus = 1;
            }

            header.next = new ListNode(temp);
            header = header.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            header.next = l1;
        }
        else if (l2 != null) {
            header.next = l2;
        }
        else {
            if (surplus == 1) {
                header.next = new ListNode(1);
            }

            return result;
        }

        if (surplus == 1) {
            header.next.val++;
            header = header.next;
        }

        while (header.val >= 10)
        {
            header.val = header.val % 10;
            if(header.next == null)
            {
                header.next = new ListNode(1);
            }
            else
            {
                header.next.val++;
            }

            header = header.next;
        }

        return result;
    }

}
