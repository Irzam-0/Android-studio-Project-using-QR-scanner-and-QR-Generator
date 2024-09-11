package com.example.iqraapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder

lateinit var btngo_back: Button
lateinit var editInput: EditText
lateinit var btGenerate: Button
lateinit var ivQr: ImageView

class pageSignup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_signup)
        ivQr = findViewById(R.id.iv_qr)
        editInput = findViewById(R.id.edit_input)
        btGenerate = findViewById(R.id.bt_generate)
        btngo_back = findViewById(R.id.btngo_back)
        btngo_back.setOnClickListener {
            val intent = Intent(this, pageLogin::class.java)
            startActivity(intent)
        }
        btGenerate.setOnClickListener {
            generateQR()
        }

    }
}
fun generateQR() {
    val text = editInput.text.toString().trim()
    val writer = MultiFormatWriter()
    try {
        val matrix = writer.encode(text, BarcodeFormat.QR_CODE, 400, 400)
        val encoder = BarcodeEncoder()
        val bitmap = encoder.createBitmap(matrix)
        ivQr.setImageBitmap(bitmap)
    } catch (e: WriterException) {
        e.printStackTrace()
    }
}
