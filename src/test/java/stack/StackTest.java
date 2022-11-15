package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StackTest {

    private Stack stack;

    @BeforeEach
    void do_before_each_test(){
        stack = new Stack(5);
    }

    @Test
    void newly_created_stacks_should_be_empty() {
        assertThat(stack.getSize()).isEqualTo(0);
    }

    @Test
    void after_one_push_stack_size_should_be_one() {
        stack.push("A");

        assertThat(stack.getSize()).isEqualTo(1);
    }

    @Test
    void after_one_push_and_one_pop_should_be_empty() {
        stack.push("A");
        stack.pop();

        assertThat(stack.getSize()).isEqualTo(0);
    }

    @Test
    void When_pushed_passed_limit_stack_overflows() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        assertThatExceptionOfType(StackOverFlowException.class).isThrownBy(() -> stack.push("F"));
    }

    @Test
    void when_popped_passed_limit_stack_underflows() {
        stack.push("A");
        stack.pop();
        assertThatExceptionOfType(StackUnderFlowException.class).isThrownBy(() -> stack.pop());
    }

    @Test
    void when_two_values_are_pushed_then_one_is_popped_size_is_one() {
        stack.push("A");
        stack.push("B");
        stack.pop();

        assertThat(stack.getSize()).isEqualTo(1);
    }

    @Test
    void when_one_is_pushed_one_is_popped() {
        String onePushed = stack.push("one");
        String firstPopped = stack.pop();
        assertThat(onePushed).isEqualTo(firstPopped);
    }

    @Test
    void when_one_and_two_are_pushed_two_and_one_are_popped() {
        String onePushed = stack.push("one");
        String twoPushed = stack.push("two");
        String firstPopped = stack.pop();
        String secondPopped = stack.pop();
        assertThat(onePushed).isEqualTo(secondPopped);
        assertThat(twoPushed).isEqualTo(firstPopped);
    }

    @Test
    void when_creating_stack_with_negative_size_should_through_IllegalCapacity() {
        final Stack[] illegalStack = new Stack[1];
        assertThatExceptionOfType(StackIllegalCapacity.class)
                .isThrownBy(() -> illegalStack[0] = new Stack(-1));
    }

    @Test
    void when_creating_stack_with_zero_capacity_any_push_should_overflow() {
        Stack stack1 = new Stack(0);
        assertThatExceptionOfType(StackOverFlowException.class).isThrownBy(() -> stack1.push("A"));
    }

    @Test
    void when_one_is_pushed_one_is_on_top() {
        stack.push("One");
        assertThat(stack.getTop()).isEqualTo("One");
    }

    @Test
    void when_stack_is_empty_top_throws_empty() {
        assertThatExceptionOfType(StackEmptyException.class).isThrownBy(() -> stack.getTop());
    }

    @Test
    void given_stack_with_one_two_pushed_find_one_and_two() {
        stack.push("One");
        stack.push("Two");
        String oneFound = stack.findElement("One");
        String twoFound = stack.findElement("Two");
        String threeFound = stack.findElement("Three");

        assertThat(oneFound).isEqualTo("One");
        assertThat(twoFound).isEqualTo("Two");
        assertThat(threeFound).isEqualTo(null);
    }

    @Test
    void given_a_stack_with_no_two_find_two_returns_null() {
        String twoFound = stack.findElement("Two");

        assertThat(twoFound).isEqualTo(null);
    }

    @Test
    void elements_should_be_unique() {
        Stack stack1 = new Stack(5);

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("C");

        stack1.push("A");
        stack1.push("B");
        stack1.push("C");

        boolean equality = stack.equals(stack1);

        assertThat(equality).isEqualTo(true);

    }
}
