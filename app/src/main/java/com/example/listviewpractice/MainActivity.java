package com.example.listviewpractice;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.listviewpractice.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.am,R.drawable.ca,R.drawable.dp,R.drawable.loki,R.drawable.st,};
        String[] name = {"Ant Man","Caption America","Deadpool","Loki Asguagdian","Dr.Strange"};
        String[] lastMessage = {"I am Ant Man","I am Caption America",
                "I am Deadpool","I am Loki Asguagdian","I am Dr.Strange"};
        String[] phoneNo = {"123456789","987654321","678954321","987123456","9087564321"};
        String[] country = {"United State","Russia","India","Canada","japan"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i =0; i<imageId.length;i++){

            User user = new User(name[i],lastMessage[i],phoneNo[i],country[i],imageId[i]);
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
}