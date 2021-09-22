package com.example.testing1apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.* //semua widget di import
import androidx.databinding.DataBindingUtil
import com.example.testing1apps.databinding.ActivityMainBinding

//import kotlinx.andorid.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
//    private lateinit var binding:ActivityMainBinding
    private lateinit var greet:TextView
    private lateinit var input:EditText
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        val button = findViewById(R.id.btn1) as Button //inisialisasi tombol dengan memanggil id tombol dari res
        val input:EditText = findViewById(R.id.input1)
        val greet:TextView = findViewById(R.id.greeting)
        val image:ImageView = findViewById(R.id.gambar)
        val btnmoveActivity:Button = findViewById(R.id.btn_move_activity)

        button.setOnClickListener {
            //do logic here...

            button.setText("click again")// karena udah pake binding bisa lgsg manggil nama fungsi nya misal jadi binding.btn1.setText dst
            val name =input.text.toString()
            if (name==null||name.trim()==""){//trim untuk memisah  string
            //nampilin Toast pop up kecil notif activity
                Toast.makeText(this@MainActivity, "please input your name ", Toast.LENGTH_SHORT).show()
                input.error="fill the input"
            }
            else
             {
                 greet.setText("hello $name")
                //nampilin Toast pop up kecil notif activity
                 Toast.makeText(this@MainActivity, "your input succsess", Toast.LENGTH_SHORT).show()
                //gambar
//                 val imageRes= resources.getIdentifier(name,"drawable",packageName)
//                 image.setImageResource(imageRes)

            }
        }

        btnmoveActivity.setOnClickListener(this)

//        if (savedInstanceState != null) {
//            val result = savedInstanceState.getString(STATE_RESULT)
//            greet.text=result
//        }
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString(STATE_RESULT,greet.text.toString())
//    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity->{
                val moveIntent = Intent(this@MainActivity,MoveActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }


}