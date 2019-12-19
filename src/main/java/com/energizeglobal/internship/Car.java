package com.energizeglobal.internship;

import java.util.Comparator;

public class Car implements Comparable<Car> {
    int price;
    int horsePowers;

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", HP =" + horsePowers +
                '}';
    }

    public Car(int price, int horsePowers) {
        this.price = price;
        this.horsePowers = horsePowers;
    }

    @Override
    public int compareTo(Car other) {
        return (this.price > other.price) ? 1 : (this.price == other.price ? 0 : -1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (price != car.price) return false;
        return horsePowers == car.horsePowers;
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + horsePowers;
        return result;
    }

    static class HorsePowerComparator implements Comparator<Car> {
        @Override
        public int compare(Car first, Car second) {
            return first.horsePowers > second.horsePowers ? 1 : (first.horsePowers == second.horsePowers) ? 0 : -1;
        }
    }

}
