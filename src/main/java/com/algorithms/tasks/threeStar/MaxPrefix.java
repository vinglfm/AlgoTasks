package com.algorithms.tasks.threeStar;


import java.util.*;

/**
 * Solution for 11.2013 main task in codility
 *
 * @author a.pryshchepa(vinglfm@gmail.com)
 */
public class MaxPrefix {
    private static int MAX_WEIGHT = 1000000000;
    /**
     * @param forString string to find longest prefix in
     * @return a value of the longest prefix
     * @throws IllegalArgumentException if <code>forString</code> is null
     */
    public int slowSolution(String forString) {
        if (forString == null)
            throw new IllegalArgumentException("value of the string to find prefix for can't be a null");
        if (forString.isEmpty())
            return 0;

        char[] chars = forString.toCharArray();
        Map<Character, boolean[]> letterMap = createLetterMap(chars);

        int maxProduct = 0;
        int prefixLength, currentPrefixMatches = 0, currentElementProduct;
        char currentElement;
        List<Integer> firstElemPositions = getPositions(letterMap.get(chars[0]));
        List<Character> currentPrefix = new LinkedList<>();
        for (int i = 0, size = forString.length(); i < size; ++i) {
            currentPrefix.add(chars[i]);
            prefixLength = currentPrefix.size();
            if (prefixLength == 1) {
                currentPrefixMatches = firstElemPositions.size();
            } else {
                for (int j = 0; j < firstElemPositions.size(); ++j) {
                    int checkedElems = 1;
                    int begPosition = firstElemPositions.get(j) + 1;

                    while (checkedElems < prefixLength) {
                        currentElement = currentPrefix.get(checkedElems);
                        if (begPosition >= size || !letterMap.get(currentElement)[begPosition]) {
                            break;
                        }
                        ++begPosition;
                        ++checkedElems;
                    }

                    if (checkedElems == prefixLength) {
                        ++currentPrefixMatches;
                    }
                }
            }
            currentElementProduct = prefixLength * currentPrefixMatches;
            if (currentElementProduct > maxProduct)
                maxProduct = currentElementProduct;
            currentPrefixMatches = 0;
        }

        return maxProduct;
    }

    private Map<Character, boolean[]> createLetterMap(char[] forString) {
        Map<Character, boolean[]> letterMap = new HashMap<>();
        boolean[] letterPositions;
        int pos = 0;
        for (char letter : forString) {
            letterPositions = letterMap.get(letter);
            if (letterPositions == null) {
                letterPositions = new boolean[forString.length];
                letterMap.put(letter, letterPositions);
            }
            letterPositions[pos++] = true;

        }
        return letterMap;
    }

    private List<Integer> getPositions(boolean[] presenceArr) {
        List<Integer> positions = new LinkedList<>();
        for (int i = 0; i < presenceArr.length; ++i) {
            if (presenceArr[i])
                positions.add(i);
        }
        return positions;
    }

    /**
     * @param forString string to find longest prefix in
     * @return a value of the longest prefix
     * @throws IllegalArgumentException if <code>forString</code> is null
     */
    public int anotherSlowsolution(String forString) {
        if (forString == null)
            throw new IllegalArgumentException("value of the string to find prefix for can't be a null");
        if (forString.isEmpty())
            return 0;

        char[] chars = forString.toCharArray();
        Map<String, Integer> prefixEntrances = new HashMap<String, Integer>();
        List<MatchHelper> matchingPrefixes = new LinkedList<MatchHelper>();
        List<MatchHelper> listToRemove = new LinkedList<MatchHelper>();
        List<Integer> previousBeginList = new LinkedList<Integer>();
        Character prefixBeg = chars[0];
        StringBuilder sb = new StringBuilder();
        int currentWeight;

        int maxWeight = 0;
        for (Character character : chars) {
            sb.append(character);

            String currentPrefix = sb.toString();
            currentWeight = currentPrefix.length() == 1 ? 0 :/*times = 1*/1 * /*size of the single
            prefix*/currentPrefix.length();
            if (maxWeight < currentWeight)
                maxWeight = currentWeight;
            prefixEntrances.put(currentPrefix, currentWeight);

            if (character.equals(prefixBeg)) {
                for (String prefix : prefixEntrances.keySet()) {
                    matchingPrefixes.add(new MatchHelper(prefix));
                }

                for(int i = 0, size = previousBeginList.size();  i < size; ++i) {
                    if(currentPrefix.startsWith(forString.substring(previousBeginList.get(i), currentPrefix.length() - 1))) {
                        matchingPrefixes.add(new MatchHelper(currentPrefix,
                                currentPrefix.length() - 1 - previousBeginList.get(i)));
                    }
                }

                if(currentPrefix.length() != 1) {
                    previousBeginList.add(currentPrefix.length() - 1);
                }
            }

            for (MatchHelper matchHelper : matchingPrefixes) {
                if (!matchHelper.nextMatch(character)) {
                    listToRemove.add(matchHelper);
                }

                if (matchHelper.isFinished()) {
                    currentWeight = prefixEntrances.get(matchHelper.prefix) + matchHelper.prefix.length();
                    prefixEntrances.put(matchHelper.prefix, currentWeight);
                    listToRemove.add(matchHelper);
                    if (maxWeight < currentWeight)
                        maxWeight = currentWeight;
                }
            }
            matchingPrefixes.removeAll(listToRemove);
            listToRemove.clear();
        }

        return maxWeight;
    }

    private static class MatchHelper {
        private final String prefix;
        private int position = 0;

        private MatchHelper(String prefix) {
            this.prefix = prefix;
        }

        private MatchHelper(String prefix, int fromPosition) {
            this.prefix = prefix;
            this.position = fromPosition;
        }

        private String getPrefix() {
            return prefix;
        }

        private int getPosition() {
            return position;
        }

        private boolean nextMatch(Character nextChar) {
            if (nextChar.equals(prefix.charAt(position))) {
                ++position;
                return true;
            }

            return false;
        }

        private boolean isFinished() {
            if (position == prefix.length())
                return true;
            return false;
        }

//        @Override
//        public boolean equals(Object other) {
//            if (other == null)
//                return false;
//            if (this == other)
//                return true;
//            if (!(other instanceof MatchHelper))
//                return false;
//            MatchHelper otherHelper = (MatchHelper) other;
//            return this.prefix.equals(otherHelper.prefix);
//        }
    }

    /**
     * @param forString string to find longest prefix in
     * @return a value of the longest prefix
     * @throws IllegalArgumentException if <code>forString</code> is null
     */
    public int solution(String forString) {
        if (forString == null)
            throw new IllegalArgumentException("value of the string to find prefix for can't be a null");
        if (forString.isEmpty())
            return 0;

        int[] zValues = zFunction(forString.toCharArray());

//        /* sorting */
        Arrays.sort(zValues);
//        int[] countings = new int[zValues.length + 1];

//        for(int i = 0, size = zValues.length; i < size; ++i) {
//            ++countings[zValues[i]];
//        }

//        int prevIncrements = 0;
//        for(int i = countings.length - 1; i > 0 ; --i) {
//            countings[i] += prevIncrements;
//            prevIncrements = countings[i];
//        }
        int curMax = 0, currentValue;
        for(int i = zValues.length - 1; i >= 0 && zValues[i] > 0; --i) {
            currentValue = zValues[i] * (zValues.length - i);
            curMax = Math.max(curMax, currentValue);
        }

//        int curMax = 0, currentValue;
//        for(int i = countings.length - 1; i > 0; --i) {
//            currentValue = countings[i] * i;
//            curMax = Math.max(curMax, currentValue);
//        }

        return Math.min(curMax, MAX_WEIGHT);
    }

    private int[] zFunction(char[] forChars) {

        int[] zValues = new int[forChars.length];

        int left = 0, right = 0;
        int prevZValue;
        int betta;
        int explicitTemp;
        zValues[0] = forChars.length;
        for(int i = 1; i < forChars.length; ++i ) {
           if(i > right) {
               //calculate z(k) explicitly
               for (explicitTemp = i; explicitTemp < forChars.length && forChars[explicitTemp] == forChars[explicitTemp - i]; ++explicitTemp);
               if (explicitTemp > i) {
                   zValues[i] = explicitTemp - i;
                   left = i;
                   right = explicitTemp - 1;
               }
           } else {
               prevZValue = (i - left);
               betta = right - i + 1;
               if (zValues[prevZValue] < betta) {
                   zValues[i] = zValues[prevZValue];
               } else  if (zValues[prevZValue] > betta) {
                   zValues[i] = betta;
               }
               else {
                   //calculate z(k) explicitly
//                   int iter = i + betta - 1;
                   for (explicitTemp = i; explicitTemp < forChars.length && forChars[explicitTemp] ==
                           forChars[explicitTemp - i]; ++explicitTemp);
                   zValues[i] = explicitTemp - i;
                   left = i;
                   right = explicitTemp - 1;
               }
           }
        }

        return zValues;
    }
}
