package com.example.makeuptask.networking;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import kotlin.jvm.internal.SerializedIr;

public class ProductResult implements Parcelable {

    public int id;
    public String brand;
    public String name;
    public String price;
    public String image_link;
    public float rating;

    protected ProductResult(Parcel in) {
        id = in.readInt();
        brand = in.readString();
        name = in.readString();
        price = in.readString();
        image_link = in.readString();
        rating = in.readFloat();
    }

    public static final Creator<ProductResult> CREATOR = new Creator<ProductResult>() {
        @Override
        public ProductResult createFromParcel(Parcel in) {
            return new ProductResult(in);
        }

        @Override
        public ProductResult[] newArray(int size) {
            return new ProductResult[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(brand);
        parcel.writeString(name);
        parcel.writeString(price);
        parcel.writeString(image_link);
        parcel.writeFloat(rating);
    }
}
