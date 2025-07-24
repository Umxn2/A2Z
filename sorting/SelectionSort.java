import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class SelectionSort {

  public static void main(String[] args) throws Exception {

    ArrayList<Integer> input = getInput();
    int size = input.size();
    if (args[0].equals("S")) {
      selectionSort(input, size);
      writeInput(input, "./SelectionSort.txt");
      String[] selectionSortArgs = new String[1];
      selectionSortArgs[0] = "./SelectionSort.txt";
      CheckData.main(selectionSortArgs);
    } else if (args[0].equals("B")) {
      bubbleSort(input, size);
      writeInput(input, "./BubbleSort.txt");
      String[] bubbleSortArgs = new String[1];
      bubbleSortArgs[0] = "./BubbleSort.txt";
      CheckData.main(bubbleSortArgs);
    } else if (args[0].equals("I")) {
      insertionSort(input, size);
      writeInput(input, "./InsertionSort.txt");
      String[] insertionSortArgs = new String[1];
      insertionSortArgs[0] = "./InsertionSort.txt";
      CheckData.main(insertionSortArgs);
    } else if (args[0].equals("M")) {
      mergeSort(input, size);
      writeInput(input, "./MergeSort.txt");
      String[] mergeSortArgs = new String[1];
      mergeSortArgs[0] = "./MergeSort.txt";
      CheckData.main(mergeSortArgs);
    } else if (args[0].equals("Q")) {
      quickSort(input, size);
      writeInput(input, "./QuickSort.txt");
      String[] quickSortArgs = new String[1];
      quickSortArgs[0] = "./QuickSort.txt";
      CheckData.main(quickSortArgs);
    } else if (args[0].equals("T")) {
      input = treeSort(input, size);
      writeInput(input, "./TreeSort.txt");
      String[] treeSortArgs = new String[1];
      treeSortArgs[0] = "./TreeSort.txt";
      CheckData.main(treeSortArgs);
    }

  }

  static ArrayList<Integer> treeSort(ArrayList<Integer> input, int size) {

    BinaryTree binaryTree = new BinaryTree();
    for (int i = 0; i < size; i++) {
      binaryTree.addNode(input.get(i));
    }
    input = binaryTree.treeToArray();
    return input;
  }

  static class BinaryTree {

    Node node;

    BinaryTree() {
      node = null;
    }

    void addNode(int value) {

      if (node == null) {
        Node parentNode = new Node(value);
        node = parentNode;
        return;
      }

      Node currentNode = node;
      Node previousNode = null;
      while (currentNode != null) {
        previousNode = currentNode;
        if (currentNode.value >= value) {
          currentNode = currentNode.leftPointer;
        } else if (currentNode.value < value) {
          currentNode = currentNode.rightPointer;
        }
      }

      if (previousNode == null)
        throw new RuntimeException("Bug detected!!! previousNode is null");

      if (previousNode.value > value)
        previousNode.leftPointer = new Node(value);
      else if (previousNode.value <= value)
        previousNode.rightPointer = new Node(value);
    }

    ArrayList<Integer> treeToArray() {
      ArrayList<Integer> output = new ArrayList<>();
      if (node == null)
        return output;
      preOrder(output, node);
      return output;
    }

    void preOrder(ArrayList<Integer> output, Node node) {
      if (node == null)
        return;
      preOrder(output, node.leftPointer);
      output.add(node.value);
      preOrder(output, node.rightPointer);
    }

  }

  static class Node {

    Node leftPointer;
    Node rightPointer;
    int value;

    Node(int value) {
      leftPointer = null;
      rightPointer = null;
      this.value = value;
    }

  }

  static void quickSort(ArrayList<Integer> input, int size) {

    quickSort(input, 0, size - 1);

  }

  static void quickSort(ArrayList<Integer> input, int l, int r) {

    if (l >= r) {
      return;
    }

    int pivot = input.get(l);
    int leftPointer = l;
    int rightPointer = r;
    while (leftPointer <= rightPointer) {
      while (leftPointer <= r && input.get(leftPointer) < pivot) {
        leftPointer++;
      }
      while (rightPointer >= l && input.get(rightPointer) > pivot) {
        rightPointer--;
      }
      if (input.get(leftPointer) < pivot && input.get(rightPointer) > pivot)
        Collections.swap(input, leftPointer, rightPointer);
    }

    Collections.swap(input, l, leftPointer);
    quickSort(input, l, leftPointer - 1);
    quickSort(input, leftPointer + 1, r);
  }

  static void mergeSort(ArrayList<Integer> input, int size) {
    mergeSort(input, 0, size - 1);
  }

  static void mergeSort(ArrayList<Integer> input, int l, int r) {

    int mid = (r + l) / 2;
    if (mid == r)
      return;
    mergeSort(input, l, mid);
    mergeSort(input, mid + 1, r);
    merge(input, l, r, mid);
  }

  static void merge(ArrayList<Integer> input, int l, int r, int mid) {

    ArrayList<Integer> temp = new ArrayList<>();
    int leftPointer = l;
    int rightPointer = mid + 1;
    while (leftPointer <= mid && rightPointer <= r) {
      if (input.get(leftPointer) <= input.get(rightPointer)) {
        temp.add(input.get(leftPointer));
        leftPointer++;
      } else {
        temp.add(input.get(rightPointer));
        rightPointer++;
      }
    }
    while (leftPointer <= mid) {
      temp.add(input.get(leftPointer));
      leftPointer++;
    }
    while (rightPointer <= r) {
      temp.add(input.get(rightPointer));
      rightPointer++;
    }

    for (int i = l; i <= r; i++) {
      input.set(i, temp.get(i - l));
    }

  }

  static void bubbleSort(ArrayList<Integer> input, int size) {
    for (int i = 0; i < size - 1; i++) {
      for (int j = 0; j < size - 1 - i; j++) {
        if (input.get(j) > input.get(j + 1)) {
          Collections.swap(input, j, j + 1);
        }
      }
    }
  }

  static void insertionSort(ArrayList<Integer> input, int size) {

    for (int i = 1; i < size; i++) {
      insert(input, i);
    }

  }

  static void insert(ArrayList<Integer> input, int index) {
    while (input.get(index) < input.get(index - 1)) {
      Collections.swap(input, index, index - 1);
      index--;
      if (index == 0)
        return;
    }
  }

  static void selectionSort(ArrayList<Integer> input, int size) {
    for (int i = 0; i < size; i++) {
      int maxIndex = findMax(i, input, size);
      Collections.swap(input, i, maxIndex);
    }
  }

  static int findMax(int curr, ArrayList<Integer> input, int size) {
    int max = Integer.MAX_VALUE;
    int index = -1;
    for (int i = curr; i < size; i++) {
      if (max > input.get(i)) {
        max = input.get(i);
        index = i;
      }
    }
    return index;
  }

  static ArrayList<Integer> getInput() throws Exception {

    ArrayList<Integer> input = new ArrayList<>();
    File file = new File("./data.txt");
    Scanner scanner = new Scanner(file);
    while (scanner.hasNext()) {

      input.add(scanner.nextInt());
    }
    scanner.close();
    return input;

  }

  static void writeInput(ArrayList<Integer> input, String output) throws Exception {

    int size = input.size();
    FileWriter fileWriter = new FileWriter(output);
    for (int i = 0; i < size; i++) {
      fileWriter.write(String.valueOf(input.get(i)) + "\n");
    }
    fileWriter.close();

  }

}
