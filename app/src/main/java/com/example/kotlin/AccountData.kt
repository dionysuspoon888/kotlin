package com.example.kotlin

/**
 * Created by D on 10/21/2018.
 */
class AccountData {

    var name:String? = null
    get() {
        if(field == null){
            return "NAME!";
        }
        return field;}
    set(value){
        field = value+" OK!";
    }

    var pwd:String?
        get() {
            if(field == null){
                return "PWD!";
            }
            return field;}
        set(value){
            field = value;
        }

    var mark:Int?;

    constructor(name: String?, pwd: String?, mark: Int?) {
        this.name = name
        this.pwd = pwd
        this.mark = mark
    }



}