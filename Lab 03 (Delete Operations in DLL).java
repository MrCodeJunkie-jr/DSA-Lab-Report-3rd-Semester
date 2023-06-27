class node{
    int info;
    node prev;
    node next;
   
}
class dll{
    static node head=null;
    static node tail=null;
    static void  addfromhead(int el){
        node nnode=new node();
        nnode.info=el;
        if(head==null){
            nnode.next=null;
            nnode.prev=null;
            head=tail=nnode;
        }
        else{
            nnode.next=head;
            head=nnode;
            nnode.prev=null;
            nnode.next.prev=nnode;
        }
    }
    static void addfromtail(int el){
        node nnode=new node();
        nnode.info=el;
        if(head==null){
            nnode.next=null;
            nnode.prev=null;
            head=tail=nnode;
        }
        else{
            nnode.prev=tail;
            tail.next=nnode;
            tail=nnode;
        }
    }
    static void addatkpos(int k,int el){
        node nnode=new node();
        node temp=head;
        int count =1;
        int size=sizeoflist();
        if(k<0&&k>size+1){
            System.out.println("Invalid poisition");
        }
        else{
            while(count<k-1){
                temp=temp.next;
                count++;
            }
            nnode.prev=temp;
            nnode.next=temp.next;
            nnode.next.prev=nnode;
            temp.next=nnode;
            nnode.info=el;
        }
    }
    static void removefromhead(){
        if(head==null){
            System.out.println("Empty list");
        }
        else{
            head=head.next;
            head.prev=null;
        }
    }
    static void removefromtail(){
        if(head==null){
              System.out.println("Empty list");
        }
        else{
            tail=tail.prev;
            tail.next=null;
        }
    }
    static void removeatkpos(int k){
        node temp=head;
        int count=1;
        int size=sizeoflist();
        if(k<0||k>size+1){
            System.out.println("Invalid position");
        }
        else{
            while(count<k-1){
                temp=temp.next;
                count++;
            }
        }
        if(k==1&&head==tail){
            removefromhead();
        }
        else if(k==size){
            removefromtail();
        }
        else{
            temp.next=temp.next.next;
            temp.next.prev=temp;
        }
    }
    static void search(int l){
        node temp=head;
        int count=1;
        if(head==null){
            System.out.println("The list is empty");
        }
        while(temp!=null){
            temp=temp.next;
            count++;
            if(temp.info==l){
                System.out.println("Found data:"+temp.info);
                System.out.println("Data position:"+count);
                break;
            }
            else{
                System.out.println("Not found");
            }
        }
    }
    static int sizeoflist(){
         node temp=head;
           int count =0;
                while(temp!=null){
                    temp=temp.next;
                    count ++;
                }
            return count;
    }
    static void display(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.info+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args){
        addfromhead(5);
        addfromhead(10);
        addfromhead(15);
        addfromhead(17);
        System.out.println("After add from head operation");
         display();
          System.out.println("\n");
        addfromtail(20);
        System.out.println("After add from tail operation");
         display();
        addatkpos(2,11);
         System.out.println("\n");
        System.out.println("after add at k position operation");
        display();
        removefromhead();
         System.out.println("\n");
        System.out.println("after remove from head operation");
        display();
        removefromtail();
         System.out.println("\n");
        System.out.println("after remove from tail operation");
        display();
        removeatkpos(3);
         System.out.println("\n");
        System.out.println("after remove at k position operation");
        display();
         System.out.println("\n");
         System.out.println("after searching an element operation");
        search(15);
    }
}
