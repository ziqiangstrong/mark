package Task;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * java 任务实现
 */
public class JavaTask {


    /**等待时长*/
    private final static long waitLongSecond=6000;


    /**
     * 方式1，继承Thread,sleep执行时间后
     */
    static class threadTask extends Thread{

        @Override
        public void run() {
            try {
                System.out.println("任务等待执行");
                sleep(waitLongSecond);
                System.out.println("执行代码块");
                System.out.println("任务等待执行后");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }


    /**
     * 方式2，实现Runnable,sleep执行时间后
     * @param
     */
    static  class  runableTask implements Runnable{

        @Override
        public void run() {
            try{
                System.out.println("执行代码块");
                System.out.println("任务执行后");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    /**
     * 方法3
     * @param
     */
    static class TimerTaskThree extends  TimerTask{

        @Override
        public long scheduledExecutionTime() {
            return waitLongSecond;
        }

        @Override
        public void run() {
            System.out.println("开始执行任务");
            scheduledExecutionTime();
            System.out.println("结束执行任务");
        }
    }


    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        System.out.println(System.currentTimeMillis());
//1
//        threadTask innerTask=new threadTask();
//        innerTask.run();
//2TODO
//         runableTask runableTask=new runableTask();
//         runableTask.run();
//3
//        TimerTaskThree timerTaskThree=new TimerTaskThree();
//        timerTaskThree.run();
//        Timer timer=new Timer();
//        long delay=waitLongSecond;
//        long periodSeconds=1;
//        timer.schedule(timerTaskThree,delay);
//        timer.scheduleAtFixedRate(timerTaskThree,delay);
//4
        runableTask runableTask=new runableTask();
        ScheduledExecutorService scheduledExecutorService= Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(runableTask,10, TimeUnit.SECONDS);
        long end=System.currentTimeMillis();
        System.out.println("任务执行时间"+(end-start));
        System.out.println("任务测试：");
    }











}
