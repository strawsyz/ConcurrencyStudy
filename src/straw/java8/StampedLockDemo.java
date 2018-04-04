package straw.java8;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo{

	static Thread [] holdCpuThreads = new Thread [3];
	static final StampedLock lock = new StampedLock();
	public static void main(String[] args) {
		new Thread(){
			public void run(){
				long readLong =lock.writeLock();
				LockSupport.parkNanos(600000000000L);
				lock.unlockWrite(readLong);
			}
		}.start();
	}
}
