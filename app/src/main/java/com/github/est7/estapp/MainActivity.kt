package com.github.est7.estapp

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.view.AsyncLayoutInflater
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.async.view.*
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    var str: String? = "kong"

    fun isOdd(x: Int) = x % 2 != 0

    val numbers = listOf(1, 2, 3)

    val sumLambda: (Int, Int) -> Int = { x, y -> x + y }

    val sumLambda1 = { x: Int, y: Int -> x + y }

    fun doubleTheResult(x: Int, y: Int, f: (Int, Int) -> Int): Int {
        return f(x, y) * 2
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doubleTheResult(3, 454, sumLambda)

        val fasdf = Foo()
        val fasdff = Foo(2342)
        val fasdfff = Foo("name", 34534)
        val methodex = fasdfff.method()

        val transform = transform("Red")


        val list = ArrayList<String>()

        val list1 = listOf("3", "234", 354)

        list1.filter {
            ele ->
            ele !is Int
        }.map {
            print(list1)
        }

        if (list.size < 2) {
            print("Two integers expected")
            return
        }

        val x = parseInt(list[0])
        val y = parseInt(list[1])

        //直接使用 x*y 会产生错误因为它们中有可能会有空值
        if (x != null && y != null) {
            //x 和 y 将会在空值检测后自动转换为非空值
            print(x * y)
        }


        btn.setOnClickListener {
            loadAsync(R.layout.async) {
                second.text = "I am second TextView"
            }
        }

    }

    fun loadAsync1(@LayoutRes res: Int, action: View.(Int) -> Unit) {
        AsyncLayoutInflater(this@MainActivity).inflate(res, ll_parent)
        { view, resid, parent ->
            with(parent) {
                addView(view)
                action(352)
            }

            parent.apply {
                addView(view)
                action(324)
            }


        }
    }


    fun loadAsync(@LayoutRes res: Int, action: View.() -> Unit) {
        AsyncLayoutInflater(this).inflate(res, ll_parent)
        { view, resid, parent ->
            with(parent) {
                addView(view)
                action()
            }
        }
    }

    fun loadAsync2(@LayoutRes res: Int, action: View.() -> Unit) {
        AsyncLayoutInflater(this).inflate(res, ll_parent)
        { view, resid, parent ->
            with(parent) {
                addView(view)
                action()
            }
        }
    }

}


fun transform(color: String): Int {

    return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }

}

fun cases(obj: Any): Unit {
    return when (obj) {
        1 -> print("one")
        "hello" -> print("Greeting")
        is Long -> print("Long")
        !is Long -> print("Not a string")
        else -> print("Ubknow")
    }
}

//这个语法要研究一下
fun MainActivity.loadAsync(@LayoutRes res: Int, action: View.() -> Unit) =
        AsyncLayoutInflater(this).inflate(res, ll_parent)
        { view, resid, parent ->
            with(parent) {
                addView(view)
                action(view)
            }
        }

