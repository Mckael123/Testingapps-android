package com.example.testing1apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MoveActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)

        var firstnum:EditText  = findViewById(R.id.firstnum)
        var operation:EditText = findViewById(R.id.operation)
        var secondnum:EditText = findViewById(R.id.secnum)
        var resultbtn:Button   = findViewById(R.id.btnCount)
        var result:TextView = findViewById(R.id.result)


        resultbtn.setOnClickListener{
          val opt   = operation.text.toString()
          val first = firstnum.text.toString()
          val sec   = secondnum.text.toString()

          
            when(opt){
                "+"->{
                    var count=(first.toDouble()+sec.toDouble())
                    val moveWithDataIntent= Intent(this,MoveWithDataActivity::class.java)
                    moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_Result,count)
                    startActivity(moveWithDataIntent)
                }
                "-"-> {
                    var count= (first.toDouble() - sec.toDouble())
                    val moveWithDataIntent= Intent(this,MoveWithDataActivity::class.java)
                    moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_Result,count)
                    startActivity(moveWithDataIntent)
                }
                "*"->{
                    var count=(first.toDouble()*sec.toDouble())
                    val moveWithDataIntent= Intent(this,MoveWithDataActivity::class.java)
                    moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_Result,count)
                    startActivity(moveWithDataIntent)
                }
                "/"->{
                    var count= (first.toDouble()/sec.toDouble())
                    val moveWithDataIntent= Intent(this,MoveWithDataActivity::class.java)
                    moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_Result,count)
                    startActivity(moveWithDataIntent)
                }
                else ->{
                    Toast.makeText(this,"input the correct operation symbol",Toast.LENGTH_SHORT).show()
                }
            }

            if (first==null||first.trim()==""){//trim untuk memisah  string
                //nampilin Toast pop up kecil notif activity
                Toast.makeText(this, "please input the fisrt number ", Toast.LENGTH_SHORT).show()
                firstnum.error="fill input first number"
            }
            else if (opt==null||opt.trim()==""){//trim untuk memisah  string
                //nampilin Toast pop up kecil notif activity
                Toast.makeText(this, "please input your name ", Toast.LENGTH_SHORT).show()
                operation.error="fill input the operation mathematics"
            }
            else if (sec==null||sec.trim()==""){//trim untuk memisah  string
                //nampilin Toast pop up kecil notif activity
                Toast.makeText(this, "please input the second number ", Toast.LENGTH_SHORT).show()
                secondnum.error="fill input the second"
            }
    
        }

    }
}




