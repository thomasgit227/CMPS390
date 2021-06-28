package Heaps;

public class Main {
    public static void main(String[] args) {
        int[] myArr = {10, 3, 21, 8, 2, 15, 19};
        Heap myHeap = new Heap(myArr);
        myHeap.heapSort();
        // myHeap.printHeap();
        myHeap.printTree();
    }
}