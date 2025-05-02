package com.ohgiraffers.section04.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Practice1 {

    public String solution(int n, int k) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder("<");

        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }

            sb.append(queue.poll());

            if(!queue.isEmpty()) sb.append(", ");
        }

        sb.append(">");
        return sb.toString();
    }
}
