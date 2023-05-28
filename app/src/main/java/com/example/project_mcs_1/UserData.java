package com.example.project_mcs_1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class UserData implements Parcelable {
    private String name, email, password;

    public UserData(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    protected UserData(Parcel in) {
        name = in.readString();
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel in) {
            return new UserData(in);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(password);
    }
}
