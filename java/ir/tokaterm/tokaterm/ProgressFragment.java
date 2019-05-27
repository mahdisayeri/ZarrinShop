package ir.tokaterm.tokaterm;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProgressFragment extends Fragment {


    public ProgressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_progress, container, false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main=new Intent(getContext(),MainActivity.class);
                startActivity(main);
                getActivity().finish();
            }
        },3000);

        return view;
    }

    private class operation extends AsyncTask<String,Void,String>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            return null;
        }


        @Override
        protected void onPostExecute(String s) {


        }
    }


}
