package e.fuckingdo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import io.realm.Realm

class AddToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)

        title = "Add a new note"

        val button = findViewById<Button>(R.id.AddTodoBtn)

        button.setOnClickListener {

            val editText = findViewById<EditText>(R.id.toDoEditTex)
            val checkBox = findViewById<CheckBox>(R.id.updateChkBoc)

            val todo = ToDoItem()
            todo.name = editText.text.toString()
            todo.important = checkBox.isChecked

            val realm = Realm.getDefaultInstance()
            realm.beginTransaction()
            realm.copyToRealm(todo)
            realm.commitTransaction()


        }
    }
}