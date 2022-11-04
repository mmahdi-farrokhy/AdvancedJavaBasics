package stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Stack {

    private final List<String> elements;
    private final int limit;
    private String Top;
    public Stack(int limit) {
        if(limit < 0)
            throw new StackIllegalCapacity("Limit Is Wrong!");

        this.elements = new LinkedList<>();
        this.limit = limit;
    }

    public int getSize() {
        return elements.size();
    }

    public String push(String element) {
        if(elements.size() >= limit)
            throw new StackOverFlowException("Stack Is Full - Stack Over Flowed");

        if(elements.contains(element))
            return null;

        elements.add(element);
        return elements.get(elements.size()-1);
    }

    public String pop() {
        if (elements.size() == 0)
            throw new StackUnderFlowException("Stack Is Empty - Stack Under Flowed");

        String popped = elements.get(elements.size()-1);
        elements.remove(elements.size()-1);
        return popped;
    }

    public String getTop() {
        if (elements.size() == 0)
            throw new StackEmptyException("Top Is Empty!");
        Top = elements.get(elements.size()-1);
        return Top;
    }

    public String findElement(String element) {
        String isFound = null;
        int index = elements.indexOf(element);

        if(index != -1)
            isFound = element;

        return isFound;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null || getClass() != obj.getClass())
            return false;

        Stack stack = (Stack) obj;
        return Objects.equals(this.elements, stack.elements)
            && limit == stack.limit
            && Objects.equals(Top, stack.Top);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements, limit, Top);
    }

    public int getLimit() {
        return limit;
    }

    public void showElements(){
        for (String element : elements)
            System.out.println(element);
    }
}
