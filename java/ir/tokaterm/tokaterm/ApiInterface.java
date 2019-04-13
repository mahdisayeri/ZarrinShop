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

}
