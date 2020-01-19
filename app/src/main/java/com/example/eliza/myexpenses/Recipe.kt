package com.example.eliza.myexpenses

class Recipe{
    var name : String = ""
    var ingredients : String = ""
    var desc : String = ""
    var id : Int = 0

    constructor(name:String, ingredients:String, desc:String){
        this.name = name
        this.ingredients = ingredients
        this.desc = desc
    }

    constructor(){}

}