package ir.tokaterm.tokaterm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Register extends Fragment {

    private EditText user_et,pass_et;
    private Button reg_btn;


    public Register() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View reg_View=inflater.inflate(R.layout.fragment_register, container, false);

        reg_btn=reg_View.findViewById(R.id.reg_register_btn);
       user_et=reg_View.findViewById(R.id.reg_username);
        pass_et=reg_View.findViewById(R.id.reg_password);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerAction();
            }
        });

    return reg_View;
    }

    public void registerAction(){

    String user_t=user_et.getText().toString();
    String pass_t=pass_et.getText().toString();

        Call<User> userCall=Main2.apiInterface.regcall(user_t,pass_t);

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                switch (response.body().getApiResponse()) {
                    case "REGISTERED":
                        Toast.makeText(getActivity(), "شما قبلا ثبت نام کرده اید .", Toast.LENGTH_LONG).show();
                        user_et.setText("");
                        pass_et.setText("");
                        break;
                    case "SUCCESS":
                        Toast.makeText(getActivity(), "ثبت نام شما با موفقیت انجام شد .", Toast.LENGTH_LONG).show();
                       getActivity().onBackPressed();
                        break;
                    case "ERROR":
                        Toast.makeText(getActivity(), "خطا ...", Toast.LENGTH_LONG).show();

                        break;
                }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getActivity(), "connection error " +t, Toast.LENGTH_LONG).show();
            }
        });


    }

}
