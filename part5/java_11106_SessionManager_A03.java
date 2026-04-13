public class java_11106_SessionManager_A03 {
    // Maximum amount of memory a JVM is allowed to allocate to our program
    private static final long MAX_MEMORY = Runtime.getRuntime().maxMemory();

    // Current memory allocation
    private static long allocatedMemory = 0;

    // Method to allocate memory
    public static void allocateMemory(int size) {
        // Check if memory allocation is under the maximum limit
        if (allocatedMemory + size <= MAX_MEMORY) {
            allocatedMemory += size;
            System.out.println("Allocated " + size + " bytes of memory. Total allocated memory: " + allocatedMemory);
        } else {
            System.out.println("Not enough memory available. Maximum memory limit: " + MAX_MEMORY);
        }
    }

    // Method to release memory
    public static void releaseMemory(int size) {
        // If the size to release is less than the current memory allocation, decrease the allocation
        if (allocatedMemory - size >= 0) {
            allocatedMemory -= size;
            System.out.println("Released " + size + " bytes of memory. Current allocated memory: " + allocatedMemory);
        } else {
            System.out.println("Not enough memory allocated. Current memory allocation: " + allocatedMemory);
        }
    }
}