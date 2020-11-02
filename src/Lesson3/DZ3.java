package Lesson3;


import Lesson3.deque.Deque;
import Lesson3.deque.DequeImpl;
import Lesson3.mystack.Stack;
import Lesson3.mystack.StackImpl;

public class DZ3 {

    public static void main(String[] args) {

        //Создать программу, которая переворачивает вводимые строки (читает справа налево).


        String str = "abcd";

        System.out.println(new StringBuilder(str).reverse());

        Stack<Character> st = new StackImpl<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));
        }

        while ( !st.isEmpty() ) {
            System.out.print(st.pop());
        }
        System.out.println();

        if (true) {
            return;
        }



       // Создать класс для реализации дека.


        Deque<Integer> deq = new DequeImpl<>(6);

        deq.insertRight(1);
        deq.insertRight(2);
        deq.insertRight(3);
        // 1 2 3 4
        deq.insertRight(4);
        // 5 1 2 3 4
        deq.insertLeft(5);
        // 6 5 1 2 3 4
        deq.insertLeft(6);

        //5 1 2 3 4
        deq.removeLeft();
        // 5 1 2 3
        deq.removeRight();

//        displayLeftToRight(deq); // Queue
        displayRightToLeft(deq); //Stack
    }


    private static <E> void displayRightToLeft(Deque<E> deq) {
        while (!deq.isEmpty()) {
            System.out.println(deq.removeRight());
        }
    }

    private static <E> void displayLeftToRight(Deque<E> deq) {
        while (!deq.isEmpty()) {
            System.out.println(deq.removeLeft());
        }
    }
}

    }
}