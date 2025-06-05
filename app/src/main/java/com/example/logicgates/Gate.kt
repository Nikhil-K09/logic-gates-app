package com.example.logicgates
var gatelist= mutableListOf<Gate>()
val GATE_ID_EXTRA="gateExtra"
class Gate (
    var cover:Int,
    var title:String,
    var description:String,
    var truth_table:Int,
    var simulate:Int,
    var id:Int? =gatelist.size
)