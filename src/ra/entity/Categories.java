package ra.entity;

import java.util.Scanner;

public class Categories {
    private int catalogID;
    private String catalogName;
    private String description;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogID, String catalogName, String description, boolean catalogStatus) {
        this.catalogID = catalogID;
        this.catalogName = catalogName;
        this.description = description;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(int catalogID) {
        this.catalogID = catalogID;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    // inputData
    public void inputData(Scanner scanner, Categories[] arrCategories, int indexCategories) {
        this.catalogID = inputCatalogID(arrCategories, indexCategories);
        this.catalogName = inputCatalogName(scanner, arrCategories, indexCategories);
        this.description = inputDescription(scanner);
        this.catalogStatus = inputCatalogStatus((scanner));

    }
    //validate dữ liệu:
//    public int inputCatalogID(Categories[] arrCategories, int indexCategories){
//        if(indexCategories == 0){
//            return 1;
//        }
//        else {
//            //B1: Tìm max câtlogID
////            B2: return max +1
//            int max = arrCategories[0].getCatalogID();
//            for (int i = 1; i < indexCategories ; i++) {
//                if(max<arrCategories[i].getCatalogID()){
//                    max = arrCategories[i].getCatalogID();
//                }
//
//            }
//            return  max +1;
//        }
//    }

    public int inputCatalogID(Categories[] arrCategories, int indexCategories) {
        if (indexCategories == 0) {
            return 1;
        } else {
            int max = arrCategories[0].getCatalogID();
            for (int i = 1; i < indexCategories; i++) {
                if (max < arrCategories[i].getCatalogID()) {
                    max = arrCategories[i].getCatalogID();
                }

            }
            return max + 1;
        }

    }


    public String inputCatalogName(Scanner scanner, Categories[] arrCategories, int indexCategories) {
        System.out.println("Nhập tên danh mục:");
        String CatalogName = scanner.nextLine();
        do {
            if (CatalogName.length() <= 50) {
                //Kiểm tra trùng lặp
                boolean isExist = false;
                for (int i = 0; i < indexCategories; i++) {
                    if (arrCategories[i].getCatalogName().equals(CatalogName)) {
                        isExist = true;
                        break;
                    }
                    if (isExist) {
                        System.err.println("Danh mục đã tồn tại, vui lòng nhập lại");
                    } else {
                        return catalogName;
                    }

                }

            } else {
                System.err.println("Danh mục tối đa 50 ký tự, vui lòng nhập lại");
            }

        }
        while (true);


    }


    public String inputDescription(Scanner scanner) {
        System.out.println("Nhập mô tả danh mục");
        return scanner.nextLine();
    }

    public boolean inputCatalogStatus(Scanner scanner) {
        System.out.println("Nhập vào trang thái danh mục");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals(("false"))) {
                return Boolean.parseBoolean(status);

            } else {
                System.err.println("TRạng thái chỉ nhận 1 trong 2 giá trị true hoặc false vui lòng nhập lại.");
            }

        }
        while (true);
    }




public  void displayData(){
    System.out.printf("Mã danh mục : %d - Tên danh mục :  %s - Mô tả : %s - Trạng thái : %s \n" ,
            this.catalogID, this.catalogName, this.description, this.catalogStatus?"Hoạt động":"Không hoạt đông");
}
}
