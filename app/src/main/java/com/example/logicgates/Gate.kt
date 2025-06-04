package com.example.logicgates
var gatelist= mutableListOf<Gate>()
class Gate (
    var cover:Int,
    var title:String,
    var description:String,
    var id:Int? =gatelist.size
)