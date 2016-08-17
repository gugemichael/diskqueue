package org.diskqueue.utils;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class RefCount {
    private AtomicInteger count = new AtomicInteger();

    public void incrRef() {
        this.count.incrementAndGet();
    }

    public void decrRef() {
        if (this.count.decrementAndGet() == 0)
            recyle();
    }

    /**
     * clean up method after decr() called if refcount decreased
     * to zero !
     *
     */
    public abstract void recyle();
}