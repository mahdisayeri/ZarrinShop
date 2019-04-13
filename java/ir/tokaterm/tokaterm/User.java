package ir.tokaterm.tokaterm;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("response")
    private String apiResponse;
    @SerializedName("name")
    private String apiName;
    @SerializedName("username")
    private String apiUserName;

    public String getApiResponse() {
        return apiResponse;
    }

    public String getApiName() {
        return apiName;
    }

    public String getApiUserName() {
        return apiUserName;
    }
}
