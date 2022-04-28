package com.example.listviewpractice;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.listviewpractice.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //feeding static data to the user class

        int[] imageId = {R.drawable.am,R.drawable.ca,R.drawable.dp,R.drawable.loki,R.drawable.st,};
        String[] name = {"Ant Man","Caption America","Deadpool","Loki Asguagdian","Dr.Strange"};
        String[] lastMessage = {"I am Ant Man","I am Caption America",
                "I am Deadpool","I am Loki Asguagdian","I am Dr.Strange"};
        String[] phoneNo = {"123456789","987654321","678954321","987123456","9087564321"};
        String[] country = {"United State","Russia","India","Canada","japan"};

        ArrayList<User> userArrayList = new ArrayList<>();

        // inflating our arraylist

        for(int i =0; i<imageId.length;i++){

            User user = new User(name[i],lastMessage[i],phoneNo[i],country[i],imageId[i]);
          // adding user to the array list
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(MainActivity.this,UserActivity.class);
                intent.putExtra("name",name[position]);
                intent.putExtra("phone",phoneNo[position]);
                intent.putExtra("country",country[position]);
                intent.putExtra("imageid",imageId[position]);

                startActivity(intent);
            }
        });


    }
    // this function will be called on clicking the profile image from list view.

    public void picDisplay(View view)
    {
        // since views cant be passed directly through intent . so we need
        // convert it into bitmap and passed as key value pairs in bundle
        // and retrieved in another activity.

        view.buildDrawingCache();
        Bitmap image = view.getDrawingCache();
        Bundle extra = new Bundle();
        Intent intent = new Intent(this,ProfilePicDisplay.class);

        extra.putParcelable("imagebitmap",image);
        intent.putExtras(extra);
        startActivity(intent);

    }
}