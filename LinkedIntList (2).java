import java.util.List;
import java.util.NoSuchElementException;
public class LinkedIntList {
    public class ListNode {
        int data;
        ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }
    private ListNode front;
    public LinkedIntList() {
        front = null;
    }

    // Returns value in list at given index.
    // Precondition: 0 <= index < size()
    public int get(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Adds the given value to the end of the list.
    public void add(int value) {
        if (front == null) {
            // adding to an empty list
            front = new ListNode(value);
        } else {
            // adding to the end of an existing list
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    // Inserts the given value at the given index.
    // Precondition: 0 <= index <= size()
    public void add(int index, int value) {
        if (index == 0) {
            // adding to an empty list
            front = new ListNode(value, front);
        } else {
            // inserting into an existing list
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new ListNode(value, current.next);
        }
    }

    // Removes value at given index from list.
    // Precondition: 0 <= index < size()
    public void remove(int index) {
        if (index == 0) {
            // special case: removing first element
            front = front.next;
        } else {
            // removing from elsewhere in the list
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    // Adds given value to list in sorted order.
    // Precondition: Existing elements are sorted
    public void addSorted(int value) {
        if (front == null || value <= front.data) {
            // insert at front of list
            front = new ListNode(value, front);
        } else {
            // insert in middle of list
            ListNode current = front;
            while (current.next != null &&
                    current.next.data < value) {
                current = current.next;
            }
        }
    }

    // Prints the list.
    public void print() {
        ListNode current = front;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;  // move to next node
        }
    }
    // Returns the number of nodes in the linked list.
    public int size() {
        ListNode current = front;
        int count = 0;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    // Returns the values in the linked list with a space in between the nodes, as a string.
    public String toString() {
        String str = "";
        ListNode current = front;

        while(current != null) {
            str = str + current.data + " ";
            current = current.next;
        }
        return str;
    }
    // My Methods------------------------------------------------------------------------------------------
    public boolean contains(int value) {
        ListNode current = front;
        while (current != null) {
            if (current.data == value) {
                System.out.println ("True");
                return true;
            }
            current = current.next;
        }
        System.out.println ("False");
        return false;
    }
    public void set(int index, int value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        ListNode current = front;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                current.data = value;
                return;
            }
            current = current.next;
            currentIndex++;
        }
        throw new IndexOutOfBoundsException("Too Large Of a Index");
    }
    public String isSorted() {
        if (front == null) {
            System.out.println ("Sorted");
            return "True";
        }

        ListNode current = front;

        while (current.next != null) {
            if (current.data > current.next.data) {
                System.out.println ("Not Sorted");
                return "False";
            }
            current = current.next;
        }
        System.out.println ("Sorted");
        return "True";
    }

    public int deleteBack() {
        if (front == null) {
            throw new NoSuchElementException("The list is empty.");
        }
        if (front.next == null) {
            int value = front.data;
            front = null;
            return value;
        }
        ListNode current = front;
        while (current.next.next != null) {
            current = current.next;
        }
        int value = current.next.data;
        current.next = null;
        return value;
    }
    public int lastIndexOf(int value) {
        ListNode current = front;
        int lastIndex = -1;
        int currentIndex = 0;
        while (current != null) {
            if (current.data == value) {
                lastIndex = currentIndex;
            }
            current = current.next;
            currentIndex++;
        }
        return lastIndex;
    }

    public int kthFromTheEnd(int index) {
        ListNode mainPointer = front;
        ListNode referencePointer = front;
        for (int i = 0; i < index; i++) {
            if (referencePointer == null) {
                throw new IllegalArgumentException("Index is greater than the list length.");
            }
            referencePointer = referencePointer.next;
        }
        while (referencePointer != null) {
            mainPointer = mainPointer.next;
            referencePointer = referencePointer.next;
        }
        return mainPointer.data;
    }


    public void rotateLeft() {
        if (front == null || front.next == null) {
            return;
        }
        ListNode current = front;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next.next = front;
        front = current.next;
        current.next = null;
    }

    public void rotateRight() {
        if (front == null || front.next == null) {
            return;
        }
        ListNode current = front;
        while (current.next.next != null) {
            current = current.next;
        }
        ListNode temp = front;
        front = current.next;
        current.next = null;
        front.next = temp;
    }
public void removeDuplicates() {
    if (front == null) {
        return;
    }

    ListNode current = front;

    while (current.next != null) {
        if (current.data == current.next.data) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
}
public void reverse() {
    if (front == null) {
        return;
    }

    ListNode current = front;
    ListNode previous = null;
    ListNode next = null;

    while (current != null) {
        next = current.next;
        current.next = previous;
        previous = current;
        current = next;
    }

    front = previous;

}

public static void main(String[] args) {

        //Linked Tree
        LinkedIntList list = new LinkedIntList();
        list.add(25);
        list.add(27);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(63);
        list.add(70);
        list.add(86);
        list.add(90);
        list.add(105);

        //Given Methods
    System.out.println ("Original List: ");
    list.print();
    System.out.println ("");

    System.out.println ("Add Method: ");
    list.add(30);
    list.print();
    System.out.println ("");

    System.out.println ("Add Method: ");
    list.add(0, 30);
    list.print();
    System.out.println ("");

    System.out.println ("Remove Method: ");
    list.remove(0);
    list.print();
    System.out.println ("");

    System.out.println ("Remove Method: ");
    list.remove(4);
    list.print();
    System.out.println ("");

    System.out.println ("Size Method: ");
    System.out.println(list.size());
    System.out.println ("");

        //Austin's Test For Created Methods
    System.out.println ("Contains Method: ");
        list.contains(30);
    System.out.println ("");

    System.out.println ("Set Method: ");
        list.set(1,30);
        list.print();
    System.out.println ("");

    System.out.println ("isSorted Method: ");
        list.isSorted();
    System.out.println ("");

    System.out.println ("deleteBack Method: ");
        list.deleteBack();
        list.deleteBack();
        list.print();
    System.out.println ("");

    System.out.println("Last Index of Method: ");
        System.out.println(list.lastIndexOf(50));
    System.out.println ("");

    System.out.println ("Kth From The End Method: ");
        System.out.println(list.kthFromTheEnd(3));
    System.out.println ("");

    System.out.println ("Rotate Left Method: ");
    list.rotateLeft();
    list.print();
    System.out.println ("");

    System.out.println ("Rotate Right Method: ");
    list.rotateRight();
    list.print();
    System.out.println ("");

    System.out.println ("RemoveDuplicates Method: ");
    list.removeDuplicates();
    list.print();
    System.out.println ("");

    System.out.println ("Reverse Method: ");
    list.reverse();
    list.print();
    System.out.println ("");
        }
    }


