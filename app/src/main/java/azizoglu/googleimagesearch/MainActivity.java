package azizoglu.googleimagesearch;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView search;
    private EditText searchInput;
    public static ImageView img;
    private String searchWord = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search = (TextView) findViewById(R.id.btn_search);
        img = (ImageView) findViewById(R.id.imageView);
        searchInput = (EditText) findViewById(R.id.search_input);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchWord = searchInput.getText().toString();
                CustomSearch.activity = MainActivity.this;
                new CustomSearch().execute(searchWord);
                hideKeyboard();
            }
        });
    }

    private void hideKeyboard() {
        InputMethodManager inputManager =
                (InputMethodManager) getApplicationContext().
                        getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(
                getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
