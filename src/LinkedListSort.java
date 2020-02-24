public class LinkedListSort
{
    public static Node merge(Node l, Node r)
    {
        Node newHead=null;

        if(l==null)
            return r;
        if(r==null)
            return l;

        if((l.getRun().getTime())<=(r.getRun().getTime()))
        {
            newHead=l;
            newHead.next=merge(l.next,r);
        }
        else
        {
            newHead=r;
            newHead.next=merge(l,r.next);
        }

        return newHead;
    }
    public static Node mergeSort(Node head)
    {
        if(head==null || head.next==null)
            return head;

        int len=0;
        Node temp=head;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }

        Node mid=head;
        for(int i=0; i<(len/2)-1; i++)
            mid=mid.next;
        Node midNext=mid.next;

        mid.next=null;

        Node l=mergeSort(head);
        Node r=mergeSort(midNext);

        Node newHead=merge(l,r);

        return newHead;
    }
}
