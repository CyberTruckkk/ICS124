package GuoWenlong_lab4.lab4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Object> pass = new ArrayList<>();
        LinkedLists<Integer> list = new LinkedLists<>();
        LinkedList realList = new LinkedList<>();
        System.out.println(list.size);
        System.out.println(list.first);
        list.add(0);
        System.out.println("test for add(e),expect: Node{item=0} get :"+list.first);
        list.add(1);
        System.out.println("test for add(e),expect: Node{item=1} get :"+list.first);
        list.add(2);
        pass.add("add(e)");
        System.out.println(list.printOut());
        System.out.println("test for add(e),expect: Node{item=2} get :"+list.first);
        System.out.println("test for first(),expect: 2 get :"+list.first());
        pass.add("first()");
        System.out.println("test for last(),expect: 0 get :"+list.last());
        pass.add("last()");
        System.out.println("test for size(),expect: 3 get :"+list.size());
        // in the list are [0,1,2]
        System.out.println("test for indexOf(0),expect: 2 get :"+list.indexOf(0));
        System.out.println("test for indexOf(1),expect: 1 get :"+list.indexOf(1));
        System.out.println("test for indexOf(2),expect: 0 get :"+list.indexOf(2));
        list.add(66,1);
        System.out.println("size:4 " + list.size());
        pass.add("size()");
        System.out.println("printOut"+list.printOut());
        //list = [0,66,1,2]
        System.out.println("list = [2,1,0] test for add(66,1) list = [2,66,1,0],expect: 1 get :"+list.indexOf(66));
        System.out.println("list = [2,1,0] test for add(66,1) list = [2,66,1,0],expect: 0 get :"+list.indexOf(2));
        System.out.println("list = [2,1,0] test for add(66,1) list = [2,66,1,0],expect: 2 get :"+list.indexOf(1));
        System.out.println("list = [2,1,0] test for add(66,1) list = [2,66,1,0],expect: 3 get :"+list.indexOf(0));
        System.out.println("test for add(e,index) pass");
        pass.add("add(e,index)");

    }
    public Object[] toArray(LinkedLists lists){
        LinkedList list = new LinkedList<>();
        while (lists.first!=null){
            list.add(lists.first);
        }
        return list.toArray();
    }

}