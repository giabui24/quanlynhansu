import java.util.Scanner;

public class Main {
	
	 public static Scanner scanner = new Scanner(System.in);
	 public static void showMenu() {
         System.out.println("-----------menu------------");
         System.out.println("1. Them phong ban.");
         System.out.println("2. delete phong ban.");
         System.out.println("3. update phong ban.");
         System.out.println("4. show phong ban.");
         System.out.println("5. them nhan vien.");
         System.out.println("6. xoa nhan vien");
         System.out.println("7. update nhan vien.");
         System.out.println("8. show nhan vien.");
         System.out.println("9. sua phong ban nhan vien.");
         System.out.println("0. exit.");
         System.out.println("---------------------------");
         System.out.print("Please choose: ");
     }
public static void main(String[] args) {
	 String choose = null;
     boolean exit = false;
     QuanLyNhanSu quanly = new QuanLyNhanSu();
   
     showMenu();
     while (true) {
         choose = scanner.nextLine();
         switch (choose) {
         case "1":
             quanly.addPhongBan();
             break;
         case "2":
            quanly.deletePhongBan();
             break;
         case "3":
           quanly.updatePhongBan();
             break;
         case "4":
             quanly.showListPhongBan();
             break;
         case "5":
             quanly.addNhanVien();
             break;
         case "6":
             quanly.deleteNhanVien();
             break;
         case "7":
             quanly.updateNhanVien();
             break;
         case "8":
             quanly.showListNhanVien();
             break;
         case "9":
             quanly.updateNhanVienPhongBan();
             break;
         case "0":
             System.out.println("exited!");
             exit = true;
             break;
         default:
             System.out.println("invalid! please choose action in below menu:");
             break;
         }
         if (exit) {
             break;
         }
         // show menu
         showMenu();
     }
}
}
