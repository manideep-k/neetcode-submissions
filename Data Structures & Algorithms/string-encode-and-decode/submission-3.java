class Solution {

    public String encode(List<String> strs) {
        // ["abcd", "ef12", "hi5"] = abcdef12hi5|004004003|003
        String encoded = "";
        String length = "";
        for (String str : strs) {
            encoded = encoded + str;
            length = length + getLengthString(str.length());
        }
        encoded = encoded + length + getLengthString(strs.size());
        System.out.println("Encoded: " + encoded);
        return encoded;
    }

    public List<String> decode(String str) {
        System.out.println("Decoding string: " + str);
        int noOfStrs = Integer.parseInt(str.substring(str.length() - 3, str.length()));
        System.out.println("Number of strings: " + noOfStrs);
        if (noOfStrs == 0) {
            return new ArrayList<>();
        }
        int originalStrsLength = str.length() - (noOfStrs * 3) - 3;
        String encodedLengthStr = str.substring(originalStrsLength, str.length() - 3);
        String originalStrs = str.substring(0, originalStrsLength);
        List<String> decoded = new ArrayList<>();
        System.out.println("encodedLengthStr: " + encodedLengthStr);
        int[] encodedLengths = Arrays
                .stream(encodedLengthStr.split("(?<=\\G...)"))
                .mapToInt(Integer::parseInt).toArray();
        int lengthPointer = 0;
        for (int i = 0; i < noOfStrs; i++) {
            int length = encodedLengths[i];
            decoded.add(originalStrs.substring(i == 0 ? 0 : lengthPointer, lengthPointer + length));
            lengthPointer = lengthPointer + length;
        }
        return decoded;
    }

    private String getLengthString(int length) {
        String lengthStr = String.valueOf(length);
        if (lengthStr.length() == 1) {
            lengthStr = "00" + lengthStr;
        } else if (lengthStr.length() == 2) {
            lengthStr = "0" + lengthStr;
        }
        return lengthStr;
    }
}
