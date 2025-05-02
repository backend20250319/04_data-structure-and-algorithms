package com.ohgiraffers.section03.stack;

import java.util.Stack;

public class Practice2 {

    public int solution(String input) {

        int count = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') stack.push(input.charAt(i));
            else {
                stack.pop();
                if (input.charAt(i - 1) == '(' ) count += stack.size();
                else count++;
            }
        }

        return count;
    }
}
