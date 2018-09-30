package com.hrd.androidhrd.mvp_demo.data.repo;

public class Database {
    private static  Database database;
    private Database(){}
    public static Database getDatabase() {
        if(database==null)
            database=new Database();
        return database;
    }

    public UserRepository getUserRepository(){
        return new UserRepository();
    }

}
