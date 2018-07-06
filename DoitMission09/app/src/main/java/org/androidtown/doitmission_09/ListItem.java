package org.androidtown.doitmission_09;

public class ListItem {
    String birth;
    String phone;
    String num;
    int resId;

    public ListItem(String phone, String num) {
        this.phone = phone;
        this.num = num;
    }
    public ListItem(String num, String birth, String phone, int resId){
        this.phone = phone;
        this.num = num;
        this.birth = birth;
        this.resId = resId;
    }
    public String getBirth(){
        return birth;
    }
    public void setBirth(String birth){
        this.birth = birth;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getNum(){
        return num;
    }
    public void setNum(String num){
        this.num = num;
    }
    public int getResId(){
        return resId;
    }
    public void setResId(int resId){
        this.resId = resId;
    }

}
