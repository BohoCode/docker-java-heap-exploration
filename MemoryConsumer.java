import java.util.Vector;

public class MemoryConsumer {

    private static float CAP = 1.2f;  // 80%
    private static int ONE_MB = 1024 * 1024;

    private static Vector cache = new Vector();

    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();

        long totalMem = rt.totalMemory();
        long maxMem = rt.maxMemory();
        long freeMem = rt.freeMemory();
        System.out.println("rt.totalMemory: " + totalMem/ONE_MB + "MB");
        System.out.println("rt.maxMemeory: " + maxMem/ONE_MB + "MB");
        System.out.println("rt.freeMemory: " + freeMem/ONE_MB + "MB");

        long usedMemBytes = totalMem - freeMem;
        System.out.println("usedMemBytes (total - free): " + usedMemBytes/ONE_MB + "MB");
        long freeMemBytes = maxMem - usedMemBytes;
        System.out.println("freeMemBytes (max - used): " + freeMemBytes/ONE_MB + "MB");

        //long allocBytes = Math.round(freeMemBytes * CAP);
        double toAlloc = freeMemBytes * CAP;
        System.out.println("toAlloc: " + toAlloc);
        long allocBytes = Double.valueOf(toAlloc).longValue();
        System.out.println("allocBytes(0.8 * freeMemBytes): " + allocBytes/ONE_MB + "MB");

        System.out.println("Reserving: " + allocBytes/ONE_MB + "MB");

        for (int i = 0; i < allocBytes / ONE_MB; i++){
            cache.add(new byte[ONE_MB]);
        }

        totalMem = rt.totalMemory();
        maxMem = rt.maxMemory();
        freeMem = rt.freeMemory();

        System.out.println("rt.totalMemory: " + totalMem/ONE_MB + "MB");
        System.out.println("rt.maxMemeory: " + maxMem/ONE_MB + "MB");
        System.out.println("rt.freeMemory: " + freeMem/ONE_MB + "MB");

        usedMemBytes = totalMem - freeMem;
        System.out.println("usedMemBytes (total - free): " + usedMemBytes/ONE_MB + "MB");
        freeMemBytes = maxMem - usedMemBytes;
        System.out.println("freeMemBytes (max - used): " + freeMemBytes/ONE_MB + "MB");

    }
}
