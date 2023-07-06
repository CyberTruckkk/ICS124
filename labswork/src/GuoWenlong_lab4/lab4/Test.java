package GuoWenlong_lab4.lab4;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedLists<Integer> list = new LinkedLists<>();
        System.out.println(list.size);
        System.out.println(list.first);
        list.add(0);
        System.out.println("test for add(e),expect: Node{item=0} get :"+list.first);
        list.add(1);
        System.out.println("test for add(e),expect: Node{item=1} get :"+list.first);
        list.add(2);
        list.traverse("add 0 - 1 - 2");
        System.out.println("test for add(e),expect: Node{item=2} get :"+list.first);
        System.out.println("test for first(),expect: 2 get :"+list.first());
        System.out.println("test for last(),expect: 0 get :"+list.last());
        System.out.println("test for size(),expect: 3 get :"+list.size());
        // in the list are [0,1,2]
        System.out.println("test for indexOf(0),expect: 2 get :"+list.indexOf(0));
        System.out.println("test for indexOf(1),expect: 1 get :"+list.indexOf(1));
        System.out.println("test for indexOf(2),expect: 0 get :"+list.indexOf(2));
        System.out.println("add at index 0");
        list.add(66,0);
        System.out.println("indeex of 66 "+list.indexOf(66));
        System.out.println("size:4 " + list.size());
        System.out.println(list.remove(0) + " expect 66 ,[2,1,0] "+list.printOut());
        list.add(3);
        System.out.println(list.printOut());
        System.out.println("test for get(1),expect: 2 get :"+list.get(1));
        System.out.println("test for get(1),expect: 2 get :"+list.get(0));
        System.out.println(list.printOut());
        list.add(77);
        list.clear();
        list.printOut();

    }
    public Object[] toArray(LinkedLists lists){
        LinkedList list = new LinkedList<>();
        while (lists.first!=null){
            list.add(lists.first);
        }
        return list.toArray();
    }

}