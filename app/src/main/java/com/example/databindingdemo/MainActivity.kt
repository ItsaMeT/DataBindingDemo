package com.example.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.databindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val student:Student = Student("21WMR077712", "Ali")
        binding.s = student

        binding.tvStudentID.text = student.id
        binding.tvStudentName.text = student.name

        binding.btnUpdate.setOnClickListener(){
            student.name = "Abu"

            binding.apply {
                invalidateAll()
            }
        }
    }
}