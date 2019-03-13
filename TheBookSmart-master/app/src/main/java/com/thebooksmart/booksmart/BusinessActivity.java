package com.thebooksmart.booksmart;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BusinessActivity extends AppCompatActivity {
//this one is connected using mysql

    EditText name, editDetails, editKeyword, editProduct;
    Spinner spinnerCat;
    Button listBiz_button;
    ArrayAdapter<CharSequence> adapter;
    private static final String DB_URL = "jdbc:mysql://192.168.43.91/booksmart"; //change to your ipv4 address
    private static final String USER ="root";
    private static final String PASS ="";
    //FirebaseDatabase database;
    //DatabaseReference ref;
    //Requestqueue
    BizList bizList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
        spinnerCat = (Spinner)findViewById(R.id.spinnerCat);
        adapter = ArrayAdapter.createFromResource(this,R.array.business_class,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCat.setAdapter(adapter);
        spinnerCat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+"selected",Toast.LENGTH_LONG).show();
            }
            public void onNothingSelected(AdapterView<?> parent){

            }
        });




        //list out category class
        /*spinnerCat = (Spinner)findViewById(R.id.spinnerCat);

        spinnerCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Popupmenu popupmenu = new PopupMenu(MainActivity.this, spinnerCat);
                ((PopupMenu) popupmenu).getMenuInflater().inflate(R.menu.popup_menu,((PopupMenu) popupmenu).getMenu());

                ((PopupMenu) popupmenu).setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this,""+ item.getTitle(),Toast.LENGTH_SHORT.show());
                        return true;
                    }
                });
            }
        });*/
        /*name = (EditText)findViewById(R.id.Name);
        editDetails = (EditText)findViewById(R.id.editDetails);
        editProduct = (EditText)findViewById(R.id.editProduct);
        editKeyword = (EditText)findViewById(R.id.editKeyword);
        listBiz_button = (Button)findViewById(R.id.listBiz_button);
       // database = FirebaseDatabase.getInstance();
        //ref = database.getReference("BizList");
        bizList = new BizList();*/

    }
    //this one obtain from bizlist java class
   /* private void getValues(){
        bizList.setName(name.getText().toString());
        bizList.setDetails(editDetails.getText().toString());
        bizList.setProducts(editProduct.getText().toString());
        bizList.setKeyword(editKeyword.getText().toString());

    }*/

    public void formInsert(View view)
    {
        Send objSend = new Send();
        objSend.execute("");
    }

    private class Send extends AsyncTask<String, String, String>
    {
        String msg ="";
        String text = name.getText().toString();
        String text2 = editDetails.getText().toString();
        String text3 = editProduct.getText().toString();
        String text4 = editKeyword.getText().toString();

        protected void onPreExecute(){
            name.setText("loading...");
            editDetails.setText("loading..");
            editProduct.setText("loading..");
            editKeyword.setText("loading..");
        }


        @Override
        protected String doInBackground(String... strings)
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                if(conn == null){
                    msg = "Not Connected, mate";
                }
                else{
                    String query = "INSERT INTO busineslist(bizName, bizDetails, bizMainProduct, bizKeywords) VALUES ('$bizName','$bizDetails','$bizMainProduct','$bizKeywords')";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(query);
                    msg = "Your Business Has Been Approved";
                }
                conn.close();
            }
            catch (Exception e)
            {
                msg = "Not connected, mate";
                e.printStackTrace();
            }
            return msg;
        }

        protected void onPostExecute(String msg)
        {
            name.setText(msg);
            editDetails.setText(msg);
            editProduct.setText(msg);
            editKeyword.setText(msg);
        }
    }

    /*public void formInsert(View view){
    ref.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            ref.child("Biz01").setValue(bizList);
            //this is thrown away if it is not working
           // Toast.makeText(MainActivity.this, "Your Business Has Been Revised. This could take a while",Toast.LENGTH_LONG);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    }*/
}
