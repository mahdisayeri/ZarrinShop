package ir.tokaterm.tokaterm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ofline_Fragment extends Fragment {


    private TextView check_network;
    private Button retry_connect;

    public Ofline_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_ofline, container, false);

        check_network=view.findViewById(R.id.offline_check_network_textView);
        retry_connect=view.findViewById(R.id.offline_retry_connect);

        check_network.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "check_network", Toast.LENGTH_SHORT).show();
            }
        });

        retry_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "retry connect", Toast.LENGTH_SHORT).show();
            }
        });






        return view;
    }

}
