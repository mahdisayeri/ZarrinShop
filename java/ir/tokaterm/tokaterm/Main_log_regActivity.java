package ir.tokaterm.tokaterm;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main_log_regActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView reg_tv;
    public static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);

        toolbar=findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        apiInterface=Api.getApi().create(ApiInterface.class);

        reg_tv=findViewById(R.id.main2_login_btn);

        Login log=new Login();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.main2_frag_holder,log);
        ft.commit();

        reg_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register reg=new Register();
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.main2_frag_holder,reg);
                ft.commit();

                reg_tv.setText("");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.toobar_menu_cart:
                Toast.makeText(this, "cart", Toast.LENGTH_LONG).show();
                break;
            case R.id.toolbar_menu_search:
                Toast.makeText(this, "search", Toast.LENGTH_LONG).show();
                break;
            default:
                break;

        }

        return true;
    }


}
