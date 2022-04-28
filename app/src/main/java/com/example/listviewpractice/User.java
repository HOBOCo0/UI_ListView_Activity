package com.example.listviewpractice;

// created a user class to feed the
// data to the user

public class User {

    String mName,mLastMessage,mPhoneNo,mCountry;
    int mImageId;

    public User(String name, String lastMessage, String phoneNo, String country, int imageId) {
        this.mName = name;
        this.mLastMessage = lastMessage;
        this.mPhoneNo = phoneNo;
        this.mCountry = country;
        this.mImageId = imageId;
    }
}
