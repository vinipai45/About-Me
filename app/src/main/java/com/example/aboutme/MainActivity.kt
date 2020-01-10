package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        val doneButton : Button =findViewById(R.id.doneButton);
//
//        doneButton.setOnClickListener {
//            addNickName(it);
//        }

        binding.doneButton.setOnClickListener {
            addNickName(it);

        }



    }

    fun  addNickName(view: View) {

//        val nickNameTextView : TextView= findViewById(R.id.nickNameTextView);
//        val nickNameEditText : EditText=findViewById(R.id.nickNameEditText);
        binding.apply {
            binding.nickNameTextView.text = nickNameEditText.text;
            invalidateAll();
            binding.nickNameTextView.visibility = View.VISIBLE;
            binding.nickNameEditText.visibility = View.GONE;
            binding.doneButton.visibility = View.GONE;
        }




        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
