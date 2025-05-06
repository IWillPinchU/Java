public class StoreDiffObjects {

    public static void main(String[] args) {

        Box<String> box = new Box<>();
        box.setItem("Banana");

        Box<Integer> box1 = new Box<>();
        box1.setItem(3);

        Product<String, Double> product = new Product<>("apple", 0.50);
        Product<String, Integer> product1 = new Product<>("apple", 15);

        System.out.println(box.getItem());
        System.out.println(box1.getItem());

        System.out.println(product.getItem());
        System.out.println(product.getPrice()  );

        System.out.println(product1.getItem());
        System.out.println(product1.getPrice()  );
    }
}
