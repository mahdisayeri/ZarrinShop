package ir.tokaterm.tokaterm;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static final String BASE_URL="http://www.tokaterm.ir/files/api/";
    public static Retrofit myretrofit=null;

    public static Retrofit getApi(){

        if(myretrofit==null){

            myretrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return myretrofit;
    }
}

