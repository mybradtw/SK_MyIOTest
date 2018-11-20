package tw.brad.myiotest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("config", MODE_PRIVATE);
        editor = sp.edit();

        int counter = sp.getInt("counter", 0);
        editor.putInt("counter", counter+1);
        editor.commit();

    }

    public void test1(View view) {
        editor.putString("username", "Brad");
        editor.putString("password", "123456");
        editor.putBoolean("sound", false);
        editor.commit();
        Toast.makeText(this, "Save OK", Toast.LENGTH_SHORT).show();
    }
    public void test2(View view) {
        boolean sound = sp.getBoolean("sound", true);
        String username = sp.getString("username", "guest");
        String password = sp.getString("password", "123");
        int counter = sp.getInt("counter", 0);
        Toast.makeText(this, counter + ":" + username + ":" + password + ":" + sound, Toast.LENGTH_SHORT).show();

    }
    public void test3(View view) {
        editor.clear();
        editor.commit();

    }

    public void test4(View view) {
        try {
            FileOutputStream fout = openFileOutput("data.txt", MODE_APPEND);
            fout.write("Hello,World\n".getBytes());
            fout.flush();
            fout.close();
            Toast.makeText(this, "Save2 OK", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Log.v("brad", e.toString());
        }
    }

    public void test5(View view) {

    }

}
