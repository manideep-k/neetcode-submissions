/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((prev, cur) -> Integer.compare(prev.start, cur.start));
        for (int i = 1; i <= intervals.size() - 1; i++) {
            Interval curr = intervals.get(i);
            Interval prev = intervals.get(i - 1);
            if (curr.start < prev.end) {
                return false;
            }
        }
        return true;
    }
}
