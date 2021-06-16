package dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> res = new LinkedList<>();
        dfs(digits, res, new StringBuilder(), 0, map);
        return res;
    }

    void dfs(String digits, List<String> res, StringBuilder curStr, int pos, HashMap<Integer, String> map) {
        if (pos == digits.length()) {
            res.add(curStr.toString());
            return;
        }
        String chars = map.get(Integer.parseInt(digits.charAt(pos) + ""));
        for (int i = 0; i < chars.length(); i++) {
//            System.out.println(i);
            curStr.append(chars.charAt(i));
            dfs(digits, res, curStr, pos+1, map);
            curStr.deleteCharAt(curStr.length()-1);
        }
    }

    public static void main(String[] args) {
        new LetterCombinationsOfPhoneNumber().letterCombinations("23");
    }
}