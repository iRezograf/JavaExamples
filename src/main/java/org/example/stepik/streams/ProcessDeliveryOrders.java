package org.example.stepik.streams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

class ProcessDeliveryOrders {

    public static DeliveryOrder findFirstOrder(List<DeliveryOrder> orders) {
        List<DeliveryOrder> list = orders.stream()
                .sorted(Comparator.comparing(DeliveryOrder::getDeliveryDate))
                .limit(1)
                .collect(Collectors.toList());

        if (list.isEmpty())
            return new DeliveryOrder();
        else
            return list.get(0);
    }

    public static void printAddressesToDeliver(List<DeliveryOrder> orders) {
                orders.stream()
                        .sorted(Comparator.comparing(DeliveryOrder::getDeliveryDate))
                        .distinct()
                        .map(DeliveryOrder::getAddress)
                        .forEach(System.out::println);
    }

    public static void main(String[] args) {
//        final Scanner scanner = new Scanner(System.in);

//        List<DeliveryOrder> orders = Stream.iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
//                .map(i -> scanner.nextLine().split("\\|"))
//                .map(parts -> new DeliveryOrder(
//                        Long.parseLong(parts[0]), parts[2], LocalDate.parse(parts[1])))
//                .collect(Collectors.toList());
        List<DeliveryOrder> orders = List.of(
                new DeliveryOrder(1L, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.of(2021, 9, 3)),
                new DeliveryOrder(2L, "369 Woodside Court, Troy, NY 12180", LocalDate.of(2021, 9, 5)),
                new DeliveryOrder(3L, "837 Bowman Street, Helena, MT 59601", LocalDate.of(2021, 9, 2)),
                new DeliveryOrder(4L, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.of(2021, 9, 3))
        );

        System.out.println(findFirstOrder(orders));

        printAddressesToDeliver(orders);
    }
}

class DeliveryOrder {
    private final long orderId;
    private final String address;
    private final LocalDate deliveryDate;
    // there are even more fields: customer name, phone, products info, etc

    public DeliveryOrder() {
        this.orderId = -1;
        this.address = "No address";
        this.deliveryDate = LocalDate.MIN;
    }

    public DeliveryOrder(long orderId, String address, LocalDate deliveryDate) {
        this.orderId = orderId;
        this.address = address;
        this.deliveryDate = deliveryDate;
    }

    public static Comparator<DeliveryOrder> getComparatorByDeliveryDate() {
        return Comparator.comparing(DeliveryOrder::getDeliveryDate);
    }

    public long getOrderId() {
        return orderId;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeliveryOrder that = (DeliveryOrder) o;
        return address.equals(that.address) &&
                deliveryDate.equals(that.deliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, deliveryDate);
    }

    @Override
    public String toString() {
        return orderId + "|" + deliveryDate + "|" + address;
    }
}