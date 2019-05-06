package ir.tokaterm.tokaterm;

public class Data_Model_wonderful_list {

    private String product_id;
    private String image;
    private String nameTitle;
    private String Price ;
    private String OffPercentage;
    private String product_description;


    public Data_Model_wonderful_list(String product_id,String image, String nameTitle, String Price, String OffPercentage) {
       this.product_id=product_id;
        this.image = image;
        this.nameTitle = nameTitle;
        this.Price = Price;
        this.OffPercentage = OffPercentage;
    }



    public String getproduct_id() {
        return product_id;
    }

    public void setproduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getOffPercentage() {
        return OffPercentage;
    }

    public void setOffPercentage(String offPercentage) {
        OffPercentage = offPercentage;
    }
}
