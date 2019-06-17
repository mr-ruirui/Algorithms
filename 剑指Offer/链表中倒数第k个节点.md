# 题目描述
输入一个链表，输出该链表中倒数第k个结点。 链接在[这里](https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)。

如果先获得链表长度需要`$O(n)$`时间复杂度便利整个链表，再获得倒数第k个节点；使用快慢指针，让快指针先走k-1步，慢指针和快指针同时前进，正好可以卡住倒数第k个节点。
```
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null ||k==0) return null;
        ListNode forward=head;
        ListNode behind=head;
        for(int i=0;i<k-1;i++){
            if(forward.next==null) return null;
            else forward=forward.next;
        }
        while(forward.next!=null){
            forward=forward.next;
            behind=behind.next;
        }
        return behind;
    }
}
```