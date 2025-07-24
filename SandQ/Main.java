
public class Main {
  public static void main(String[] args) {
    InnerMyStack<Integer> myStackWithQueues = new StackWithQueue<>();
    InnerMyStack<Integer> myStack = new Stack<>();
    testStack(myStackWithQueues);
    testStack(myStack);
  }

  private static void testStack(InnerMyStack<Integer> stack) {
    // Test 1: Simple push and pop
    stack.push(10);
    stack.push(20);
    System.out.println("Pop: " + stack.pop()); // Should print 20

    // Test 2: Push more, then popAll
    stack.push(30);
    stack.push(40);
    stack.push(50);
    System.out.print("PopAll: ");
    stack.popAll(); // Should print 50 40 30 10

    // Test 3: Mixed operations
    stack.push(60);
    System.out.println("Pop: " + stack.pop()); // Should print 60

    stack.push(70);
    stack.push(80);
    System.out.print("PopAll: ");
    stack.popAll(); // Should print 80 70

    // Test 4: Empty pop (optional - depending on implementation)
    System.out.println("Pop from empty stack: " + stack.pop()); // Could throw exception or return null
  }
}
