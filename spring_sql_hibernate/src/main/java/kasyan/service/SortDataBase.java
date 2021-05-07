package kasyan.service;

import kasyan.bean.Product;

import java.util.Comparator;
import java.util.List;

// класс для сортировки нанных

public final class SortDataBase {
    private SortDataBase() {
        throw new UnsupportedOperationException();
    }

    public static void sortByName(List<Product> listProduct) {
        Comparator<Product> sortByName = new SortByName();
        listProduct.sort(sortByName);
    }

    public static void sortByNameReverse(List<Product> listProduct) {
        Comparator<Product> sortByName = new SortByNameReverse();
        listProduct.sort(sortByName);
    }

    public static void sortByCategory(List<Product> listProduct) {
        Comparator<Product> sortByCategory = new SortByCategory();
        listProduct.sort(sortByCategory);
    }

    public static void sortByCategoryReverse(List<Product> listProduct) {
        Comparator<Product> sortByCategory = new SortByCategoryReverse();
        listProduct.sort(sortByCategory);
    }

    public static void sortByPrice(List<Product> listProduct) {
        Comparator<Product> sortByPrice = new SortByPrice();
        listProduct.sort(sortByPrice);
    }

    public static void sortByPriceReverse(List<Product> listProduct) {
        Comparator<Product> sortByPrice = new SortByPriceReverse();
        listProduct.sort(sortByPrice);
    }

    public static void sortByActualPrice(List<Product> listProduct) {
        Comparator<Product> sortByActualPrice = new SortByActualPrice();
        listProduct.sort(sortByActualPrice);
    }

    public static void sortByActualPriceReverse(List<Product> listProduct) {
        Comparator<Product> sortByActualPrice = new SortByActualPriceReverse();
        listProduct.sort(sortByActualPrice);
    }

    public static void sortByIdReverse(List<Product> listProduct) {
        Comparator<Product> sortById = new SortByIdReverse();
        listProduct.sort(sortById);
    }

    public static void sortById(List<Product> listProduct) {
        Comparator<Product> sortById = new SortById();
        listProduct.sort(sortById);
    }

    public static void sortByDiscount(List<Product> listProduct) {
        Comparator<Product> sortByDiscount = new SortByDiscount();
        listProduct.sort(sortByDiscount);
    }

    public static void sortByDiscountReverse(List<Product> listProduct) {
        Comparator<Product> sortByDiscount = new SortByDiscountReverse();
        listProduct.sort(sortByDiscount);
    }

    public static void sortByTotalVolume(List<Product> listProduct) {
        Comparator<Product> sortByTotalVolume = new SortByTotalVolume();
        listProduct.sort(sortByTotalVolume);
    }

    public static void sortByTotalVolumeReverse(List<Product> listProduct) {
        Comparator<Product> sortByTotalVolume = new SortByTotalVolumeReverse();
        listProduct.sort(sortByTotalVolume);
    }

    static class SortByName extends Product implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    static class SortByNameReverse extends Product implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return o2.getName().compareTo(o1.getName());
        }
    }

    static class SortByActualPrice implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return (int) o1.getActualPrice() - (int) o2.getActualPrice();
        }
    }

    static class SortByActualPriceReverse implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return (int) o2.getActualPrice() - (int) o1.getActualPrice();
        }
    }

    static class SortByCategory implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    }

    static class SortByCategoryReverse implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return o2.getCategory().compareTo(o1.getCategory());
        }
    }

    static class SortById implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return o1.getId() - o2.getId();
        }
    }

    static class SortByIdReverse implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return o2.getId() - o1.getId();
        }
    }

    static class SortByPrice implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return (int) o1.getPrice() - (int) o2.getPrice();
        }
    }

    static class SortByPriceReverse implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return (int) o2.getPrice() - (int) o1.getPrice();
        }
    }

    static class SortByDiscount implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return (int) o1.getDiscount() - (int) o2.getDiscount();
        }
    }

    static class SortByDiscountReverse implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return (int) o2.getDiscount() - (int) o1.getDiscount();
        }
    }
    static class SortByTotalVolume implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return (int) o1.getTotalVolume() - (int) o2.getTotalVolume();
        }
    }

    static class SortByTotalVolumeReverse implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return (int) o2.getTotalVolume() - (int) o1.getTotalVolume();
        }
    }
}