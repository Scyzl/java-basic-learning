package cn.itcast.day04.treeSet;

import java.time.Instant;
import java.util.Objects;

public class Item implements Comparable<Item> {
    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return partNumber == item.partNumber &&
                Objects.equals(description, item.description);
    }

    // 返回对象的散列码，散列码可以是任何整数(包括正数、负数)。equals和hashCode的定义必须兼容,
    // 即如果x.equals(y)为true, x.hashCode()必须等于y.hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    /**
     * 默认使用partNumber进行排序，若partNumber相等，则使用description进行排序
     * @param o Item对象
     * @return 比较结果
     */
    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(partNumber, o.partNumber);
        // 两个Item对象的partNumber不等，则返回比较结果diff；相等则返回description的比较结果
        return diff != 0 ? diff : description.compareTo(o.description);
    }
}
