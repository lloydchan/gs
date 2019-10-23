package com.matrixport.gs.in2;
/* Problem Name is &&& Sort Segments &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 **  * Instructions to candidate.
 **  *  1) Run this code in the REPL to observe its behaviour.
 **  *  2) Consider adding some additional tests.
 **  *  3) Implement sortSegments() correctly.
 **  *  4) If time permits, try to improve your implementation.
 **
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.tuple.*;

public class Solution {

  /**
   * Given a jumbled collection of segments, each of which is represented as
   * a Pair(startPoint, endPoint), this function sorts the segments to
   * make a continuous path.
   *
   * A few assumptions you can make:
   * 1. Each particular segment goes in one direction only, i.e.: if you
   * see (1, 2), you will not see (2, 1).
   * 2. Each starting point only have one way to the end point, i.e.: if
   * you see (6, 5), you will not see (6, 10), (6, 3), etc.
   *
   * For example, if you're passed a list containing the following int arrays:
   *      [(4, 5), (9, 4), (5, 1), (11, 9)]
   * Then your implementation should sort it such:
   *      [(11, 9), (9, 4), (4, 5), (5, 1)]
   *
   * @param segments collection of segments, each represented by a Pair(startPoint, endPoint).
   * @return The sorted segments such that they form a continuous path.
   * @throws Exception if there is no way to create one continuous path from
   *          all the segments passed into this function. Feel free to change the
   *          Exception type as you think appropriate.
   */
  public static List<Pair<Integer, Integer>> sortSegments(final List<Pair<Integer, Integer>> segments)
      throws Exception {
    // Pair is a simple data structure from Commons Lang.
    // Use getLeft() and getRight() to access the first and second value respectively.
    
    List<Pair<Integer, Integer>> result = new ArrayList<>();
    
    if (segments == null || segments.size() == 0)
      return result;
    
    // find start pt
    Set<Integer> endSet = new HashSet<>();
    Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
    
    for (Pair<Integer, Integer> p: segments) {
      endSet.add(p.getRight());
      map.put(p.getLeft(), p);
    }
    
    Pair<Integer, Integer> start = null;
    for (Pair<Integer, Integer> p: segments) {
      if (!endSet.contains(p.getLeft())) {
        start = p;
        // System.out.println(start.getLeft());
        break;
      }
    }
    
    result.add(start);
    Pair<Integer, Integer> current = start;
    while (result.size() < segments.size()) {
      Pair<Integer, Integer> p = map.get(current.getRight());
      if (p == null) {
        throw new Exception("discontinue segment");
      }
      result.add(p);
      current = p;
    }

    return result; 
    // throw new UnsupportedOperationException("Not implemented yet.");
  }

  public static boolean testBasicSort() throws Exception {
    List<Pair<Integer, Integer>> jumbledSegments = new ArrayList<>();
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(4, 5));
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(9, 4));
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(5, 1));
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(11, 9));

    List<Pair<Integer, Integer>> actualContinuousPath = sortSegments(jumbledSegments);

    List<Pair<Integer, Integer>> expectedContinuousPath = new ArrayList<>();
    expectedContinuousPath.add(new ImmutablePair<Integer, Integer>(11, 9));
    expectedContinuousPath.add(new ImmutablePair<Integer, Integer>(9, 4));
    expectedContinuousPath.add(new ImmutablePair<Integer, Integer>(4, 5));
    expectedContinuousPath.add(new ImmutablePair<Integer, Integer>(5, 1));

    return expectedContinuousPath.equals(actualContinuousPath);
  }
  
  public static boolean testBasicSort_discontinue() throws Exception {
    List<Pair<Integer, Integer>> jumbledSegments = new ArrayList<>();
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(9, 4));
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(11, 8));

    try {
      List<Pair<Integer, Integer>> actualContinuousPath = sortSegments(jumbledSegments);
    } catch (Exception e) {
      return true;
    }

    return false;
  }

  public static boolean testBasicSort_negative_start() throws Exception {
    List<Pair<Integer, Integer>> jumbledSegments = new ArrayList<>();
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(4, 5));
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(9, 4));
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(5, 1));
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(-1, 8));
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(8, 9));
    
    List<Pair<Integer, Integer>> actualContinuousPath = sortSegments(jumbledSegments);

    List<Pair<Integer, Integer>> expectedContinuousPath = new ArrayList<>();
    expectedContinuousPath.add(new ImmutablePair<Integer, Integer>(-1, 8));
    expectedContinuousPath.add(new ImmutablePair<Integer, Integer>(8, 9));
    expectedContinuousPath.add(new ImmutablePair<Integer, Integer>(9, 4));
    expectedContinuousPath.add(new ImmutablePair<Integer, Integer>(4, 5));
    expectedContinuousPath.add(new ImmutablePair<Integer, Integer>(5, 1));

    return expectedContinuousPath.equals(actualContinuousPath);
  }
  
  public static boolean testBasicSort_one() throws Exception {
    List<Pair<Integer, Integer>> jumbledSegments = new ArrayList<>();
    jumbledSegments.add(new ImmutablePair<Integer, Integer>(4, 5));
    
    List<Pair<Integer, Integer>> actualContinuousPath = sortSegments(jumbledSegments);

    List<Pair<Integer, Integer>> expectedContinuousPath = new ArrayList<>();
    expectedContinuousPath.add(new ImmutablePair<Integer, Integer>(4, 5));

    return expectedContinuousPath.equals(actualContinuousPath);
  }
  
  public static boolean testBasicSort_null() throws Exception {
    List<Pair<Integer, Integer>> actualContinuousPath = sortSegments(null);

    List<Pair<Integer, Integer>> expectedContinuousPath = new ArrayList<>();
 
    return expectedContinuousPath.equals(actualContinuousPath);
  }
  
  public static boolean testBasicSort_empty() throws Exception {
    List<Pair<Integer, Integer>> jumbledSegments = new ArrayList<>();
    
    List<Pair<Integer, Integer>> actualContinuousPath = sortSegments(jumbledSegments);

    List<Pair<Integer, Integer>> expectedContinuousPath = new ArrayList<>();

    return expectedContinuousPath.equals(actualContinuousPath);
  }
  
  public static boolean doTestsPass() throws Exception {
    boolean allPass = true;
    allPass = allPass && testBasicSort() && testBasicSort_negative_start() 
      && testBasicSort_empty() && testBasicSort_one() && testBasicSort_null()
      && testBasicSort_discontinue();
    
    return allPass;
  }

  public static void main(String[] args) throws Exception {
    if(doTestsPass()) {
      System.out.println("All tests pass");
    } else {
      System.out.println("Some tests fail");
    }
  }
}
