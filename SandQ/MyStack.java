import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

interface InnerMyStack<T> {

  public void push(T num);

  public T pop();

  public void popAll();

  public boolean isEmpty();
}

class Stack<T> implements InnerMyStack<T> {
  private List<T> arr;
  private int top;

  public Stack() {
    arr = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      arr.add(null);
    }
    top = -1;
  }

  public void push(T x) {
    arr.set(top + 1, x);
    top++;
  }

  public void popAll() {
    while (!isEmpty()) {
      System.out.println(pop());
    }
  }

  public boolean isEmpty() {

    if (top <= -1)
      return true;
    return false;
  }

  public T pop() {
    T num = arr.get(top);
    top--;
    return num;
  }
}

class StackWithQueue<T> implements InnerMyStack<T> {
  Queue<T> queue = new SimpleQueue<>();
  Queue<T> queue2 = new SimpleQueue<>();

  @Override
  public void push(T x) {
    queue.push(x);
  }

  @Override
  public T pop() {
    T num = null;
    if (queue.isEmpty())
      throw new NoSuchElementException();
    while (!queue.isEmpty()) {
      num = queue.pop();
      if (!queue.isEmpty())
        queue2.push(num);
    }
    while (!queue2.isEmpty()) {
      T temp = queue2.pop();
      queue.push(temp);
    }
    return num;
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override
  public void popAll() {
    while (!isEmpty()) {
      System.out.println(pop());
    }
  }
}
