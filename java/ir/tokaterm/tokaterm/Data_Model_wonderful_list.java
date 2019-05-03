package ir.tokaterm.tokaterm;

public class Data_Model_wonderful_list {

    private String image;
    private String nameTitle;
    private String Price ;
    private String OffPercentage;

    public Data_Model_wonderful_list(String image, String nameTitle, String Price, String OffPercentage) {
        this.image = image;
        this.nameTitle = nameTitle;
        this.Price = Price;
        this.OffPercentage = OffPercentage;
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
