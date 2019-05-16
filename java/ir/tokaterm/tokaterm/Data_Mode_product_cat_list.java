package ir.tokaterm.tokaterm;

public class Data_Mode_product_cat_list {
    private String product_id;
    private String image;
    private String mainTitle;
   // private String subTitle;
    private String olePrice;
    private String offPersentage;


    public Data_Mode_product_cat_list(String product_id, String image, String mainTitle,String olePrice, String offPersentage) {
        this.product_id = product_id;
        this.image = image;
        this.mainTitle = mainTitle;
       // this.subTitle = subTitle;
        this.olePrice = olePrice;
        this.offPersentage = offPersentage;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

//    public String getSubTitle() {
//        return subTitle;
//    }
//
//    public void setSubTitle(String subTitle) {
//        this.subTitle = subTitle;
//    }

    public String getOlePrice() {
        return olePrice;
    }

    public void setOlePrice(String olePrice) {
        this.olePrice = olePrice;
    }

    public String getOffPersentage() {
        return offPersentage;
    }

    public void setOffPersentage(String offPersentage) {
        this.offPersentage = offPersentage;
    }
}
