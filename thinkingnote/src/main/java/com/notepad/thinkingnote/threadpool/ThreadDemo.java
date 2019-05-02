package com.notepad.thinkingnote.threadpool;

import java.util.Random;

/**
 * Description: 线程demo
 * <p>
 *     线程可通过实现Runnable接口，实现run方法
 *
 * Create:      2018/9/30 21:24
 *
 * @author Marvin Yang
 */
public class ThreadDemo implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        int a = 45;
        Random random = new Random(1);
        System.out.println(random.nextInt() + "int");
        System.out.println(a * random.nextInt());
    }
}
