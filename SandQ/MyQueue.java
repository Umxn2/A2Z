import java.util.ArrayList;
import java.util.List;

interface Queue<T> {

  public void push(T element) throws RuntimeException;

  T peek();

  T pop();

  void printQueue();

  boolean isEmpty();
}

class SimpleQueue<T> implements Queue<T> {
  int front;
  int back;
  List<T> queue;
  int maxSize = 10;

  SimpleQueue() {
    queue = new ArrayList<>();
    for (int i = 0; i < maxSize; i++) {
      queue.add(null);
    }
    front = 0;
    back = 0;
  }

  @Override
  public void push(T element) throws RuntimeException {
    if (queue.get(front % maxSize) != null) {
      throw new RuntimeException("Queue filled");
    }
    queue.set(front % maxSize, element);
    front++;
  }

  public T peek() {
    return queue.get(back % maxSize);
  }

  public boolean isEmpty() {
    if (queue.get(back % maxSize) == null)
      return true;
    return false;
  }

  public T pop() throws ArrayIndexOutOfBoundsException {
    if (queue.get(back % maxSize) == null) {
      throw new ArrayIndexOutOfBoundsException("popping an empty element");
    }

    T num = queue.get(back % maxSize);
    queue.set(back % maxSize, null);
    back++;
    return num;
  }

  public void printQueue() {
    for (int i = 0; i < maxSize; i++) {
      System.out.println(queue.get(i));
    }
  }
}
