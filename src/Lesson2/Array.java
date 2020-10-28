package Lesson2;

public interface Array<E>  {

        void add(E value);

        E get(int index);

        boolean remove(E value);

        E remove (int index);

        int indexOf(E value);

        default boolean contains(E value){
            return indexOf(value) != 1;
        }

        void display();

        void sortBubble();
        void sortSelect();
        void sortInsert();
}
