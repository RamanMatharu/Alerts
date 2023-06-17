package com.ramanmatharu.alerts

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.ramanmatharu.alerts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    lateinit var toast : Button
//    lateinit var snackBar : Button
//    lateinit var dialog : Button
//    lateinit var customDialog: Button
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        toast = findViewById(R.id.toast)
//        snackBar = findViewById(R.id.snackBar)
//        dialog = findViewById(R.id.dialog)
//        customDialog = findViewById(R.id.customDialog)

        binding.toast.setOnClickListener{
            Toast.makeText(this,"This is a Toast",Toast.LENGTH_LONG).show()
        }

        binding.snackBar.setOnClickListener {
            var snackBarView = Snackbar.make(binding.snackBar, "This is Snackbar", Snackbar.LENGTH_LONG)
            snackBarView.show()
            snackBarView.setAnchorView(R.id.snackBar)
            snackBarView.setAction("Click"){
                Toast.makeText(this,"Hello User!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.dialog.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Alert Dialog Box")
                .setMessage("Warning will be displayed here..")
                .setNegativeButton("Negative"){_,_->
                    Toast.makeText(this,"Negative Button is Clicked!",Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Neutral"){_,_->
                    Toast.makeText(this,"Neutral Button is Clicked!" , Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("Positive"){_,_->
                    Toast.makeText(this, "Positive button Clicked!",Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        binding.customDialog.setOnClickListener {
            var dialogue = Dialog(this)
            dialogue.setContentView(R.layout.custom_dialog)
            dialogue.show()

            var btnCancel = dialogue.findViewById<Button>(R.id.cancel)
            btnCancel.setOnClickListener {
                dialogue.dismiss()
            }

            var btnSet = dialogue.findViewById<Button>(R.id.set)
            var space = dialogue.findViewById<EditText>(R.id.space)
            btnSet.setOnClickListener {
                if(space.text.toString().isEmpty()){
                    space.error = "It is mandatory to fill in the blank!"
                }else {
                    binding.tvName.setText(space.getText().toString())
                    dialogue.dismiss()
                }
            }

        }
    }


}