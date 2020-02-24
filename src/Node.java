public class Node
{
    Runner run;
    Node next;

    Node(Runner r)
    {
        run=r;
        next=null;
    }

    public Runner getRun() { return run; }

    public void setRun(Runner run) {
        this.run = run;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
