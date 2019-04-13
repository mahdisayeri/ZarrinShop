package ir.tokaterm.tokaterm;

public class Data_Model_wonderful_list {

    private int image;
    private String nameTitle;
    private String oldPrice ;
    private String newPrice;

    public Data_Model_wonderful_list(int image, String nameTitle, String oldPrice, String newPrice) {
        this.image = image;
        this.nameTitle = nameTitle;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }
}
