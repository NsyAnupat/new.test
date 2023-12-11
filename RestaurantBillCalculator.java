import java.util.Scanner;
public class RestaurantBillCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalFoodprice = 0;

        while (true) {
            System.out.print("กรอกราคาอาหาร (หากต้องการหยุดใส่ 0): ");
            double foodprice = scanner.nextDouble();
            
            if (foodprice == 0) {
                break;
            }

            totalFoodprice += foodprice;
        }

        double tax = totalFoodprice * 0.07;
        double totalbill = totalFoodprice + tax;

        System.out.println("ยอดรวม: " + totalFoodprice + " บาท");
        System.out.println("ภาษี 7%: " + tax + " บาท");
        System.out.println("ยอดรวมทั้งสิ้น: " + totalbill + " บาท");
    }
}
