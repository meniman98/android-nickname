package com.example.nickname

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.DataBindingUtil
import com.example.nickname.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // right here, the binding variable is made before the onCreate function
    private lateinit var binding: ActivityMainBinding

    private var name: MyName = MyName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        // righto, when databinding is used, go ahead and assign the binding variable
        // to the layout of the xml file. this is the equivalent to using setContentView()
        // so make sure you remove the setContentView() function
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = name




        binding.btnDone.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        binding.apply {
            val userInput: Editable = binding.edName.text
            name.defaultName = userInput.toString()
            tvName.text = name.toString()
            // this is used to refresh the UI views
            invalidateAll()
            tvName.visibility = VISIBLE
        }
    }
}