package com.WhateverMyAge.WhateverMyAge.Main

import android.content.pm.PackageInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.WhateverMyAge.WhateverMyAge.R
import kotlinx.android.synthetic.main.activity_app_info.*
import java.security.AccessController.getContext

class AppInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_info)

        fun getVersionInfo() {
            val info: PackageInfo = this.packageManager.getPackageInfo(this.packageName, 0)
            val version = info.versionName
        }

        bt_back.setOnClickListener {
            finish()
        }
    }
}
