package aboutme.nada.aboutme

import aboutme.nada.aboutme.databinding.ActivityMainBinding
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val myName : MyName= MyName("Nada Eltorgoman")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName= myName
        binding.doneButton.setOnClickListener{
            addNickname(it)
        }

        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view:View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            nicknameTextView.text = editText.text
            editText.visibility = View.GONE
            view.visibility = View.GONE
            nicknameTextView.visibility = View.VISIBLE
        }
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)// Hide the keyboard.

    }
}