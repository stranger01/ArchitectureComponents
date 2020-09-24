package com.e.pluralsight_kotlin

import android.provider.ContactsContract

class DataManager {

    val courses = HashMap<String, CourseInfo>()

    val notes = ArrayList<CourseInfo>()

    init {
        initializeCourses()
    }

    private fun initializeCourses() {

        var course = CourseInfo("android intents", "Android programming with intents")
        courses[course.courseId] = course

        course = CourseInfo("android async", "Android programming and services")

        course = CourseInfo("Java Core", "Java fundamentals: The core platform")


    }
}
























