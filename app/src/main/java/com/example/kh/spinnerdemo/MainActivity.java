package com.example.kh.spinnerdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private     Spinner spinner;
    private ArrayList<Person>  arrayList1 = new ArrayList<Person>();
    private  Person person;
    private int[] im  =new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        person = new Person("435435435435a",R.drawable.a);
        arrayList1.add(person);
        person = new Person("b345435435",R.drawable.b);
        arrayList1.add(person);
        person = new Person("c43543534543",R.drawable.c);
        arrayList1.add(person);
        person = new Person("d5435435",R.drawable.d);
        arrayList1.add(person);

      Myadapter  myadapter = new Myadapter(this, R.layout.listview_layout, arrayList1);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myadapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, arrayList1.get(position).getName() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public class Myadapter extends ArrayAdapter<Person>{
    Context context;
       private int resource;
       private ArrayList<Person> arrayList  = new ArrayList<Person>();

        private LayoutInflater inflater;
        public Myadapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Person> objects) {
            super(context, resource, objects);
           this.context = context;
            this.resource = resource;
            this.arrayList  =objects;

        }

        @Nullable
        @Override
        public Person getItem(int position) {
                return super.getItem(position);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = convertView;
            ViewHolder holder = null;
            if(view == null){
                holder = new ViewHolder();
                inflater  = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                view  = inflater.inflate(resource, null);

                holder.im = (ImageView) view.findViewById(R.id.im);
                holder.txt = (TextView) view.findViewById(R.id.txt);

                view.setTag(holder);
            } else holder  = (ViewHolder) view.getTag();
            holder.im.setImageResource( arrayList.get(position).getImage());
           holder.txt.setText(arrayList.get(position).getName());
            return view;
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            return getView(position,convertView,parent);
        }

        private class ViewHolder{
            private ImageView im ;
            private TextView txt;
        }
    }

}
