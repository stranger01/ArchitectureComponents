package com.e.pluralsight_kotlin


class CourseInfo(val courseId: String, val title: String)

class NoteInfo(var course : CourseInfo, var title : String)