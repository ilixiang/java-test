package guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {
    @Test
    public void testLoad() throws Exception{
        LoadingCache<Integer, String> loadingCache = CacheBuilder.newBuilder()
                .build(new CacheLoader<Integer, String>() {
                    @Override
                    public String load(Integer key) throws Exception {
                        return System.currentTimeMillis() + " Value " + key;
                    }
                });
        // manually put
        System.out.println("-------------- 手动载入数据 ------------");
        loadingCache.put(1, "Manual Value 1");
        System.out.println(String.format("The value of key %d is %s", 1, loadingCache.get(1)));
        System.out.println("-------------- 自动载入数据 ------------");
        System.out.println(String.format("The value of key %d is %s", 2, loadingCache.get(2)));
    }

    @Test
    public void testMaximumSize() throws Exception{
        LoadingCache<Integer, String> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .build(new CacheLoader<Integer, String>() {
                    @Override
                    public String load(Integer key) throws Exception {
                        return System.currentTimeMillis() + " Value " + key;
                    }
                });
        // manually put
        loadingCache.put(1, "Manual Value 1");
        loadingCache.put(2, "Manual Value 2");
        loadingCache.get(1);
        loadingCache.put(3, "Manual Value 3");
        System.out.println(String.format("The value of key %d is %s", 2, loadingCache.getIfPresent(2)));
    }

    @Test
    public void testExpireAfterAccess() throws Exception{
        LoadingCache<Integer, String> loadingCache = CacheBuilder.newBuilder()
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .build(new CacheLoader<Integer, String>() {
                    @Override
                    public String load(Integer key) throws Exception {
                        return System.currentTimeMillis() + " Value " + key;
                    }
                });
        // manually put
        loadingCache.put(1, "Manual Value 1");
        System.out.println("------- 1秒前 --------");
        System.out.println(String.format("The value of key %d is %s", 1, loadingCache.getIfPresent(1)));
        Thread.sleep(1000);
        System.out.println("------- 1秒后 --------");
        System.out.println(String.format("The value of key %d is %s", 1, loadingCache.getIfPresent(1)));
    }

    @Test
    public void testValueReferenceEvict() throws Exception{
        LoadingCache<Integer, String> loadingCache = CacheBuilder.newBuilder()
                .weakValues()
                .build(new CacheLoader<Integer, String>() {
                    @Override
                    public String load(Integer key) throws Exception {
                        return System.currentTimeMillis() + " Value " + key;
                    }
                });
        // manually put
        loadingCache.put(128, new String("Manual Value 128"));
        System.out.println("------- GC前 --------");
        System.out.println(String.format("The value of key %d is %s", 128, loadingCache.getIfPresent(128)));
        System.gc();
        System.out.println("------- GC后 --------");
        System.out.println(String.format("The value of key %d is %s", 128, loadingCache.getIfPresent(128)));
    }

    @Test
    public void testKeyReferenceEvict() throws Exception{
        LoadingCache<Integer, String> loadingCache = CacheBuilder.newBuilder()
                .weakKeys()
                .build(new CacheLoader<Integer, String>() {
                    @Override
                    public String load(Integer key) throws Exception {
                        return System.currentTimeMillis() + " Value " + key;
                    }
                });
        // manually put
        Integer key = 128;
        loadingCache.put(key, "Manual Value 128");
        System.out.println("------- 持有引用 --------");
        System.out.println(String.format("The value of key %d is %s", key, loadingCache.getIfPresent(key)));
        key = 128;
        System.out.println("------- 不持有引用 --------");
        System.out.println(String.format("The value of key %d is %s", key, loadingCache.getIfPresent(key)));
    }

    @Test
    public void testSoftValues() throws InterruptedException, ExecutionException {
        LoadingCache<Integer, String> loadingCache = CacheBuilder.newBuilder()
                .weakKeys()
                .build(new CacheLoader<Integer, String>() {
                    @Override
                    public String load(Integer key) throws Exception {
                        return System.currentTimeMillis() + " Value " + key;
                    }
                });
        loadingCache.get(128);
        loadingCache.get(129);
        loadingCache.get(130);
        System.gc();
        loadingCache.get(128);
        System.out.println(loadingCache.getIfPresent(1));
    }

    @Test
    public void callableTest() throws ExecutionException {
        Cache<Integer, String> cache = CacheBuilder.newBuilder()
                .maximumSize(10)
                .expireAfterAccess(10, TimeUnit.SECONDS)
                .build();
        cache.get(1, () -> "hello world");
    }
}
