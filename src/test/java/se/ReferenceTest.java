package se;

import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferenceTest {
    @Test
    public void testWeakReference() throws InterruptedException {
        ReferenceQueue<Integer> referenceQueue = new ReferenceQueue<>();
        WeakReference<Integer> reference = new WeakReference<>(128, referenceQueue);
        System.gc();
        Thread.sleep(1000);
        Reference<Integer> ref = (Reference<Integer>) referenceQueue.poll();
        System.out.println(ref == reference);
    }
}
