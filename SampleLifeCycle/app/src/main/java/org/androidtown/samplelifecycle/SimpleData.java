package org.androidtown.samplelifecycle;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable{
    int number;
    String message;
    public SimpleData(int num, String mesg){
        this.number = num;
        this.message = mesg;
    }
    public SimpleData(Parcel parcel){
        number = parcel.readInt();
        message = parcel.readString();
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
     dest.writeInt(number);
     dest.writeString(message);
    }
    public void setNumber(int num){
        number = num;
    }
    public void setMessage(String mesg){
        message = mesg;
    }
    public int getNumber(){
        return number;
    }
    public String getMessage(){
        return message;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public SimpleData createFromParcel(Parcel in){
            return new SimpleData(in);
        }
        public SimpleData[] newArray(int size){
            return new SimpleData[size];
        }
    };
}
