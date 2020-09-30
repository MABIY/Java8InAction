package lambdasinaction.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
            new Apple(155, "green"),
            new Apple(120, "red"));

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static void main(String[] args) {
        List<Apple> test = filterApples(inventory, Test::isHeavyApple);
    }

    public static boolean isHeavyApple(Apple apple) {
        if (apple == null) {
            return false;
        }

        return apple.getWeight() > 150;
    }

    public interface Predicate<T> {
        boolean test(T t);
    }

    static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
