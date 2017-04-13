package com.github.est7.estapp

/**
 * Created by Administrator.
 *
 * Created Time : 2017/4/11 17:39.
 *
 * Description : File in com.github.est7.estapp , Project in EstApp
 *
 * Content:
 */
open class Foo constructor(stuId: Int = 0) {


    val customField = stuId + 100
    var stuName = ""

    init {
        println("初始化Student()对象 $stuId  $customField")
    }

    //次要构造方法
    constructor(name: String, stuId: Int) : this(stuId) {
        stuName = name
    }


    open fun method() {}


    inner class Inner {

    }

}