package com.example.iqraapp
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.zxing.integration.android.IntentIntegrator
class pageLogin : AppCompatActivity() {
    private lateinit var btnSignUp: Button
    private lateinit var btnlogin: Button
    private lateinit var scanBtn: Button
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_login)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        scanBtn = findViewById(R.id.scanner)
        textView = findViewById(R.id.text)
        btnSignUp = findViewById(R.id.btnSignup)
        btnlogin = findViewById(R.id.btnLogin)

        btnlogin.setOnClickListener {
            val intent = Intent(this, pageSuccess::class.java)
            startActivity(intent)
        }
        btnSignUp.setOnClickListener {
            val intent = Intent(this, pageSignup::class.java)
            startActivity(intent)
        }
        scanBtn.setOnClickListener {
            val intentIntegrator = IntentIntegrator(this)
            intentIntegrator.setOrientationLocked(false)
            intentIntegrator.setPrompt("Scan a QR Code")
            intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            intentIntegrator.initiateScan()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (intentResult != null) {
            val contents = intentResult.contents
            if (contents != null) {
                textView.text = contents
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
