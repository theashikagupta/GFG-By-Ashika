/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    public static void removeLoop(Node head) {
        // code here
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                Node p1=head;
                Node p2=slow;
                if(p1==p2){
                    Node p3=p1.next;
                        while(p3.next!=p1){
                            p3=p3.next;
                        }
                        p3.next=null;
                        return;
                }
                else{
                    while(p1!=p2){
                    p1=p1.next;
                    p2=p2.next;
                    if(p1==p2){
                        Node p3=p1.next;
                        while(p3.next!=p1){
                            p3=p3.next;
                        }
                        p3.next=null;
                        return;
                    }
                }
                }
                
            }
        }
    }
}