package com.hrd.androidhrd.mvp_demo.entity;

import java.util.List;

public class UrlResponse {


    @com.google.gson.annotations.SerializedName("data")
    private List<Url> data;
    @com.google.gson.annotations.SerializedName("msg")
    private String msg;
    @com.google.gson.annotations.SerializedName("status")
    private boolean status;
    @com.google.gson.annotations.SerializedName("code")
    private String code;


    //type Alt + insert Key to generate setter getter methods
    public List<Url> getData() {
        return data;
    }

    public void setData(List<Url> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class Url {
        @com.google.gson.annotations.SerializedName("approved")
        private boolean approved;
        @com.google.gson.annotations.SerializedName("main_cate")
        private String mainCate;
        @com.google.gson.annotations.SerializedName("sub_cate")
        private String subCate;
        @com.google.gson.annotations.SerializedName("pic_url")
        private String picUrl;
        @com.google.gson.annotations.SerializedName("des")
        private String des;
        @com.google.gson.annotations.SerializedName("type")
        private String type;
        @com.google.gson.annotations.SerializedName("title")
        private String title;
        @com.google.gson.annotations.SerializedName("email")
        private String email;
        @com.google.gson.annotations.SerializedName("phone")
        private String phone;
        @com.google.gson.annotations.SerializedName("address")
        private String address;
        @com.google.gson.annotations.SerializedName("link")
        private String link;
        @com.google.gson.annotations.SerializedName("id")
        private int id;

        public boolean isApproved() {
            return approved;
        }

        public void setApproved(boolean approved) {
            this.approved = approved;
        }

        public String getMainCate() {
            return mainCate;
        }

        public void setMainCate(String mainCate) {
            this.mainCate = mainCate;
        }

        public String getSubCate() {
            return subCate;
        }

        public void setSubCate(String subCate) {
            this.subCate = subCate;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "approved=" + approved +
                    ", mainCate='" + mainCate + '\'' +
                    ", subCate='" + subCate + '\'' +
                    ", picUrl='" + picUrl + '\'' +
                    ", des='" + des + '\'' +
                    ", type='" + type + '\'' +
                    ", title='" + title + '\'' +
                    ", email='" + email + '\'' +
                    ", phone='" + phone + '\'' +
                    ", address='" + address + '\'' +
                    ", link='" + link + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
