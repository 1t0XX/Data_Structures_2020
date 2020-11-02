package Lesson3;

import Lesson3.myqueue.QueueImpl;
import Lesson3.mystack.Stack;
import Lesson3.mystack.StackImpl;

import java.util.Queue;


public class Test {

    public static void main(String[] args) {
//        testStack();
        testQueue();
    }

    private static void testStack() {
        Stack<Integer> stack = new StackImpl<>(5);

        System.out.println("Add value 1: " + addToStack(stack, 1));
        System.out.println("Add value 2: " + addToStack(stack, 2));
        System.out.println("Add value 3: " + addToStack(stack, 3));
        System.out.println("Add value 4: " + addToStack(stack, 4));
        System.out.println("Add value 5: " + addToStack(stack, 5));
        System.out.println("Add value 6: " + addToStack(stack, 6));

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static boolean addToStack(Stack<Integer> stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }
        return false;
    }

   private static void testQueue() {
       Queue<Integer> queue = new QueueImpl<>(5);
     //   Queue<Integer> queue = new PriorityQueue<>(5);
        System.out.println(((QueueImpl) queue).insert(3));
        System.out.println(((QueueImpl) queue).insert(5));
        System.out.println(((QueueImpl) queue).insert(1));
        System.out.println(((QueueImpl) queue).insert(2));
        System.out.println(((QueueImpl) queue).insert(6));
        System.out.println(((QueueImpl) queue).insert(4));

        System.out.println("Queue peek: " + ((QueueImpl) queue).peekHead());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + ((QueueImpl) queue).isFull());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}

