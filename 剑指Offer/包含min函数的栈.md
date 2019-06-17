# 题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。 链接在[这里](https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)。

栈是肯定不能直接排序的，因为每次只能直接得到当前栈顶的元素；根据这个特性，我们可以使用一个辅助栈：push时，如果这个元素比当前最小元素小，那么更新最小元素压栈，反之直接压栈 ；pop时候一定更新最小元素；这样操作保证辅助栈顶一定是当前栈内的最小元素，我们可以在O(1)时间得到栈内最小元素，炒鸡好玩。
```
import java.util.Stack;

public class Solution {
    private Stack<Integer> stack=new Stack();
    private Stack<Integer> extra=new Stack();    //辅助栈
    int min=9999;
    public void push(int node) {
        stack.push(node);
        if(node<min) {
            min=node;
            extra.push(node);
        }
        else extra.push(min);
    }
    
    public void pop() {
        stack.pop();
        extra.pop();
        min=extra.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return extra.peek();
    }
}
```