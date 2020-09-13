package e.fuckingdo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AddToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)

        title = "Add a new note"
    }
}