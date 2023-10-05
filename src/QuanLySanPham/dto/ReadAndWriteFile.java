package QuanLySanPham.dto;

import QuanLySanPham.Product;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteFile {
    File file = new File("data/product.csv");
    public void WriteFile(ArrayList<Product> list) {
        try {
            FileWriter fileWriter = new FileWriter("product.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Product product : list) {
                line += product.getId() + "," + product.getName() + "," + product.getQuantity() + "," + product.getPrice() + "," + product.getProductType() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<Product> readFile() {
        ArrayList<Product> list =new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Product product = new Product(Integer.parseInt(data[1]), data[2], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]);
                list.add(product);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
