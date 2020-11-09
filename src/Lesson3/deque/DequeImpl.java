package Lesson3.deque;

import Lesson3.myqueue.QueueImpl;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {


    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertLeft(E value) {
       if(isFull()){
           return false;
       }

       if(head==0){
           head= data.length;
       }

       data[--head] =value;
        size++;

        return true;
    }

    @Override
    public boolean insertRight(E value) {
        return super.insert(value);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {

        if(isFull()){
            return null;
        }

        if(tail<0) {
            tail = data.length - 1;
        }
            size--;
            return data[tail--];
        }

    }
