package com.mucomarley.yenihesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var ilksayi : Double = 0.0
    var ilksayiVarmi : Boolean = false
    var hangiIslem : String = ""
    var yeni : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun temizle(view: View){
        sonuc.setText("")
        ilksayi  = 0.0
        ilksayiVarmi  = false
        hangiIslem  = ""
        yeni = false

    }
    fun onSayi(view: View){
        if (yeni){
            sonuc.text = ""
            yeni = false
        }
        var sayi : String = (view as TextView).text.toString()
        sonuc.text = sonuc.text.toString() + sayi
    }
    fun artieksi(view: View) {
        if (!yeni && !sonuc.text.toString().isEmpty()) {
            var sayi: Double = sonuc.text.toString().toDouble()
            sayi *= -1
            var sStr = sayi.toString()
            if (sStr.substring(sStr.length - 2) == ".0") {
                sonuc.text = sStr.substring(0, sStr.length - 2)
            } else {
                sonuc.text = sStr
            }

        }
    }
    fun yuzde(view: View) {
        if (!yeni && !sonuc.text.toString().isEmpty()) {
            var sayi: Double = sonuc.text.toString().toDouble()
            sayi / 100
            var sStr = sayi.toString()
            if (sStr.substring(sStr.length - 2) == ".0") {
                sonuc.text = sStr.substring(0, sStr.length - 2)
            } else {
                sonuc.text = sStr
            }

        }
    }

    fun islem(view: View){
        var islem1 : String = (view as TextView).text.toString()
        if (!sonuc.text.toString().isEmpty()){
            if (!ilksayiVarmi){
                ilksayi = sonuc.text.toString().toDouble()
                hangiIslem =islem1
                yeni = true
                ilksayiVarmi = true
            }else if (islem1 != "="){
                var ikinci = sonuc.text.toString().toDouble()
                var s = islemyap(ilksayi,ikinci,hangiIslem)
                hangiIslem = islem1
                var sStr = s.toString()
                if (sStr.substring(sStr.length-2)==".0"){
                    sonuc.text = sStr.substring(0,sStr.length-2)
                }else{
                    sonuc.text = s.toString()
                }

                ilksayi = sonuc.text.toString().toDouble()
                yeni = true
                ilksayiVarmi = true

            }else{//EŞİTTİR OLAYI

                var ikinci = sonuc.text.toString().toDouble()
                var s = islemyap(ilksayi,ikinci,hangiIslem)
                hangiIslem = islem1
                var sStr = s.toString()
                if (sStr.substring(sStr.length-2)==".0"){
                    sonuc.text = sStr.substring(0,sStr.length-2)
                }else{
                    sonuc.text = s.toString()
                }
                ilksayiVarmi = false
            }
        }

    }
    private fun islemyap(s1:Double,s2:Double,i : String):Double{
        return if (i == "*")
            s1 * s2
        else if (i == "/")
            s1 / s2
        else if (i == "-")
            s1 - s2
        else
            s1 + s2
    }
    fun virgul(view: View){
        var str = sonuc.text.toString()
        if (!yeni && !str.contains('.') && !str.isEmpty()){
            sonuc.text= sonuc.text.toString()+ "."

        }

    }
}