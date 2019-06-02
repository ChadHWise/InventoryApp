package com.chadw.inventory.model

class Item {

    var itemName: String? = ""
    var itemDescrip: String? = ""
    var itemPurchasePrice: Double? = 0.00
    var materialCost: Double? = 0.00
    var laborCharge: Double? = 0.00
    var askingPrice: Double? = 0.00
    var category: Category? = null
    var height: Double? = 0.00
    var width: Double? = 0.00
    var length: Double? = 0.00
    var location: Location? = null
    var quantity: Int? = 1
    var sold: Boolean? = false

    fun UpdateItemInfo(itemName:String?,itemDescrip:String?,itemPurchasePrice:Double?,materialCost:Double?,laborCharge:Double?,askingPrice:Double?,category:Category?,height:Double?,width:Double?,length:Double?,location:Location?,quantity:Int?){
        this.itemName = itemName
        this.itemDescrip = itemDescrip
        this.itemPurchasePrice = itemPurchasePrice
        this.materialCost = materialCost
        this.laborCharge = laborCharge
        this.askingPrice = askingPrice
        this.category = category
        this.height = height
        this.width = width
        this.length = length
        this.location = location
        this.quantity = quantity
    }

    fun GetFullCost() : Double?{
        return this.itemPurchasePrice!! + this.materialCost!! + this.laborCharge!!
    }

    fun GetProfit(): Double?{
        return this.askingPrice!!.minus(this.GetFullCost()!!)
    }

    fun UpdateQuantity(updateQuan: Int?) {
        this.quantity = updateQuan
    }

    fun MarkSold(){
        this.sold = true
    }
}