package QuanLySanPham;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuProduct {
    ProductManager productManager = new ProductManager();
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    public void showMenu() {
        int btn;
        do {
            System.out.println("=-=-MENU-=-=");
            System.out.println("Nhập số theo bảng");
            System.out.println("1. Thêm mới sản phẩm \n" +
                    "2. Sửa sản phẩm theo id \n" +
                    "3. Xóa sản phẩm \n" +
                    "4. Lấy ra tất cả sản phẩm \n" +
                    "5. Tìm kiếm theo tên \n" +
                    "6. Nhập vào loại sản phẩm va lấy ra tất cả sản phẩm cùng loại \n" +
                    "7. Tìm sản phẩm theo id \n" +
                    "0. Thoát khỏi chương trình");
            try{
                btn = inputInt.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(" hãy nhập so");
                inputInt.nextLine();
                btn = -1;
            }

            switch (btn) {
                case 1:
                    addProduc();
                    break;
                case 2:
                    editProduc();
                    break;
                case 3:
                    deleteProduc();
                    break;
                case 4:
                    showAllProduc();
                    break;
                case 7:
                    seachProducId();
                    break;
            }
        } while (btn != 0);
    }

    public void addProduc() {
        System.out.println(" Nhập tên sản phẩm");
        String nameAdd = inputString.nextLine();
        System.out.println("Số lượng sản phẩm ");
        int quantityAdd = inputInt.nextInt();
        System.out.println("Giá tiền sản phẩm");
        int priceAdd = inputInt.nextInt();
        System.out.println("Loại sản phẩm");
        String productTypeAdd = inputString.nextLine();
        Product product = new Product(nameAdd, quantityAdd, priceAdd, productTypeAdd);
        productManager.addProduct(product);

    }
    public void deleteProduc() {
        System.out.println(" Nhập id sản phẩm bạn muốn xóa");
        int idDelete = inputInt.nextInt();
        productManager.deleteProduct(idDelete);
        System.out.println(" xóa thành công !");
    }
    public void showAllProduc() {
        ArrayList<Product> list = productManager.findAll();
        for (Product product: list) {
            System.out.println(product);
        }
    }
    public void seachProducId() {
        System.out.println("Nhập id sản phẩm bạn tìm kiếm ");
        int idSeach = inputInt.nextInt();
        productManager.searchId(idSeach);
    }
    public void editProduc() {
        System.out.println("Nhập id bạn muốn sửa ");
        int idEdit = inputInt.nextInt();
        System.out.println("Thay đổi tên sản phẩm ");
        String nameEdit = inputString.nextLine();
        System.out.println("Thay đổi só lượng sản phẩm");
        int quantityAdd = inputInt.nextInt();
        System.out.println(" Gía tiền ");
        int priceEdit = inputInt.nextInt();
        System.out.println("Loại sản phẩm");
        String productTypeEdit = inputString.nextLine();
        Product product = new Product(idEdit, nameEdit, quantityAdd, priceEdit, productTypeEdit);
        productManager.editProduct(idEdit, product);
    }
}
