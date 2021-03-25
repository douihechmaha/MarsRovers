package com.marsRovers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    private Lock lock = new ReentrantLock();

    public void runThread(String fichierSource) {
        lock.lock();
        try {
            Services.readAndExtractFile(fichierSource);
        } finally {
            lock.unlock();
        }
    }

    public void finished() {
        System.out.print("this thread has finished : ");
    }
}