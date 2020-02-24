public class Winner
{
    public static Node winners(int category, Node head)
    {
        Node first = null;
        Node second = null;
        Node temp = head;

        while(temp != null)
        {
            Runner r1 = temp.getRun();
            if(r1.getCategory()==category)
            {
                if(first==null)
                    first=temp;
                else if(first.getRun().getTime()>r1.getTime())
                    first=temp;
            }
            temp = temp.getNext();
        }

        temp=head;
        while(temp != null)
        {
            Runner r1 = temp.getRun();
            if(r1.getCategory()==category)
            {
                if(second==null && temp!=first)
                    second=temp;
                else if((r1.getTime()>first.getRun().getTime()) && (second.getRun().getTime()>r1.getTime()))
                    second=temp;
            }
            temp = temp.getNext();
        }

        if(first!=null)
        {
            Node F=new Node(first.getRun());
            if(second!=null)
            {
                Node S=new Node(second.getRun());
                F.setNext(S);
            }
            return F;
        }
        else
            return null;
    }
}
