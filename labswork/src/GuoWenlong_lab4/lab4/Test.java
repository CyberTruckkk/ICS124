package GuoWenlong_lab4.lab4;

public class Test {
    public static void main(String[] args) {
        LinkedLists<Integer> list = new LinkedLists<>();
        System.out.println(list.size);
        System.out.println(list.first);
        list.add(0);
        System.out.println("test for add(e),expect: Node{item=0} get :" + list.first);
        list.add(1);
        System.out.println("test for add(e),expect: Node{item=1} get :" + list.first);
        list.add(2);
        list.traverse("[2,1,0]");
        System.out.println("test for add(e),expect: Node{item=2} get :" + list.first);
        System.out.println("test for first(),expect: 2 get :" + list.first());
        System.out.println("test for last(),expect: 0 get :" + list.last());
        System.out.println("test for size(),expect: 3 get :" + list.size());
        // in the list are [0,1,2]
        System.out.println("test for indexOf(0),expect: 2 get :" + list.indexOf(0));
        System.out.println("test for indexOf(1),expect: 1 get :" + list.indexOf(1));
        System.out.println("test for indexOf(2),expect: 0 get :" + list.indexOf(2));
        System.out.println("add at index 0");
        list.add(66, 0);
        list.traverse("[66,2,1,0]");
        System.out.println("indeex of 66 " + list.indexOf(66));
        System.out.println("size:4 " + list.size());
        System.out.println(list.remove(0) + " expect get 66");
        list.traverse("[66,2,1,0] -> [2,1,0] ");
        list.add(3);
        list.traverse("[3,2,1,0]");
        System.out.println("test for get(-1),expect: 0 get :" + list.get(-1));
        System.out.println("test for get(0),expect: 3 get :" + list.get(0));
        System.out.println("test for get(1),expect: 2 get :" + list.get(1));
        System.out.println("test for get(2),expect: 1 get :" + list.get(2));
        System.out.println("test for get(3),expect: 0 get :" + list.get(3));
        list.traverse("[3,2,1,0]");
        list.add(77);
        list.traverse("[77,3,2,1,0]");
        LinkedLists<Integer> newLists = new LinkedLists<>();
        newLists = (LinkedLists<Integer>) list.cut(2);
        newLists.traverse("[77,3,2,1,0] cut (2) newlists");
        list.traverse("list after 2 : origin list");
        list.reverse();
        list.traverse("testfor reverse,[77,3]");
        list.clear();
        list.traverse("test for clear []");
        System.out.println("test for stack.isEmpty() expect true, " + list.isEmpty());
        list.push(0);
        System.out.println("test for stack.isEmpty() expect true, " + list.isEmpty());
        list.traverse("test for push() [0]");
        list.add(1);
        list.add(2);
        list.traverse("[2,1,0]");
        System.out.println("test for peek() [2,1,0],expect:2,  " + list.peek());
        System.out.println("test for peek() [2,1,0]" + list.last());
        System.out.println("test for size() [2,1,0],expect:3, " + list.size());
        System.out.println("test for pop() [2,1,0],expect:2, " + list.pop());
        list.traverse("[2,1,0] after pop()");
    }

}