package com.example.imransk.cgpacalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;

    double cgpa_average;

    List<String> credit_list=new ArrayList<>();
    List<String> cgpa_list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        listView=findViewById(R.id.list_view_ID);

        //hide action bar
        getSupportActionBar().hide();

        Intent intent=getIntent();

      credit_list = intent.getStringArrayListExtra("credit_list");
      cgpa_list = intent.getStringArrayListExtra("grade_list");
      cgpa_average=intent.getDoubleExtra("average_CGPA",0);


         textView=findViewById(R.id.total_CGPA);
        AdapterClass adapterClass=new AdapterClass(getApplicationContext(),credit_list,cgpa_list,cgpa_average);
        listView.setAdapter(adapterClass);

    }



    public class AdapterClass extends BaseAdapter {

        Context context;
        List<String> credit_list;
        List<String> grade_list;
        double cgpa_average;


        public AdapterClass(Context applicationContext, List<String> credit_list, List<String> cgpa_list,double cgpa_average) {
            this.context=applicationContext;
            this.credit_list=credit_list;
            this.grade_list =cgpa_list;
            this.cgpa_average=cgpa_average;
        }



        @Override
        public int getCount() {
            return credit_list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater=LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.item_view,null);

            TextView count=view.findViewById(R.id.serial_ID);
            TextView credit=view.findViewById(R.id.credit_ID);
            TextView cgpa=view.findViewById(R.id.cgpa_ID);

            count.setText(String.valueOf(i+1)+". ");
            credit.setText("Credit = "+credit_list.get(i));
            cgpa.setText("CGPA = "+ grade_list.get(i));


            textView.setText("Average CGPA = "+String.valueOf(new DecimalFormat("##.##").format(cgpa_average)));

            return view;
        }
    }

}
