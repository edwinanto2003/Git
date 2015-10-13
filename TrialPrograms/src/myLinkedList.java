
public class myLinkedList 
{ 
    /**
     * 
     * This class describes and defines a generic node for use in a singly linked list
     * implementation
     * 
     * @author Edwin Anto
     */
    public class Node
    {
        private int data;
        private Node next;

        public Node(int data)
        {
            this.data = data;
            this.setNext(null);
        }

        /**
         * @return the data
         */
        public int getData() {
            return data;
        }

        /**
         * @return the next
         */
        public Node getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(Node next) {
            this.next = next;
        }        
    }


    private Node root;

    public myLinkedList()
    {
        this.root = null;
    }

    public void createList()
    {
        int n;
        for (int i = 0; i < 20; i++)
        {
            n = (int) Math.random();
            
        }
    }
    
    public void insert(int n)
    {
        if (this.root == null)
            root = new Node(n);
        else
        {
            
        }                
    }
}
