package iteso.mx.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import iteso.mx.myfirstapp.beans.Form

class MainActivity : AppCompatActivity() {
    private lateinit var mEditTextName: EditText
    private lateinit var mEditTextPhone: EditText
    private lateinit var mSaveBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditTextName = findViewById(R.id.activity_main_name_et)
        mEditTextPhone = findViewById(R.id.activity_main_phone_et)
        mSaveBtn = findViewById(R.id.activity_main_save_btn)

        mSaveBtn.setOnClickListener { validate() }
    }

    /**
     * Creates toEditable into Strings, returns an Editable from the String
     * @return Editable
     */
    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

    private fun validate() {
        if (mEditTextName.text.toString() == "") {
            Toast.makeText(this, getString(R.string.activity_main_error_no_name), Toast.LENGTH_SHORT).show()
            return
        } else if (mEditTextPhone.text.toString() == "") {
            Toast.makeText(this, getString(R.string.activity_main_error_no_phone), Toast.LENGTH_SHORT).show()
            return
        }
        Toast.makeText(this, Form(mEditTextName.text.toString(), mEditTextPhone.text.toString()).toString(), Toast.LENGTH_SHORT).show()
        mEditTextName.text = "".toEditable() // EditText requires a Editable
        mEditTextPhone.text = "".toEditable() // EditText requires a Editable
    }
}
