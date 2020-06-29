package DataStructure;

import java.util.ArrayList;

public class QueueTest{
    ArrayList<Integer> queue = new ArrayList();
    int maxSize;
    
    QueueTest(int size) {
        this.maxSize = size;
    }
    
    public void add(int val) throws Exception{
        if(queue.size() < maxSize)
            queue.add(val);
        else {
            throw new Exception("queue is full");
        } 
    }
    
    public int poll() throws Exception{
        if(queue.size() > 0){
            int temp = queue.get(queue.size()-1);
            queue.remove(queue.size()-1);
            return temp;
        }
        else 
            throw new Exception("Queue is empty");
        
    } 
    
    public static void main(String [] args) throws Exception {
        QueueTest q = new QueueTest(4);
        q.add(1);
        System.out.println("");        
        System.out.println("Test");
    }
}
