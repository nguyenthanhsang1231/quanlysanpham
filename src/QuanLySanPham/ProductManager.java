package QuanLySanPham;

import QuanLySanPham.dto.ReadAndWriteFile;

import java.util.ArrayList;

public class ProductManager {

    ArrayList<Product> list = new ArrayList<>();
    private ReadAndWriteFile readAndWriteFile;

    public ProductManager() {
        readAndWriteFile = new ReadAndWriteFile();
        this.list = readAndWriteFile.readFile();
    }
    public void addProduct(Product product) {
        this.list.add(product);
        readAndWriteFile.WriteFile(list);
    }
    public void editProduct(int id, Product product) {
        int index = findIndexById(id);
        list.set(index, product);
    }

    public void deleteProduct(int id) {
        int index = findIndexById(id);
        this.list.remove(index);
    }

    public int findIndexById(int id) {
        for (Product product : list) {
            if (product.getId() == id) {
                return product.getId();
            }
        }
        return -1;
    }
    public ArrayList<Product> findAll() {
        return list;
    }
    public ArrayList<Product> searchName(String name) {
        return list;
    }
    public ArrayList<Product> searchId(int id) {
        for (Product product: list) {
            if (product.getId() == id) {
                return list;
            }
        }
        return list;
    }
}
