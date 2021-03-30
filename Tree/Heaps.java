package heaps;

import java.util.Arrays;

public class MinHeap {
	private int INITIAL_CAPACITY = 10;
	private int[] items = new int[INITIAL_CAPACITY];
	private int size = 0;
	
	private int getLeftChildIndex(int parentIndex) {
		return (parentIndex * 2) + 1;
	}
	
	private int getRightChildIndex(int parentIndex) {
		return (parentIndex * 2) + 2;
	}
	
	private int getParentIndex(int childIndex) {
		return (childIndex - 1)/2;
	}
	
	private boolean hasParent(int index) {
		return (getParentIndex(index) >= 0);
	}
	
	private boolean hasLeftChild(int index) {
		return (getLeftChildIndex(index) < size);
	}
	
	private boolean hasRightChild(int index) {
		return (getRightChildIndex(index) < size);
	}
	
	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	
	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	
	private int parentNode(int index) {
		return items[getParentIndex(index)];
	}
	
	public int peek(){
		if (size == 0) {
			throw new IllegalStateException();
		}
		return items[0];
	}
	
	private void swap(int parentIndex, int childIndex) {
		int temp = items[parentIndex];
		items[parentIndex] = items[childIndex];
		items[childIndex] = temp;
	}
	
	private void ensureCapacity() {
		if(size == INITIAL_CAPACITY) {
			items = Arrays.copyOf(items, INITIAL_CAPACITY*2);
			INITIAL_CAPACITY *= 2;
		}
	}
	
	public void insert(int data) {
		//first ensure the capacity
		ensureCapacity();
		items[size] = data;
		size++;
		heapifyUp();
	}
	
	public int poll() {
		if(size == 0) {
			throw new IllegalStateException();
		}
		int returnVal = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return returnVal;
	}
	
	private void heapifyUp() {
		int index = size - 1;
		while(hasParent(index) && (parentNode(index) > items[index])) {
			swap(getParentIndex(index), index);
			//adjust the index with recent parent
			index = getParentIndex(index);
		}
	}
	
	private void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int childIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
				childIndex = getRightChildIndex(index);
			}
			if(leftChild(childIndex) > items[index]) {
				swap(index, childIndex);
			}
			index = childIndex;
		}
	}
	
	public int[] display() {
		return items;
	}
	
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		minHeap.insert(10);
		minHeap.insert(5);
		minHeap.insert(25);
		minHeap.insert(3);
		minHeap.insert(21);
		for(int i=0; i<minHeap.items.length; i++) {
			System.out.println(minHeap.items[i]+"->");
		}
	}
}
