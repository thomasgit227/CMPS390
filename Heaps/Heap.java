package Heaps;

public class Heap {
    
    int[] heap;
    int len = 0;

    public Heap() {
        heap = new int[len];
    }

    public Heap(int len) {
        this.len = len;
        heap = new int[len];
    }

    public Heap(int[] heap) {
        this.heap = heap;
    }

    public int getParentIndex(int childIndex) {
        return childIndex / 2;
    }
    
    public int getLeftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    public int getRightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    public int getLayerAmount(int[] tree) {
        return (int)(Math.log10(tree.length) / Math.log10(2)) + 1;
    }

    public void heapSort() {
        for(int i = heap.length/2 - 1; i >= 0; i--) {
            reHeapify(i, heap.length);
        }

        for(int i = heap.length - 1; i > 0; i--) {
            int temp = heap[i];
            heap[i] = heap[0];
            heap[0] = temp;

            reHeapify(0, i);
        }
    }

    //Turn into Heap
    public void heapify(int child) {
        int parent = (int)(child * .5);
        if(heap[child] > heap[parent]) {
            int temp = heap[child];
            heap[child] = heap[parent];
            heap[parent] = temp;
        }
    }
    
    //Recursively Maintain Heap
    public void reHeapify(int parentIndex, int len) {
        int leftIndex = getLeftChildIndex(parentIndex);
        int rightIndex = getRightChildIndex(parentIndex);
        int newParentIndex = parentIndex;

        //Set Root to Left if Left exists in Heap, and is greater than Parent
        if(leftIndex < len && heap[leftIndex] > heap[parentIndex]) {
            newParentIndex = leftIndex;
        }
        //Set Root to Right if Right exists in Heap, and is greater than Parent
        if(rightIndex < len && heap[rightIndex] > heap[parentIndex]) {
            newParentIndex = rightIndex;
        }
        //If Child was Larger, Swap Parent and Child
        if(newParentIndex != parentIndex) {
            int temp = heap[parentIndex];
            heap[parentIndex] = heap[newParentIndex];
            heap[newParentIndex] = temp;

            //Either ReHeaps Current Parent or Moves Down to Heap Sub-Heap
            reHeapify(newParentIndex, len);
        }
    }


    public void printHeap() { 
        for(int i = 0; i < heap.length; i++) {
            System.out.println(heap[i]);
        }
    }

    public void printTree() {
        int layers = getLayerAmount(heap);
        int[] reversedHeap = new int[heap.length];
        int curr = 0;

        for(int i = 0; i < heap.length; i++) {
            reversedHeap[i] = heap[heap.length - 1 - i];
        }

        for(int i = 0; i < layers; i++) {
            for(int j = 0; j < Math.pow(2, layers - i - 1); j++) {
                System.out.print(reversedHeap[curr] + "\t");
                curr++;
            }
            System.out.print("\n");
        }
    }
}