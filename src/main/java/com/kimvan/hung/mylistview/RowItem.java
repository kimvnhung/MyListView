package com.kimvan.hung.mylistview;

import android.util.Log;

/**
 * Created by h on 08/08/2017.
 */

public class RowItem {
    private int profile_pic_link;
    private String full_name;
    private String sex;
    private String status;

    public RowItem(int profile_pic_link,String full_name,String sex,String status){
        this.profile_pic_link =  profile_pic_link;
        this.full_name = full_name;
        this.sex = sex;
        this.status = status;
        Log.i(CustomApdater.tag,"Conteructor RowItem");
    }

    public int getProfile_pic_link(){
        return profile_pic_link;
    }

    public String getFull_name(){
        return full_name;
    }

    public String getSex(){
        return sex;
    }

    public String getStatus(){
        return status;
    }

    public void setProfile_pic_link(int profile_pic_link){
        this.profile_pic_link = profile_pic_link;
    }
    public void setFull_name(String full_name){
        this.full_name = full_name;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public void setStatus(String status){
        this.status=status;
    }

}
