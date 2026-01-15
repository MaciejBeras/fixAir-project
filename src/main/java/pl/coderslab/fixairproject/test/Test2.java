package pl.coderslab.fixairproject.test;

import java.util.Arrays;

public class Test2 {

  public static void main(String[] args) {

    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    int result = Arrays.stream(numbers)
        .filter(n -> n % 2 == 0)
        .map(n -> n * 2)
        .sum();
  }

}

//4. Napisz strumień, który z ciągu liczb odfiltruje liczby parzyste,
//te liczby które zostały pomnoży przez dwa, a nastepnie je zsumuje.
//public class Main {
//  public static void main(String[] args) {
//    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//  }