package concurrency;

public class Lock {
	static int threadCount = 0;
	static boolean readLockAvailable = true;
	static boolean writeLockAvailable = true;
	
	Lock (){
	}

	public static void acquireReadLock() {
		while(!isReadLockAvailable() || !isWriteLockAvailable())
			sleeps(1000);
		lockReadLock();
		incrementReadCount();
		if(getReadCount()==1)
			lockWriteLock();
		unlockReadLock();
		System.out.println("acquireReadLock");
	}
	
	public static void releaseReadLock() {
		while(!isReadLockAvailable())
			sleeps(1000);
		lockReadLock();
		decrementReadCount();
		if(getReadCount()==0)
			unlockWriteLock();
		unlockReadLock();
		System.out.println("releaseReadLock");
	}
	
	public static void acquireWriteLock() {
		while(!isReadLockAvailable() || !isWriteLockAvailable() || (getReadCount()!=0))
			sleeps(1000);
		lockWriteLock();
		lockReadLock();
		System.out.println("acquireWriteLock");
	}

	public static void releaseWriteLock() {
		unlockWriteLock();
		unlockReadLock();
		System.out.println("releaseWriteLock");
	}
	
	static void sleeps(int mSeconds) {
		try {
			Thread.currentThread().sleep(mSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static boolean isReadLockAvailable() {
		return Lock.readLockAvailable;
	}
	
	
	static boolean isWriteLockAvailable() {
		return Lock.writeLockAvailable;
	}
	
	
	static void incrementReadCount() {
		Lock.threadCount++;
	}
	
	static int getReadCount() {
		return Lock.threadCount;
	}
	
	static void decrementReadCount() {
		Lock.threadCount--;
	}
	
	static void lockWriteLock() {
		Lock.writeLockAvailable = false;
	}
	
	static void unlockWriteLock() {
		Lock.writeLockAvailable = true;
	}
	
	static void lockReadLock() {
		Lock.readLockAvailable = false;
	}
	
	static void unlockReadLock() {
		Lock.readLockAvailable = true;
	}
}
