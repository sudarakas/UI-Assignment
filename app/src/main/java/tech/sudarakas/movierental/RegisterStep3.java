package tech.sudarakas.movierental;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.androidbuts.multispinnerfilter.KeyPairBoolData;
import com.androidbuts.multispinnerfilter.MultiSpinnerSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class RegisterStep3 extends AppCompatActivity{

    private Spinner spinnerObject;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_step_3);

        final List<String> list = Arrays.asList(getResources().getStringArray(R.array.category_array));

        final List<KeyPairBoolData> listArray0 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(list.get(i));
            h.setSelected(false);
            listArray0.add(h);
        }

        final List<KeyPairBoolData> listArray1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            KeyPairBoolData h = new KeyPairBoolData();
            h.setId(i + 1);
            h.setName(list.get(i));
            h.setSelected(i < 5);
            listArray1.add(h);
        }

        MultiSpinnerSearch multiSelectSpinnerWithSearch = findViewById(R.id.multipleItemSelectionSpinner);

        multiSelectSpinnerWithSearch.setSearchEnabled(true);
        multiSelectSpinnerWithSearch.setHintText("Select Movie Categories");
        multiSelectSpinnerWithSearch.setClearText("Clear");
        multiSelectSpinnerWithSearch.setSearchHint("Search Movie Categories");
        multiSelectSpinnerWithSearch.setEmptyTitle("Not Data Found!");
        multiSelectSpinnerWithSearch.setShowSelectAllButton(true);

        multiSelectSpinnerWithSearch.setItems(listArray1, items -> {
            //The followings are selected items.
            for (int i = 0; i < items.size(); i++) {
                Log.i("i", i + " : " + items.get(i).getName() + " : " + items.get(i).isSelected());
            }
        });

        spinnerObject = (Spinner) findViewById(R.id.ageSpinner);
        spinnerObject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                ((TextView)parentView.getChildAt(0)).setTextColor(Color.WHITE);
            }
        });

        multiSelectSpinnerWithSearch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                ((TextView)parentView.getChildAt(0)).setTextColor(Color.WHITE);
            }
        });

    }

    public String deDup(String s, String ch) {
        return new LinkedHashSet<String>(Arrays.asList(s.split(ch))).toString().replaceAll("(^\\[|]$)", "").replace(", ", ch);
    }
}
