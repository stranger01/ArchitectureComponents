package com.e.pluralsight_kotlin

import android.provider.ContactsContract

class DataManager {

    val courses = HashMap<String, CourseInfo>()

    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
    }

    private fun initializeCourses() {

        var course = CourseInfo("android intents", "Android programming with intents")
        courses[course.courseId] = course


        course = CourseInfo("android async", "Android programming and services")
        courses[course.courseId] = course

        course = CourseInfo("Java Core", "Java fundamentals: The core platform")
        courses[course.courseId] = course


    }
}
























