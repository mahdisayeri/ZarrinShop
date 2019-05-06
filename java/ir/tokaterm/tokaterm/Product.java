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

    @SerializedName("other_imageUrl")
    private String apiOther_imageUrl;


//    public Product(String apiComment_count,String apiDescription) {
//
//        this.apiComment_count=apiComment_count;
//        this.apiDescription = apiDescription;
//
//    }

    public Product(String apiproduct_id,String apiImageUrl, String apiTitle, String apiprice,
                   String apiOffPercentage,String apiComment_count,String apiDescription) {
        this.apiproduct_id=apiproduct_id;
        this.apiImageUrl = apiImageUrl;
        this.apiTitle = apiTitle;
        this.apiprice = apiprice;
        this.apiOffPercentage = apiOffPercentage;
        this.apiComment_count=apiComment_count;
        this.apiDescription = apiDescription;
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

    public String getApiOther_imageUrl() {
        return apiOther_imageUrl;
    }

    public void setApiOther_imageUrl(String apiOther_imageUrl) {
        this.apiOther_imageUrl = apiOther_imageUrl;
    }
}
