class KthLargest {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
                continue;
            }
            add(num);
            System.out.println(minHeap);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
            return minHeap.peek();
        }
        if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
