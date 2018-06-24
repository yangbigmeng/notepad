package com.notepad.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字符串匹配类
 *
 * Created by YM on 2017/7/2.
 */
public class DictionarySearch {

    /**
     * 全匹配
     * @param query 待匹配的问句
     * @return 匹配的词, 词的位置
     */
    public Map<String, List<Integer>> getAllMatch(String query) {
        Map<String, List<Integer>> matchedWord = new HashMap<>();
        for (int start = 0; start < query.length(); start ++) {
            int span = 1;
            while ((start + span) < query.length() + 1) {
                String needMatch = query.substring(start, start + span);
                if (wordDictionary.containsKey(needMatch)) {
                    if (wordDictionary.get(needMatch)) {
                        updateMatchedWord(matchedWord, needMatch, start);
                    }
                    span ++;
                } else {
                    break;
                }
            }
        }
        return matchedWord;
    }

    /**
     * 最大匹配
     * @param query 待匹配的问句
     * @return 匹配的词, 词的位置
     */
    public Map<String, List<Integer>> getMaxMatch(String query) {
        Map<String, List<Integer>> matchedWord = new HashMap<>();
        for (int start = 0; start < query.length(); ) {
            int span = 1;
            while ((start + span) < query.length() + 1) {
                String needMatch = query.substring(start, start + span);
                if (wordDictionary.containsKey(needMatch)) {
                    span ++;
                } else {
                    break;
                }
            }
            // 发现不匹配之后, 才将匹配的word写入结果
            if (1 != span) {
                span --;
                updateMatchedWord(matchedWord, query.substring(start, start + span), start);
            }
            start += span;
        }
        return matchedWord;
    }

    /**
     * 根据word构造单字索引; word -> true, 否则 false
     *  //TODO 空白字符处理， 尤其是多个空白字符
     * @param word 词
     */
    public boolean addKey(String word) {
        if (!StringUtil.isValid(word)) {
            return true;
        }
        wordDictionary.put(word, true);
        for (int i = 1; i < word.length(); i ++) {
            String subString = word.substring(0, i);
            if (wordDictionary.getOrDefault(subString, false)) {
                continue;
            }
            wordDictionary.put(subString, false);
        }
        return true;
    }

    /**
     * 更新匹配的词结果
     * @param matchedWord 匹配的词结果
     * @param word 匹配到的词
     * @param index 词的起点位置
     */
    private void updateMatchedWord(Map<String, List<Integer>> matchedWord, String word, int index) {
        List<Integer> startIndex = matchedWord.getOrDefault(word, new ArrayList<>());
        startIndex.add(index);
        matchedWord.put(word, startIndex);
    }

    /** 词典 key -> word, value -> true/false */
    private Map<String, Boolean> wordDictionary = new HashMap<String, Boolean>();

    public Map<String, Boolean> getWordDictionary() {
        return wordDictionary;
    }
}
