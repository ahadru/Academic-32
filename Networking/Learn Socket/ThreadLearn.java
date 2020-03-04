public class ThreadLearn implements Runnable{
    public void run(){
        while(true){
            System.out.println("Hello World, In Thread");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        ThreadLearn tl = new ThreadLearn();
        Thread t = new Thread(tl);
        t.start();
        while(true){
            System.out.println("In Main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}