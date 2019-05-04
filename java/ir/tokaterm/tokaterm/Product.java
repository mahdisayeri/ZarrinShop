package ir.tokaterm.tokaterm;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("imageUrl")
    private String apiImageUrl;
    @SerializedName("title")
    private String apiTitle;
    @SerializedName("price")
    private String apiprice;
    @SerializedName("offPercentage")
    private String apiOffPercentage;



    public Product(String apiImageUrl, String apiTitle, String apiprice, String apiOffPercentage) {
        this.apiImageUrl = apiImageUrl;
        this.apiTitle = apiTitle;
        this.apiprice = apiprice;
        this.apiOffPercentage = apiOffPercentage;
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
}
