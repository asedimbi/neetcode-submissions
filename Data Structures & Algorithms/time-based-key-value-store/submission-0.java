class TimeMap {

    //Define a HashMap
    Map<String, List<TimedStatus>> timeMap;

    public TimeMap() {
        this.timeMap = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {

        this.timeMap.putIfAbsent(key, new ArrayList<>());
        this.timeMap.get(key).add(new TimedStatus(timestamp, value));
        
    }
    
    public String get(String key, int timestamp) {

        List<TimedStatus> statuses = this.timeMap.getOrDefault(key, null);
        if(statuses == null){
            return "";
        }  

        //binary search on statuses list
        return binarySearchList(statuses, timestamp);
        
    }

    private String binarySearchList(List<TimedStatus> statuses, int timestamp) {

        int l = 0, r = statuses.size() - 1;
        int resultIndex = -1;

        while (l <= r) {

            int m = l + (r - l) / 2;
            int t = statuses.get(m).getTimeStamp();

            if (t <= timestamp) {
                resultIndex = m;  // Valid candidate
                l = m + 1;        // Try finding a closer timestamp
            } else {
                r = m - 1;        // Timestamp is too large
            }
        }

        return (resultIndex == -1) ? "" : statuses.get(resultIndex).getStatus();
    }

    class TimedStatus implements Comparable<TimedStatus>{

        int timeStamp;
        String status;

        //constructor
        public TimedStatus(int timeStamp, String status){
            this.timeStamp = timeStamp;
            this.status = status;
        }

        @Override
        public int compareTo(TimedStatus other){
            return Integer.compare(this.timeStamp, other.timeStamp);
        }

        @Override
        public String toString(){
            return "(" + this.timeStamp + ", " + this.status + ")";
        }

        public int getTimeStamp(){
            return this.timeStamp;
        }

        public String getStatus(){
            return this.status;
        }

    }
}
