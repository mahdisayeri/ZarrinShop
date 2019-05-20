package ir.tokaterm.tokaterm;

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
    Call<ProductArray> wonderfulListCall(@Query("productList") String wonderfulList);

    @POST("product_moreDetails.php")
    Call<Product> product_moreDetailCall(@Query("product_id")String product_id);

    @POST("product_category_list.php")
    Call<ProductArray> product_category_listCall(@Query("category")String Category);

    @POST("bestSellerList.php")
    Call<ProductArray> best_seller_listCall(@Query("category")String Category);

    @POST("search.php")
    Call<ProductArray> search_listCall(@Query("word")String Word);
}
