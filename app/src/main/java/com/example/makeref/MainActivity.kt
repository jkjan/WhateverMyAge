package com.example.makeref

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import java.util.Random

class Quotes (val Quote : String, val QuotedFrom : String)

class MainActivity : AppCompatActivity() {
    private  val random = Random()
    private var num = random.nextInt(5)
    private val quotelist = arrayListOf(
        Quotes("죽고자 하면 살 것이고 살고자 하면 죽을 것이다.", "-이순신"),
        Quotes("복수는 차갑게 식혀서 먹을 때가 가장 맛있는 음식과도 같다.", "-프랑스 속담"),
        Quotes("사진이 진실이라면 영화는 초당 24번의 진실이다","-장 뤽 고다르"),
        Quotes("카메라는 불행한 일들과 그들이 잊혀지는 것에 대한 무기이다", "-빔 벤더스"),
        Quotes("영화란 지루한 부분이 커트된 인생이다.", "-알프레드 히치콕")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        quote.text = quotelist[num].Quote
        quotedfrom.text = quotelist[num].QuotedFrom

        bt_guide.setOnClickListener {//setting 화면
            val intent = Intent(this, GuideActivity::class.java)
            startActivity(intent)
        }
        bt_love.setOnClickListener {//사랑방 화면
            val intent = Intent(this, LoveActivity::class.java)
            startActivity(intent)
        }
        bt_login.setOnClickListener {//로그인 화면
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        bt_travelandfood.setOnClickListener{//기능 구현X
            val intent = Intent(this, TravelAndFood::class.java)
            startActivity(intent)
            //Toast.makeText(this,"미구현", Toast.LENGTH_SHORT).show()
            //val intent = Intent(this, NotyetActivity::class.java)
            //startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        num = random.nextInt(5)
        quote.text = quotelist[num].Quote
        quotedfrom.text = quotelist[num].QuotedFrom
    }
}
