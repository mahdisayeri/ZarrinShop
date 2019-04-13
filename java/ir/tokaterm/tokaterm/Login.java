package ir.tokaterm.tokaterm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {


    EditText user,pass;
    Button login_btn;

    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View login_view=inflater.inflate(R.layout.fragment_login, container, false);

       user=login_view.findViewById(R.id.log_username);
       pass=login_view.findViewById(R.id.log_password);
       login_btn=login_view.findViewById(R.id.log_login_btn);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAction();
            }
        });


        return login_view;
    }

    public void loginAction(){

        String luser=user.getText().toString();
        String lpass=pass.getText().toString();
        Call<User> calluser=Main2.apiInterface.logincall(luser,lpass);
       // Toast.makeText(getActivity(), luser+"   " +lpass, Toast.LENGTH_LONG).show();

        calluser.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> respo) {

                switch (respo.body().getApiResponse()) {
                    case "SUCCESS LOGIN":
                        Toast.makeText(getActivity(), "ورود با موفقیت انجام شد ", Toast.LENGTH_LONG).show();
                        getActivity().onBackPressed();

                        break;
                    case "PASSWORD INCORECT":
                        Toast.makeText(getActivity(), "رمز عبور وارد شده اشتباه است .", Toast.LENGTH_LONG).show();


                        break;
                    case "NOT EXIST USERNAME":
                        Toast.makeText(getActivity(), "نام کاربری وجود ندارد .", Toast.LENGTH_LONG).show();

                        break;
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getActivity(),  "خطا در اتصال"+t, Toast.LENGTH_LONG).show();
            }
        });

    }


}
