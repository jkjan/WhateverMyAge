package com.example.makeref

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_food_fragment.*
//import sun.invoke.util.VerifyAccess.getPackageName
import android.R.attr.name
import android.util.Log
import kotlinx.android.synthetic.main.activity_explanation_fragment.*
import java.util.*

class HowToMessageE : Fragment(){
    var getData = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        val activity  = getActivity() as Instruction
        getData = activity.sendData()
        Log.i("data sent", "$getData")
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
     /*   val bundle = this.getArguments()

        var value1 = bundle?.getInt("Which", -1)
        Log.i("which fragment?", "$value1")
*/
        getBundle()
        return inflater.inflate(R.layout.activity_explanation_fragment, container,false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i("?", "??????")
        super.onActivityCreated(savedInstanceState)

        val pic :String
        when (getData) {
                1-> {pic = "@drawable/kakao_type_words"
                    explanation.text = "하고 싶은 말을 입력할 수 있어요."
                    piccount.text = "5/6"
                }
            2-> pic = "@drawable/kakao_main"
            3->{pic = "@drawable/kakao_gallery_confirm"
                explanation.text = "친구에게 사진을 보냈어요."
                piccount.text = "5/5"}
            4->{pic = "@drawable/youtube_videos_list"
                explanation.text = "다른 동영상들도 확인할 수 있어요."
                piccount.text = "5/5"}
            5->pic = "@drawable/youtube_playlists"
            6->pic = "@drawable/youtube_comment"
            7->pic = "@drawable/contact_home"
            else-> pic = "@drawable/kakao_home"
        }
        val res = resources
        val id = res.getIdentifier(pic, "id", context!!.packageName)
        explanationpic.setImageResource(id)

        //tvFragmentMain.setImageResource(R.drawable.avengers)     //text 대신 tv~~.ImageView = drawable.. 하면 됨
        //View v = getView()
    }

    private fun getBundle() {
        var bundle = this.getArguments()
        var value = 1
        if (null != bundle) {
           value = bundle?.getInt("Which", -1)
        }
        Log.i("which fragment?", "$value")
    }



}