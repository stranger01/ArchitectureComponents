package e.fuckingdo


import io.realm.Realm
import io.realm.RealmObject

open class ToDoItem : RealmObject() {

    var name: String = ""
    var important: Boolean = false



}