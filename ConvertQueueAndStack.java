import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConvertQueueAndStack {
    class MyQueue{
        public Stack<Integer> in;
        public Stack<Integer> out;

        public MyQueue(){
            in = new Stack<Integer>();
            out = new Stack<Integer>();
        }

        private void inToOut(){
            if(out.empty()){
                while(!in.empty()){
                    out.push(in.pop());
                }
            }
        }

        public void push(int value){
            in.push(value);
            inToOut();
        }

        public int pop(){
            inToOut();
            return out.pop();
        }

        public int peek(){
            inToOut();
            return out.peek();
        }

        public boolean empty(){
            return in.empty() && out.empty();
        }
    }

    class MyStack{
        Queue<Integer> queue;

        public MyStack(){
            queue = new LinkedList<Integer>();
        }

        public void push(int value){
            int n = queue.size();
            queue.offer(value);
            for(int i=0;i<n;i++){
                queue.offer(queue.poll());
            }
        }

        public int pop(){
            return queue.poll();
        }

        public int top(){
            return queue.peek();
        }

        public boolean empty(){
            return queue.isEmpty();
        }
    }
}
