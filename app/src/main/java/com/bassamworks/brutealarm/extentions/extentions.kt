package com.bassamworks.brutealarm.extentions

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(message: String, length: Int) {
    Toast.makeText(this.context, message, length).show()
}

fun Activity.showToast(message: String, length: Int) {
    Toast.makeText(this, message, length).show()
}