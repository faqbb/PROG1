import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BonusTrack1 {
    public static void main(String[] args) {
        int num = 1;
        int maxQuantity = 100;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (num != 0) {
            try {
                Item producto = userSetItem();
                System.out.println("ID: " + producto.id + " Nombre: " + producto.name + " fecha: " + producto.date + " time: " + producto.time + " Cantidad: " + producto.quantity + " Prioridad: " + producto.priority);
                producto = checkQuantityLimit(producto, maxQuantity);
                System.out.println("Insterte 0 para terminar");
                num = Integer.valueOf(input.readLine());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    static class Item {
        private int id;
        private String name;
        private String date;
        private String time;
        private int quantity;
        private String priority;

        public void setItem(int id, String name, String date, String time, int quantity, String priority) {
            this.id = id;
            this.name = name;
            this.date = date;
            this.time = time;
            this.quantity = quantity;
            this.priority = priority;
        }
    }

    public static Item userSetItem() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserte ID");
        int id = Integer.valueOf(input.readLine());
        System.out.println("Inserte nombre");
        String name = input.readLine();
        System.out.println("Inserte fecha");
        String date  = input.readLine();
        System.out.println("Inserte hora");
        String time = input.readLine();
        System.out.println("Inserte cantidad");
        int quantity = Integer.valueOf(input.readLine());
        System.out.println("Inserte prioridad");
        String priority = input.readLine();
        Item item = new Item();
        item.setItem(id, name, date, time, quantity, priority);
        return item;
    }

    public static Item checkQuantityLimit(Item product, int maxQuantity) throws IOException {
        if (product.quantity >= maxQuantity) {
            System.out.println("Cantidad máxima alcanzada");
            Item item = new Item();
            item.setItem(product.id, product.name, product.date, product.time, product.quantity, "baja");
            System.out.println("ID: " + item.id + " Nombre: " + item.name + " fecha: " + item.date + " time: " + item.time + " Cantidad: " + item.quantity + " Prioridad: " + item.priority);
            return item;
        } else {
            return product;
        }
    }
  
}
