package com.example.kubra.contactsproviderexample;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int RC_PICK_CONTACT=1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.buttonContacts);

    }
    public void listele(View view){
    Intent intent=new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
    startActivityForResult(intent,RC_PICK_CONTACT);
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_PICK_CONTACT && resultCode == RESULT_OK) {
            Uri contactDataUri = data.getData();
            Cursor result = getContentResolver().query(contactDataUri, null, null, null, null);

            if (result.moveToFirst()) {
                int nameIndex = result.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                String display_name = result.getString(nameIndex);
                Toast.makeText(getApplicationContext(), display_name, Toast.LENGTH_LONG).show();
            }
        }
    }}
