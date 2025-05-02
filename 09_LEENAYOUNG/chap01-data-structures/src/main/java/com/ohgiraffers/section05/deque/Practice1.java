package com.ohgiraffers.section05.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Practice1 {

    static class Balloon {
        int order;
        int noteValue;

        Balloon(int order, int noteValue) {
            this.order = order;
            this.noteValue = noteValue;
        }
    }

    public String solution(Integer[] notes) {

        Deque<Balloon> deque = new ArrayDeque<>();

        for (int i = 0; i < notes.length; i++) {
            deque.add(new Balloon(i + 1, notes[i]));
        }

        StringBuilder sb = new StringBuilder();

        Balloon balloon = deque.removeFirst();
        sb.append(balloon.order).append(" ");

        while (!deque.isEmpty()) {
            int num = balloon.noteValue;

            if (num < 0){
                for (int i = num; i < 0; i++){
                    deque.addFirst(deque.removeLast());
                }
            } else {
                for (int i = 0; i < num - 1; i++){
                    deque.addLast(deque.removeFirst());
                }
            }
            balloon = deque.removeFirst();
            sb.append(balloon.order).append(" ");
        }

        return sb.toString().trim();
    }
}
