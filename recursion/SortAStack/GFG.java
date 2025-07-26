import java.util.Stack;

class GfG {

    public Stack<Integer> sort(Stack<Integer> s) {
        sortInPlace(s);
        return s;
    }

    public void sortInPlace(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int element = s.pop();
        sort(s);
        insertElement(s, element);
    }

    public void insertElement(Stack<Integer> s, int element) {
        if (s.isEmpty()) s.push(element);

        if (s.peek() > element) {
            int num = s.pop();
            insertElement(s, element);
            s.push(num);
        }
        s.push(element);
    }
}
