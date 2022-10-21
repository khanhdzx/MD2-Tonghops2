package Main;

import entity.Catalog;
import entity.User;
import impl.CatalogImp;
import impl.UserImp;
import notify.ShopMessage;

import java.util.Scanner;

public class ShopManagement {
    private static CatalogImp catImp =new CatalogImp();
    private static UserImp userImp =new UserImp();

    public static void main(String[] args) {
        User userKhanhSky = new User(1,"KhanhSky","23102003","Khánh Nguyễn",true,true);
        userImp.create(userKhanhSky);
        Scanner sc =new Scanner(System.in);
        do {
            System.out.println("*********************CỬA HÀNG ABC*******************");
            System.out.println("1.Đăng nhập ");
            System.out.println("2.Đăng ký ");
            System.out.println("3.Thoát ");
            System.out.println("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    login(sc);
                    break;
                case 2:
                    break;
                case 3:
                    sc.close();
                    System.exit(0);
                default:
                    System.err.println(ShopMessage.NOTIFY_SHOP_CHOICE);
            }
        }while (true);
    }
    public static void login(Scanner sc){
        do {
            System.out.println("Tên đăng nhập: ");
            String userName = sc.nextLine();
            System.out.println("Mật khẩu: ");
            String password = sc.nextLine();
            User user = userImp.checkLogin(userName,password);
            if (user!=null){
                if (user.isPermission()){
                    displayMenuShopManagement(sc);
                }else {
                    displayMenuUser(sc);
                }
                break;
            }else {
                System.out.println(ShopMessage.NOTIFY_LOGIN_FAIL);
                System.out.println("1.Đăng nhập lại");
                System.out.println("2.Đăng ký tài khoản");
                System.out.println("3.Thoát");
                System.out.println("Sự lựa chọn: ");
                int choice =Integer.parseInt(sc.nextLine());
                if (choice==2){
                    
                }else if (choice == 3){
                    break;
                }
            }
        }while (true);
    }
    public static void displayMenuShopManagement(Scanner sc){
        boolean exit = true;
        do {
            System.out.println("******************QUẢN LÝ CỬA HÀNG***********************");
            System.out.println("1.Quản lý danh mục");
            System.out.println("2.Quản lý sản phẩm");
            System.out.println("3.Quản lý người dùng");
            System.out.println("4.Thoát");
            System.out.println("Sự lựa chọn của bạn: ");
            int choice =Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    displayMenuCatalogManagement(sc);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    exit= false;
                    break;
                default:
                    System.err.println(ShopMessage.NOTIFY_SHOP_MANAGEMENT_CHOICE);
            }
        }while (exit);
    }
    public static void displayMenuUser(Scanner sc){

    }

    public static void displayMenuCatalogManagement(Scanner sc){
        boolean exit = true;
        do {
            System.out.println("*****************QUẢN LÝ DANH MỤC********************");
            System.out.println("1.Danh sách danh mục");
            System.out.println("2.Thêm mới danh mục");
            System.out.println("3.Cập nhật danh mục");
            System.out.println("4.Xoá danh mục");
            System.out.println("5.Tìm danh mục theo tên");
            System.out.println("6.Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    catImp.displayData();
                    break;
                case 2:
                    Catalog catNew= catImp.inputData(sc);
                    boolean result = catImp.create(catNew);
                    if(result){
                        System.out.println(ShopMessage.NOTIFY_CATALOG_CREATE_SUCCESS);
                    }else {
                        System.out.println(ShopMessage.NOTIFY_CATALOG_CREATE_FAIL);
                    }
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    exit = false;
                    break;
                default:
                    System.out.println(ShopMessage.NOTIFY_SHOP_MANAGEMENT_CHOICE);
            }
        }while (exit);
    }
}
