package com.chadw.inventory.model

class Item {

    var itemName: String? = null
    var itemPurchasePrice: Double? = null
    var materialCost: Double? = null
    var laborCharge: Double? = null
    var askingPrice: Double? = null
    var category: Category? = null
    var height: Double? = null
    var width: Double? = null
    var length: Double? = null
    var location: Location? = null
    var quantity: Int? = 1

    public fun UpdateItemInfo(itemName:String?,itemDescrip:String?,itemPurchasePrice:Double?,materialCost:Double?,laborCharge:Double?,askingPrice:Double?,category:Category?,height:Double?,width:Double?,length:Double?,location:Location?,quantity:Int?){
        this.itemName = itemName
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

}