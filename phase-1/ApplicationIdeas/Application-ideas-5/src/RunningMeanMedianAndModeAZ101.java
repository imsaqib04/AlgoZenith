import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RunningMeanMedianAndModeAZ101 {

        static final long MOD = 1000000007;

        static long power(long a, long b) {
            long result = 1;
            a %= MOD;
            while (b > 0) {
                if ((b & 1) == 1)
                    result = (result * a) % MOD;
                a = (a * a) % MOD;
                b >>= 1;
            }
            return result;
        }

        static long modInverse(long a) {
            return power(a, MOD - 2);
        }

        public static void main(String[] args) throws Exception {

            BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
            StringBuilder sb = new StringBuilder();
            int T = Integer.parseInt(br.readLine());

            while (T-- > 0) {

                int Q = Integer.parseInt(br.readLine());

                long sum = 0;
                int size = 0;

                PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>( Collections.reverseOrder());

                HashMap<Integer, Integer> freq = new HashMap<>();
                TreeMap<Integer, TreeSet<Integer>> freqMap = new TreeMap<>();

                for (int i = 0; i < Q; i++) {

                    String line = br.readLine();
                    String[] parts = line.split(" ");

                    String query = parts[0];

                    if (query.equals("insert")) {
                        int x = Integer.parseInt(parts[1]);

                        // Mean
                        sum += x;
                        size++;

                        // Median
                        if (maxHeap.isEmpty() || x <= maxHeap.peek())
                            maxHeap.add(x);
                        else
                            minHeap.add(x);

                        // Balance
                        if (maxHeap.size() > minHeap.size() + 1)
                            minHeap.add(maxHeap.poll());
                        else if (minHeap.size() > maxHeap.size())
                            maxHeap.add(minHeap.poll());

                        // Mode
                        int oldFreq = freq.getOrDefault(x, 0);
                        int newFreq = oldFreq + 1;
                        freq.put(x, newFreq);

                        if (oldFreq > 0) {
                            freqMap.get(oldFreq).remove(x);
                            if (freqMap.get(oldFreq).isEmpty())
                                freqMap.remove(oldFreq);
                        }

                        freqMap.putIfAbsent(newFreq, new TreeSet<>());
                        freqMap.get(newFreq).add(x);
                    }

                    else if (query.equals("remove")) {
                        int x = Integer.parseInt(parts[1]);

                        sum -= x;
                        size--;

                        // Median remove
                        if (x <= maxHeap.peek())
                            maxHeap.remove(x);
                        else
                            minHeap.remove(x);

                        // Balance
                        if (maxHeap.size() > minHeap.size() + 1)
                            minHeap.add(maxHeap.poll());
                        else if (minHeap.size() > maxHeap.size())
                            maxHeap.add(minHeap.poll());

                        // Mode
                        int oldFreq = freq.get(x);
                        int newFreq = oldFreq - 1;

                        freqMap.get(oldFreq).remove(x);
                        if (freqMap.get(oldFreq).isEmpty())
                            freqMap.remove(oldFreq);

                        if (newFreq == 0)
                            freq.remove(x);
                        else {
                            freq.put(x, newFreq);
                            freqMap.putIfAbsent(newFreq, new TreeSet<>());
                            freqMap.get(newFreq).add(x);
                        }
                    }

                    else if (query.equals("getMean")) {
                        if (size == 0)
                            sb.append(-1).append("\n");
                        else {
                            long ans = (sum % MOD) * modInverse(size) % MOD;
                            sb.append(ans).append("\n");
                        }
                    }

                    else if (query.equals("getMedian")) {
                        if (size == 0)
                            sb.append(-1).append("\n");
                        else {
                            if (size % 2 == 1)
                                sb.append(maxHeap.peek()).append("\n");
                            else {
                                long a = maxHeap.peek();
                                long b = minHeap.peek();
                                long ans = ((a + b) % MOD) * modInverse(2) % MOD;
                                sb.append(ans).append("\n");
                            }
                        }
                    }

                    else if (query.equals("getMode")) {
                        if (size == 0)
                            sb.append(-1).append("\n");
                        else {
                            int maxFreq = freqMap.lastKey();
                            int mode = freqMap.get(maxFreq).first();
                            sb.append(mode).append("\n");
                        }
                    }
                }
            }

            System.out.print(sb);
        }
    }