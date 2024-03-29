package ra.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
    private String productID;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private int catalogID;
    private int productStatus;

    public Product() {
    }

    public Product(String productID, String productName, float price, String description, Date created, int catalogID, int productStatus) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogID = catalogID;
        this.productStatus = productStatus;
    }


    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(int catalogID) {
        this.catalogID = catalogID;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }


    public void inputData(Scanner scanner, Product[] arrProducts, int indexProduct, Categories[] arrCategories, int indexCategories) {
        this.productID = inputProductID(scanner, arrProducts, indexProduct);
        this.productName = inputProductName(scanner, arrProducts, indexProduct);
        this.price = inputPrice(scanner);
        this.description = inputDescription(scanner);
        this.created = inputCreated(scanner);
        this.catalogID = inputCatalogID(scanner);
        this.productStatus = inputProductStatus(scanner);
    }

    public String inputProductID(Scanner scanner, Product[] arrProducts, int indexProduct) {
        System.out.println("Mời bạn nhập mã sản phẩm : ");
        String productID = scanner.nextLine();
        do {
            if (productID.length() == 4) {
                boolean isExist = false;
                for (int i = 1; i < indexProduct; i++) {
                    if (arrProducts[i].getProductID().equals(productID)) {
                        isExist = true;
                        break;
                    }
                    if (isExist) {
                        System.err.println("Mã sản phẩm đã tồn tại, vui lòng nhập lại");
                    } else {
                        return productID;
                    }


                }


            } else {
                System.err.println("Mã sản phẩm gồm 4 ký tự, mời bạn nhập lại");

            }

        }
        while (true);


    }

    public String inputProductName(Scanner scanner, Product[] arrproducts, int indexProduct) {
        System.out.println("Mời bạn nhập tên sản phẩm");
        do {
            String productName = scanner.nextLine();
            if (productName.length() >= 10 && productName.length() <= 50) {
                boolean isExist = false;
                for (int i = 1; i < indexProduct; i++) {
                    if (arrproducts[i].getProductName().equals(productName)) {
                        isExist = true;
                        break;
                    }
                }
                if (isExist) {
                    System.err.println("Tên sản phẩm đồ uống đã trùng lặp, vui lòng nhập lại");
                } else {
                    return productName;
                }

            } else {
                System.err.println("Tên sản phẩm đồ uống có độ tài từ 10-50 ký tự, vui lòng nhập lại");
            }

        }
        while (true);


    }

    public float inputPrice(Scanner scanner) {
        System.out.println("Mời bạn nhập giá sản phẩm : ");
        float price = Float.parseFloat(scanner.nextLine());
        do {
            if (price > 0) {
                return price;
            } else {
                System.err.println("Giá sản phẩm có giá trị lớn hơn 0, vui lòng nhập lại.");
            }

        }

        while (true);


    }


    public String inputDescription(Scanner scanner) {
        System.out.println("Mời bạn nhập mô tả sản phẩm : ");
        return scanner.nextLine();

    }

    public Date inputCreated(Scanner scanner){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Nhập ngày nhập sản phẩm : ");
        do {
            String created = scanner.nextLine();
            try {
                Date retuneCreated = sdf.parse(created);
                return retuneCreated;
            } catch (ParseException e) {
                System.err.println("Dịnh dạng ngày nhập không hợp lệ, vui lòng nhập sản phẩm có định dạng dd/MM/yyyy");;
            }catch (Exception ex){
                System.err.println("Có lỗi trong quá trình xử lý, vui lòng nhập lại ");
            }

        }while (true);

    }

    public  int inputCatalogID(Scanner scanner){
        System.out.println("Nhập mã danh mục mà sản phẩm thuộc về");
        return Integer.parseInt(scanner.nextLine());


    }

    public int inputProductStatus(Scanner scanner){
        System.out.println("Nhập vào trạng thái sản phẩm");
        do {
            int status = Integer.parseInt(scanner.nextLine());
            if (status == 0 || status == 1 || status == 2){
                return status;
            }
            else {
                System.err.println("Trạng thái chỉ nhận giá trị 0,1,2. vui lòng nhập lại");
            }


        }
        while (true);

    }

    public void displayData(Categories[] arrCategories, int indexCategories){
        System.out.printf("Mã SP %s - Tên SP %s - Giá $f\n", this.productID, this.productName, this.price);
        System.out.printf("Mô tả sản phẩm %s - Ngày nhập %s\n", this.description, this.created.toString());
        String catalogName = "";
        for (int i = 0; i < indexCategories; i++) {
            if (arrCategories[i].getCatalogID() == this.catalogID) {
                catalogName = arrCategories[i].getCatalogName();
                break;
            }
        }
        System.out.printf("Danh mục: %s - Trạng thái: %s\n", catalogName,
                this.productStatus == 0 ? "Đang bán" : (this.productStatus == 1 ? "Hết hàng" : "Không bán"));
    }
    }

}
