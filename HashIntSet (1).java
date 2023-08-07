public class HashIntSet {
        private class Node{
            public int data;
            public Node next;

            public Node(int value) {
                data = value;
                next = null;
            }
            public Node(int value, Node next) {
                data = value;
                this.next = next;
            }
        }
        private Node[] elements;
        private int size;
        public HashIntSet() {
            elements = new Node[10];
            size = 0;
        }
        public int hash(int i) {
            return (Math.abs(i) % elements.length);
        }
        public void add(int value) {
            if(!contains(value)) {
                int h = hash(value);
                Node newNode = new Node(value);
                newNode.next = elements[h];
                elements[h] = newNode;
                size++;

            }
        }
        public boolean contains(int value) {
            Node current = elements[hash(value)];
            while(current != null) {
                if(current.data == value) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }
        public String toString() {
            String s = "";
            for(Node n:elements) {
                Node current = n;
                while(current != null) {
                    s += current.data + " ";
                    current = current.next;
                }
            }
            return s;
        }
        public void remove(int value) {
            int h = hash(value);
            if(elements[h] != null && elements[h].data == value) {
                elements[h] = elements[h].next;
                size--;
            }else {
                Node current = elements[h];
                while(current != null && current.next != null) {
                    if(current.next.data == value) {
                        current.next = current.next.next;
                        size--;
                        return;
                    }
                    current = current.next;
                }
            }
        }
        //addAll
        public void addAll(HashIntSet set) {
            for(Node n:set.elements) {
                Node current = n;
                while(current != null) {
                    add(current.data);
                    current = current.next;
                }
            }
        }
        //equals
    public boolean equals(Object o) {
            if(o instanceof HashIntSet) {
                HashIntSet set = (HashIntSet) o;
                if(set.size != size) {
                    return false;
                }
                for(Node n:set.elements) {
                    Node current = n;
                    while(current != null) {
                        if(!contains(current.data)) {
                            return false;
                        }
                        current = current.next;
                    }
                }
                return true;
            }
            return false;
        }
        //removeAll
        public void removeAll(HashIntSet set) {
            for(Node n:set.elements) {
                Node current = n;
                while(current != null) {
                    remove(current.data);
                    current = current.next;
                }
            }
        }
        //retainAll
        public void retainAll(HashIntSet set) {
            for(Node n:elements) {
                Node current = n;
                while(current != null) {
                    if(!set.contains(current.data)) {
                        remove(current.data);
                    }
                    current = current.next;
                }
            }
        }
        //toArray
        public int[] toArray() {
            int[] arr = new int[size];
            int index = 0;
            for(Node n:elements) {
                Node current = n;
                while(current != null) {
                    arr[index] = current.data;
                    index++;
                    current = current.next;
                }
            }
            return arr;
        }

        public static void main(String[] args) {
            //Austin's Outputs Remove all Commented out
            HashIntSet set = new HashIntSet();
            set.add(37);
            set.add(-2);
            set.add(45);
            set.add(32);
            set.add(57);
            set.add(7);
            System.out.println("Set 1: ");
            System.out.println(set);
            System.out.println();

            HashIntSet set2 = new HashIntSet();
            set2.add(37);
            set2.add(-2);
            set2.add(48);
            set2.add(42);
            set2.add(57);
            System.out.println("Set 2: ");
            System.out.println(set2);
            System.out.println();

            System.out.println("Contains Method: ");
            System.out.println(set.contains(57));
            System.out.println();

            System.out.println("Remove Method:  ");
            set.remove(7);
            System.out.println(set);
            System.out.println();

            System.out.println("Add All Method: ");
            set.addAll(set2);
            System.out.println(set);
            System.out.println();

            System.out.println("Equals Method: ");
            System.out.println(set.equals(set2));
            System.out.println();

            System.out.println("Retain All Method: ");
            set.retainAll(set2);
            System.out.println(set);
            System.out.println();

            //System.out.println("Remove All Method: ");
            //set.removeAll(set2);
            //System.out.println(set);
            //System.out.println();

            System.out.println("To Array Method: ");
            int[] arr = set.toArray();
            for(int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }




        }

    }


