package com.knowanimal.knowanimals

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var resultTv: TextView
    lateinit var showButtonn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showButtonn = findViewById<Button>(R.id.showQuestionBtn)
        resultTv = findViewById<Button>(R.id.resultTV)
        showButtonn.setOnClickListener {
            showDialog("")
        }
    }

    private fun showDialog(title: String) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.item_question_detail, null)
        val dialogBuilder = AlertDialog.Builder(this!!)
        dialogBuilder.setView(mDialogView)

        val alert = dialogBuilder.create()
        alert.setCanceledOnTouchOutside(false)

        val yesBtn = mDialogView.findViewById(R.id.yesBtn) as Button
        val noBtn = mDialogView.findViewById(R.id.noBtn) as Button
        val questionTV = mDialogView.findViewById(R.id.questionTV) as TextView

        questionTV.setText("Bu bir aslan mı?")
        alert.show()

        yesBtn.setOnClickListener {
            resultTv.setText("Süpersin doğru bildin")
            alert.dismiss()
        }
        noBtn.setOnClickListener {
            resultTv.setText("Olsun bir daha dene")

            alert.dismiss()
        }

    }
}
