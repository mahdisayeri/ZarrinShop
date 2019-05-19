package ir.tokaterm.tokaterm;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("product_id")
    private String apiproduct_id;

    @SerializedName("imageUrl")
    private String apiImageUrl;

    @SerializedName("title")
    private String apiTitle;

    @SerializedName("price")
    private String apiprice;

    @SerializedName("offPercentage")
    private String apiOffPercentage;

    @SerializedName("rate")
    private String apiRate;

    @SerializedName("comment_count")
    private String apiComment_count;

    @SerializedName("product_description")
    private String apiDescription;

    @SerializedName("img1")
    private String apiImg1;

    @SerializedName("img2")
    private String apiImg2;

    @SerializedName("img3")
    private String apiImg3;


//    public Product(String apiComment_count,String apiDescription) {
//
//        this.apiComment_count=apiComment_count;
//        this.apiDescription = apiDescription;
//
//    }


    public Product(String apiproduct_id, String apiImageUrl, String apiTitle, String apiprice, String apiOffPercentage, String apiRate, String apiComment_count, String apiDescription, String apiImg1, String apiImg2, String apiImg3) {
        this.apiproduct_id = apiproduct_id;
        this.apiImageUrl = apiImageUrl;
        this.apiTitle = apiTitle;
        this.apiprice = apiprice;
        this.apiOffPercentage = apiOffPercentage;
        this.apiRate = apiRate;
        this.apiComment_count = apiComment_count;
        this.apiDescription = apiDescription;
        this.apiImg1 = apiImg1;
        this.apiImg2 = apiImg2;
        this.apiImg3 = apiImg3;
    }

    public String getApiComment_count() {
        return apiComment_count;
    }

    public void setApiComment_count(String apiComment_count) {
        this.apiComment_count = apiComment_count;
    }

    public String getApiproduct_id() {
        return apiproduct_id;
    }

    public void setApiproduct_id(String apiproduct_id) {
        this.apiproduct_id = apiproduct_id;
    }

    public String getApiImageUrl() {
        return apiImageUrl;
    }

    public void setApiImageUrl(String apiImageUrl) {
        this.apiImageUrl = apiImageUrl;
    }

    public String getApiTitle() {
        return apiTitle;
    }

    public void setApiTitle(String apiTitle) {
        this.apiTitle = apiTitle;
    }

    public String getApiprice() {
        return apiprice;
    }

    public void setApiprice(String apiprice) {
        this.apiprice = apiprice;
    }

    public String getApiOffPercentage() {
        return apiOffPercentage;
    }

    public void setApiOffPercentage(String apiOffPercentage) {
        this.apiOffPercentage = apiOffPercentage;
    }

    public String getApiRate() {
        return apiRate;
    }

    public void setApiRate(String apiRate) {
        this.apiRate = apiRate;
    }

    public String getApiDescription() {
        return apiDescription;
    }

    public void setApiDescription(String apiDescription) {
        this.apiDescription = apiDescription;
    }

    public String getApiImg1() {
        return apiImg1;
    }

    public void setApiImg1(String apiImg1) {
        this.apiImg1 = apiImg1;
    }

    public String getApiImg2() {
        return apiImg2;
    }

    public void setApiImg2(String apiImg2) {
        this.apiImg2 = apiImg2;
    }

    public String getApiImg3() {
        return apiImg3;
    }

    public void setApiImg3(String apiImg3) {
        this.apiImg3 = apiImg3;
    }
}
