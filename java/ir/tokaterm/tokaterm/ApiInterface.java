package ir.tokaterm.tokaterm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {


    @POST("register.php")
    Call<User> regcall(@Query("username") String UserName,@Query("password") String Password);

    @POST("login.php")
    Call<User> logincall(@Query("username") String UserName,@Query("password") String Password);

    @GET("wonderfulList.php")
    Call<JSONResponse> wonderfulListCall(@Query("wonderfulList") String wonderfulList);

    @POST("product_moreDetails.php")
    Call<Product> product_moreDetailCall(@Query("product_id")String product_id);

}
