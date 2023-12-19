package com.example.ez03homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var s1: EditText //s ตัวแปรช่อง subject
    private lateinit var s2: EditText
    private lateinit var s3: EditText
    private lateinit var s4: EditText
    private lateinit var s5: EditText
    private lateinit var Credit1: EditText
    private lateinit var Credit2: EditText
    private lateinit var Credit3: EditText
    private lateinit var Credit4: EditText
    private lateinit var Credit5: EditText
    private lateinit var Grade1: EditText
    private lateinit var Grade2: EditText
    private lateinit var Grade3: EditText
    private lateinit var Grade4: EditText
    private lateinit var Grade5: EditText
    private lateinit var totalCredits: TextView
    private lateinit var gpa: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s1 = findViewById(R.id.s1)
        s2 = findViewById(R.id.s2)
        s3 = findViewById(R.id.s3)
        s4 = findViewById(R.id.s4)
        s5 = findViewById(R.id.s5)
        Credit1 = findViewById(R.id.Credit1)
        Credit2 = findViewById(R.id.Credit2)
        Credit3 = findViewById(R.id.Credit3)
        Credit4 = findViewById(R.id.Credit4)
        Credit5 = findViewById(R.id.Credit5)
        Grade1 = findViewById(R.id.Grade1) //grade คือ ช่อง point
        Grade2 = findViewById(R.id.Grade2)
        Grade3 = findViewById(R.id.Grade5)
        Grade4 = findViewById(R.id.Grade4)
        Grade5 = findViewById(R.id.Grade5)
        //totalCredits = findViewById(R.id.totalCredits)
        //gpa = findViewById(R.id.gpa)

        findViewById<Button>(R.id.btnOK).setOnClickListener {calculateGPA() }
        findViewById<Button>(R.id.btnClear).setOnClickListener { clearinput() }
    }

    private fun calculateGPA() {
        val credit1 = Credit1.text.toString().toDoubleOrNull()
        val credit2 = Credit2.text.toString().toDoubleOrNull()
        val credit3 = Credit3.text.toString().toDoubleOrNull()
        val credit4 = Credit4.text.toString().toDoubleOrNull()
        val credit5 = Credit5.text.toString().toDoubleOrNull()

        if (credit1 == null || credit2 == null || credit3 == null || credit4 == null || credit5 == null) {
            showToast("กรุณากรอกทุกช่อง")
            return
        }

        val totalCredits = credit1 + credit2 + credit3 + credit4 + credit5
        val totalGradePoints =
            (credit1 * getGradePoint(Grade1.text.toString())) +
                    (credit2 * getGradePoint(Grade2.text.toString())) +
                    (credit3 * getGradePoint(Grade3.text.toString())) +
                    (credit4 * getGradePoint(Grade4.text.toString())) +
                    (credit5 * getGradePoint(Grade5.text.toString()))

        val gpa = totalGradePoints / totalCredits

        showResult(totalCredits, gpa)
    }

    private fun getGradePoint(grade: String): Double {
        return when (grade) {
            "A" -> 4.0
            "B+" -> 3.5
            "B" -> 3.0
            "C+" -> 2.5
            "C" -> 2.0
            "D+" -> 1.5
            "D" -> 1.0
            else -> 0.0
        }
    }

    private fun showResult(totalCredits: Double, gpa: Double) {
        val resultMessage = "Total Credits: $totalCredits\nGPA: %.2f".format(gpa)
        showToast(resultMessage)

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun clearinput() {
        s1.text.clear()
        s2.text.clear()
        s3.text.clear()
        s4.text.clear()
        s5.text.clear()
        Credit1.text.clear()
        Credit2.text.clear()
        Credit3.text.clear()
        Credit4.text.clear()
        Credit5.text.clear()
        Grade1.text.clear()
        Grade2.text.clear()
        Grade3.text.clear()
        Grade4.text.clear()
        Grade5.text.clear()
    }
}