package com.dal4.testretrofit.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dal4.testretrofit.R;
import com.dal4.testretrofit.database.RetrofitClient;
import com.dal4.testretrofit.models.MoviesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String api_key = "44de72d6bdmsh44c87fbd426af3cp17d89cjsnb12758d4d3e4";
    String api = "imdb8.p.rapidapi.com";

    EditText MovieEd;
    Button SearchBtn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        MovieEd = findViewById(R.id.MovieName);
        SearchBtn = findViewById(R.id.Btn_Search);
        textView = findViewById(R.id.text_VIEW);

        SearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String MovieName = MovieEd.getText().toString();
                Call<MoviesModel> call = RetrofitClient.getInstance().getMovies(MovieName, api, api_key);
                call.enqueue(new Callback<MoviesModel>() {
                    @Override
                    public void onResponse(Call<MoviesModel> call, Response<MoviesModel> response) {
                        if (response.isSuccessful() && response.code() == 200) {
                            MoviesModel moviesModel = response.body();
                            Toast.makeText(MainActivity.this, moviesModel.getD().size() + "", Toast.LENGTH_SHORT).show();

                            List<MoviesModel.MoveDetail> moveDetails = moviesModel.getD();
                            textView.setText(moveDetails.get(1).getId());
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage() +"", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}